package br.com.projeto.usuario.api.repositories;

import br.com.projeto.usuario.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    User findByEmail(String emailRequest);
}
