package br.com.projeto.usuario.api.services;

import br.com.projeto.usuario.api.entities.User;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@AllArgsConstructor
public class FindByNameTest {

    private UserService userService;

    @Test
    void findByName() {

        var user = User.builder()
                .email("mateus@medeiros")
                .age(10)
                .name("Mateus")
                .build();

        var findUser = userService.findByName(user.getName());
        Assertions.assertThat(findUser.get(0).getName()).isEqualTo("mateus@test.com");

    }
}