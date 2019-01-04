package com.example.nba.service.impl;

import com.example.nba.model.Team;
import com.example.nba.repository.TeamRep;
import com.example.nba.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TeamServiceImpl
 *
 * @author 10905 2018/12/31
 * @version 1.0
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRep rep;
    @Override
    public Team save(Team team) {
        return rep.save(team);
    }

    @Override
    public List<Team> findAll() {
        return rep.findAll();
    }

    @Override
    public Team findByName(String teamName) {
        return rep.findByName(teamName);
    }
}
