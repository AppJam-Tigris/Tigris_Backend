package team.appjam.tigris_server.domain.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "uid는 Null, 공백을 허용하지 않습니다.")
    private final String uid;

    @NotBlank(message = "password는 Null, 공백을 허용하지 않습니다.")
    private final String password;

}
