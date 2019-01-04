package com.example.nba.service;

import com.example.nba.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * PlayerService
 *
 * @author 10905 2019/1/2
 * @version 1.0
 */
public interface PlayerService {
    /**
     * 存储球员信息
     *
     * @param player
     * @return
     */
    Player save(Player player);

    /**
     * 查询球员信息
     *
     * @return
     */
    List<Player> findAll();

    /**
     * 分页查询
     * @param startPage
     * @param pageSize
     * @return
     */
    List<Player> findByPage(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize);


}
