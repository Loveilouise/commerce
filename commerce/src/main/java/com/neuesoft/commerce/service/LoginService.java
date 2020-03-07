package com.neuesoft.commerce.service;

import com.neuesoft.commerce.pojo.User;

public interface LoginService {
    /**
     *
     * @param userName
     * @return
     */
    User findUser(String userName);
}
