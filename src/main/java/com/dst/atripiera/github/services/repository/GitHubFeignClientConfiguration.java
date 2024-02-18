package com.dst.atripiera.github.services.repository;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

class GitHubFeignClientConfiguration {
    @Bean
    ErrorDecoder errorDecoder() {
        return new GitHubFeignClientErrorDecoder();
    }
}

