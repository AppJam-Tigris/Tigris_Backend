package team.appjam.tigris_server.domain.clinic.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class Count {

    @Id
    private String clinic;

    @Indexed
    private TimeSchedule time;

    @TimeToLive
    private Long expiration;

    

}
