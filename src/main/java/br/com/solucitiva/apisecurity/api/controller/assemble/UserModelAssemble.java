package br.com.solucitiva.apisecurity.api.controller.assemble;

import br.com.solucitiva.apisecurity.api.controller.model.output.UserModelOutput;
import br.com.solucitiva.apisecurity.domain.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserModelAssemble {

    private ModelMapper modelMapper;

    public UserModelOutput toModelOutput(User user){

        return modelMapper.map(user, UserModelOutput.class);
    }


}
