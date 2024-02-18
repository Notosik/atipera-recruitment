package com.dst.atripiera.github.api.repository;

import com.dst.atripiera.github.api.repository.dto.UserRepositoriesDto;
import com.dst.atripiera.github.services.repository.vo.Repository;

import java.util.Set;


@FunctionalInterface
public interface UserRepositoriesDtoFactory {
    UserRepositoriesDto create(Set<Repository> repositories);
}
