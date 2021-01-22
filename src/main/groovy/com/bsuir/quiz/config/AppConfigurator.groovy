package com.bsuir.quiz.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

class AppConfigurator extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        [
                PersistenceConfigurator.class,
                CacheConfigurator.class
        ]
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        [
                WebMVCConfigurator.class
        ]
    }

    @Override
    protected String[] getServletMappings() {
        ["/"]
    }
}
