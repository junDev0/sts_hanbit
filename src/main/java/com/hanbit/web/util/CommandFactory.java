package com.hanbit.web.util;

/**
 * @date     : 2016. 7. 21.
 * @author   : jun
 * @fileName : CommandFactory.java
 * @story    :
 */

public class CommandFactory {

	public Command createCommand(String directory,String action,String page){
		
		return new Command(directory, action,page);
	}
}
