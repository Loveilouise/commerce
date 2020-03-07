package com.neuesoft.commerce.mapper;

import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.User;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterMapper {

    @Insert("insert into user(user_name,user_password,user_status) values" +
            "(#{user_name},#{user_password},#{user_status});")
    void addNewuser(User user);
    






}
