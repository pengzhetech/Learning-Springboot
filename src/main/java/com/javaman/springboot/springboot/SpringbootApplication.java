package com.javaman.springboot.springboot;

import com.javaman.springboot.springboot.listener.MyApplicationEnvironmentPreparedEventListener;
import com.javaman.springboot.springboot.listener.MyApplicationFailedEventListener;
import com.javaman.springboot.springboot.listener.MyApplicationPreparedEventListener;
import com.javaman.springboot.springboot.listener.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringbootApplication.class);
        application.addListeners(new MyApplicationStartedEventListener(),
            new MyApplicationPreparedEventListener(),
            new MyApplicationFailedEventListener(),
            new MyApplicationEnvironmentPreparedEventListener());
        application.run(args);
    }

}
