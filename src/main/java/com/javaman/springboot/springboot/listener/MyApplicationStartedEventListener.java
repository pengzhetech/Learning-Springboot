package com.javaman.springboot.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author pengzhe
 * @date 2019-05-13 17:42
 * 应用启动时的监听器
 * ApplicationStartedEvent:
 * spring boot启动开始时执行的事件
 */
@Slf4j
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        SpringApplication app = event.getSpringApplication();
        app.setBannerMode(Mode.OFF);
        log.info("==MyApplicationStartedEventListener==");

    }
}
