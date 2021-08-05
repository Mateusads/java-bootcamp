package br.com.projeto.usuario.api.controller.mapper;

import br.com.projeto.usuario.api.controller.dto.UserRequestDTO;
import br.com.projeto.usuario.api.controller.dto.UserResponseDTO;
import br.com.projeto.usuario.api.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toEntity(UserRequestDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .age(userDTO.getAge())
                .email(userDTO.getEmail())
                .build();
    }

    public static UserResponseDTO toDTO(User response) {
        return UserResponseDTO.builder()
                .name(response.getName())
                .age(response.getAge())
                .email(response.getEmail())
                .build();
    }

    public static List<UserResponseDTO> toDTOs(List<User> users) {
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());

    }
}
