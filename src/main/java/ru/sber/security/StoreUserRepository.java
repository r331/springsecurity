package ru.sber.security;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface StoreUserRepository extends CrudRepository<StoreUserEntity, UUID> {
    Optional<StoreUserEntity> findByName(String name);
}
