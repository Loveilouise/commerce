package com.neuesoft.commerce.service;

public interface RegisterService {
    /**
     * 检查是否有重名
     * @param userName
     * @return
     */
    int registerNameCheck(String userName);

    /**
     * 注册
     * @param userName
     * @param userPwd
     * @param userRole
     * @return
     */
    int register(String userName,String userPwd,int userRole);
}
