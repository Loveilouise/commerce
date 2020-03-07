package com.neuesoft.commerce.service;


import com.neuesoft.commerce.mapper.UserMapper;
import com.neuesoft.commerce.mapper.UserMapper2;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.User;
import com.neuesoft.commerce.pojo.UserExample;
import com.neuesoft.commerce.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    UserMapper2 userMapper2;
    @Override
    public int registerNameCheck(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> list = userMapper.selectByExample(example);
        if(null == list || list.size() ==0){
            //查不到重名角色，可以注册
            return 1;
        }else {
            return 0;
        }

    }

    @Override
    public int register(String userName, String userPwd, int userRole) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPwd);
        user.setUserStatus(userRole);
        userMapper.insertSelective(user);
        
        

        if(user.getUserStatus()==1){
        	Company company = new Company();
        	company.setCename(user.getUserName());
        	company.setCpassword(user.getUserPassword());       	
        	userMapper2.insertCompany(company);
        }else if(user.getUserStatus()==2){
        	Seller seller = new Seller();
        	seller.setSname(user.getUserName());
        	seller.setSpassword(user.getUserPassword());       	
        	userMapper2.insertSeller(seller);
        }
        return 0;
    }
}
