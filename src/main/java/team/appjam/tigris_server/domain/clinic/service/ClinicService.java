package team.appjam.tigris_server.domain.clinic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.appjam.tigris_server.domain.clinic.api.dto.response.ClinicInfoResponse;
import team.appjam.tigris_server.domain.clinic.repository.ClinicRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public List<ClinicInfoResponse> searchClinicInfo(String keyword) {
        return clinicRepository.findByNameContaining(keyword).stream()
                .map(ClinicInfoResponse::new)
                .collect(Collectors.toList());
    }

}
