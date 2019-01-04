package com.example.nba.service.impl;

import com.example.nba.model.CompetitionPlatform;
import com.example.nba.repository.CompetitionPlatformRep;
import com.example.nba.service.CompetitionPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CompetitionPlatformServiceImpl
 *
 * @author 10905 2018/12/31
 * @version 1.0
 */
@Service
public class CompetitionPlatformServiceImpl implements CompetitionPlatformService {
    @Autowired
    private CompetitionPlatformRep rep;

    @Override
    public List<CompetitionPlatform> findAll() {
        return rep.findAll();
    }
}
