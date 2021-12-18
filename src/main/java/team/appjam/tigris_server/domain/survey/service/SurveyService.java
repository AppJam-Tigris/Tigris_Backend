package team.appjam.tigris_server.domain.survey.service;

import org.springframework.stereotype.Service;
import team.appjam.tigris_server.domain.survey.dto.request.UploadSurveyRequest;

@Service
public interface SurveyService {

    void uploadSurvey(UploadSurveyRequest request);

}
