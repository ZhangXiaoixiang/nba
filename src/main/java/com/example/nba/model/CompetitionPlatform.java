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
 * competition_platform
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor //无参
@AllArgsConstructor //全参
@Entity
@Table(name = "competition_platform")
public class CompetitionPlatform implements Serializable {
    /**
     * 赛事直播平台ID
     */
    @Id
    private Integer id;

    /**
     * 平台名称
     */
    private String name;

    private static final long serialVersionUID = 1L;


}