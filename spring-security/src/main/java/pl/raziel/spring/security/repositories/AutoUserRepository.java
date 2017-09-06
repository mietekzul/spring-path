package pl.raziel.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.raziel.spring.security.entities.AutoUser;

public interface AutoUserRepository extends JpaRepository<AutoUser, Long> {
}
