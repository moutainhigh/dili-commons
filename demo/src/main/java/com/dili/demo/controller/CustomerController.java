package com.dili.demo.controller;

import com.dili.demo.domain.Customer;
import com.dili.demo.service.CustomerService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.EasyuiPageOutput;
import com.dili.ss.metadata.ValueProviderUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2019-12-27 14:43:13.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /**
     * 跳转到Customer页面
     * @param modelMap
     * @return String
     */
    @RequestMapping(value="/index.html", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "customer/index";
    }

    /**
     * 跳转到Customer页面
     * @param modelMap
     * @return String
     */
    @RequestMapping(value="/preSave.html", method = RequestMethod.GET)
    public String preSave(ModelMap modelMap,Long id) {
        if(id != null){
            Customer customer = customerService.get(id);
            modelMap.put("customer",customer);
        }
        return "customer/preSave";
    }

    /**
     * 跳转到Customer页面
     * @param modelMap
     * @return String
     */
    @RequestMapping(value="/treegrid.html", method = RequestMethod.GET)
    public String treegrid(ModelMap modelMap) {
        return "customer/treegrid";
    }

    /**
     * 跳转到Customer页面
     * @param modelMap
     * @return String
     */
    @RequestMapping(value="/log.html", method = RequestMethod.GET)
    public String log(ModelMap modelMap) {
        return "customer/log";
    }

    /**
     * 跳转到Customer页面
     * @param modelMap
     * @return String
     */
    @RequestMapping(value="/hotkey.html", method = RequestMethod.GET)
    public String hotkey(ModelMap modelMap) {
        return "customer/hotkey";
    }

    /**
     * 跳转到Customer页面
     * @param modelMap
     * @return String
     */
    @RequestMapping(value="/select2.html", method = RequestMethod.GET)
    public String select2(ModelMap modelMap) {
        return "customer/select2";
    }

    /**
     * 跳转到Customer页面
     * @param modelMap
     * @return String
     */
    @RequestMapping(value="/nav.html", method = RequestMethod.GET)
    public String nav(ModelMap modelMap) {
        return "customer/nav";
    }

    /**
     * 分页查询Customer，返回easyui分页信息
     * @param customer
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(Customer customer, HttpServletRequest request) throws Exception {
        return customerService.listEasyuiPageByExample(customer, true).toString();
    }

    /**
     * 新增Customer
     * @param customer
     * @return BaseOutput
     */
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(Customer customer) {
        customerService.insertSelective(customer);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改Customer
     * @param customer
     * @return BaseOutput
     */
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(Customer customer) {
        customerService.updateSelective(customer);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除Customer
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        customerService.delete(id);
        return BaseOutput.success("删除成功");
    }

    /**
     * 启禁用货站
     * @param id 货站ID
     * @param enable 是否启用
     * @return
     */
    @RequestMapping(value = "/doEnable.action", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public BaseOutput doEnable(Long id, Boolean enable) {
        return customerService.updateEnable(id, enable);
    }
}