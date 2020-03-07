package com.neuesoft.commerce.mapper;

import com.neuesoft.commerce.pojo.Parameter;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ParameterMapper {

    /*参数管理*/

    /**
     * 查询所有的参数管理信息
     * @return
     */
    @Select("select * from parameter_management limit #{index},#{total}")
    List<Parameter> queryAllParameter(@Param("index") int index,@Param("total") int total);

    /**
     * 查询出所有的记录条数
     * @return
     */
    @Select("select count(*) from parameter_management")
    int queryTotal();



    /**
     * 插入一条新的记录
     * @param parameter 参数对象
     * @return Result 结果集
     */
    @Insert("insert into parameter_management(parameter_value,parameter_key,parameter_description) values" +
            "(#{parameter_value},#{parameter_key},#{parameter_description});")
    void addNewParameter(Parameter parameter);

    /**
     * 更新数据信息
     * @param parameter
     */
    @Update("update parameter_management set parameter_value=#{parameter_value},parameter_key=#{parameter_key},parameter_description=#{parameter_description}" +
            "where parameter_id=#{parameter_id};")
    void updateParameter(Parameter parameter);

    /**
     * 删除参数信息
     * @param id
     */
    @Delete("delete from parameter_management where parameter_id = #{parameter_id}")
    void deleteParameter(int id);

    /**
     * 根据id查询出当前记录
     * @param id
     * @return
     */
    @Select("select parameter_value,parameter_key,parameter_description from parameter_management where parameter_id = #{id}")
    Parameter findParameterById(int id);
}
