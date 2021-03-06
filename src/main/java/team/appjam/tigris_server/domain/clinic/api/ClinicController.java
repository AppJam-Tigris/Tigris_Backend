package team.appjam.tigris_server.domain.clinic.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.appjam.tigris_server.domain.clinic.api.dto.response.ClinicInfoResponse;
import team.appjam.tigris_server.domain.clinic.service.ClinicService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/clinic")
@RestController
public class ClinicController {

    private final ClinicService clinicService;

    @GetMapping("/search")
    public List<ClinicInfoResponse> searchClinic(@RequestBody String keyword) {
        return clinicService.searchClinicInfo(keyword);
    }

    @GetMapping
    public List<ClinicInfoResponse> getRecommendClinic() {
        return clinicService.getRecommendClinic();
    }

}
