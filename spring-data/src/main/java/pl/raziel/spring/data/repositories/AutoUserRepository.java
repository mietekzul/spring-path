package pl.raziel.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.raziel.spring.data.entities.AutoUser;

public interface AutoUserRepository extends JpaRepository<AutoUser, Long> {
}
