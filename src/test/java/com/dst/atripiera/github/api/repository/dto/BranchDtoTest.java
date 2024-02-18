package com.dst.atripiera.github.api.repository.dto;

import com.dst.atripiera.github.services.repository.vo.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BranchDtoTest {

    @Test
    void testFrom() {
        // Create a Branch object
        Branch branch = new Branch("branch1", "commit1");

        // Call the from method
        BranchDto branchDto = BranchDto.from(branch);

        // Verify the generated BranchDto
        assertEquals(branch.name(), branchDto.name());
        assertEquals(branch.lastCommitSha(), branchDto.lastCommitSha());
    }
}