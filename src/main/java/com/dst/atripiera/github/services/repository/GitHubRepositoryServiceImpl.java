package com.dst.atripiera.github.services.repository;


import com.dst.atripiera.github.services.repository.vo.Branch;
import com.dst.atripiera.github.services.repository.vo.Repository;

import java.util.Set;
import java.util.stream.Collectors;

final class GitHubRepositoryServiceImpl implements GitHubRepositoryService {
    private final GitHubFeignClient gitHubFeignClient;

    GitHubRepositoryServiceImpl(final GitHubFeignClient gitHubFeignClient) {
        this.gitHubFeignClient = gitHubFeignClient;
    }

    @Override
    public Set<Repository> acquireUserRepos(String username) {
        final var repos = gitHubFeignClient.getUserRepos(username);
        return repos.stream()
                .filter(repo -> !repo.fork())
                .map(this::acquireRepositoryDetails)
                .collect(Collectors.toSet());
    }

    private Repository acquireRepositoryDetails(GitHubRepositoryResponse gitHubRepository) {
        final var branches = gitHubFeignClient.getRepoBranches(gitHubRepository.owner().login(), gitHubRepository.name())
                .stream()
                .map(gitHubRepositoryBranch ->
                        new Branch(
                                gitHubRepositoryBranch.name(),
                                gitHubRepositoryBranch.commit().sha()
                        )
                ).collect(Collectors.toSet());

        return new Repository(
                gitHubRepository.owner(),
                gitHubRepository.name(),
                branches
        );
    }
}
