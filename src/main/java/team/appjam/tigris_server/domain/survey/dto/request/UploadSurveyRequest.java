package team.appjam.tigris_server.domain.survey.dto.request;


import lombok.Getter;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;
import team.appjam.tigris_server.domain.clinic.entity.TimeSchedule;
import team.appjam.tigris_server.domain.survey.entity.CovidCheckType;
import team.appjam.tigris_server.domain.survey.entity.Question;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
public class UploadSurveyRequest {
    @NotBlank
    private CovidCheckType covidCheckType;
    @NotBlank
    private Integer clinicId;
    @NotBlank
    private List<Question> questionList;
    @NotBlank
    private TimeSchedule timeSchedule;

}
