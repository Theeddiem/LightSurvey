package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.dao.SurveyRepository;
import com.eddieknaz.springboot.fastsurvey.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepo;

    @Override
    public Survey addSurvey(Survey theSurvey, HttpServletRequest request) {

        String uuid = UUID.randomUUID().toString();
        theSurvey.setUuid(uuid);
        System.out.println("theSurvey   -- "+theSurvey);
        return surveyRepo.save(theSurvey);
    }

    @Override
    public Survey getSurvey(String surveyUuid) {

        Survey survey = surveyRepo.findById(surveyUuid).get();
        System.out.println("this is the survey found for MySQL" + survey);

        if(survey == null)
        {
            throw new RuntimeException("Survey id not found - " + surveyUuid);
        }

        return survey;
    }
}
