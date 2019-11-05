package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
public class MyGetMethod {

	@RequestMapping("hello")
	public String test1() {
		return "hello ,test李焕贞";
	}
//	@RequestMapping("hello")
//	@ApiOperation(value="普通的不带参数的Get请求",httpMethod="GET")
//	public String test1() {
//		return "hello ,test";
//	}
	
	

	
	@RequestMapping(value="/getCookie",method=RequestMethod.GET)
	public String getCookies(HttpServletResponse response) {
		Cookie cookie=new Cookie("login","true");
		response.addCookie(cookie);
		return "获得cookie成功";
	}
	
	@RequestMapping(value="/getwithCookie",method=RequestMethod.GET)
	public String getWithCookies(HttpServletRequest request) {
	
		Cookie [] cookies=request.getCookies();
		if(Objects.isNull(cookies)) {
			return "错误，必须携带Cookie";
		}
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("login") &&
					cookie.getValue().equals("true")) {
				return "访问成功";
			}
		}
		return "错误，必须携带Cookie";
	}
	/*
	 * url?para1=value&para2=value2
	 */
	@RequestMapping(value="/getByWithPara1",method=RequestMethod.GET)
	public Map<String,Integer> getBypara1(@RequestParam Integer goodId) {
		Map<String,Integer> goods=new HashMap<String,Integer> ();
		goods.put("笔记本", 5000);
		goods.put("洗衣液", 78);
		return goods;
	}
	@RequestMapping(value="/getByWithPara2",method=RequestMethod.GET)
	public String getName(@RequestParam String name) {
	
		return "你输入的是"+name;
	}
	/*
	 * url/get/withpara/1/2
	 */
	@RequestMapping(value="/getByWithPara2/{start}/{end}",method=RequestMethod.GET)
	public Map<String,Integer> getBypara2(@PathVariable Integer start,
			@PathVariable Integer end) {
		Map<String,Integer> goods=new HashMap<String,Integer> ();
		goods.put("笔记本", 8000);
		goods.put("洗衣液", 78);
		return goods;
	}
		

}
