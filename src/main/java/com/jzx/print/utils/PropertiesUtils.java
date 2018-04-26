package com.jzx.print.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 配置文件解析
 * 
 * @author 杨杰
 * @version 2018年4月26日
 * @see PropertiesUtils
 * @since
 */
public class PropertiesUtils {
	private static final String BUNDLE_NAME = "config";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private static ResourceBundle EXIT_RESOURCE_BUNDLE = null;

	private PropertiesUtils() {
	}

	/**
	 * 获取内部文件指定的属性
	 * 
	 * @param key 要获取的key
	 * @return
	 * @see
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			System.err.println(("load properties for key = " + key + "not found!"));
			return "";
		}
	}

	/**
	 * 获取外部文件指定的属性
	 * 
	 * @param key 要获取的key
	 * @return
	 * @see
	 */
	public static String getByKey(String key) {
		try {
			if (EXIT_RESOURCE_BUNDLE == null) {
				return "";
			}
			return EXIT_RESOURCE_BUNDLE.getString(key);
		} catch (Exception e) {
			System.err.println(("load properties for key = " + key + "not found!"));
			return "";
		}
	}

	/**
	 * 初始化外部配置文件
	 * 
	 * @param filePath
	 * @throws IOException
	 * @see
	 */
	public static void initProperties(String filePath) throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		EXIT_RESOURCE_BUNDLE = new PropertyResourceBundle(in);
	}
}
