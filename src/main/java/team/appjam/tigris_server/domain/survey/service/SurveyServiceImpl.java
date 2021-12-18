package team.appjam.tigris_server.domain.survey.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.appjam.tigris_server.domain.clinic.entity.Count;
import team.appjam.tigris_server.domain.clinic.entity.TimeSchedule;
import team.appjam.tigris_server.domain.clinic.repository.ClinicRepository;
import team.appjam.tigris_server.domain.clinic.repository.CountRepository;
import team.appjam.tigris_server.domain.survey.api.request.UploadSurveyRequest;
import team.appjam.tigris_server.domain.survey.entity.Survey;
import team.appjam.tigris_server.domain.survey.exception.ClinicNotFoundException;
import team.appjam.tigris_server.domain.survey.repository.SurveyRepository;
import team.appjam.tigris_server.domain.user.facade.UserFacade;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService{
    private final SurveyRepository surveyRepository;
    private final CountRepository countRepository;
    private final ClinicRepository clinicRepository;
    private final UserFacade userFacade;


    @Override
    @Transactional
    public void uploadSurvey(UploadSurveyRequest request) {

        clinicRepository.findById(request.getClinicId()).map(clinic ->
        {
            Survey survey = surveyRepository.save(
                    Survey.builder()
                            .clinic(clinic)
                            .covidCheckType(request.getCovidCheckType())
                            .questionList(request.getQuestionList())
                            .writer(userFacade.getCurrentUser())
                            .build()

            );
            addCount(request.getTimeSchedule(), clinic.getId());

            return survey;
        }
        ).orElseThrow(ClinicNotFoundException::new);
    }


    private void addCount(TimeSchedule timeSchedule, Integer clinicId){

        Long todaysLast = LocalDateTime.now().with(LocalDateTime.MAX).atZone(ZoneId.systemDefault()).toEpochSecond();
        try {
            Optional<Count> count = countRepository.findByClinicIdAndTime(clinicId, timeSchedule);
            if (count.isPresent()) {
                countRepository.save(count.get().addCnt());
            } else countRepository.save(
                    Count.builder()
                            .time(timeSchedule)
                            .expiration(1000 * (todaysLast - System.currentTimeMillis()))
                            .clinicId(clinicId)
                            .build()
            );
        } catch (NullPointerException e) {
            countRepository.save(
                    Count.builder()
                            .time(timeSchedule)
                            .expiration(1000 * (todaysLast - System.currentTimeMillis()))
                            .clinicId(clinicId)
                            .build()
            );
        }
    }


}
