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
        voterIp =String.valueOf((rand.nextInt(1000)));
        voter.setIpAddress(voterIp);

        List<Option> optionsVoted = optionRepo.findAllById(optionsId);
        for (Option option: optionsVoted   )
        {
            if(option.getVoters().contains(voter)) // hashSet checking o(1) if user voted already for this option.
            {
                throw new BadRequestException("Already Voted for that option");
            }
        }

        for (Option option: optionsVoted)
        {
            voter.addOption(option);
        }

        voterRepo.save(voter);
    }
}
