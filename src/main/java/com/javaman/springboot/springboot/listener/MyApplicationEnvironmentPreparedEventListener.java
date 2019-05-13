package com.javaman.springboot.springboot.listener;

import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * @author pengzhe
 * @date 2019-05-13 17:47
 * ApplicationEnvironmentPreparedEvent：
 * spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建
 *
 * 在该监听中获取到ConfigurableEnvironment后可以对配置信息做操作，
 * 例如：修改默认的配置信息，增加额外的配置信息等等~~~
 */
@Slf4j
public class MyApplicationEnvironmentPreparedEventListener
    implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println("------->MyApplicationEnvironmentPreparedEventListener");
        ConfigurableEnvironment envi = event.getEnvironment();
        MutablePropertySources mps = envi.getPropertySources();
        if (mps != null) {
            Iterator<PropertySource<?>> iter = mps.iterator();
            while (iter.hasNext()) {
                PropertySource<?> ps = iter.next();
                log.info("ps.getName:{};ps.getSource:{};ps.getClass:{}", ps.getName(), ps.getSource(), ps.getClass());
            }
        }

    }
}
