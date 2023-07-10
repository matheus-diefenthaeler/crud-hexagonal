package br.com.diefenthaeler.hexagonal.application.ports.in;

import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
