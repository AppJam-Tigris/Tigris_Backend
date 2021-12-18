package team.appjam.tigris_server.domain.user.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import team.appjam.tigris_server.domain.user.entity.Gender;
import team.appjam.tigris_server.domain.user.entity.Location;
import team.appjam.tigris_server.domain.user.entity.Nationality;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class JoinRequest {

    @NotBlank(message = "name은 Null, 공백을 허용하지 않습니다.")
    private String name;

    @NotBlank(message = "phoneNumber는 Null, 공백을 허용하지 않습니다.")
    private String phoneNumber;

    @NotBlank(message = "frontHumanNum은 Null, 공백을 허용하지 않습니다.")
    private String frontHumanNum;

    @NotNull(message = "gender는 Null을 허용하지 않습니다.")
    private Gender gender;

    @NotNull(message = "nationality는 Null을 허용하지 않습니다.")
    private Nationality nationality;

    @NotNull(message = "location은 Null을 허용하지 않습니다.")
    private Location location;

    @NotBlank(message = "uid는 Null, 공백을 허용하지 않습니다.")
    private String uid;

    @Pattern(regexp="(?=.*[a-z])(?=.*[!#$%&'()*+,-./:;<=>?@＼^_`{|}~])(?=.*[0-9])(?=\\S+$).{8,32}$",
            message = "password는 띄어쓰기를 제외한 영문 소문자와 숫자, 특수문자가 적어도 1개 이상씩 포함된 8자이상 32글자 이하의 비밀번호여야 합니다.")
    @NotBlank(message = "password는 Null, 공백을 허용하지 않습니다.")
    private String password;

}
