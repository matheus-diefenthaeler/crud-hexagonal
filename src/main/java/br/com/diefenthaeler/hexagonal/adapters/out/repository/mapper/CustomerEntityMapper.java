package br.com.diefenthaeler.hexagonal.adapters.out.repository.mapper;

import br.com.diefenthaeler.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerEntityMapper {
    CustomerEntity toCostumerEntity(Customer customer);
}
