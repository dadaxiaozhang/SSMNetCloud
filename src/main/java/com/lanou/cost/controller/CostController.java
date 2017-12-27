package com.lanou.cost.controller;

import com.lanou.admin.bean.AdminList;
import com.lanou.bean.AdminRole;
import com.lanou.cost.bean.Cost;
import com.lanou.cost.service.Impl.CostServiceImpl;
import com.lanou.login.bean.AdminInfo;
import com.lanou.role.bean.RoleInfo;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/18.
 * 嗯，这是这个工程唯一的注释
 */
@Controller
public class CostController {

    @Resource(name = "CostService")
    private CostServiceImpl costService;

    //    资费管理页面的跳转
    @RequestMapping(value = "/toCost")
    public String toCost() {

        return "fee/fee_list";
    }

    @RequestMapping(value = "/getAllCost")
    @ResponseBody
    public AjaxResult getAllCost(HttpSession session) {

        AjaxResult ajaxResult = new AjaxResult();
        List<String> costName=new ArrayList<>();
        List<Cost> allCost = costService.getAllCost();
        for (int i = 0; i <allCost.size() ; i++) {
            String name=allCost.get(i).getName();
            costName.add(name);
        }
        session.setAttribute("costName",costName);
        ajaxResult.setData(allCost);
        return ajaxResult;

    }

//    资费管理添加页面跳转
    @RequestMapping(value = "/toAddCost")
    public String toAddCost(){

        return "fee/fee_add";
    }

//    资费管理添加
    @RequestMapping(value = "/addCost")
    @ResponseBody
    public AjaxResult AddCost(Cost cost,HttpSession session){
        AjaxResult ajaxResult=new AjaxResult();
        List<String> costName = (List<String>) session.getAttribute("costName");
        for (int i = 0; i < costName.size(); i++) {
            if (costName.get(i).equals(cost.getName())){
                ajaxResult.setErrorCode(404);
                return ajaxResult;
            }
        }
        java.util.Date date = new java.util.Date();
        long times = date.getTime();
        cost.setCreatime(new Timestamp(times));
        if (cost.getBaseDuration()==null){
           cost.setBaseDuration(0);
        }
        if (cost.getBaseCost()==null){
            cost.setBaseCost(0);
        }
        if (cost.getUnitCost()==null){
            cost.setUnitCost(0);
        }
        costService.insert(cost);
        return ajaxResult;
    }

    //    删除资费
    @RequestMapping(value = "/delcost")
    @ResponseBody
    public AjaxResult delCost(Cost cost) {
        AjaxResult ajaxResult = new AjaxResult();
        int i = costService.delCost(cost);

        if (i==1){
            ajaxResult.setErrorCode(200);
        }
        return ajaxResult;
    }

    //    获取当前资费信息存到Session中
    @RequestMapping(value = "/jumptoFee")
    @ResponseBody
    public AjaxResult updateFee(Integer costId, HttpSession session) throws UnsupportedEncodingException {

        AjaxResult ajaxResult = new AjaxResult();
        session.setAttribute("costId", costId);
        ajaxResult.setErrorCode(200);
        return ajaxResult;
    }

    //   资费管理修改页面的跳转
    @RequestMapping(value = "/toUpdateFee")
    public String toUpdateFee() {
        return "fee/fee_modi";
    }

    @RequestMapping(value = "/getFeeInfo")
    @ResponseBody
    public AjaxResult getFeeInfo(HttpSession session) {
        AjaxResult ajaxResult = new AjaxResult();

        Integer costId = (Integer) session.getAttribute("costId");
        Cost cost = costService.getCostById(costId);
        List<String> costName = (List<String>) session.getAttribute("costName");
        for (int i = 0; i < costName.size(); i++) {
            if (costName.get(i).equals(cost.getName())){
                costName.remove(i);
            }
        }
        ajaxResult.setData(cost);
        return ajaxResult;
    }

//    资费管理信息修改
    @RequestMapping(value = "/updateCost")
    @ResponseBody
    public AjaxResult updateCost(Cost cost,HttpSession session){

        AjaxResult ajaxResult=new AjaxResult();
        List<String> costName = (List<String>) session.getAttribute("costName");
        for (int i = 0; i < costName.size(); i++) {
            if (costName.get(i).equals(cost.getName())){
                ajaxResult.setErrorCode(404);
                return ajaxResult;
            }
        }
        int i = costService.updateCost(cost);
        if (i==1){
            ajaxResult.setErrorCode(200);
        }
        return ajaxResult;
    }

//    资费管理状态开通
    @RequestMapping(value = "/startFee")
    @ResponseBody
    public AjaxResult startFee(Cost cost){
        AjaxResult ajaxResult=new AjaxResult();
        java.util.Date date = new java.util.Date();
        long times = date.getTime();
        cost.setStartime(new Timestamp(times));
        int i = costService.updateStatus(cost);
        if (i==1){
            ajaxResult.setErrorCode(200);
            ajaxResult.setData(cost);
        }
        return ajaxResult;
    }

//    资费详情跳转
    @RequestMapping(value = "/fee_detail")
    public String togetDetail(){
        return "fee/fee_detail";
    }

//    资费详情的获取
    @RequestMapping(value = "/getDetail")
    @ResponseBody
    public AjaxResult getDetail(Integer costId){
        AjaxResult ajaxResult=new AjaxResult();
        Cost cost = costService.getCostById(costId);
        ajaxResult.setData(cost);
        return ajaxResult;
    }
}
