package br.com.diefenthaeler.hexagonal.application.core.usecase;

import br.com.diefenthaeler.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.diefenthaeler.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.diefenthaeler.hexagonal.application.ports.out.DeleteCustomerByIdOuputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOuputPort deleteCustomerByIdOuputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOuputPort deleteCustomerByIdOuputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOuputPort = deleteCustomerByIdOuputPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOuputPort.delete(id);
    }
}
