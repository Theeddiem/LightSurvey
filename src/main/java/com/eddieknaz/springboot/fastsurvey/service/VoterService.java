package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.entity.Voter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface VoterService {

    void voteForOption(@RequestBody Voter voter, @RequestParam List<Integer> optionsId,  HttpServletRequest request);
}
