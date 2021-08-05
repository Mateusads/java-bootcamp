package br.com.bootcamp.controller.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String name;

    private String cpf;

    private String fullAdress;

    private int age;

    private String gender;


}
