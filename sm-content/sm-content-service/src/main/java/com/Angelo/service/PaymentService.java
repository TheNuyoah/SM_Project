package com.Angelo.service;

import com.Angelo.dto.Page;
import com.Angelo.pojo.Payment;
import com.Angelo.res.RestFulBean;
import jxl.write.WriteException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
public interface PaymentService {
     
        /**
     * 分页查找数据
     *
     * @param page 前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Payment> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Payment> queryById(Integer id)throws WriteException, IOException;


    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Payment payment);

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Payment>> queryByUserId(Integer userId);

    RestFulBean<String> pay(Payment payment);

    RestFulBean<Map> getTotalList(Page<Payment> page)throws Exception;
}
