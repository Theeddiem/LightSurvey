package com.eddieknaz.springboot.fastsurvey.rest;
import com.eddieknaz.springboot.fastsurvey.entity.*;
import com.eddieknaz.springboot.fastsurvey.exception.NotFoundException;
import com.eddieknaz.springboot.fastsurvey.service.OptionService;
import com.eddieknaz.springboot.fastsurvey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SurveyRestController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private OptionService optionService;

    @GetMapping("test")
    public String find(HttpServletRequest request)
    {
            return request.getRemoteAddr();
    }

    @PostMapping("/surveys")
    public Survey addSurvey(@RequestBody Survey survey)
    {
        return surveyService.AddSurvey(survey);
    }

    @GetMapping("/surveys/{surveyUuid}")
    public Survey getSurvey(@PathVariable String surveyUuid )
    {
        try {
            return surveyService.GetSurvey(surveyUuid);
        }
        catch ( NotFoundException ex) {
            throw ex;//
        }


    }
    @SendTo("/topic/surveys/{surveyId}")
    @MessageMapping("/survey/{surveyId}")
    public Survey greeting(@DestinationVariable String surveyId) throws Exception {
        //Thread.sleep(1000); // simulated delay
        try {
            return surveyService.GetSurvey(surveyId);
        }
        catch ( NotFoundException ex) {
            throw ex;//
        }
    }
}
