package br.com.diefenthaeler.hexagonal.adapters.in.consumer.mapper;

import br.com.diefenthaeler.hexagonal.adapters.in.consumer.message.CustomerMessage;
import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {
    @Mapping(target = "address", ignore = true)
    Customer toCostumer(CustomerMessage customerMessage);
}

