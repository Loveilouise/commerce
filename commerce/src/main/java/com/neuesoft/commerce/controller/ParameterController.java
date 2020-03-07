package com.neuesoft.commerce.controller;

import com.neuesoft.commerce.common.Pagion;
import com.neuesoft.commerce.common.Result;
import com.neuesoft.commerce.pojo.Parameter;
import com.neuesoft.commerce.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ParameterController {

    @Autowired
    private ParameterService parameterService;


    /**
     * 查询所有的参数信息并返回给前端：以json的格式
     * @return
     */
    @RequestMapping("/queryAllParameter")
    @ResponseBody
    public Result queryAllParameter(@RequestBody Pagion page){

        System.out.println("控制层：查询所有参数信息");

        Result rs = new Result();
        int currentpage = page.getCurrentPage();
        rs = parameterService.queryAllParameter(currentpage);
        System.out.println(rs);
        return rs;

    }

    /**
     * 通过前端添加数据
     * @param parameter
     * @return
     */
    @RequestMapping("/addNewParameter")
    @ResponseBody
    public Result addNewParameter(@RequestBody Parameter parameter){

        System.out.println("控制层：插入参数数据");
        Result rs = parameterService.addNewParameter(parameter);

        return rs;

    }

    /**
     * 根据id删除参数信息
     * @param parameter
     * @return
     */
    @RequestMapping("/deleteParameter")
    @ResponseBody
    public Result deleteParameter(@RequestBody Parameter parameter){

        System.out.println("控制层：删除参数数据");
        int id = parameter.getParameter_id();

        Result rs = parameterService.deleteParameter(id);

        return rs;

    }

    /**
     * 更新参数信息
     * @param parameter
     * @return
     */
    @RequestMapping("/updateParameter")
    @ResponseBody
    public Result updateParameter(@RequestBody Parameter parameter){

        System.out.println("控制层：更新参数数据");

        System.out.println(parameter);

        Result rs = parameterService.updateParameter(parameter);

        return rs;
    }

    /**
     *
     * @param
     * @returna
     */
    @RequestMapping("/showParameter")
    @ResponseBody
    public Result showParameter(@RequestBody Parameter parameter){

        System.out.println("控制层：更新数据,根据id查询到当前数据");

        int id = parameter.getParameter_id();

        Result rs = parameterService.findParameterById(id);

        System.out.println(rs);

        return rs;

    }
}
