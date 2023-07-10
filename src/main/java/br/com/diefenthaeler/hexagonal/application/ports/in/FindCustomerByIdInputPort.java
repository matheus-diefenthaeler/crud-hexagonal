package br.com.diefenthaeler.hexagonal.application.ports.in;

import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
