package br.com.diefenthaeler.hexagonal.adapters.in.consumer;

import br.com.diefenthaeler.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import br.com.diefenthaeler.hexagonal.adapters.in.consumer.message.CustomerMessage;
import br.com.diefenthaeler.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    private final UpdateCustomerInputPort updateCustomerInputPort;
    @KafkaListener(topics = "tp-cpf-validated", groupId = "diefenthaeler")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCostumer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
