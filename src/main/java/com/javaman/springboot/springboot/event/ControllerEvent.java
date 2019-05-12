package com.javaman.springboot.springboot.event;

import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author pengzhe
 * @date 2019-05-12 13:00
 * @description
 */
@Data
public class ControllerEvent extends ApplicationContextEvent {

    private String param;

    public ControllerEvent(ApplicationContext source, String param) {
        super(source);
        this.param = param;
    }

}
