package com.hanbit.web.util;

import java.util.List;
import java.util.Map;

/**
 * @date     : 2016. 7. 8.
 * @author   : jun
 * @fileName : CommonService.java
 * @story    :
 */

public interface CommonService {
	public List<?> list();
	public List<?> findBy();
	public int count();
	public Map<?,?> map();
}
