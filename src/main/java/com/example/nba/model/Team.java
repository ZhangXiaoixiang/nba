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
 * team
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
@Entity
@Table(name = "team")
public class Team implements Serializable {
    /**
     * 球队编号
     */
    @Id
    private String id;

    /**
     * 球队姓名
     */
    private String name;

    /**
     * 分区1东2西
     */
    private Integer zone;


    /**
     * 胜场数
     */
    private Integer victory;

    /**
     * 败场数
     */
    private Integer defeat;

    /**
     * 排名注意关键字
     */
    private Integer ranking;

    private static final long serialVersionUID = 1L;


}