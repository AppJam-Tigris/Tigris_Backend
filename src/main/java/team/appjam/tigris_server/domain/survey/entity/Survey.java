package team.appjam.tigris_server.domain.survey.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.appjam.tigris_server.domain.clinic.entity.Clinic;
import team.appjam.tigris_server.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
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

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "question",
            joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"))
    private List<Question> questionList;

}
