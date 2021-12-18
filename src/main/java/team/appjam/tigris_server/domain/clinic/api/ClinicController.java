package team.appjam.tigris_server.domain.clinic.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.appjam.tigris_server.domain.clinic.api.dto.SurveyLinkResponse;
import team.appjam.tigris_server.domain.clinic.service.ClinicService;

@RequiredArgsConstructor
@RequestMapping("/clinic")
@RestController
public class ClinicController {

    private final ClinicService clinicService;

    @GetMapping("/{clinic-name}")
    public SurveyLinkResponse getSurveyLink(@PathVariable(name = "clinic-name") String clinic) {
        return clinicService.getSurveyLink(clinic);
    }

}
