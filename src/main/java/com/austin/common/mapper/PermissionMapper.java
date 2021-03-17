package com.austin.common.mapper;

import com.austin.common.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:权限
 * @Author: GongJun
 * @Date: Created in 16:56 2021/1/18
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
