package com.austin.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:测试
 * @Author: GongJun
 * @Date: Created in 16:56 2021/1/18
 */
@Mapper
public interface TestMapper extends BaseMapper<Object> {
    String getMessage(@Param("s") String s);
}
