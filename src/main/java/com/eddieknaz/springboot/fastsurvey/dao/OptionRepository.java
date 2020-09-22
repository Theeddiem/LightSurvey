package com.eddieknaz.springboot.fastsurvey.dao;

import com.eddieknaz.springboot.fastsurvey.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option,Integer> {
}
