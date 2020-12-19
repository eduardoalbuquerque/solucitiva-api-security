package br.com.solucitiva.apisecurity;

import br.com.solucitiva.apisecurity.domain.model.User;
import br.com.solucitiva.apisecurity.domain.repository.UserRepository;
import br.com.solucitiva.apisecurity.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestConfiguration{

        @Bean
        public UserService userService(){
            return new UserService();
        }

    }

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    public void userTestServiceFindById(){
        User user = new User();
        Optional userOptional = userService.findById(1L);
        var user2 = userOptional.of(user);
        Assertions.assertEquals("Luiz Eduardo",user2);

    }

    @Before
    public void setup(){
        User user = new User();
        user.setId(1L);
        user.setCpf("91401160425");
        user.setName("Luiz Eduardo");
        user.setEmail("edu@hotmail.com");
        user.setPassword("123");
        Long id = 1L;

        Mockito.when(userRepository.findById(user.getId()))
                .thenReturn(Optional.of(user));
    }

}
