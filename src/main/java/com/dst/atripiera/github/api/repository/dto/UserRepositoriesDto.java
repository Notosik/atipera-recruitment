package com.dst.atripiera.github.api.repository.dto;

import java.util.Set;

public record UserRepositoriesDto(
        Set<RepositoryDto> repositories
) {}

