package com.example.nba.repository;

import com.example.nba.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRep extends JpaRepository<Team,String> {

    Team findByName(String teamName);
}
