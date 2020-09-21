package com.eddieknaz.springboot.fastsurvey.rest;
import com.eddieknaz.springboot.fastsurvey.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SurveyRestController {

    @Autowired
    HelloRepository repo;

    @Autowired
    VoterRepository voterRepo;
//
    @Autowired
    OptionRepository optionRepo;

    @Autowired
    SurveyRepository surveyRepo;

    @GetMapping("test")
    public void find(){
//        List<Survey> a = surveyRepo.findAll();
////        Survey survey = new Survey()
//        System.out.println("-------------------------------------------------------------------------------------");
//        System.out.println("-------------------------------------------------------------------------------------");
//        System.out.println(a);
//        System.out.println("-------------------------------------------------------------------------------------");
//        System.out.println("-------------------------------------------------------------------------------------");
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
//        String formatted = df.format(new Date());
//        System.out.println(formatted);
//
//        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
        System.out.println("localhot/test");


    }
    @PostMapping("/surveys")
    public Survey addSurvey(@RequestBody Survey theSurvey)
    {
        System.out.println("lalala");
        System.out.println("theSurvey   -- "+theSurvey);
        String uuid = UUID.randomUUID().toString();
        theSurvey.setUuid(uuid);
        return surveyRepo.saveAndFlush(theSurvey);

    }

    @PutMapping("/options")
    public void voteForOption(@RequestBody Voter theVoter, @RequestParam List<Integer> optionsId)
    {


        for (Integer id : optionsId)
        {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Id ----" + id);
            Option theOption = optionRepo.findById(id).get();
            System.out.println(theOption);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println(theVoter);
            System.out.println("-------------------------------------------------------------------------------------");
            theVoter.setOptionId(id);
            theOption.addVoter(theVoter);
            optionRepo.saveAndFlush(theOption);
        }



    }

    @GetMapping("/surveys")
    public List<Survey> getSurveys()
    {
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

    @PutMapping("/surveys/{surveyUuid}")
    public Survey updateSurvey(@RequestBody Survey theSurvey)
    {

        return surveyRepo.saveAndFlush(theSurvey);
    }

}
