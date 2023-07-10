package br.com.diefenthaeler.hexagonal.application.core.usecase;

import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import br.com.diefenthaeler.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.diefenthaeler.hexagonal.application.ports.in.UpdateCustomerInputPort;
import br.com.diefenthaeler.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import br.com.diefenthaeler.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutPort findAddressByZipCodeOutPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutPort.find(zipCode);

        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
