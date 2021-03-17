package com.austin.common.service;

import com.austin.common.core.bean.UserBean;
import com.austin.common.entity.Permission;
import com.austin.common.entity.Role;
import com.austin.common.entity.User;
import com.austin.common.entity.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户人员 服务类
 * </p>
 *
 * @author GongJun
 * @since 2019-08-28
 */
public interface IUserService extends IService<User> {

    List<Permission> selectUserPermissionsByWrapper(Wrapper wrapper);

    List<Permission> selectUserModulessByWrapper(String id);

    UserBean getUser(String username);

    List<UserVo> selectUserVoPage(Page page, Wrapper wrapper);

    UserVo findUserById(String id);

    List<Role> getRolesByManagerId(String id);

}
