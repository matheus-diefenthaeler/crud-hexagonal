package br.com.diefenthaeler.hexagonal.adapters.out.repository.entity;

import lombok.Data;

@Data
public class AdressEntity {
    private String street;
    private String city;
    private String state;

}
