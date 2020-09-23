package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.dao.OptionRepository;
import com.eddieknaz.springboot.fastsurvey.dao.VoterRepository;
import com.eddieknaz.springboot.fastsurvey.entity.Option;
import com.eddieknaz.springboot.fastsurvey.entity.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepository voterRepo;

    @Autowired
    private OptionRepository optionRepo;

    @Override
    public void voteForOption(Voter voter, List<Integer> optionsId, HttpServletRequest request) {
        String voterIp = request.getRemoteAddr();
        List<Voter> votersList = new ArrayList<>();

        List<Option> optionsVoted = optionRepo.findAllById(optionsId);
        System.out.println("options I choose to vote"+ optionsVoted);
        for (Option option: optionsVoted )
        {
           System.out.println(option.getVoters().contains(voter));
            if(option.getVoters().contains(voter)) // hashSet checking o(1) if user voted already for this option.
            {
                System.out.println("already voted for option");
                return;
            }
        }

        for (Integer id : optionsId)
        votersList.add(new Voter(voter.getName(),voter.getIpAddress(),id));

        voterRepo.saveAll(votersList);
    }
}
