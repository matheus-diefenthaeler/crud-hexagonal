package br.com.diefenthaeler.hexagonal.application.core.usecase;

import br.com.diefenthaeler.hexagonal.application.core.domain.Customer;
import br.com.diefenthaeler.hexagonal.application.ports.in.InsertCustomerInputPort;
import br.com.diefenthaeler.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import br.com.diefenthaeler.hexagonal.application.ports.out.InsertCustomerOutputPort;
import br.com.diefenthaeler.hexagonal.application.ports.out.SendCpfForValidationOuputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOuputPort sendCpfForValidationOuputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutPort findAddressByZipCodeOutPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOuputPort sendCpfForValidationOuputPort) {
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOuputPort = sendCpfForValidationOuputPort;
    }

    @Override
    public void insert(Customer customer, String zipcode) {
        var address = findAddressByZipCodeOutPort.find(zipcode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOuputPort.send(customer.getCpf());
    }
}
