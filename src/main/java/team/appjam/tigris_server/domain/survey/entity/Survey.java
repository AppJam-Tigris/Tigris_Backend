package team.appjam.tigris_server.domain.survey.entity;


import team.appjam.tigris_server.domain.clinic.entity.Clinic;
import team.appjam.tigris_server.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User writer;
    @Enumerated(EnumType.STRING)
    private CovidCheckType covidCheckType;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;
    @ElementCollection
    private List<Question> questionList;

}
