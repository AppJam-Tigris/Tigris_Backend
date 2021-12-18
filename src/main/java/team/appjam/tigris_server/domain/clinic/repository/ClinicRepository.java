package team.appjam.tigris_server.domain.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    List<Clinic> findByNameContaining(String name);
    List<Clinic> findByCityContaining(String city);
}
