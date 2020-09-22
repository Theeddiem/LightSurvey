package com.eddieknaz.springboot.fastsurvey.rest;
import com.eddieknaz.springboot.fastsurvey.dao.OptionRepository;
import com.eddieknaz.springboot.fastsurvey.dao.SurveyRepository;
import com.eddieknaz.springboot.fastsurvey.dao.VoterRepository;
import com.eddieknaz.springboot.fastsurvey.entity.*;
import com.eddieknaz.springboot.fastsurvey.service.SurveyService;
import com.eddieknaz.springboot.fastsurvey.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SurveyRestController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private VoterService voterService;

    @GetMapping("test")
    public String find(HttpServletRequest request)
    {
            return request.getRemoteAddr();
    }

    @PostMapping("/surveys")
    public Survey addSurvey(@RequestBody Survey survey, HttpServletRequest request)
    {
        return surveyService.addSurvey(survey,request);
    }

    @PostMapping("/voters")
    public void voteForOption(@RequestBody Voter voter, @RequestParam List<Integer> optionsId, HttpServletRequest request)
    {
        voterService.voteForOption(voter, optionsId, request);
    }

//    @GetMapping("/surveys")
//    public List<Survey> getSurveys()
//    {
////        System.out.println("get Surveys");
////        System.out.println(surveyRepo.findAll());
////        return surveyRepo.findAll();
//    }


    @GetMapping("/surveys/{surveyUuid}")
    public Survey getSurvey(@PathVariable String surveyUuid )
    {
        return surveyService.getSurvey(surveyUuid);
    }
}
