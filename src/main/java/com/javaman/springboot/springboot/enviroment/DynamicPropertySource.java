package com.javaman.springboot.springboot.enviroment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.MapPropertySource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 模拟动态获取配置文件
 */
@Slf4j
public class DynamicPropertySource extends MapPropertySource {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
    private static Map<String, Object> map = new ConcurrentHashMap<String, Object>(64);

    static {
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                map = dynamicLoadMapInfo();
            }
        }, 1, 10, TimeUnit.SECONDS);

    }

    public DynamicPropertySource(String name) {
        super(name, map);
    }


    //动态获取资源信息
    private static Map<String, Object> dynamicLoadMapInfo() {
        //通过http或tcp等通信协议获取配置信息
        return mockMapInfo();
    }

    private static Map<String, Object> mockMapInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        int randomData = new Random().nextInt();
        log.info("random data{};currentTime:{}", randomData, sdf.format(new Date()));
        map.put("dynamic-info", randomData);
        return map;

    }

    @Override
    public Object getProperty(String name) {
        return map.get(name);
    }
}
