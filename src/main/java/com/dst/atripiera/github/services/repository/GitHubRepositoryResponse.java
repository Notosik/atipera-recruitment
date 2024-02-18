package com.dst.atripiera.github.services.repository;

import com.dst.atripiera.github.services.repository.vo.Owner;

record GitHubRepositoryResponse(
        Boolean fork,
        Integer id,
        String name,
        Owner owner
) {
}
