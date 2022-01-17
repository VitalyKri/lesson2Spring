package ru.gb.newrealization;


import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component("want")
@Primary
@Profile("want")
public class WantMessageProvider implements MessageProvider {

    @InjectFoodStuff
    private String stuff;

    public WantMessageProvider() {
        System.out.println("stuff from constructor:"+ stuff);
    }

    @PostConstruct
    public void init(){
        System.out.println("stuff from init method:"+ stuff);
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("stuff from preDestroy:"+ stuff);
    }

    @Override
    public String getMessage() {
        return "i want "+ stuff;
    }
}
