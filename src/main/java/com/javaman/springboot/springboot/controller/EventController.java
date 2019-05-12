package com.javaman.springboot.springboot.controller;

import com.javaman.springboot.springboot.event.ControllerPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.javaman.springboot.springboot.constant.Constant.ROOT_REQUEST_MAPPING;

/**
 * @author pengzhe
 * @date 2019-05-12 13:09
 * @description
 */
@RestController
@RequestMapping(ROOT_REQUEST_MAPPING)
@Slf4j
public class EventController {

    @Autowired
    private ControllerPublisher publisher;

    @GetMapping("/event")
    public String eventController() {
        publisher.publishEvent("客户端参数");
        return "OK";
    }

}
