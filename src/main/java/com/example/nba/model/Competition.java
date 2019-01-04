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
 * competition
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参


public class Competition implements Serializable {
    /**
     * 赛事表ID
     */

    private String id;

    /**
     * 主队
     */
    private Integer host;

    /**
     * 客队
     */
    private Integer guest;

    /**
     * 开赛时间
     */
    private String time;

    /**
     * 直播平台
     */
    private String platform;

    /**
     * 主队分数
     */
    private Integer hostScores;

    /**
     * 客队分数
     */
    private Integer guestScores;

    /**
     * 开赛状态(0未赛1开赛中2结束)
     */
    private String state;

    private static final long serialVersionUID = 1L;


}