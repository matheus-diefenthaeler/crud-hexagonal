package br.com.diefenthaeler.hexagonal.adapters.out;

import br.com.diefenthaeler.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import br.com.diefenthaeler.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import br.com.diefenthaeler.hexagonal.application.core.domain.Address;
import br.com.diefenthaeler.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPort {
    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipcode) {
        var addressResponse = findAddressByZipCodeClient.find(zipcode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
