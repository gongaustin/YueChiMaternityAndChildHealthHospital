package com.austin.common.service.impl;

import com.austin.common.entity.Permission;
import com.austin.common.entity.Role;
import com.austin.common.mapper.RoleMapper;
import com.austin.common.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author GongJun
 * @since 2019-08-28
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Permission> getPermissionsByRoleId(String id, Integer type) {
        return this.baseMapper.getPermissionsByRoleId(id,type);
    }
}
