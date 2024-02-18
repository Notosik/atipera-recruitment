package com.dst.atripiera.github.services.repository.vo;

import java.util.Set;

public record Repository(
        Owner owner,
        String repositoryName,
        Set<Branch> branches
) {
}
