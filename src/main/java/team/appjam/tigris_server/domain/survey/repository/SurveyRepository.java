package team.appjam.tigris_server.domain.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.appjam.tigris_server.domain.survey.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
