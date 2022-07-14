package com.example.demo.generator.service;

import com.example.demo.common.ResultBean;
import com.example.demo.generator.domain.OperateLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
* @author ozzo
* @description 针对表【operate_log】的数据库操作Service
* @createDate 2022-07-13 16:42:48
*/
public interface OperateLogService extends IService<OperateLog> {
    /**
     * 增加日志
     * @param operateLog 新增日志实体
     */
    ResultBean<String> addOperateLog(OperateLog operateLog);

    /**
     * 查询日志
     * @param localDateTime 查询日期
     * */
    ResultBean<List<OperateLog>> getAll(LocalDateTime localDateTime);

    /**
     * 删除日志
     * @param ids 批量删除
     * */
    ResultBean<String> delLog(String ids);
}
