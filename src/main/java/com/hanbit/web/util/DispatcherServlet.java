package com.hanbit.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

/**
 * @date     : 2016. 7. 22.
 * @author   : jun
 * @fileName : DispatcherServlet.java
 * @story    :
 */

public class DispatcherServlet  {
	public static void send(HttpServletRequest request, HttpServletResponse response,Command command)throws Exception, IOException{
		
		System.out.println("view:"+command.getView());
			request.getRequestDispatcher(command.getView()).forward(request, response);

	}
}
