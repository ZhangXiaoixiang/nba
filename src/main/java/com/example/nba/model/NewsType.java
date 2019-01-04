package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * news_type
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
@AllArgsConstructor//全参
public class NewsType implements Serializable {
    /**
     * 新闻类型ID
     */
    private Integer id;

    /**
     * 类型名称
     */
    private String name;

    private static final long serialVersionUID = 1L;


}