package com.jzx.print.test;

import java.util.ArrayList;
import java.util.List;

public class PrintMain {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>开始打印<<<<<<<<<<<<<<<<<<<");
		List<GoodsInfo> goods = new ArrayList<GoodsInfo>();
		goods.add(new GoodsInfo("J2EE", "11800", "1", "11800"));
		goods.add(new GoodsInfo("大数据", "14800", "1", "14800"));
		goods.add(new GoodsInfo("前端", "11800", "1", "11800"));

		SalesTicket stk = new SalesTicket(goods, "源辰信息", "201705230010", "3", "38400", "38400", "0");
		Print p = new Print(stk);
		p.printer();
		System.out.println(">>>>>>>>>>>>>>>>结束打印<<<<<<<<<<<<<<<<<<<");
	}
}
