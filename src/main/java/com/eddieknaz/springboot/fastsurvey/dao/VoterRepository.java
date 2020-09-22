package com.eddieknaz.springboot.fastsurvey.dao;

import com.eddieknaz.springboot.fastsurvey.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter,Integer> {
}
