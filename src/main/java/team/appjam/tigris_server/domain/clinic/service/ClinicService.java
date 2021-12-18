package team.appjam.tigris_server.domain.clinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.appjam.tigris_server.domain.clinic.api.dto.SurveyLinkResponse;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;
import team.appjam.tigris_server.domain.clinic.exception.ClinicNotFoundException;
import team.appjam.tigris_server.domain.clinic.repository.ClinicRepository;

@RequiredArgsConstructor
@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    @Transactional(readOnly = true)
    public SurveyLinkResponse getSurveyLink(String clinicName) {
        Clinic clinic = clinicRepository.findByName(clinicName)
                .orElseThrow(() -> ClinicNotFoundException.EXCEPTION);

        return new SurveyLinkResponse(clinic);
    }

}
