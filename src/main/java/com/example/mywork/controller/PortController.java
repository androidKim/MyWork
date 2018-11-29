package com.example.mywork.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mywork.common.Constant;
import com.example.mywork.mapper.MainMapper;
import com.example.mywork.mapper.PortMainMapper;
import com.example.mywork.model.portfolio;
import com.example.mywork.util.Util;

/*
 * portfolio main view..
 */
@Controller
public class PortController
{     
	/******************************* Define *******************************/
	private static final Logger logger = LoggerFactory.getLogger(PortController.class);

	/******************************* Member *******************************/
	public Util m_Util = new Util();
    
	@Autowired
	PortMainMapper mapper;
    /******************************* User Function *******************************/
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/portMain")
    public ModelAndView portMain(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	    	
    		ArrayList<portfolio> pArray = new ArrayList<>();
		pArray = mapper.getPortList();

    		ModelAndView mav = new ModelAndView();
    		mav.addObject("pArray", pArray);
		mav.setViewName("port_main");
		return mav;
    } 
    //-----------------------------------------------------------------------------
    //
	@RequestMapping(value = "/setPortPage")
    public ModelAndView setPortPage(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	
    		ModelAndView mav = new ModelAndView();
		mav.setViewName("set_port_page");
		return mav;
    } 
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/setPortProc")
    public String setPortProc(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	
    		String port_type = request.getParameter("select");
    		String title = request.getParameter("title");
    		String content = request.getParameter("content");
    		String my_part = request.getParameter("my_part");
    		String imgNm = "";
    		String work_date = request.getParameter("work_date");
    	
    		portfolio pInfo = new portfolio(port_type, title, content, my_part, imgNm, work_date);
    		mapper.setPortfolio(pInfo);
		return "redirect:/portMain";
    } 
    //-----------------------------------------------------------------------------
    //port detail
    @RequestMapping(value = "/portDetail")
    public ModelAndView portDetail(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	
    		String seq = request.getParameter("seq");
    	
    		portfolio pInfo = new portfolio(); 
    		pInfo = mapper.getPortDetail(seq);
    		
    		//
    		if(pInfo.content != null)
    			pInfo.content = pInfo.content.replaceAll("\r\n","<br>");
    		
    		if(pInfo.my_part != null)
    			pInfo.my_part = pInfo.my_part.replaceAll("\r\n","<br>");
    		
    		ModelAndView mav = new ModelAndView();
    		mav.addObject("pInfo", pInfo);
		mav.setViewName("port_detail");
		return mav;
    } 
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/modPortPage")
    public ModelAndView modPortPage(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	
    		String seq = request.getParameter("seq");
    		
    		portfolio pInfo = new portfolio();
    		pInfo = mapper.getPortDetail(seq);
    	
    		ModelAndView mav = new ModelAndView();
    		mav.addObject("pInfo", pInfo);
		mav.setViewName("mod_port_page");
		return mav;
    } 
    //-----------------------------------------------------------------------------
    //port update
    @RequestMapping(value = "/modPortProc")
    public String modPortProc(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	
    		String seq = request.getParameter("seq");
    		String port_type = request.getParameter("select");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String my_part = request.getParameter("my_part");
		String work_date = request.getParameter("work_date");
		String img = "";
		
		portfolio pInfo = new portfolio(port_type, title, content, my_part, img, work_date);
		pInfo.seq = Integer.parseInt(seq);
		
		mapper.modPortfolio(pInfo);
    		
		return "redirect:/portMain";
    } 
    //-----------------------------------------------------------------------------
    //port delete
    @RequestMapping(value = "/deletePortProc")
    public String deletePortProc(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	
    		String seq = request.getParameter("seq");
    		mapper.deletePort(seq);
    		return "redirect:/portMain";
    }
}