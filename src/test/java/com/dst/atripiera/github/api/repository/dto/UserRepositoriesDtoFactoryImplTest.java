package com.dst.atripiera.github.api.repository.dto;

import com.dst.atripiera.github.api.repository.UserRepositoriesDtoFactory;
import com.dst.atripiera.github.services.repository.vo.Branch;
import com.dst.atripiera.github.services.repository.vo.Owner;
import com.dst.atripiera.github.services.repository.vo.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class UserRepositoriesDtoFactoryImplTest {

    private UserRepositoriesDtoFactory userRepositoriesDtoFactory;

    @BeforeEach
    public void setUp() {
        userRepositoriesDtoFactory = new UserRepositoriesDtoFactoryImpl();
    }

    @Test
    void testCreateNewInstanceOfDto() {
        // Create a set of repositories
        var owner = new Owner("user1");
        Set<Repository> repositories = new HashSet<>();
        repositories.add(new Repository(owner, "repo1", createBranches()));
        repositories.add(new Repository(owner, "repo2", createBranches()));
        repositories.add(new Repository(owner, "repo3", createBranches()));

        // Call the create method
        UserRepositoriesDto userRepositoriesDto = userRepositoriesDtoFactory.create(repositories);

        // Verify the generated UserRepositoriesDto
        Assertions.assertNotNull(userRepositoriesDto);
        Assertions.assertEquals(repositories.size(), userRepositoriesDto.repositories().size());
    }

    private Set<Branch> createBranches() {
        Set<Branch> branches = new HashSet<>();
        branches.add(new Branch("main", "mainsha"));
        branches.add(new Branch("develop", "devsha"));
        return branches;
    }
}