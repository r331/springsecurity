package ru.sber.security.customer;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;
import static ru.sber.security.customer.Permission.DELETE;
import static ru.sber.security.customer.Permission.READ;

public enum Role {
    ADMIN(READ, DELETE),
    CUSTOMER(READ);

    @Getter
    private final Set<GrantedAuthority> permissions;

    Role(Permission... permissions) {
        this.permissions = stream(permissions)
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(toSet());
    }
}
