package team.appjam.tigris_server.domain.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;

import java.util.Optional;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    Optional<Clinic> findByName(String name);
}
