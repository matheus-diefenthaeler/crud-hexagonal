package br.com.diefenthaeler.hexagonal.adapters.out.client.mapper;

import br.com.diefenthaeler.hexagonal.adapters.out.client.response.AddressResponse;
import br.com.diefenthaeler.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
