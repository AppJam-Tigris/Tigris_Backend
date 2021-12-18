package team.appjam.tigris_server.domain.clinic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;

@Getter
@AllArgsConstructor
public class SurveyLinkResponse {

    private final String link;

    public SurveyLinkResponse(Clinic clinic) {
        this.link = clinic.getLink();
    }

}
