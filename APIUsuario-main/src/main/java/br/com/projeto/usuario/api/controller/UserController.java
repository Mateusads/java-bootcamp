package br.com.projeto.usuario.api.controller;

import br.com.projeto.usuario.api.controller.dto.UserRequestDTO;
import br.com.projeto.usuario.api.controller.dto.UserResponseDTO;
import br.com.projeto.usuario.api.controller.mapper.UserMapper;
import br.com.projeto.usuario.api.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView users(Model model) {
        model.addAttribute("userList", listAllUser());
        return new ModelAndView("index");
    }

    @GetMapping("/register")
    public ModelAndView newUser(@ModelAttribute("user") UserRequestDTO userRequestDTO) {
        return new ModelAndView("register/user");
    }

    @PostMapping("/register/user/save")
    public ModelAndView userSave(@ModelAttribute("user") UserRequestDTO userRequestDTO, Model model) {
        model.addAttribute("userSave", createUser(userRequestDTO));
        return new ModelAndView("register/save");
    }

    @GetMapping("/edit/user/{email}")
    public ModelAndView userEdit(@PathVariable("email") String emailRequest, Model model) {
        model.addAttribute("userEdit", findUserByEmail(emailRequest));
        return new ModelAndView("edit/user");
    }

    @PostMapping("/edit/user/update")
    public ModelAndView userEditUpdate(@ModelAttribute("userEdit") UserRequestDTO userRequestDTO, Model model) {
        model.addAttribute("userSave", updateUser(userRequestDTO));
        return new ModelAndView("register/save");
    }

    @GetMapping("/delete/user/{email}")
    public ModelAndView userDelete(@PathVariable("email") String emailRequest) {
        deleteUserByEmail(emailRequest);
        return new ModelAndView("register/save");
    }

    @PostMapping("/user")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
        var entity = UserMapper.toEntity(userRequestDTO);
        var result = userService.createUser(entity);
        return UserMapper.toDTO(result);
    }

    @GetMapping("/user")
    public List<UserResponseDTO> listAllUser() {
        var result = userService.findAll();
        return UserMapper.toDTOs(result);
    }

    @GetMapping("/user/name/{name}")
    public List<UserResponseDTO> findUserByName(@RequestParam String nameRequest) {
        var result = userService.findByName(nameRequest);
        return UserMapper.toDTOs(result);
    }

    @GetMapping("/user/email/{email}")
    public UserResponseDTO findUserByEmail(@RequestParam String emailRequest) {
        var result = userService.findByEmail(emailRequest);
        return UserMapper.toDTO(result);
    }

    @PatchMapping("/user/age")
    public UserResponseDTO updateUser(@RequestBody UserRequestDTO userRequestDTO) {
        var entity = UserMapper.toEntity(userRequestDTO);
        var result = userService.updateUser(entity);
        return UserMapper.toDTO(result);
    }

    @DeleteMapping("/user/delete/{email}")
    public void deleteUserByEmail(@RequestParam String emailRequest) {
        userService.deleteUser(emailRequest);

    }
}
