package br.com.diefenthaeler.hexagonal.application.ports.out;

import br.com.diefenthaeler.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPort {

    Address find(String zipcode);
}
