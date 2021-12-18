package team.appjam.tigris_server.domain.survey.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Question {

    private boolean check;

    private String detail;

}
