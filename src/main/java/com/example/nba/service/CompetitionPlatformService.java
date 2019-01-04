package com.example.nba.service;

import com.example.nba.model.CompetitionPlatform;

import java.util.List;

public interface CompetitionPlatformService {
    /**
     * 全查询
     */
    List<CompetitionPlatform> findAll();
}
