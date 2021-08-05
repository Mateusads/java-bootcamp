package br.com.bootcamp.service;

import br.com.bootcamp.model.User;
import br.com.bootcamp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User createUser(User entity) {
        userRepository.save(entity);
        return entity;
    }
}
