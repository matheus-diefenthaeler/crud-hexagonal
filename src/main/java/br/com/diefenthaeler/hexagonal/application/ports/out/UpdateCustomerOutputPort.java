package br.com.diefenthaeler.hexagonal.application.ports.out;

import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
