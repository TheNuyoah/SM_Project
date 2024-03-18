package com.Angelo.service;

import com.Angelo.dto.Page;
import com.Angelo.dto.Users;
import com.Angelo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Users> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map<String, Object>> login(Users users);

    RestFulBean<Map> getList(Page<Users> page)throws Exception;

    RestFulBean<Map> upload(MultipartFile coverFile) throws Exception;

    RestFulBean<Map> getCountList(Page<Users> page)throws Exception;

    List<Users> getAllStudentsList();

    RestFulBean<String> group(List<Users> usersList);

    RestFulBean<List<Users>> getTeachList();

    RestFulBean<Map> getAbsenteeCountList(Page<Users> page)throws Exception;

    RestFulBean<String> updatePassword(Users users);
}
