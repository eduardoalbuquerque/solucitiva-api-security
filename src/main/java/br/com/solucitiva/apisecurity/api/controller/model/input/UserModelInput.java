package br.com.solucitiva.apisecurity.api.controller.model.input;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModelInput {

    private String cpf;
    private String name;
    private String email;
    private String password;

}
