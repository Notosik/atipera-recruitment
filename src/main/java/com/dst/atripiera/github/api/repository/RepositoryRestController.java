package com.dst.atripiera.github.api.repository;

import com.dst.atripiera.github.api.repository.dto.UserRepositoriesDto;
import com.dst.atripiera.github.services.repository.GitHubRepositoryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class RepositoryRestController {

    private final GitHubRepositoryService gitHubRepositoryService;
    private final UserRepositoriesDtoFactory userRepositoriesResultFactory;

    RepositoryRestController(
            GitHubRepositoryService gitHubRepositoryService,
            UserRepositoriesDtoFactory userRepositoriesResultFactory
    ) {
        this.gitHubRepositoryService = gitHubRepositoryService;
        this.userRepositoriesResultFactory = userRepositoriesResultFactory;
    }

    @GetMapping(path = "/repositories/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserRepositoriesDto> getUserRepositories(@PathVariable String username) {
        var repositories = gitHubRepositoryService.acquireUserRepos(username);
        return ResponseEntity.ok(userRepositoriesResultFactory.create(repositories));
    }
}


