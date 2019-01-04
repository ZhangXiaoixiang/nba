package com.example.nba.service.impl;

import com.example.nba.model.PlayerRole;
import com.example.nba.repository.PlayerRoleRep;
import com.example.nba.service.PalyerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * palyerRoleServiceImpl
 *
 * @author 10905 2018/12/31
 * @version 1.0
 */
@Service
public class PalyerRoleServiceImpl implements PalyerRoleService {

    @Autowired
    private PlayerRoleRep playerRoleRep;

    @Override
    public PlayerRole save(PlayerRole playerRole) {
        return playerRoleRep.save(playerRole);
    }
}
