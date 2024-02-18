package com.dst.atripiera.github.services.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GitHubRepositoryServiceConfiguration {
    @Bean
    GitHubRepositoryService gitHubRepositoryService(GitHubFeignClient gitHubFeignClient){
        return new GitHubRepositoryServiceImpl(gitHubFeignClient);
    }
}
