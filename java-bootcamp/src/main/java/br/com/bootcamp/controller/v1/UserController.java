package br.com.bootcamp.controller.v1;


import br.com.bootcamp.controller.v1.dto.UserRequestDTO;
import br.com.bootcamp.controller.v1.mapper.UserMapper;
import br.com.bootcamp.model.User;
import br.com.bootcamp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Controller
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/users")
    public String getUser(){
        return "s";
    }

    @PostMapping("/register")
    public User createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        var entity = UserMapper.toEntity(userRequestDTO);
        var result = userService.createUser(entity);
        return result;
    }


}
