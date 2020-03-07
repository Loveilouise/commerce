package com.neuesoft.commerce.service;

import com.neuesoft.commerce.common.Pagion;
import com.neuesoft.commerce.common.Resource;
import com.neuesoft.commerce.common.Result;
import com.neuesoft.commerce.mapper.ParameterMapper;
import com.neuesoft.commerce.pojo.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParameterService {

    /*参数管理业务层*/

    @Autowired
    private ParameterMapper parameterMapper;

    /**
     * 查询所有的参数
     * @return
     */
    public Result queryAllParameter(int currentPage){

        System.out.println("业务层：查询所有参数数据");
        Result rs = new Result();

        try {

            //处理currentPage 将其转换为 index传给mapper层
            int index = (currentPage - 1)*Resource.PAGETOTAL;
            rs.setData(parameterMapper.queryAllParameter(index,Resource.PAGETOTAL));
            rs.setMsg("查询成功！");
            Pagion page = new Pagion();
            page.setCurrentPage(currentPage);
            int total = parameterMapper.queryTotal();
            int pagetotal;
            //返回总共多少页
            if (total % Resource.PAGETOTAL == 0)
                pagetotal = total/Resource.PAGETOTAL;
            else
                pagetotal = total/Resource.PAGETOTAL + 1;
            page.setPageTotal(pagetotal);
            rs.setPage(page);
            rs.setCode(Resource.SUCCESS);

        }catch (Exception e){

            e.printStackTrace();
            rs.setMsg("查询失败！");
            rs.setCode(Resource.ERROR);
        }

        return rs;
    }



    /**
     * 往数据库中插入一条参数记录
     * @param parameter 参数对象
     * @return rs 结果集  用于响应前端
     */
    public Result addNewParameter(Parameter parameter){

        System.out.println("业务层：插入一条参数数据");
        Result rs = new Result();

        try{
            parameterMapper.addNewParameter(parameter);
            rs.setCode(Resource.SUCCESS);
            rs.setMsg("保存成功");
        }catch (Exception e){

            e.printStackTrace();
            rs.setCode(Resource.ERROR);
            rs.setMsg("保存失败");
        }

        return rs;

    }

    /**
     * 根据id删除参数数据
     * @param id
     * @return
     */
    public Result deleteParameter(int id){

        System.out.println("业务层：删除一条参数数据");
        Result rs = new Result();

        try{

            parameterMapper.deleteParameter(id);
            rs.setCode(Resource.SUCCESS);
            rs.setMsg("删除成功！");
        }catch (Exception e){

            e.printStackTrace();
            rs.setCode(Resource.ERROR);
            rs.setMsg("删除失败！");
        }

        return rs;

    }

    /**
     * 根据id更新参数数据
     * @param parameter
     * @return
     */
    public Result updateParameter(Parameter parameter){

        System.out.println("业务层：更新一条参数数据");
        Result rs = new Result();

        try{

            parameterMapper.updateParameter(parameter);
            rs.setCode(Resource.SUCCESS);
            rs.setMsg("更新成功！");
        }catch (Exception e){

            e.printStackTrace();
            rs.setCode(Resource.ERROR);
            rs.setMsg("更新失败！");
        }

        return rs;
    }


    /**
     * 根据id查询到该数据字典信息记录
     * @param id
     * @return
     */
    public Result findParameterById(int id){

        System.out.println("业务层：根据id查询一条参数数据");
        Result rs = new Result();

        try{

            rs.setData(parameterMapper.findParameterById(id));
            rs.setCode(Resource.SUCCESS);
            rs.setMsg("查询成功！");
        }catch (Exception e){

            e.printStackTrace();
            rs.setCode(Resource.ERROR);
            rs.setMsg("查询失败！");
        }

        return rs;


    }

}
