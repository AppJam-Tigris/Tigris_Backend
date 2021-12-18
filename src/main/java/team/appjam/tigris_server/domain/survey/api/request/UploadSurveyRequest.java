package team.appjam.tigris_server.domain.survey.api.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import team.appjam.tigris_server.domain.clinic.entity.TimeSchedule;
import team.appjam.tigris_server.domain.survey.entity.CovidCheckType;
import team.appjam.tigris_server.domain.survey.entity.Question;

import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@NoArgsConstructor
public class UploadSurveyRequest {

    @NotNull(message = "covidCheckType은 Null, 공백을 허용하지 않습니다.")
    private CovidCheckType covidCheckType;

    @NotNull(message = "clinicId Null, 공백을 허용하지 않습니다.")
    private Integer clinicId;

    @NotNull(message = "questionList는 Null, 공백을 허용하지 않습니다.")
    private List<Question> questionList;

    @NotNull(message = "timeSchedule은 Null, 공백을 허용하지 않습니다.")
    private TimeSchedule timeSchedule;

}
