package com.example.demo.controller;


import com.example.demo.common.ResultBean;
import com.example.demo.generator.domain.OperateLog;
import com.example.demo.generator.service.OperateLogService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 日志CRUD
 * */
@RestController
@RequestMapping("/operateLog")
public class OperateLogController {

    @Autowired
    OperateLogService operateLogService;

    @GetMapping("/list")
    public ResultBean<List<OperateLog>> getAll(LocalDateTime localDateTime){
        return operateLogService.getAll(localDateTime);
    }

    @GetMapping("/delete")
    public ResultBean<String> delAll(String ids){
        return operateLogService.delLog(ids);
    }
}
