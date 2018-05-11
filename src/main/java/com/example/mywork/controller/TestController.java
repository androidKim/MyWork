package com.example.mywork.controller;

import java.util.Enumeration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.mywork.util.Util;

@Controller
public class TestController
{     
	/******************************* Define *******************************/
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	/******************************* Member *******************************/
	public Util m_Util = new Util();
    //@Autowired
    //TestService testService;
    
    @Autowired
	private HttpServletRequest request;
    /******************************* User Function *******************************/
    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value = "/test")
    public void test(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	    	
		try 
		{			
			//RequestData...
			String strParam = request.getParameter("json_data");
			//if(strParam != null)
			if(strParam == null)
			{	
			    	//결과값 flush...
			    	//Common
			    	JSONObject reqCommon = new JSONObject();
			    	reqCommon.put("ret_code", 0);
			    	reqCommon.put("ret_msg", "SUCCESS");
					JSONObject jsonResult = new JSONObject();
					jsonResult.put("common", reqCommon);							
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print(jsonResult.toString());
					response.flushBuffer();
			}
			else
			{
				return;
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   	
    } 

    //-----------------------------------------------------------------------------
    //
    @RequestMapping(value="/setFileUpload",method = RequestMethod.POST)   
	public void setFileUpload(HttpServletRequest request, HttpServletResponse response)
	{	
	    	MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
	        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
	        MultipartFile multipartFile = null;
	        while(iterator.hasNext()){
	            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
	            if(multipartFile.isEmpty() == false)
	            {
	            	/*
	                log.debug("------------- file start -------------");
	                log.debug("name : "+multipartFile.getName());
	                log.debug("filename : "+multipartFile.getOriginalFilename());
	                log.debug("size : "+multipartFile.getSize());
	                log.debug("-------------- file end --------------\n");
	            	 */
	            }
	        }
	}

    //-----------------------------------------------------------------------------
    //android, ios cookie test page
    @RequestMapping(value = "/webviewTest")
    public ModelAndView webviewTest(Model model, HttpServletRequest request, HttpServletResponse response) 
    {	    	
		ModelAndView mav = new ModelAndView();
		response.addCookie(new Cookie("foo", "bar"));//key, value
		
		mav.addObject("user-agent", getUserAgent());
		mav.addObject("headers", getHeadersInfo());
		
		mav.setViewName("webview_test");
		
		return mav;
    } 
   
    //get user agent
  	private String getUserAgent() 
  	{
  		return request.getHeader("user-agent");
  	}

  	//get request headers
  	private Map<String, String> getHeadersInfo() 
  	{
  		Map<String, String> map = new HashMap<String, String>();

  		Enumeration headerNames = request.getHeaderNames();
  		while (headerNames.hasMoreElements()) 
  		{
  			String key = (String) headerNames.nextElement();
  			String value = request.getHeader(key);
  			map.put(key, value);
  		}
  		return map;
  	}
}