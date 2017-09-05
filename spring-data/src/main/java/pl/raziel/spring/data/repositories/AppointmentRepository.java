package pl.raziel.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.raziel.spring.data.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
