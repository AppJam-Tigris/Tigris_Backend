package team.appjam.tigris_server.domain.clinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.appjam.tigris_server.domain.clinic.entity.Count;
import team.appjam.tigris_server.domain.clinic.entity.TimeSchedule;

import java.util.Optional;

@Repository
public interface CountRepository extends CrudRepository<Count, Integer> {
    Optional<Count> findByClinicIdAndTime(Integer clinicId, TimeSchedule time);
}
