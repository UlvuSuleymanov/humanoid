//package com.insta.pomidro.config;
//
//import jdk.jfr.Description;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//
//@Configuration
//public class TemplateConfig {
//    @Bean
//    @Description("Thymeleaf Template Resolver")
//    public ServletContextTemplateResolver templateResolver() {
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//
//        return templateResolver;
//    }
//
//    @Bean
//    @Description("Thymeleaf Template Engine")
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setTemplateEngineMessageSource(messageSource());
//        return templateEngine;
//    }
//
//    @Bean
//    @Description("Thymeleaf View Resolver")
//    public ThymeleafViewResolver viewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setOrder(1);
//        return viewResolver;
//    }
//}
