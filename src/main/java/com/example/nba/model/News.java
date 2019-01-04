package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * news
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
public class News implements Serializable {
    /**
     * 新闻编号
     */
    private Integer id;

    /**
     * 新闻时间
     */
    private Date date;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻类型
     */
    private String type;

    /**
     * 新闻来源
     */
    private String source;

    /**
     * 图片路径
     */
    private String picpath;

    /**
     * 新闻正文
     */
    private String text;

    private static final long serialVersionUID = 1L;


}