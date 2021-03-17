package com.austin.common.service.impl;

import com.austin.common.entity.Permission;
import com.austin.common.mapper.PermissionMapper;
import com.austin.common.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author GongJun
 * @since 2019-08-28
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
