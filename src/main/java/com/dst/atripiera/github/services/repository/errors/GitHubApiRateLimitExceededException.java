package com.dst.atripiera.github.services.repository.errors;

public class GitHubApiRateLimitExceededException extends FeignClientCallException {
    public GitHubApiRateLimitExceededException(Integer status, GitHubError gitHubError) {
        super(
                status,
                String.format("%s, you can find more info at: %s", gitHubError.message(), gitHubError.documentationUrl())
        );
    }
}
