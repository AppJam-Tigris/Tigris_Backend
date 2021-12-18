package team.appjam.tigris_server.domain.user.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team.appjam.tigris_server.domain.user.entity.Gender;
import team.appjam.tigris_server.domain.user.entity.Location;
import team.appjam.tigris_server.domain.user.entity.User;

@Getter
@AllArgsConstructor
public class UserInfoResponse {

    private final String name;
    private final String phoneNumber;
    private final Integer birthDay;
    private final Gender gender;
    private final Location location;

    public UserInfoResponse(User user) {
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.birthDay = user.getBirthDay();
        this.gender = user.getGender();
        this.location = user.getLocation();
    }

}
