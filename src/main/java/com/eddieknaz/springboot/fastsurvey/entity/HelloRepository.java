package com.eddieknaz.springboot.fastsurvey.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface HelloRepository extends JpaRepository<Hello, Integer> {

}
