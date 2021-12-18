package team.appjam.tigris_server.domain.survey.dto.request;


import lombok.Getter;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;
import team.appjam.tigris_server.domain.survey.entity.CovidCheckType;
import team.appjam.tigris_server.domain.survey.entity.Question;

import java.util.List;


@Getter
public class UploadSurveyRequest {
    private CovidCheckType covidCheckType;
    private Clinic clinic;
    private List<Question> questionList;

}
