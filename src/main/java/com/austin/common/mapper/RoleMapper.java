package com.austin.common.mapper;

import com.austin.common.entity.Permission;
import com.austin.common.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:角色
 * @Author: GongJun
 * @Date: Created in 16:56 2021/1/18
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Permission> getPermissionsByRoleId(@Param("id") String id, @Param("type") Integer type);
}
