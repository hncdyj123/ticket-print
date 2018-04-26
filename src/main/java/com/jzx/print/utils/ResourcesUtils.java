package com.jzx.print.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

/**
 * 资源解析器
 * 
 * @author 杨杰
 * @version 2018年4月26日
 * @see ResourcesUtils
 * @since
 */
public class ResourcesUtils {
	/**
	 * 解析模板文件
	 * 
	 * @param extFile 外部模板
	 * @return
	 * @throws FileNotFoundException
	 * @see
	 */
	public String getResource(String extFile) throws Exception {
		String jsonStr = "";
		InputStream stream = null;
		try {
			if (StringUtils.isBlank(extFile)) {
				stream = this.getClass().getResourceAsStream("/template.json");
			} else {
				File file = new File(extFile);
				stream = new FileInputStream(file);
			}
			byte[] bytes = new byte[stream.available()];
			stream.read(bytes);
			jsonStr = new String(bytes, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonStr;
	}
}
