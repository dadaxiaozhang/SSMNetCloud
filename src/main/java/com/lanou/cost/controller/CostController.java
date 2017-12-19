package com.lanou.cost.controller;

import com.lanou.cost.bean.Cost;
import com.lanou.cost.service.Impl.CostServiceImpl;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
        costService.insert(cost);
        return ajaxResult;
    }
}
