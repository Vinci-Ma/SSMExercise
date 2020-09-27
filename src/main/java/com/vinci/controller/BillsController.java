package com.vinci.controller;

import com.github.pagehelper.PageInfo;
import com.vinci.bean.Bills;
import com.vinci.bean.Billtype;
import com.vinci.service.BillTypesService;
import com.vinci.service.BillsService;
import com.vinci.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author:Vinci_Ma
 * @Oescription:
 * @Date Created in 2020-09-22-14:45
 * @Modified By:
 */
@Controller
public class BillsController {
    @Resource
    private BillTypesService typesService;
    @Resource
    private BillsService billsService;

    //查询账单类型及信息
    @RequestMapping("/gettypes")
    public String gettypes(ModelMap map){
        //1、查询所有类型
        List<Billtype> types = typesService.getTypes();
        //2、查询所有账单
        PageInfo<Bills> info = billsService.getBills(-1, null, null, 1, PageUtil.PAGESIZE);
        //3、保存数据给前台
        map.addAttribute("types",types);
        map.addAttribute("info",info);
        return "show";
    }

    //查询所有账单
    @RequestMapping("/getAllBills")
    public String getBills(@RequestParam(defaultValue = "1") int index, @RequestParam(defaultValue = "-1") Integer typeid, String begin, String end, ModelMap map){
        PageInfo<Bills> info = billsService.getBills(typeid, begin, end, index, PageUtil.PAGESIZE);
        map.addAttribute("info",info);
        List<Billtype> types = typesService.getTypes();
        map.addAttribute("types",types);
        //数据回显
        //将模糊查询的值再返回给前台
        map.addAttribute("tid",typeid);
        map.addAttribute("begintime",begin);
        map.addAttribute("endtime",end);
        return "show";
    }

    //查询账单类型
    @RequestMapping("/getBillType")
    public String getBillType(ModelMap map){
        List<Billtype> types = typesService.getTypes();
        map.addAttribute("types",types);
        //跳转到记账页面
        return "add";
    }

    //删除操作
    @RequestMapping("/deleteById")
    public void delete(int bid, HttpServletResponse response){
        int i = billsService.deleteByPrimaryKey(bid);
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            if(i>0){
                writer.print("<script>alert('删除成功');location.href='/gettypes'</script>");
                return;
            }
            writer.print("<script>alert('删除失败');location.href='/gettypes'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //主键查询
    @RequestMapping("/findById")
    public String findById(int bid,ModelMap map){
        Bills bills = billsService.selectByPrimaryKey(bid);
        List<Billtype> types = typesService.getTypes();
        map.addAttribute("types",types);
        map.addAttribute("bills",bills);
        return "update";
    }

    //新增账单
    @RequestMapping("/insertBill")
    public String add(Bills bills){
        int insert = billsService.insert(bills);
        if(insert>0){
            //一般执行成功或者失败不会直接跳转页面，而是发送一个请求跳转页面，保证页面中是有数据的
            //回到主页面:show.jsp
            return "redirect:/gettypes";
        }
        //重新回到新增页面
        return "redirect:/getBillType";
    }

    //修改
    @RequestMapping("/updateBill")
    public String updateBill(Bills bills){
        int i = billsService.updateByPrimaryKey(bills);
        if(i>0){
            return "redirect:/gettypes";
        }
        return "redirect:/findById?bid="+bills.getId();
    }
}
