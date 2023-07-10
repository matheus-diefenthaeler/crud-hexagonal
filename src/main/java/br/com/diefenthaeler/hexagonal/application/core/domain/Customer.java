package br.com.diefenthaeler.hexagonal.application.core.domain;

public class Customer {
    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;

    public Customer() {
        this.isValidCpf = false;
    }

    public Customer(String id, String name, Address address, String cpf, Boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    public String getId() {
        return id;
    }

    public Customer setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Customer setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Customer setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public Customer setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
        return this;
    }
}
