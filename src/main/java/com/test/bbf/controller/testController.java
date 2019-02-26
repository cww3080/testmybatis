package com.test.bbf.controller;

import com.test.bbf.entity.Product;
import com.test.bbf.service.ProductService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
//@ComponentScan({"com.test.bbf.service"})
//@MapperScan("com.test.bbf.dao")
@RequestMapping("test")
public class testController {
    @Autowired
    ProductService productService;

    @RequestMapping("productHtml")
    public String productHtml(Map<String,Object> map){
        //map.put("products",productService.getProductList());
        map.put("products","");
        System.out.println("------------------------加载productHtml请求--------------------------");
        return "product/productView";
    }
    @RequestMapping("getAllProducts")
    @ResponseBody()
    public List<Product> getAllProducts(){
        System.out.println("----------------------- 读取所有产品信息 ---------------------------");
        List<Product> proList = productService.getProductList();
        //System.out.println(proList);
        return proList;
    }
    @RequestMapping("getProductById")
    @ResponseBody()
    public Product getProductById(String proId){
        System.out.println("----------------------- 读取单个产品信息：proId="+proId+" ---------------------------");
        return productService.getProductById(proId);
    }
    @RequestMapping("updateProduct")
    @ResponseBody()
    public int updateProduct(@RequestBody Product product){
        System.out.println("----------------------- 修改产品信息：product="+product+" ---------------------------");
        return productService.updateProduct(product);
    }

    @RequestMapping("addproduct")
    public String addproduct(){
        return "product/addproduct";
    }
    @RequestMapping("updateproduct")
    public String updateproduct(){
        return "product/updateproduct";
    }
    @RequestMapping("nopower")
    public String nopower(){
        return "nopower";
    }
    @RequestMapping("error")
    public String error(){
        return "error";
    }
    @RequestMapping("loginhtml")
    public String loginhtml(){
        return "loginview";
    }


    @RequestMapping("login")
    public String login(String loginname, String pwd, Model model){
        System.out.println("loginname="+loginname+"；pwd="+pwd);
        /**
         * 使用shiro编写认证操作
         */
        //1、获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(loginname,pwd);

        //3、执行登录方法
        try {
            subject.login(token);
            //登录成功；有任何异常即登录失败。
            return "redirect:/test/productHtml";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在！");
            return "loginview";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误！");
            return "loginview";
        }
    }
}
