package com.gavin.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class description
 *
 * @author wangbingchang
 * @date 2020/12/27
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public HelloFeignFallbackService helloFeignFallbackService() {
        return new HelloFeignFallbackService();
    }
}
