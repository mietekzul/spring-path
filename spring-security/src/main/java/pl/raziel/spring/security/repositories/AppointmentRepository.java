package pl.raziel.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.raziel.spring.security.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
