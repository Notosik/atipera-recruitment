package com.dst.atripiera.github.services.repository;

record GitHubRepositoryBranchResponse(String name, Commit commit) {
    record Commit(String sha, String url) {
    }
}
