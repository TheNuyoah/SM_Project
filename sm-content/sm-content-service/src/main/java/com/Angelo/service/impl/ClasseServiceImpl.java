package com.Angelo.service.impl;

import com.Angelo.dto.Page;
import com.Angelo.mapper.ClasseMapper;
import com.Angelo.pojo.Classe;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.ClasseService;
import com.Angelo.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("classeService")
public class ClasseServiceImpl implements ClasseService {
    @Autowired
    private ClasseMapper classeMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Classe> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Classe> list= classeMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Classe classe: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = classeMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Classe> queryById(Integer id) {
       Classe classe=this.classeMapper.queryById(id);
         return RestFulBean.succ(classe);
    }

    /**
     * 新增数据
     *
     * @param classe 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Classe classe) {
        this.classeMapper.insert(classe);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param classe 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Classe classe) {
        this.classeMapper.update(classe);
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.classeMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Classe>> getByprofessionId(Integer professionId) {
        List<Classe> lsit =this.classeMapper.getByprofessionId(professionId);
        return RestFulBean.succ(lsit);
    }

    @Override
    public RestFulBean<Map> getClassList(Page<Classe> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Classe> list= classeMapper.getPageClassListByCondition(page);

        //根据条件查询数据的条数
        Integer count = classeMapper.getPageClassListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
}
