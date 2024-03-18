package com.Angelo.controller;

import com.Angelo.dto.Page;
import com.Angelo.dto.Users;
import com.Angelo.mapper.ClasseMapper;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.UsersService;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Autowired
    private UsersService usersService;
    @Autowired
    private ClasseMapper classeMapper;
    /**
     *  分页查询注册数据
     * @param
     * @return Map
     */
    @PostMapping("/get/list")
    public RestFulBean<Map> getList(@RequestBody Page<Users> page) throws Exception {
        return usersService.getList(page);
    }
    /**
     *  分页查询注册统计数据
     * @param
     * @return Map
     */
    @PostMapping("/get/list/count")
    public RestFulBean<Map> getCountList(@RequestBody Page<Users> page) throws Exception {
        return usersService.getCountList(page);
    }
    /**
     *  分页查询在籍统计数据
     * @param
     * @return Map
     */
    @PostMapping("/get/list/absentee/count")
    public RestFulBean<Map> getAbsenteeCountList(@RequestBody Page<Users> page) throws Exception {
        return usersService.getAbsenteeCountList(page);
    }
    //新增
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Users users) throws Exception {
        return usersService.insert(users);
    }
    //修改
    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody Users users) throws Exception {
        return usersService.update(users);
    }
    //根据id删除
    @PostMapping("/delete")
    public RestFulBean<String> delete(@RequestBody Users users) throws Exception {
        return usersService.deleteById(users.getId());
    }
    //根据id获取用户详情信息
    @PostMapping("/get/by/id")
    public RestFulBean<Users> getById(@RequestBody Users users) throws Exception {
        return usersService.queryById(users.getId());
    }
    //分班级
    @PostMapping("/group/class")
    public RestFulBean<String> group(@RequestBody Users users) throws Exception {
        return usersService.group(users.getUsersList());
    }
    //上传照片
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return usersService.upload(coverFile);
    }
    //获取教师列表
    @PostMapping("/get/teachList")
    public RestFulBean<List<Users>> getTeachList() throws Exception {
        return usersService.getTeachList();
    }
    //修改
    @PostMapping("/update/password")
    public RestFulBean<String> updatePassword(@RequestBody Users users) throws Exception {
        return usersService.updatePassword(users);
    }
//    //获取管理员列表
//    @PostMapping("/get/adminList")
//    public RestFulBean<List<Users>> getAdminList() throws Exception {
//        return usersService.getAdminList();
//    }

}
