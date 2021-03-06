package team.appjam.tigris_server.domain.user.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CheckDuplicateRequest {

    @NotBlank(message = "uid는 Null, 공백을 허용하지 않습니다.")
    private String uid;

}
