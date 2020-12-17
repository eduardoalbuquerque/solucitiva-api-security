package br.com.solucitiva.apisecurity.api.controller.disassembler;


import br.com.solucitiva.apisecurity.api.controller.model.input.UserModelInput;
import br.com.solucitiva.apisecurity.domain.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserDisassembler {

    private ModelMapper modelMapper;

    public User toModelInput(UserModelInput userModelInput){

        return modelMapper.map(userModelInput, User.class);
    }


}
