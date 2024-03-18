package com.Angelo.service.impl;

import com.Angelo.dto.Page;
import com.Angelo.mapper.ClasseMapper;
import com.Angelo.mapper.PaymentMapper;
import com.Angelo.mapper.ProfessionMapper;
import com.Angelo.pojo.Classe;
import com.Angelo.pojo.Payment;
import com.Angelo.pojo.Profession;
import com.Angelo.res.RestFulBean;
import com.Angelo.service.PaymentService;
import com.Angelo.util.PageUtil;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private ProfessionMapper professionMapper;
    @Autowired
    private ClasseMapper classeMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传过来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Payment> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Payment> list= paymentMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Payment payment: list){
               
            }
        }
        //根据条件查询数据的条数
        Integer count = paymentMapper.getPageListCount(page);
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
    public RestFulBean<Payment> queryById(Integer id) throws WriteException, IOException{
         Payment payment=this.paymentMapper.queryById(id);
        payment.setTotal(payment.getTuition()+payment.getStayFee());
        if(payment.getIsPay()==0)
        {
            payment.setPay("未缴费");
        }
        if(payment.getIsPay()==1)
        {
            payment.setPay("已缴费");
        }
        this.export(payment);
        payment.setExcelUrl("http://localhost:8087/file/payment.xls");
         return RestFulBean.succ(payment);
    }
    //导出excel表 学年注册名单
    public void export(Payment payment)throws WriteException, IOException {

        //1. 导出Excel的路径
        String filePath ="D:\\design\\images\\payment.xls";
        WritableWorkbook wwb =null;
        try {
            wwb = Workbook.createWorkbook(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WritableSheet sheet = wwb.createSheet("注册列表",0);//或者rwb.getSheet(0)获取第一个区域
        //设置titles
        String[] titles={"年份","专业","学费","住宿费","合计","缴费状态"};
        //单元格
        Label label=null;
        //第一行设置列名
        for(int i=0;i<titles.length;i++){

            label=new Label(i,0,titles[i]);
            //7：添加单元格
            sheet.addCell(label);
        }

        try {
                sheet.addCell(new Label(0,1,String.valueOf(payment.getYear())));
                sheet.addCell(new Label(1,1,payment.getName()));
                //Label对应数据库String类型数据
                sheet.addCell(new Label(2,1,String.valueOf(payment.getTuition())));
                //Label对应数据库String类型数据
                sheet.addCell(new Label(3,1,String.valueOf(payment.getStayFee())));
                sheet.addCell(new Label(4,1,String.valueOf(payment.getTotal())));
            sheet.addCell(new Label(5,1,payment.getPay()));
            wwb.write();

        } catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            wwb.close();
        }
    }
    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Payment payment) {
        this.paymentMapper.insert(payment);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Payment payment) {
        this.paymentMapper.update(payment);
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
        this.paymentMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }
}
