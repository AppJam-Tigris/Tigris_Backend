package team.appjam.tigris_server.domain.user.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Location {

    @Column(length = 5, nullable = false)
    private Integer address;

    @Column(length = 60, nullable = false)
    private String roadName;

    @Column(length = 100, nullable = false)
    private String detailsAddress;

}
