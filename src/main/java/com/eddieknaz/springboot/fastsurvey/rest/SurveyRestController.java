package com.eddieknaz.springboot.fastsurvey.rest;
import com.eddieknaz.springboot.fastsurvey.dao.OptionRepository;
import com.eddieknaz.springboot.fastsurvey.dao.SurveyRepository;
import com.eddieknaz.springboot.fastsurvey.dao.VoterRepository;
import com.eddieknaz.springboot.fastsurvey.entity.*;
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
    VoterRepository voterRepo;

    @Autowired
    SurveyRepository surveyRepo;

    @GetMapping("test")
    public String find(HttpServletRequest request){

        List<String>  a= new ArrayList<>();

        final String[] IP_HEADER_CANDIDATES = {
                "X-Forwarded-For",
                "Proxy-Client-IP",
                "WL-Proxy-Client-IP",
                "HTTP_X_FORWARDED_FOR",
                "HTTP_X_FORWARDED",
                "HTTP_X_CLUSTER_CLIENT_IP",
                "HTTP_CLIENT_IP",
                "HTTP_FORWARDED_FOR",
                "HTTP_FORWARDED",
                "HTTP_VIA",
                "REMOTE_ADDR" };


        for (String header : IP_HEADER_CANDIDATES) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                a.add(ip);
            }
        }

        System.out.println("ja "+ request.getRemoteAddr());
        a.add(request.getRemoteAddr());
        String userIpAddress = request.getHeader("X-Forwarded-For");
        System.out.println("this is else " + request.getLocalAddr());
        try {
            System.out.println("this is b " + InetAddress.getLocalHost().getHostAddress() );
            a.add(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("this is rqeust " +request.getRemoteAddr());

        a.add(request.getRemoteAddr());

            return request.getRemoteAddr();

    }

    @PostMapping("/surveys")
    public Survey addSurvey(@RequestBody Survey theSurvey, HttpServletRequest request)
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
