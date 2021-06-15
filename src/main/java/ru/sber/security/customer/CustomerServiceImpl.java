package ru.sber.security.customer;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    final List<Customer> customers = new ArrayList<>();

    @PostConstruct
    void fillCustomers(){
        customers.add(new Customer(UUID.fromString("00ba0b5f-9888-4c28-8140-34f4ab0f8574"), "Arnold", "Schwarzenegger"));
        customers.add(new Customer(UUID.randomUUID(), "Sylvester", "Stallone"));
        customers.add(new Customer(UUID.randomUUID(), "Dolph", "Lundgren"));
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer getById(UUID id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findAny().orElseThrow(NoSuchElementException::new);
    }
}
