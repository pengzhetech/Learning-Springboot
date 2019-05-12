package com.javaman.springboot.springboot.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author pengzhe
 * @date 2019-05-12 13:01
 * @description
 */
@Component
@Slf4j
public class ControllerListener implements ApplicationListener<ControllerEvent> {
    @Override
    public void onApplicationEvent(ControllerEvent controllerEvent) {
        log.info("报告,接口调用完毕.参数为:::{}", controllerEvent.getParam());
    }
}
