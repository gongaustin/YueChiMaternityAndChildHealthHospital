package com.austin.common.service;

import com.austin.common.entity.Permission;
import com.austin.common.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author GongJun
 * @since 2019-08-28
 */
public interface IRoleService extends IService<Role> {

    List<Permission> getPermissionsByRoleId(String id, Integer type);

}
