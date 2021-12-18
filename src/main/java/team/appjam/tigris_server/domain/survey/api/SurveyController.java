package team.appjam.tigris_server.domain.survey.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.appjam.tigris_server.domain.survey.api.request.UploadSurveyRequest;
import team.appjam.tigris_server.domain.survey.service.SurveyService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/survey")
@RestController
public class SurveyController {

    private final SurveyService service;

    @PostMapping
    public void uploadSurvey(@RequestBody @Valid UploadSurveyRequest request) {
        service.uploadSurvey(request);
    }

}
