package com.jzx.print;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.jzx.print.analysis.PrintBook;
import com.jzx.print.goods.GoodsInfo;
import com.jzx.print.utils.PropertiesUtils;
import com.jzx.print.utils.ResourcesUtils;

/**
 * 主程序类
 * 
 * @author 杨杰
 * @version 2018年4月26日
 * @see PrintMain
 * @since
 */
public class PrintMain {

	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>开始打印<<<<<<<<<<<<<<<<<<<");
		// 模板解析
		String jsonStr = "";
		try {
			jsonStr = new ResourcesUtils().getResource(PropertiesUtils.getString("ext.template"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (StringUtils.isBlank(jsonStr)) {
			System.exit(0);
			return;
		}
		PrintBook printBook = JSON.parseObject(jsonStr, PrintBook.class);

		// 设置打印页眉
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("companyName", "茶颜观色(武陵店)");
		dataMap.put("merberNo", "1234567890");
		dataMap.put("orderNo", "1234567890");
		dataMap.put("orderDate", "2018-04-25 15:32:32");
		dataMap.put("printDate", "2018-04-25 15:32:32 星期三");
		// 设置打印body
		List<GoodsInfo> goods = new ArrayList<GoodsInfo>();
		goods.add(new GoodsInfo("J2EE", "11800", "1", "11800"));
		goods.add(new GoodsInfo("大数据", "14800", "1", "14800"));
		goods.add(new GoodsInfo("前端", "11800", "1", "11800"));
		dataMap.put("goodInfos", goods);
		// 设置打印页脚
		dataMap.put("goodsCount", "3");
		dataMap.put("totalmoney", "38400");
		dataMap.put("actualmoney", "38400");
		dataMap.put("changemoney", "0");
		dataMap.put("operatorname", "茶颜观色");
		dataMap.put("score", "10");
		dataMap.put("address", "常德水星楼(苏宁电器背后、麦当劳斜对面)");
		// 输出打印
		PrintTicket printTicket = new PrintTicket(printBook, dataMap);
		printTicket.printer();
		System.out.println(">>>>>>>>>>>>>>>>结束打印<<<<<<<<<<<<<<<<<<<");
	}
}
