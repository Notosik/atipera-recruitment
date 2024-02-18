package com.dst.atripiera.github.services.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "gitHub",
        url = "https://api.github.com",
        configuration = GitHubFeignClientConfiguration.class

)
interface GitHubFeignClient {
    @GetMapping("/users/{username}/repos")
    List<GitHubRepositoryResponse> getUserRepos(@PathVariable String username);

    @GetMapping("/repos/{username}/{repository}/branches")
    List<GitHubRepositoryBranchResponse> getRepoBranches(@PathVariable String username, @PathVariable("repository") String repositoryName);
}


