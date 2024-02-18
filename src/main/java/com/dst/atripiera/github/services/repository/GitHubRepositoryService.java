package com.dst.atripiera.github.services.repository;

import com.dst.atripiera.github.services.repository.vo.Repository;

import java.util.Set;

@FunctionalInterface
public interface GitHubRepositoryService {
    Set<Repository> acquireUserRepos(String username);
}
