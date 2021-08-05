package br.com.projeto.usuario.api.services;

import br.com.projeto.usuario.api.entities.User;
import br.com.projeto.usuario.api.repositories.UserRepository;
import br.com.projeto.usuario.api.services.exceptions.DataBaseException;
import br.com.projeto.usuario.api.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        emailUsed(user);
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String nameRequest) {
        var entity = userRepository.findByName(nameRequest);
        if (!entity.isEmpty()) {
            return entity;
        }
        throw new ResourceNotFoundException("Name not found");
    }

    public User findByEmail(String emailRequest) {
        var entity = userRepository.findByEmail(emailRequest);
        if (entity != null) {
            return entity;
        }
        throw new ResourceNotFoundException(emailRequest);
    }

    public User updateUser(User user) {
        var entity = findByEmail(user.getEmail());
        entity.setAge(user.getAge());
        entity.setName(user.getName());
        return userRepository.save(entity);
    }

    public void deleteUser(String emailRequest) {
        var entity = findByEmail(emailRequest);
        userRepository.delete(entity);
    }

    private void emailUsed(User user) {
        var entity = userRepository.findByEmail(user.getEmail());
        if (entity != null) {
            throw new DataBaseException("Error - email is being used");
        }
    }



}
