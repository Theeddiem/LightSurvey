package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.dao.SurveyRepository;
import com.eddieknaz.springboot.fastsurvey.entity.Survey;
import com.eddieknaz.springboot.fastsurvey.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        System.out.println(surveyUuid);
        Optional<Survey> tempSurvey = surveyRepo.findById(surveyUuid);
        if(!tempSurvey.isPresent())
            throw new NotFoundException("Can't find survey id: " + surveyUuid);

        Survey survey = tempSurvey.get();
        System.out.println("survey before sort" + survey);
        survey.setOptions(survey.getOptions().stream().distinct().sorted().collect(Collectors.toList()));
        System.out.println("survey after sort" + survey);
        // sorted is using the compareTo method in Option class
        // and using distinct because of the oneToMany hibernate bug that returns duplicate objects
        return  survey;
    }
}
