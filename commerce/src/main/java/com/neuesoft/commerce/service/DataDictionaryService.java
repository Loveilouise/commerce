package com.neuesoft.commerce.service;

import com.neuesoft.commerce.common.Pagion;
import com.neuesoft.commerce.common.Resource;
import com.neuesoft.commerce.common.Result;
import com.neuesoft.commerce.mapper.DataDictionaryMapper;
import com.neuesoft.commerce.pojo.DataDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryService {

    /**
     * 数据字典的业务层
     */

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    /**
     * 查询所有的字典数据
     * @return
     */
    public List<DataDictionary> queryAll(){

        System.out.println("业务层：查询所有字典数据");
        return dataDictionaryMapper.queryAll();
    }


    /**
     * 限制查询  用于分页处理
     * @param currentPage
     * @return
     */
    public Result queryAllDataDictionary(int currentPage){

        System.out.println("业务层：限制查询条件");
        Result rs = new Result();

        try {

            //处理currentPage 将其转换为 index传给mapper层
            int index = (currentPage - 1)*Resource.PAGETOTAL;
            rs.setData(dataDictionaryMapper.queryAllDataDictionary(index,Resource.PAGETOTAL));
            rs.setMsg("查询成功！");
            Pagion page = new Pagion();
            page.setCurrentPage(currentPage);
            int total = dataDictionaryMapper.queryTotal();
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
     * 往数据库中插入一条数据字典记录
     * @param dd 数据字典对象
     * @return rs 结果集  用于响应前端
     */
    public Result addNewDataDictionary(DataDictionary dd){

        System.out.println("业务层：插入一条字典数据");
        Result rs = new Result();

        try{

            dataDictionaryMapper.addNewDataDictionary(dd);
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
     * 根据id删除数据字典
     * @param id
     * @return
     */
    public Result deleteDataDictionary(int id){

        System.out.println("业务层：删除一条字典数据");
        Result rs = new Result();

        try{

            dataDictionaryMapper.deleteDataDictionary(id);
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
     * 根据id更新数据字典
     * @param dd
     * @return
     */
    public Result updateDataDictionary(DataDictionary dd){

        System.out.println("业务层：更新一条字典数据");
        Result rs = new Result();

        try{

            dataDictionaryMapper.updateDataDictionary(dd);
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
    public Result findDataDictionaryById(int id){

        System.out.println("业务层：根据id查询一条字典数据");
        Result rs = new Result();

        try{

            rs.setData(dataDictionaryMapper.findDataDictionaryById(id));
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
