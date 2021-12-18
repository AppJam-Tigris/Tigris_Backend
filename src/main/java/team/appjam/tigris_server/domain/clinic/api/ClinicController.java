package team.appjam.tigris_server.domain.clinic.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.appjam.tigris_server.domain.clinic.api.dto.response.ClinicResponse;
import team.appjam.tigris_server.domain.clinic.service.ClinicService;

@RequiredArgsConstructor
@RequestMapping("/clinic")
@RestController
public class ClinicController {

    private final ClinicService clinicService;

    @GetMapping("/search")
    public ClinicResponse searchClinic(@RequestBody String keyword) {
        return clinicService.searchClinicInfo(keyword);
    }

    @GetMapping
    public ClinicResponse getRecommendClinic() {
        return  clinicService.getRecommendClinic();
    }

}
