package br.com.diefenthaeler.hexagonal.adapters.out;

import br.com.diefenthaeler.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.diefenthaeler.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import br.com.diefenthaeler.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;
    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCostumerEntity(customer);
        customerRepository.save(customerEntity);

    }
}
