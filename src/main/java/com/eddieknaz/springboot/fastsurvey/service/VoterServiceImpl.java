package com.eddieknaz.springboot.fastsurvey.service;

import com.eddieknaz.springboot.fastsurvey.dao.VoterRepository;
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

    @Override
    public void voteForOption(Voter voter, List<Integer> optionsId, HttpServletRequest request) {

        String voterIp = request.getRemoteAddr();


        List<Voter> votersList = new ArrayList<>();

        for (Integer id : optionsId)
            votersList.add(new Voter(voter.getName(),voter.getIpAddress(),id));

        voterRepo.saveAll(votersList);
    }
}
