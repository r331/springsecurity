package ru.sber.security.customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAll();

    Customer getById(UUID id);
}
