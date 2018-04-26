package com.jzx.print.analysis;

import java.util.ArrayList;
import java.util.List;

/**
 * 文档实体类
 * 
 * @author 杨杰
 * @version 2018年4月25日
 * @see PrintBook
 * @since
 */
public class PrintBook {
	// 打印页头
	private List<PrintObject> header = new ArrayList<PrintObject>();
	// 打印内容
	private List<PrintObject> gooods = new ArrayList<PrintObject>();
	// 打印页脚
	private List<PrintObject> footer = new ArrayList<PrintObject>();

	public List<PrintObject> getHeader() {
		return header;
	}

	public void setHeader(List<PrintObject> header) {
		this.header = header;
	}

	public List<PrintObject> getGooods() {
		return gooods;
	}

	public void setGooods(List<PrintObject> gooods) {
		this.gooods = gooods;
	}

	public List<PrintObject> getFooter() {
		return footer;
	}

	public void setFooter(List<PrintObject> footer) {
		this.footer = footer;
	}

}
