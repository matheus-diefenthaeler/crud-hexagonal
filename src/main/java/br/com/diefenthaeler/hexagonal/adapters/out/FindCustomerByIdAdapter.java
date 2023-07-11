package br.com.diefenthaeler.hexagonal.adapters.out;

import br.com.diefenthaeler.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.diefenthaeler.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import br.com.diefenthaeler.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCostumer(entity));
    }
}
