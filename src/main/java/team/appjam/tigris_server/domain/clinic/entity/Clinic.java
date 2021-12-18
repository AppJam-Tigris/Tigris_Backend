package team.appjam.tigris_server.domain.clinic.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Clinic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;

    private String secCity;

    private String name;

    private String address;

    private String weekDayTime;

    private String saturDayTime;

    private String holiDayTime;

    private String repPhoneNumber;

    private String managerClinic;

    private String managerPhoneNumber;



}
