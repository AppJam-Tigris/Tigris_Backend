package team.appjam.tigris_server.domain.clinic.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;

@Getter
@AllArgsConstructor
public class ClinicInfoResponse {

    private final Integer clinicId;
    private final String name;
    private final String address;
    private final String city;
    private final String managerPhoneNumber;

    public ClinicInfoResponse(Clinic clinic) {
        this.clinicId = clinic.getId();
        this.name = clinic.getName();
        this.address = clinic.getAddress();
        this.city = clinic.getCity();
        this.managerPhoneNumber = clinic.getManagerClinic();
    }

}
