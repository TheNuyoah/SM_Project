package com.Angelo.mapper;


import com.Angelo.dto.Page;
import com.Angelo.pojo.Profession;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProfessionMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Profession queryById(Integer id);


    /**
     * 新增数据
     *
     * @param profession 实例对象
     * @return 影响行数
     */
    int insert(Profession profession);


    /**
     * 修改数据
     *
     * @param profession 实例对象
     * @return 影响行数
     */
    int update(Profession profession);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Profession> getList();

    List<Profession> getPageListByCondition(@Param("page") Page<Profession> page);

    Integer getPageListCount(@Param("page") Page<Profession> page);
}
