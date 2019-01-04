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
 * player
 *
 * @author
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
@Entity
@Table(name = "player")
public class Player implements Serializable {
    /**
     * 球员编号
     */
    @Id
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 球队
     */
    private Integer team;

    /**
     * 得分
     */
    private Float point;

    /**
     * 篮板球
     */
    private Float rebound;

    /**
     * 助攻
     */
    private Float assist;

    /**
     * 球员图片路径
     */
    private String picPath;

    private static final long serialVersionUID = 1L;


}