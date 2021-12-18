package team.appjam.tigris_server.domain.survey.service;

import team.appjam.tigris_server.domain.survey.api.request.UploadSurveyRequest;

public interface SurveyService {

    void uploadSurvey(UploadSurveyRequest request);

}
