package team.appjam.tigris_server.domain.survey.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team.appjam.tigris_server.domain.survey.dto.request.UploadSurveyRequest;
import team.appjam.tigris_server.domain.survey.repository.SurveyRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService{
    private final SurveyRepository surveyRepository;


    @Override
    public void uploadSurvey(UploadSurveyRequest request) {

        


    }
}
