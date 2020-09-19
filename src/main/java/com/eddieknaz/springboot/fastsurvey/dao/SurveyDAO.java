package com.eddieknaz.springboot.fastsurvey.dao;

import com.eddieknaz.springboot.fastsurvey.entity.Survey;

import java.util.List;

public interface SurveyDAO {

    public List<Survey> findAll();


}
