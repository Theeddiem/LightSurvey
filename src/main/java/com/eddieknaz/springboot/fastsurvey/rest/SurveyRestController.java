package com.eddieknaz.springboot.fastsurvey.rest;
import com.eddieknaz.springboot.fastsurvey.entity.Option;
import com.eddieknaz.springboot.fastsurvey.entity.Survey;
import com.eddieknaz.springboot.fastsurvey.entity.Voter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@RestController
@RequestMapping("/api")
public class SurveyRestController {



    @GetMapping("/Surveys")
    public Survey getSurvey()
    {
        Voter firstVoter = new Voter("Eddie","127.56.123.11");
        Voter secondVoter = new Voter("Ron","176.13.144.15");
        Voter thirdVoter = new Voter("Jim","134.88.21.18");

        Option firstOption = new Option("Pizza");
        Option secondOption = new Option("Hamburger");
        Option thirdOption = new Option("Sushi");

        ArrayList<Option> options = new ArrayList<>();
        options.add(firstOption);
        options.add(secondOption);
        options.add(thirdOption);

        Date currentDate = new Date();
        currentDate.getTime();

        Survey firstSurvey = new Survey("What are we eating?",options,  currentDate.getTime());
        int x = firstSurvey.getOptions().indexOf(firstOption);
        System.out.println(x);
        firstSurvey.getOptions().get(x).addVoter(firstVoter);
        firstSurvey.getOptions().get(x).addVoter(secondVoter);
        firstSurvey.getOptions().get(x).addVoter(thirdVoter);




        return  firstSurvey;

    }

}
