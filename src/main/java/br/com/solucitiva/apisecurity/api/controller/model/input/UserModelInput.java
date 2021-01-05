package br.com.solucitiva.apisecurity.api.controller.model.input;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserModelInput {

    @CPF
    private String cpf;
    @Size(min = 10, max = 60)
    private String name;
    @NotBlank
    @Email
    private String email;
    @Size(min = 6, max = 10)
    private String password;

}
