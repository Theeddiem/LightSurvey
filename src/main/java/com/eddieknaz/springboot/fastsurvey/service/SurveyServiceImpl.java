package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.dao.SurveyRepository;
import com.eddieknaz.springboot.fastsurvey.entity.Option;
import com.eddieknaz.springboot.fastsurvey.entity.Survey;
import com.eddieknaz.springboot.fastsurvey.exception.BadRequestException;
import com.eddieknaz.springboot.fastsurvey.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepo;

    @Override
    public Survey AddSurvey(Survey theSurvey) {

        String uuid = UUID.randomUUID().toString();
        theSurvey.setUuid(uuid);
        System.out.println("theSurvey   -- "+theSurvey);
        return surveyRepo.save(theSurvey);
    }

    @Override
    public Survey GetSurvey(String surveyUuid) {

        Optional<Survey> tempSurvey = surveyRepo.findById(surveyUuid);
        if(!tempSurvey.isPresent())
            throw new NotFoundException("Can't find survey id: " + surveyUuid);

        Survey survey = tempSurvey.get();
//        for (Option p: survey.getOptions())
//        System.out.println(p);  {
//
//        }
//        System.out.println("options size" + survey.getOptions().size());
//        System.out.println("_+___+_______________________________________");

       // Collections.sort(survey.getOptions()); // sort options
        return  survey;
    }
}
