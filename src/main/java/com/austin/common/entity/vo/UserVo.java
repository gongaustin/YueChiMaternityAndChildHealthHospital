package com.austin.common.entity.vo;

import com.austin.common.entity.User;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 11:44 2021/1/22
 */
public class UserVo extends User {
    private int isAdmin = 0;

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
