package com.example.nba.repository;

import com.example.nba.model.PlayerRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PalyerRoleRep
 *
 * @author 10905 2018/12/31
 * @version 1.0
 */
public interface PlayerRoleRep extends JpaRepository<PlayerRole,String> {
}
