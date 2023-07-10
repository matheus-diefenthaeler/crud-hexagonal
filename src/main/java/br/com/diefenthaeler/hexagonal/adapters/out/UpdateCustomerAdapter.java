package br.com.diefenthaeler.hexagonal.adapters.out;

import br.com.diefenthaeler.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.diefenthaeler.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import br.com.diefenthaeler.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCostumerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
