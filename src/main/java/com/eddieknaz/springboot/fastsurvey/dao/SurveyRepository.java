package com.eddieknaz.springboot.fastsurvey.dao;

import com.eddieknaz.springboot.fastsurvey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey,String> {
}
