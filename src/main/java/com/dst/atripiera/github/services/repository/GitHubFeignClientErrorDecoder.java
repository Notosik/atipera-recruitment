package com.dst.atripiera.github.services.repository;


import com.dst.atripiera.github.services.repository.errors.GitHubApiRateLimitExceededException;
import com.dst.atripiera.github.services.repository.errors.GitHubError;
import com.dst.atripiera.github.services.repository.errors.GitHubUserNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;

class GitHubFeignClientErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        GitHubError gitHubError = tryToParseResponse(response);
        if (gitHubError == null) {
            return errorDecoder.decode(methodKey, response);
        }

        return switch (response.status()) {
            case 403 -> new GitHubApiRateLimitExceededException(response.status(), gitHubError);
            case 404 -> new GitHubUserNotFoundException(response.status(), gitHubError);
            default -> errorDecoder.decode(methodKey, response);
        };
    }

    private GitHubError tryToParseResponse(Response response) {
        try {
            byte[] bodyData = Util.toByteArray(response.body().asInputStream());
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(bodyData, GitHubError.class);
        } catch (IOException e) {
            return null;
        }
    }
}