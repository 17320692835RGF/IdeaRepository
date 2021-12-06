package com.ssm.service;

import com.ssm.po.Admin;

/**
 * @Description
 * @Author
 * @Date 2021/9/14 0014 14:54
 */
public interface AdminService {
    public Admin login(String loginname, String loginpwd);
}
