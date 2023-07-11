package br.com.diefenthaeler.hexagonal.application.ports.out;

public interface SendCpfForValidationOuputPort {
    void send(String cpf);
}
