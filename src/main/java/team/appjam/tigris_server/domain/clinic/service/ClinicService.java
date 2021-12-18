package team.appjam.tigris_server.domain.clinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.appjam.tigris_server.domain.clinic.api.dto.response.ClinicResponse;
import team.appjam.tigris_server.domain.clinic.repository.ClinicRepository;
import team.appjam.tigris_server.domain.user.entity.User;
import team.appjam.tigris_server.domain.user.facade.UserFacade;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClinicService {

    private final UserFacade userFacade;
    private final ClinicRepository clinicRepository;

    @Transactional(readOnly = true)
    public ClinicResponse searchClinicInfo(String keyword) {
        return clinicRepository.findByNameContaining(keyword).stream()
                .map(ClinicResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClinicResponse getRecommendClinic() {
        User user = userFacade.getCurrentUser();

        return clinicRepository.findByCityContaining(user.getLocation().getRoadName()).stream()
                .map(clinic -> {
                    ClinicResponse response = new ClinicResponse()
                })
    }

}
