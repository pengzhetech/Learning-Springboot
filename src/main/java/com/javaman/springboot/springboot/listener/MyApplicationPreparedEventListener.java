package com.javaman.springboot.springboot.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author pengzhe
 * @date 2019-05-13 17:51
 * ApplicationPreparedEvent:
 * spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的。
 *
 * 在获取完上下文后，可以将上下文传递出去做一些额外的操作。
 *
 * 在该监听器中是无法获取自定义bean并进行操作的。
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        System.out.println("------>MyApplicationPreparedEventListener");
        ConfigurableApplicationContext cac = event.getApplicationContext();
        passContextInfo(cac);
    }

    /**
     * 传递上下文
     *
     * @param cac
     */
    private void passContextInfo(ApplicationContext cac) {
        //dosomething()
    }
}
