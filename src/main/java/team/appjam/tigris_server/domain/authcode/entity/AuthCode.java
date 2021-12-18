package team.appjam.tigris_server.domain.authcode.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class AuthCode {

    @Id
    private String phoneNumber;

    private String code;

}
