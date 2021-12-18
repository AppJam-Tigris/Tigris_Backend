package team.appjam.tigris_server.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 5, nullable = false)
    private String name;

    @Column(length = 11, unique = true, nullable = false)
    private String phoneNumber;

    @Column(length = 6, nullable = false)
    private String frontHumanNum;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @Column(nullable = false)
    @Embedded
    private Location location;

    @Column(nullable = false)
    private String uid;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }

}
