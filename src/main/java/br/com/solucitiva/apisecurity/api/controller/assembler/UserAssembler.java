package br.com.solucitiva.apisecurity.api.controller.assembler;

import br.com.solucitiva.apisecurity.api.controller.model.output.UserModelOutput;
import br.com.solucitiva.apisecurity.domain.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserAssembler {

    private ModelMapper modelMapper;

    public UserModelOutput toModelOutput(User user){

        return modelMapper.map(user, UserModelOutput.class);
    }

    public List<UserModelOutput> toListModelOutput(List<User> users){
        return users.stream().map(user -> this.toModelOutput(user))
                .collect(Collectors.toList());
    }


}
