package com.Angelo.mapper;


import com.Angelo.dto.Page;
import com.Angelo.pojo.ClasseHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ClasseHistoryMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClasseHistory queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<ClasseHistory> getPageListByCondition(@Param("page") Page<ClasseHistory> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<ClasseHistory> page);


    /**
     * 新增数据
     *
     * @param classeHistory 实例对象
     * @return 影响行数
     */
    int insert(ClasseHistory classeHistory);




    /**
     * 修改数据
     *
     * @param classeHistory 实例对象
     * @return 影响行数
     */
    int update(ClasseHistory classeHistory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    ClasseHistory queryByYearAndClasseId(Integer year, Integer classeId);

    ClasseHistory getClasseHistory(ClasseHistory classeHistory);
}

