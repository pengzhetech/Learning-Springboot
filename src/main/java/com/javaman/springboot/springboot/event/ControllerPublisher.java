package com.javaman.springboot.springboot.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author pengzhe
 * @date 2019-05-12 13:05
 * @description
 */
@Component
@Slf4j
public class ControllerPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publishEvent(String param) {
        log.info("---ControllerPublisher 事件发布开始---");
        ControllerEvent controllerEvent = new ControllerEvent(this.applicationContext, param);
        //向Spring容器中所有的事件监听者发送事件
        applicationContext.publishEvent(controllerEvent);
    }
}
