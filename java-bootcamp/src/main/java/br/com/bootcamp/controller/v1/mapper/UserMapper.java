package br.com.bootcamp.controller.v1.mapper;
;
import br.com.bootcamp.controller.v1.dto.UserRequestDTO;
import br.com.bootcamp.controller.v1.dto.UserResponseDTO;
import br.com.bootcamp.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toEntity(UserRequestDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .cpf(userDTO.getCpf())
                .age(userDTO.getAge())
                .gender(userDTO.getGender())
                .fullAdress(userDTO.getFullAdress())
                .build();
    }

    public static UserResponseDTO fullToDTO(User response) {
        return UserResponseDTO.builder()
                .name(response.getName())
                .age(response.getAge())
                .cpf(response.getCpf())
                .fullAdress(response.getFullAdress())
                .gender(response.getGender())
                .build();
    }

    public static UserResponseDTO toDTO(User response) {
        return UserResponseDTO.builder()
                .name(response.getName())
                .age(response.getAge())
                .gender(response.getGender())
                .build();
    }

    public static List<UserResponseDTO> toDTOs(List<User> users) {
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());

    }
}
