package ru.sber.security.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Customer {
    private UUID id;
    private String firstName;
    private String lastName;
}
