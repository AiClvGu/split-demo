# 前后端分离CRUD的demo案例

## demo-backend

数据库进行导入即可

```yml
spring:
  datasource:
    username: user（你数据库的账号）	
    password: password （你数据库的密码）
    url: jdbc:mysql://localhost:3306/xxx（你数据库database名称）?serverTimezone=UTC&useUnicode=TRUE&characterEncoding=utf-8&useSSL=TRUE
    driver-class-name: com.mysql.cj.jdbc.Driver
```

## demo-front

> 1、npm install
>
> 2、npm run serve
>
> 即可运行

使用springboot+vue+element-ui搭建的一个简单的小demo算是自己以后学习上的一环，后续也会慢慢的上传github内容。
上面也写了一些开发时候的注释。
希望可以帮助一些刚开始学习前后端分离的萌新。