package com.dst.atripiera.github.api.repository.dto;

import com.dst.atripiera.github.api.repository.UserRepositoriesDtoFactory;
import com.dst.atripiera.github.services.repository.vo.Repository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
final class UserRepositoriesDtoFactoryImpl implements UserRepositoriesDtoFactory {
    public UserRepositoriesDto create(Set<Repository> repositories) {
        return new UserRepositoriesDto(
                repositories.stream()
                        .map(RepositoryDto::from)
                        .collect(Collectors.toSet())
        );
    }
}