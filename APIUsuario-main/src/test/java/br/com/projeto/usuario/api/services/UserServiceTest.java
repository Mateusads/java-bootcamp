package br.com.projeto.usuario.api.services;

import br.com.projeto.usuario.api.entities.User;
import br.com.projeto.usuario.api.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService service;

    @Test
    void createUserTest(){
        var newUser = User.builder()
                .age(30)
                .email("mateus@medeiros")
                .name("Mateus")
                .build();
        var saved = service.createUser(newUser);

        Assertions.assertThat(saved.getId()).isEqualTo(1);

    }

}