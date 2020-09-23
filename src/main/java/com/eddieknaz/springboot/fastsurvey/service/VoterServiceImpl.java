package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.dao.OptionRepository;
import com.eddieknaz.springboot.fastsurvey.dao.VoterRepository;
import com.eddieknaz.springboot.fastsurvey.entity.Option;
import com.eddieknaz.springboot.fastsurvey.entity.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepository voterRepo;

    @Autowired
    private OptionRepository optionRepo;

    @Override
    public void voteForOption(Voter voter, List<Integer> optionsId, HttpServletRequest request) {
        System.out.println("here");
        String voterIp = request.getRemoteAddr();

        List<Voter> votersList = new ArrayList<>();

        List<Option> a = optionRepo.findAllById(optionsId);
        System.out.println("options I choose to vote"+ a);
        for (Option option: a )
        {
            System.out.println("those are the voters for the option" + option.getVoters());
            for (Voter v: option.getVoters()  )
            {
                if(v.getIpAddress().equals(voter.getIpAddress())) {
                    System.out.println("cant vote for this");
                    return;
                }

            }
        }


        for (Integer id : optionsId)
            votersList.add(new Voter(voter.getName(),voter.getIpAddress(),id));
        voterRepo.saveAll(votersList);

    }
}
