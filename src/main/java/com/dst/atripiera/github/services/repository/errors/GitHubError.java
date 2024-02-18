package com.dst.atripiera.github.services.repository.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GitHubError(String message, @JsonProperty("documentation_url") String documentationUrl) {
}