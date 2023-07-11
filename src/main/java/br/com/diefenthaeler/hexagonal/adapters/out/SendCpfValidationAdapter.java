package br.com.diefenthaeler.hexagonal.adapters.out;

import br.com.diefenthaeler.hexagonal.application.ports.out.SendCpfForValidationOuputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendCpfValidationAdapter implements SendCpfForValidationOuputPort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
