package com.example.nba.repository;

import com.example.nba.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * PlayerRep
 *
 * @author 10905 2019/1/2
 * @version 1.0
 */
public interface PlayerRep extends JpaRepository<Player, String> {
    /**
     * 自定义查询
     *
     * @return
     */
    @Query(value = "select * from player ORDER BY point DESC", nativeQuery = true)
    List<Player> orderByPoint();

    /**
     * 分页查询,2组排序,得分相同看篮板,篮板相同就随机(暂时不管了)
     *
     * @param startPage 起始页
     * @param pageSize  每页大小
     * @return
     */
    @Query(value = "SELECT * FROM player ORDER BY point DESC ,rebound desc LIMIT :startPage,:pageSize", nativeQuery = true)
    List<Player> findByPage(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize);
}
