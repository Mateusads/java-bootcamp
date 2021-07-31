package br.com.bootcamp.java.java.bootcamp.repository;

import br.com.bootcamp.java.java.bootcamp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
