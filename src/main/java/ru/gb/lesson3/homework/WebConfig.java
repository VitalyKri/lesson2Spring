package ru.gb.lesson3.homework;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebConfig implements WebApplicationInitializer {

    public static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup");
        // конструктор пустой
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // из какого контекста будет работать конфигурация (классы, учавствующие публикации)
        context.register(HomeConfiguration.class);

        // он перенаправляет запросы на контроллеры, Он будет знать куда перенаправлять запросы
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        //регистрация в сервлете томката (веб-сервиса)
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");



    }
}
