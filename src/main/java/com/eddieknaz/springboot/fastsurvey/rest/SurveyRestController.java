package com.eddieknaz.springboot.fastsurvey.rest;
import com.eddieknaz.springboot.fastsurvey.dao.OptionRepository;
import com.eddieknaz.springboot.fastsurvey.dao.SurveyRepository;
import com.eddieknaz.springboot.fastsurvey.dao.VoterRepository;
import com.eddieknaz.springboot.fastsurvey.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SurveyRestController {

    @Autowired
    VoterRepository voterRepo;

    @Autowired
    SurveyRepository surveyRepo;

    @GetMapping("test")
    public void find(){

    }

    @PostMapping("/surveys")
    public Survey addSurvey(@RequestBody Survey theSurvey)
    {

        String uuid = UUID.randomUUID().toString();
        theSurvey.setUuid(uuid);
        System.out.println("theSurvey   -- "+theSurvey);
        return surveyRepo.save(theSurvey);
    }

    @PostMapping("/voters")
    public void voteForOption(@RequestBody Voter theVoter, @RequestParam List<Integer> optionsId)
    {
        List<Voter> votersList = new ArrayList<>();

        for (Integer id : optionsId)
            votersList.add(new Voter(theVoter.getName(),theVoter.getIpAddress(),id));

        voterRepo.saveAll(votersList);
    }

    @GetMapping("/surveys")
    public List<Survey> getSurveys()
    {
        System.out.println("get Surveys");
        System.out.println(surveyRepo.findAll());
        return surveyRepo.findAll();
    }


    @GetMapping("/surveys/{surveyUuid}")
    public Survey getSurvey(@PathVariable String surveyUuid )
    {

        Survey theSurvey = surveyRepo.findById(surveyUuid).get();
        System.out.println("this is the survey found for MySQL" + theSurvey);

        if(theSurvey == null)
        {
            throw new RuntimeException("Survey id not found - " + surveyUuid);
        }

        return theSurvey;

    }
}
