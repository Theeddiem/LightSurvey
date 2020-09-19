package com.eddieknaz.springboot.fastsurvey.dao;

import com.eddieknaz.springboot.fastsurvey.entity.Survey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SurveyDAOHibernateImpl implements  SurveyDAO{

    @Override
    public List<Survey> findAll() {
        return null;
    }
}
