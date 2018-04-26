package com.jzx.print.test;

/**
 * 商品信息实体类
 * 
 * @author admin
 * @version 2018年4月24日
 * @see GoodsInfo
 * @since
 */
public class GoodsInfo {
	// 商品名称
	private String name;
	// 商品单价
	private String price;
	// 商品数量
	private String num;
	// 小计
	private String total;

	public GoodsInfo() {

	}

	public GoodsInfo(String name, String price, String num, String total) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
