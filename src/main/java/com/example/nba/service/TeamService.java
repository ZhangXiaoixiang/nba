package com.example.nba.service;

import com.example.nba.model.Team;

import java.util.List;

/**
 * @author 10905
 */
public interface TeamService  {
    /**
     * 添加球队信息
     * @param team
     * @return
     */
    Team save(Team team);
    /**
     * 全查询
     */
    List<Team> findAll();


    /**
     * 通过球队名称找到球队
     * @param teamName
     * @return
     */
    Team findByName(String teamName);
}
