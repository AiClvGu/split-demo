package com.example.demo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一结果返回
 * */
@Data
public class ResultBean<T> implements Serializable {

    private int code;
    private String message;
    private T data;
    /**
     * 返回结果
     * */
    public static<T> ResultBean<T> build(int code , String msg , T data){
        return new ResultBean<>(code,msg , data);
    }

    public static<T> ResultBean<T> ok(T data){
        return new ResultBean<>(data);
    }

    public static<T> ResultBean<T> ok(){
        return new ResultBean<>();
    }

    public static<T> ResultBean<T> errorMsg(String msg){
        return new ResultBean<>(500,msg,null);
    }

    public static<T> ResultBean<T> errorMap(T data){
        return new ResultBean<>(501 , "error" , data);
    }

    public static<T> ResultBean<T> errorTokenMsg(String msg){
        return new ResultBean<>(502, msg , null);
    }

    public static<T> ResultBean<T> errorException(String msg){
        return new ResultBean<>(555 , msg , null);
    }

    /**
     * 构造器
     * */
    public ResultBean(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultBean() {
    }

    public ResultBean(T data) {
        this.code=200;
        this.message="OK";
        this.data = data;
    }

}
