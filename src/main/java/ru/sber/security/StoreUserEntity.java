package ru.sber.security;

import lombok.*;
import ru.sber.security.customer.Role;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

import static javax.persistence.EnumType.STRING;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "STOREUSER")
@Getter
@Setter
public class StoreUserEntity {
    @Id
    private UUID id;

    private String name;

    private String pass;

    @Enumerated(STRING)
    private Role role;
}
