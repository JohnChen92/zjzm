package com.chzm.config.bussConfig;

import java.util.HashMap;
import java.util.Map;

public class AuthMapConfig {

	/**
	 * 路径对应权限管理的Map
	 */
	public static Map<String, String> map = null;
	
	static {
			map =new HashMap<String, String>();
			map.put("/product/saveProduct","1-2-3");
	}
}
