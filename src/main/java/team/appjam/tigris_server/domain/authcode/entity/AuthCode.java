package team.appjam.tigris_server.domain.authcode.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
@Builder
public class AuthCode {

    @Id
    private Integer phoneNumber;

    private String code;

    @TimeToLive
    private Long expiration;


    public AuthCode setCode(String code){
        this.code = code;
        this.expiration = 1800L;
        return this;
    }

}
