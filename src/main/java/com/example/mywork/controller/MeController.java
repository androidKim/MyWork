package com.example.mywork.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mywork.mapper.PortMainMapper;
import com.example.mywork.mapper.UserMapper;
import com.example.mywork.model.user;
import com.example.mywork.util.Util;

@Controller
public class MeController
{     
	/******************************* Define *******************************/
	private static final Logger logger = LoggerFactory.getLogger(MeController.class);

	/******************************* Member *******************************/
	public Util m_Util = new Util();
   

	@Autowired
	UserMapper mapper;
    /******************************* User Function *******************************/
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/meMain")
    public ModelAndView meMain(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	    	
        ModelAndView mav = new ModelAndView();
        user pInfo = new user("", "");
        pInfo.role = user.role_login_false;
		mav.setViewName("me_main");
		mav.addObject("user", pInfo);
		return mav;
    } 
    
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/loginProc")
    public ModelAndView loginProc(HttpServletRequest request, HttpServletResponse response)
    {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("uname");
		String pw = request.getParameter("psw");
		
		user pInfo = new user(id, pw);
		user pResponse = mapper.loginProc(pInfo);
		
		if(pInfo.pw.equals(pResponse.pw))
		{
			pInfo.role = user.role_login_true;
		}
		else
		{
			pInfo.role = user.role_login_false;
		}
		//set Session..
		request.getSession().setAttribute("user", pInfo);//세션 저장
		request.getSession().setMaxInactiveInterval(60 * 60 * 24);
		mav.addObject("user", pInfo);
		mav.setViewName("me_main");
		return mav;
    }
}