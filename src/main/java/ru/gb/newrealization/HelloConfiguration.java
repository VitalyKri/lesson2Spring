package ru.gb.newrealization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class HelloConfiguration {

    // old
//    @Bean
//    public MessageProvider provider(){
//        return new WantMessageProvider();
//    }
//
//    @Bean
//    public MessageRender render(){
//        ConsoleMessageRender render = new ConsoleMessageRender();
//        render.setMessageProvider(provider());
//        return render;
//    }


}
