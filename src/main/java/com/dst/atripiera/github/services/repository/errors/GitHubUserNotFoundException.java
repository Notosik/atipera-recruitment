package com.dst.atripiera.github.services.repository.errors;

public class GitHubUserNotFoundException extends FeignClientCallException {
    public GitHubUserNotFoundException(Integer status, GitHubError gitHubError) {
        super(
                status,
                String.format("Given username does not exist, you can find more info at: %s", gitHubError.documentationUrl())
        );
    }
}
