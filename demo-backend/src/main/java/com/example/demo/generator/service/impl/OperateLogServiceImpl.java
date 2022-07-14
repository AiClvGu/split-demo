package com.example.demo.generator.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.ResultBean;
import com.example.demo.exception.MyException;
import com.example.demo.generator.domain.OperateLog;
import com.example.demo.generator.mapper.OperateLogMapper;
import com.example.demo.generator.service.OperateLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
* @author ozzo
* @description 针对表【operate_log】的数据库操作Service实现
* @createDate 2022-07-13 16:42:48
*/
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog>
    implements OperateLogService {

    @Override
    public ResultBean<String> addOperateLog(OperateLog operateLog) {
        boolean save = save(operateLog);
        if(save){
            return ResultBean.ok("新增成功");
        }else{
            throw new MyException("新增异常");
        }
    }

    @Override
    public ResultBean<List<OperateLog>> getAll(LocalDateTime localDateTime) {
        return ResultBean.ok(lambdaQuery().lt(localDateTime!=null,OperateLog::getCreatetimestamp,localDateTime)
                        .orderByDesc(OperateLog::getCreatetimestamp)
                        .last("limit 50")
                        .list());
    }

    @Override
    public ResultBean<String> delLog(String ids) {
        if(StrUtil.isBlank(ids)){
            throw new MyException("传入字符不能为空");
        }
        List<String> list = Arrays.stream(ids.split(",")).toList();
        if(removeBatchByIds(list)){
            return ResultBean.ok("删除成功");
        }else{
            throw new MyException("删除失败");
        }
    }
}




