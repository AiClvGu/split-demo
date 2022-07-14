package com.example.demo.generator.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName book
 */
@Data
public class Book implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 图书信息
     */
    private String bookName;

    /**
     * 简介
     */
    private String description;

    /**
     * 图书分类
     */
    private String bookCatagory;

    /**
     *作者
     */
    private String bookAuthor;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTimeStamp;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTimeStamp;

    @Serial
    private static final long serialVersionUID = 1L;

}