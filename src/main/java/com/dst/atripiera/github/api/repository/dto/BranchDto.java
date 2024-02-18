package com.dst.atripiera.github.api.repository.dto;

import com.dst.atripiera.github.services.repository.vo.Branch;

public record BranchDto(String name, String lastCommitSha) {
    public static BranchDto from(Branch branch) {
        return new BranchDto(branch.name(), branch.lastCommitSha());
    }
}

