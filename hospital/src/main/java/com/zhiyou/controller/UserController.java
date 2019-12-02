package com.zhiyou.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.pojo.Result;
import com.zhiyou.pojo.User;
import com.zhiyou.service.UserService;
@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService userSerivce;
	
	
	//用户登录
	@RequestMapping(value={"/userLogin.do"},method={RequestMethod.POST})
	@ResponseBody
	public Result userLogin(@RequestParam(value="checkcode")String checkcode, User user, HttpSession session){
		/*System.out.println(111111);*/
		user = userSerivce.selectUserByUsernameAndPassword(user);
		Result result = null;
		//获取验证码工具类共享的checkcode和用户输入的codecheck进行比较
		String codecheck = (String) session.getAttribute("checkcode");
		if(codecheck.equalsIgnoreCase(checkcode)){
			if(user!=null){//查询到用户存在
				result = Result.success(1001, "登录成功",user);
				session.setAttribute("user", result.getObject());
			}else{
				result = Result.fail(1000, "帐号密码错误");
			}
		}else{//验证码不匹配
			result = Result.fail(1002, "验证码匹配错误");
		}	
		return result;
	}
	
	
	//用户退出登录
	@RequestMapping(value={"/userLogOut.do"},method={RequestMethod.POST})
	@ResponseBody
	public void logOut(HttpSession session){
		session.removeAttribute("user");
		session.invalidate();
	}
	
}
