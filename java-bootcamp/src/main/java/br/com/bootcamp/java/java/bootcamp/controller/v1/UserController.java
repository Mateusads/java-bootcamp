package br.com.bootcamp.java.java.bootcamp.controller.v1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class UserController {


    @GetMapping("/users")
    public String getUser(){
        return "s";
    }


}
