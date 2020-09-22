package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.entity.Survey;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

public interface SurveyService {

    Survey addSurvey(@RequestBody Survey theSurvey, HttpServletRequest request);

    Survey getSurvey(@PathVariable String surveyUuid );
}
