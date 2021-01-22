package com.bsuir.quiz.config

import com.google.common.cache.CacheBuilder
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.time.Duration

@Configuration
@EnableCaching
class CacheConfigurator {

    @Bean
    CacheManager simpleCacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager()
        simpleCacheManager.caches = [
                new ConcurrentMapCache(
                        'quizzes',
                        CacheBuilder.newBuilder().
                                expireAfterWrite(Duration.ofMinutes(1))
                                .maximumSize(100)
                                .build()
                                .asMap(),
                        false
                )
        ]
        simpleCacheManager
    }
}
