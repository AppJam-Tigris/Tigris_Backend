package team.appjam.tigris_server.domain.clinic.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;

@Getter
@AllArgsConstructor
public class ClinicInfoResponse {

    private final String name;

    private final String address;

    private final String roadName;

    public ClinicInfoResponse(Clinic clinic) {
        this.name = clinic.getName();
        this.address = clinic.getAddress();
        this.roadName = clinic.getAddress();
    }



}
