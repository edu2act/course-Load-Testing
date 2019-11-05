package com.example.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class MyPostMethod {
	public static Cookie cookie;

	@RequestMapping(value = "/loginmap", method = RequestMethod.POST)
	public String doPostLogin(HttpServletResponse response,
			@RequestParam(value = "u_Name", required = true) String userName,
			@RequestParam(value = "u_Pwd", required = true) String userPwd) {
		if (userName.equals("admin") && userPwd.equals("admin")) {
			cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			return "登录成功";
		}
		return "登录失败";
	}

	public static int count = 0;

	@RequestMapping(value = "/loginJson", method = RequestMethod.POST)
	public Student doPostJson(@RequestBody Student stu) {
		Student s = new Student();
		s.sname = stu.sname;
		s.sno = stu.sno;
		count++;
		return s;
	}

}
