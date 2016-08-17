package com.hanbit.web.global;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

/**
 * @date     : 2016. 7. 21.
 * @author   : jun
 * @fileName : Separator.java
 * @story    :
 */

public class Separator {
	public static CommandFactory fac = new CommandFactory();
	public static Command command;
	public static Command init(HttpServletRequest request, HttpServletResponse response){
		String path = request.getServletPath();
		String temp0 = path.split("/")[0];
		String temp = path.split("/")[1];
		String directory = temp.substring(0, temp.indexOf("."));
		System.out.println("디렉토리"+directory);
		
		Enumeration<String> en = request.getParameterNames();
		List<String>list = new ArrayList<String>();
		while (en.hasMoreElements()) {
			list.add((String)en.nextElement());
		}
		System.out.println("리스트"+list.toString());
		
		String action = list.contains("action")? request.getParameter("action") : "move";
		
		String page = list.contains("page")?request.getParameter("page"):"main";
		
		String pageNo = list.contains("pageNo")?request.getParameter("pageNo"):"1";

		String keyword = list.contains("keyword")?request.getParameter("keyword"):"lostChild";
		System.out.println("directory:"+directory);
		System.out.println("action"+action);
		System.out.println("page:"+page);
		command = fac.createCommand(directory, action, page);
		
		return command;

	}
}
