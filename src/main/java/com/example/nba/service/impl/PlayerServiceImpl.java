package com.example.nba.service.impl;

import com.example.nba.model.Player;
import com.example.nba.repository.PlayerRep;
import com.example.nba.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PlayerServiceImpl
 *
 * @author 10905 2019/1/2
 * @version 1.0
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRep playerRep;


    /**
     * 添加球员信息
     *
     * @param player
     * @return
     */
    @Override
    public Player save(Player player) {
        return playerRep.save(player);
    }

    /**
     * 查询全部球员信息
     *
     * @return
     */
    @Override
    public List<Player> findAll() {
        return playerRep.findAll();
    }

    /**
     * 分页查询
     * @param startPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Player> findByPage(Integer startPage, Integer pageSize) {
        return playerRep.findByPage(startPage, pageSize);
    }

    /**
     *
     * @return
     */
    public List<Player> orderByPoint() {

        return playerRep.orderByPoint();
    }
}
