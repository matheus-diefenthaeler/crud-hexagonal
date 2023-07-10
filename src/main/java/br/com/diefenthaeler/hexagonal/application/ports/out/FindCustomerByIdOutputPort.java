package br.com.diefenthaeler.hexagonal.application.ports.out;

import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String id);
}
