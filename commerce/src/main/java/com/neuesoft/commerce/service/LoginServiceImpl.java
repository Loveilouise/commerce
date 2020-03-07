package com.neuesoft.commerce.service;

import com.neuesoft.commerce.mapper.UserMapper;
import com.neuesoft.commerce.pojo.User;
import com.neuesoft.commerce.pojo.UserExample;
import com.neuesoft.commerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User findUser(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> list = userMapper.selectByExample(example);
        System.out.println("list:"+list.toString());
        if(null == list || list.size() ==0){
            return null;
        }else {
            return list.get(0);
        }

    }
}
