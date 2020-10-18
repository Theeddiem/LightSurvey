package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.dao.OptionRepository;
import com.eddieknaz.springboot.fastsurvey.dao.VoterRepository;
import com.eddieknaz.springboot.fastsurvey.entity.Option;
import com.eddieknaz.springboot.fastsurvey.entity.Voter;
import com.eddieknaz.springboot.fastsurvey.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepository voterRepo;

    @Autowired
    private OptionRepository optionRepo;

    @Override
    public void VoteForOption(Voter voter, List<Integer> optionsId, HttpServletRequest request) {
        String voterIp = request.getRemoteAddr();
        Random rand = new Random();
       // voterIp =String.valueOf((rand.nextInt(1000)));
        voter.setIpAddress(voterIp);

       List<Option> optionsVoted = optionRepo.findAllById(optionsId);
       boolean alreadyVoted = optionsVoted.stream().anyMatch(option -> option.getVoters().contains(voter));
       if(alreadyVoted)
           throw new BadRequestException("Already Voted for that option");

        optionsVoted.stream().forEach(option -> voter.addOption(option));

        voterRepo.save(voter);
    }
}
