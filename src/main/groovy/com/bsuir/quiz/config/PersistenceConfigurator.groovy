package com.bsuir.quiz.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = ["com.bsuir.quiz.model", "com.bsuir.quiz.dao"])
@ImportResource(locations = "classpath:persistence.groovy")
class PersistenceConfigurator {}
