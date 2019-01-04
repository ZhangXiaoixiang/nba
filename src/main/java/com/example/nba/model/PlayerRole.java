package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * player_role
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
@Entity
@Table(name = "player_role")
public class PlayerRole implements Serializable {
    /**
     * 球员角色ID
     */
    @Id
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    private static final long serialVersionUID = 1L;


}