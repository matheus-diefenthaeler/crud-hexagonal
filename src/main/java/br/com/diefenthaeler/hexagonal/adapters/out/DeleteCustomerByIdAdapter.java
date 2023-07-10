package br.com.diefenthaeler.hexagonal.adapters.out;

import br.com.diefenthaeler.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.diefenthaeler.hexagonal.application.ports.out.DeleteCustomerByIdOuputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOuputPort {

    private final CustomerRepository customerRepository;
    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
