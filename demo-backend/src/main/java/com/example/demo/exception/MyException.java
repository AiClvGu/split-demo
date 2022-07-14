package com.example.demo.exception;


public class MyException extends RuntimeException{

    /**
     * 错误状态码
     * */
    int errorCode;

    /**
     * 返回信息
     * */
    String message;

    public static MyException error(String message){
        return new MyException(message);
    }

    public static MyException error(){
        return new MyException();
    }

    public MyException() {
        this.errorCode = 500;
    }

    public MyException(String message) {
        this.errorCode = 500;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
