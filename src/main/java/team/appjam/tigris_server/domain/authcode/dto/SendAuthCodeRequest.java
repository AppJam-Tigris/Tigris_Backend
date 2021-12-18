package team.appjam.tigris_server.domain.authcode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SendAuthCodeRequest {

    @NotBlank(message = "phoneNumber는 Null, 공백을 허용하지 않습니다.")
    private Integer phoneNumber;

}
