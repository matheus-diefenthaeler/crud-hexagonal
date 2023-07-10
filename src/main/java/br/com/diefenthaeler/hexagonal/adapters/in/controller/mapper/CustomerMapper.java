package br.com.diefenthaeler.hexagonal.adapters.in.controller.mapper;

import br.com.diefenthaeler.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.diefenthaeler.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCostumer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

}
