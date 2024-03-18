package com.Angelo.service.impl;


import com.Angelo.dto.Page;
import com.Angelo.dto.Users;
import com.Angelo.mapper.ClasseHistoryMapper;
import com.Angelo.mapper.ClasseMapper;
import com.Angelo.mapper.UsersMapper;
import com.Angelo.pojo.ClasseHistory;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.UsersService;
import com.Angelo.util.FileUtil;
import com.Angelo.util.JwtUtils;
import com.Angelo.util.PageUtil;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ClasseMapper classeMapper;
    @Autowired
    private ClasseHistoryMapper classeHistoryMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Users> queryById(Integer id) {
       Users users=this.usersMapper.queryById(id);
        users.setImageUrl("http://localhost:8087/file/"+users.getImage());
         return RestFulBean.succ(users);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Users users) {

        if(users.getCardId()==null){
            return RestFulBean.error("身份证号码不能为空");
        }
        if(users.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(users.getImage()==null){
            return RestFulBean.error("图片不能为空");
        }
        if(users.getAge()==null){
            return RestFulBean.error("年龄不能为空");
        }
        if(users.getBirthday()==null){
            return RestFulBean.error("出生日期不能为空");
        }
        if(users.getNation()==null){
            return RestFulBean.error("民族不能为空");
        }
        if(users.getNativePlace()==null){
            return RestFulBean.error("籍贯不能为空");
        }
        if(users.getPolitical()==null){
            return RestFulBean.error("政治面貌不能为空");
        }
        if(users.getTelephone()==null){
            return RestFulBean.error("手机号码不能为空");
        }

        if(users.getCardId().trim().length()!=18){
            return RestFulBean.error("请输入18位身份证号码");
        }
        if(users.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(users.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        //13位时间戳作为学号 不可能重复
        long timeMillis=System.currentTimeMillis(); //当前系统时间戳
        //取前八位作为一个学号
        String userNo=String.valueOf(timeMillis).substring(0,8);
        users.setUserNo(String.valueOf(userNo));
        try{
            //users.getCardId().trim()拿字符串去空
            Users user = usersMapper.getByCardId(users.getCardId().trim());//根据身份证cardId查询用户
            if(user!=null){ //身份证唯一
                return RestFulBean.error("该身份证已经录入,请不要重复录入");
            }
            users.setPassword(String.valueOf(userNo));//将密码设为学号 初始密码 后面学生可自行修改
            usersMapper.insert(users);
        }
        catch (Exception e){
            return RestFulBean.error("请求异常");
        }
        return RestFulBean.succ("注册成功,学号密码为"+userNo+"请登录自行修改密码");
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Users users) {
        if(users.getCardId()==null){
            return RestFulBean.error("身份证号码不能为空");
        }
        if(users.getUserName()==null){
            return RestFulBean.error("姓名不能为空");
        }
        if(users.getImage()==null){
            return RestFulBean.error("图片不能为空");
        }
        if(users.getAge()==null){
            return RestFulBean.error("年龄不能为空");
        }
        if(users.getBirthday()==null){
            return RestFulBean.error("出生日期不能为空");
        }
        if(users.getNation()==null){
            return RestFulBean.error("民族不能为空");
        }
        if(users.getNativePlace()==null){
            return RestFulBean.error("籍贯不能为空");
        }
        if(users.getPolitical()==null){
            return RestFulBean.error("政治面貌不能为空");
        }
        if(users.getTelephone()==null){
            return RestFulBean.error("手机号码不能为空");
        }

        if(users.getCardId().trim().length()!=18){
            return RestFulBean.error("请输入18位身份证号码");
        }
        if(users.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(users.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        this.usersMapper.update(users);
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
        this.usersMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }
    /**
     * 登录接口
     *
     * @param
     * @return 是否成功
     */
    @Override
    public RestFulBean<Map<String, Object>> login(Users users) {//RestFulBean<Map<String, Object>> 这样写就是返回map的对象给前端
        if(users.getUserNo()==null)
        {
            return RestFulBean.error("学号或教师编号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }
        if(users.getRole()==null)
        {
            return RestFulBean.error("角色不能为空");
        }
        String role =users.getRole();//获取角色
        String userNo=users.getUserNo().trim();//获取教师编号或学号  users.getUserNo().trim()去空格
        //new 一个map对象 用于返回数据给前端
        Map<String,Object> result =new HashMap<>();
        Users user =usersMapper.getByUserNoAndRole(userNo,role);//根据教师编号或学号跟角色获取用户数据
        //用户不为空
        if (user!=null){
            //密码跟数据库一样
            if(users.getPassword().equals(user.getPassword()))
            {
                //用jwt生成token
                String token = JwtUtils.getToken(user); //用一个String类型接收token 传一个用户的参数user
                //将token存到redis
//           redisUtil.set("loginToken:" + user.getId(),token,60*60*24);// 60*60*24为1天
                //返回一个map对象
                //将token在前端存起来
                result.put("token",token);
                //返回userName 把这个值在前端存起来 后面录入信息需要用到
                result.put("userName",user.getUserName());
                //返回userId 在前端存起来 获取菜单的接口需要传用户id
                result.put("userId",user.getId());
                //班级id也在前端存起来 获取课表的时候需要传班级id
                result.put("classeId",user.getClasseId());
                return RestFulBean.succ(result);
            }
            else{
                return RestFulBean.error("密码错误");
            }

        }
        return RestFulBean.error("用户不存在");
    }

    @Override
    public RestFulBean<Map> getList(Page<Users> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Users users: list){
                //根据年级跟班级id 找到班主任
              ClasseHistory classeHistory =classeHistoryMapper.queryByYearAndClasseId(users.getYear(),users.getClasseId());
              if(classeHistory!=null){
                  Users teacher =usersMapper.queryById(classeHistory.getUserId()); //找到对应班主任的名字
                  users.setClassMaster(teacher.getUserName());
              }
                users.setImageUrl("http://localhost:8087/file/"+ users.getImage());
            }
        }
        //根据条件查询数据的条数
        Integer count = usersMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<Map> upload(MultipartFile coverFile) throws Exception {
        String destPath ="D:\\design\\images\\";
        // 存图片
        try{
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();
        //将图片名字返回 用于录入用户的时候 把这个值保存到image字段中
        map.put("imageName",coverFile.getOriginalFilename());
        //本地获取图片的路劲
        map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());

        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<Map> getCountList(Page<Users> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageCountListByCondition(page);
        //这里修改一下 不用mysql分页 因为是分组的查出来数据条数有问题
        // 得到最大页数，总条数
        Map<Object, Object> map = PageUtil.pagingPrepare(page, list.size());
        // 得到分页数据
        List<Users> pagetList = new LinkedList<>();
        int startIndex = (page.getPageNum() - 1) * page.getPageSize();
        int a = 0;
        while (a < page.getPageSize() && startIndex < list.size()) {
            a++;
            pagetList.add(list.get(startIndex++));
        }
        map.put("list", pagetList);
        return RestFulBean.succ(map);
    }
    @Override
    public List<Users> getAllStudentsList() {
        List<Users> list= usersMapper.getAllStudentsList();
        return list;
    }

    @Override
    public RestFulBean<String> group(List<Users> usersList) {
        for(Users users :usersList){
            this.usersMapper.updateClass(users);
        }
        return RestFulBean.succ("分班成功");
    }

    @Override
    public RestFulBean<List<Users>> getTeachList() {
        List<Users> list =usersMapper.getTeachList();
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<Map> getAbsenteeCountList(Page<Users> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getAbsenteeListByCondition(page);
        //这里修改一下 不用mysql分页 因为是分组的查出来数据条数有问题
        // 得到最大页数，总条数
        Map<Object, Object> map = PageUtil.pagingPrepare(page, list.size());
        // 得到分页数据
        List<Users> pagetList = new LinkedList<>();
        int startIndex = (page.getPageNum() - 1) * page.getPageSize();
        int a = 0;
        while (a < page.getPageSize() && startIndex < list.size()) {
            a++;
            pagetList.add(list.get(startIndex++));
        }
        map.put("list", pagetList);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<String> updatePassword(Users users) {
    this.usersMapper.updatePassword(users);
    return RestFulBean.succ("修改成功");
    }
}
