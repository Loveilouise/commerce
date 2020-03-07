package com.neuesoft.commerce.controller;

import com.neuesoft.commerce.common.Pagion;
import com.neuesoft.commerce.common.Result;
import com.neuesoft.commerce.pojo.DataDictionary;
import com.neuesoft.commerce.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataDictionaryController {

    @Autowired
    private DataDictionaryService dataDictionaryService;

    /**
     * 查询所有的数据字典信息并返回给前端：以json的格式
     * @return
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<DataDictionary> queryAll(){

        System.out.println("控制层：查询所有数据字典信息");

        return dataDictionaryService.queryAll();

    }


   /**
     * 分页查询字典数据
     * @param page
     * @return
     */
    @RequestMapping("/queryAllDataDictionary")
    @ResponseBody
    public Result queryAllDataDictionary(@RequestBody Pagion page){

        System.out.println("控制层：分页查询数据字典信息");

        System.out.println(page);

        Result rs = new Result();
        int currentpage = page.getCurrentPage();
        rs = dataDictionaryService.queryAllDataDictionary(currentpage);
        System.out.println(rs);
        return rs;

    }




    /**
     * 通过前端添加数据
     * @param dataDictionary
     * @return
     */
    @RequestMapping("/addNewDataDictionary")
    @ResponseBody
    public Result addNewDataDictionary(@RequestBody DataDictionary dataDictionary){

        System.out.println("控制层：插入数据");
        Result rs = dataDictionaryService.addNewDataDictionary(dataDictionary);

        return rs;

    }

    /**
     * 根据id删除数据字典信息
     * @param dataDictionary
     * @return
     */
    @RequestMapping("/deleteDataDictionary")
    @ResponseBody
    public Result deleteDataDictionary(@RequestBody DataDictionary dataDictionary){

        System.out.println("控制层：删除数据");
        int id = dataDictionary.getDictionary_id();

        Result rs = dataDictionaryService.deleteDataDictionary(id);

        return rs;

    }

    @RequestMapping("/updateDataDictionary")
    @ResponseBody
    public Result updateDataDictionary(@RequestBody DataDictionary dataDictionary){

        System.out.println("控制层：更新数据");

        System.out.println(dataDictionary);

        Result rs = dataDictionaryService.updateDataDictionary(dataDictionary);

        return rs;
    }


    @RequestMapping("/showDataDictionary")
    @ResponseBody
    public Result showDataDictionary(@RequestBody DataDictionary dataDictionary){

        System.out.println("控制层：更新数据,根据id查询到当前数据");

        int id = dataDictionary.getDictionary_id();

        Result rs = dataDictionaryService.findDataDictionaryById(id);

        System.out.println(rs);

        return rs;

    }
}