package com.Angelo.mapper;


import com.Angelo.dto.Page;
import com.Angelo.pojo.Classe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClasseMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Classe queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Classe> getPageListByCondition(@Param("page") Page<Classe> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Classe> page);


    /**
     * 新增数据
     *
     * @param classe 实例对象
     * @return 影响行数
     */
    int insert(Classe classe);




    /**
     * 修改数据
     *
     * @param classe 实例对象
     * @return 影响行数
     */
    int update(Classe classe);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Classe> getByprofessionId(Integer professionId);

    List<Classe> getPageClassListByCondition(@Param("page") Page<Classe> page);

    Integer getPageClassListCount(@Param("page") Page<Classe> page);
}

