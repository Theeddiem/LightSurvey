package com.eddieknaz.springboot.fastsurvey.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey,String> {
}
