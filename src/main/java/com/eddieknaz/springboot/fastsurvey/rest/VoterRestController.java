package com.eddieknaz.springboot.fastsurvey.rest;

import com.eddieknaz.springboot.fastsurvey.entity.Voter;
import com.eddieknaz.springboot.fastsurvey.exception.BadRequestException;
import com.eddieknaz.springboot.fastsurvey.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoterRestController {

    @Autowired
    private VoterService voterService;


    @PostMapping("/voters")
    public void voteForOption(@RequestBody Voter voter, @RequestParam List<Integer> optionsId, HttpServletRequest request)
    {
        try {
            voterService.VoteForOption(voter, optionsId, request);
        }
        catch (BadRequestException ex){
            throw ex;
        }

    }


}
