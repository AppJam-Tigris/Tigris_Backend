package team.appjam.tigris_server.domain.clinic.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@RedisHash
public class Count {

    @Id
    private Integer clinicId;

    @Indexed
    private TimeSchedule time;

    @TimeToLive
    private Long expiration;

    private Integer cnt;


    public Count addCnt(){
        this.cnt+=1;
        return this;
    }
}
