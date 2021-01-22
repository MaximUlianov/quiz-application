package com.bsuir.quiz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.bsuir.quiz")
@EnableWebMvc
class WebMVCConfigurator implements WebMvcConfigurer {}
