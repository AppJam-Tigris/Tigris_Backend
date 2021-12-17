package team.appjam.tigris_server.domain.refreshtoken.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class RefreshToken {

    @Id
    private String uid;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long expiration;

    @Builder
    public RefreshToken(String uid, String refreshToken, Long expiration) {
        this.uid = uid;
        this.refreshToken = refreshToken;
        this.expiration = expiration;
    }

}
