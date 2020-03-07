package com.neuesoft.commerce.mapper;

import com.neuesoft.commerce.pojo.DataDictionary;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DataDictionaryMapper {

    /**
     * 查询所有的数据字典信息
     * @return
     */
    @Select("select * from data_dictionary")
    List<DataDictionary> queryAll();


    /**
     * 限制查询：一行返回指定个数
     * limit a,b    a表示起始的索引 从0开始   b为每页显示的数据数目
     * @param index
     * @return
     */
    @Select("select * from data_dictionary limit #{index},#{total}")
    List<DataDictionary> queryAllDataDictionary(@Param("index") int index,@Param("total") int total);


    /**
     * 查询出所有的记录条数
     * @return
     */
    @Select("select count(*) from data_dictionary")
    int queryTotal();


    /**
     * 插入一条新的记录
     * @param dd 数据字典对象
     * @return Result 结果集
     */
    @Insert("insert into data_dictionary(dictionary_type,dictionary_description,code,code_value) values" +
            "(#{dictionary_type},#{dictionary_description},#{code},#{code_value});")
    void addNewDataDictionary(DataDictionary dd);

    /**
     * 更新数据信息
     * @param dd
     */
    @Update("update data_dictionary set dictionary_type=#{dictionary_type},dictionary_description=#{dictionary_description},code=#{code},code_value=#{code_value}" +
            "where dictionary_id=#{dictionary_id};")
    void updateDataDictionary(DataDictionary dd);

    /**
     * 删除数据字典信息
     * @param id
     */
    @Delete("delete from data_dictionary where dictionary_id = #{id}")
    void deleteDataDictionary(int id);


    /**
     * 根据id查询出当前记录
     * @param id
     * @return
     */
    @Select("select dictionary_type,dictionary_description,code,code_value from data_dictionary where dictionary_id = #{id}")
    DataDictionary findDataDictionaryById(int id);
}
