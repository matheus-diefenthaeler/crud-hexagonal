package br.com.diefenthaeler.hexagonal.application.ports.out;

import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
