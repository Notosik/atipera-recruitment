package com.dst.atripiera.github.api.repository.dto;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.repository.util.ClassUtils.hasProperty;

import com.dst.atripiera.github.api.repository.dto.BranchDto;
import com.dst.atripiera.github.api.repository.dto.RepositoryDto;
import com.dst.atripiera.github.services.repository.vo.Branch;
import com.dst.atripiera.github.services.repository.vo.Owner;
import com.dst.atripiera.github.services.repository.vo.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class RepositoryDtoTest {

    @Test
    void testFrom() {
        // Create a Repository object
        Repository repository = new Repository(new Owner("user1"), "repo1", createBranches());

        // Call the from method
        RepositoryDto repositoryDto = RepositoryDto.from(repository);

        // Verify the generated RepositoryDto
        Assertions.assertNotNull(repositoryDto);
        Assertions.assertEquals(repository.owner().login(), repositoryDto.ownerLogin());
        Assertions.assertEquals(repository.repositoryName(), repositoryDto.repositoryName());
        Assertions.assertEquals(repository.branches().size(), repositoryDto.branches().size());
    }

    private Set<Branch> createBranches() {
        Set<Branch> branches = new HashSet<>();
        branches.add(new Branch("branch1", "commit1"));
        branches.add(new Branch("branch2", "commit2"));
        return branches;
    }
}