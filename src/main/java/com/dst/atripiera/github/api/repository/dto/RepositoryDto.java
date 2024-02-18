package com.dst.atripiera.github.api.repository.dto;

import com.dst.atripiera.github.services.repository.vo.Repository;

import java.util.Set;
import java.util.stream.Collectors;

public record RepositoryDto(
        String ownerLogin,
        String repositoryName,
        Set<BranchDto> branches
) {

    public static RepositoryDto from(Repository repository) {
        return new RepositoryDto(
                repository.owner().login(),
                repository.repositoryName(),
                repository.branches().stream()
                        .map(BranchDto::from)
                        .collect(Collectors.toSet())
        );
    }

}