package com.jzx.print.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 销售票据实体类
 * 
 * @author admin
 * @version 2018年4月24日
 * @see SalesTicket
 * @since
 */
public class SalesTicket implements Printable {
	// 商品列表
	private List<GoodsInfo> goods;
	// 操作员
	private String operatorName = "源辰信息";
	// 订单编号
	private String orderId;
	// 商品总数
	private String totalGoodsNum;
	// 总金额
	private String totalPrice;
	// 实收款
	private String actualCollection;
	// 找零
	private String giveChange;
	// 会员编号
	private String cardNumber;
	// 积分
	private String integral;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");

	public SalesTicket(List<GoodsInfo> goods, String operatorName, String orderId, String totalGoodsNum, String totalPrice, String actualCollection, String giveChange, String cardNumber,
			String integral) {
		this.goods = goods;
		this.operatorName = operatorName;
		this.orderId = orderId;
		this.totalGoodsNum = totalGoodsNum;
		this.totalPrice = totalPrice;
		this.actualCollection = actualCollection;
		this.giveChange = giveChange;
		this.cardNumber = cardNumber;
		this.integral = integral;
	}

	public SalesTicket(List<GoodsInfo> goods, String operatorName, String orderId, String totalGoodsNum, String totalPrice, String actualCollection, String giveChange) {
		super();
		this.goods = goods;
		this.operatorName = operatorName;
		this.orderId = orderId;
		this.totalGoodsNum = totalGoodsNum;
		this.totalPrice = totalPrice;
		this.actualCollection = actualCollection;
		this.giveChange = giveChange;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// 此 Graphics2D 类扩展 Graphics 类，以提供对几何形状、坐标转换、颜色管理和文本布局更为复杂的控制。
		// 它是用于在 Java(tm) 平台上呈现二维形状、文本和图像的基础类。
		Graphics2D g2 = (Graphics2D) graphics;

		g2.setColor(Color.black);// 设置打印颜色为黑色

		// 打印起点坐标
		double x = pageFormat.getImageableX(); // 返回与此 PageFormat相关的 Paper对象的可成像区域左上方点的 x坐标。
		double y = pageFormat.getImageableY(); // 返回与此 PageFormat相关的 Paper对象的可成像区域左上方点的 y坐标。

		// Font.PLAIN： 普通样式常量 Font.ITALIC 斜体样式常量
		// Font.BOLD 粗体样式常量。
		Font font = new Font("宋体", Font.BOLD, 12); // 根据指定名称、样式和磅值大小，创建一个新 Font。

		g2.setFont(font);// 设置标题打印字体

		float heigth = font.getSize2D();// 获取字体的高度

		// 设置小票的标题标题
		g2.drawString("源辰信息科技有限公司", (float) x + 25, (float) y + heigth);

		float line = 2 * heigth; // 下一行开始打印的高度
		g2.setFont(new Font("宋体", Font.PLAIN, 8)); // 设置正文字体
		heigth = font.getSize2D(); // 字体高度

		line += 2;

		g2.drawString("操作员:" + operatorName, (float) x + 20, (float) y + line);// 设置操作员

		line += heigth;

		// 设置订单号
		g2.drawString("订单号:" + orderId, (float) x + 20, (float) y + line);
		line += heigth + 2;

		// 设置标题
		g2.drawString("名称", (float) x + 20, (float) y + line);
		g2.drawString("单价", (float) x + 60, (float) y + line);
		g2.drawString("数量", (float) x + 90, (float) y + line);
		g2.drawString("小计", (float) x + 120, (float) y + line);
		line += heigth;
		/*
		 * 虚线绘制设置 setStroke(Stroke):为 Graphics2D 上下文设置 Stroke 由 BasicStroke定义的呈现属性描述了用画笔沿 Shape 的轮廓绘制的某个标记的形状，以及应用在 Shape 路径线段的末端和连接处的装饰。 这些呈现属性包括： width：画笔的宽度，是垂直于画笔轨迹的测量值。 此宽度必须大于或等于 0.0f，0.0f为最细线条。
		 * end caps：在未封闭子路径和虚线线段的末端应用的一些装饰。如果子路径没有 CLOSE 段，则在同一点上开始和结束的子路径仍被认为是未封闭的。 关于 CLOSE 段的更多信息，请参阅 SEG_CLOSE。三个不同的装饰是： CAP_BUTT：无装饰地结束未封闭的子路径和虚线线段。 CAP_ROUND：使用半径等于画笔宽度一半的圆形装饰结束未封闭的子路径和虚线线段。
		 * CAP_SQUARE：使用正方形结束未封闭的子路径和虚线线段，正方形越过线段端点，并延长等于线条宽度一半的距离。 line joins：在两个路径线段的交汇处，以及使用 SEG_CLOSE 封闭的子路径端点的交汇处应用的装饰。 三个不同的装饰是： JOIN_BEVEL：通过直线连接宽体轮廓的外角，将路径线段连接在一起。
		 * JOIN_MITER：扩展路径线段的外边缘，直到它们连接在一起。 JOIN_ROUND：通过舍去半径为线长的一半的圆角，将路径线段连接在一起。 miter limit：对剪裁具有 JOIN_MITER 装饰的线接合点的限制。当斜接长度与笔划宽度的比大于 miterlimit 值时，需要剪裁线接合点。
		 * 斜接长度是斜接的对角线长度，即交汇处的内棱角和外棱角之间的距离。两条线段形成的角度越小，斜接长度就越长，交汇处的角度就越尖锐。 默认 miterlimit 值为 10.0f，它会使所有小于 11 度的角都被剪裁。剪裁斜接会使线接合点的装饰变成斜角。 必须大于或等于 1.0f。 dash attributes：关于如何通过在不透明和透明部分之间交替形成一个虚线模式的定义。
		 * 表示虚线模式的数组 dash phase - 开始虚线模式的偏移量
		 */
		// 虚线设置
		g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, new float[] { 4.0f }, 0.0f));
		// 在此图形上下文的坐标系中使用当前颜色在点 (x1, y1) 和 (x2, y2) 之间画一条线。 即绘制虚线
		g2.drawLine((int) x, (int) (y + line), (int) x + 158, (int) (y + line));
		line += heigth;
		// 设置商品清单
		if (goods != null && goods.size() > 0) {
			for (GoodsInfo gdf : goods) {
				g2.drawString(gdf.getName(), (float) x + 15, (float) y + line);
				g2.drawString(gdf.getPrice(), (float) x + 60, (float) y + line);
				g2.drawString(gdf.getNum(), (float) x + 95, (float) y + line);
				g2.drawString(gdf.getTotal(), (float) x + 120, (float) y + line);
				line += heigth;
			}
		}
		g2.drawLine((int) x, (int) (y + line), (int) x + 158, (int) (y + line));
		line += heigth + 2;
		g2.drawString("商品总数:" + totalGoodsNum + "件", (float) x + 15, (float) y + line);
		g2.drawString("合计:" + totalPrice + " 元", (float) x + 80, (float) y + line);
		line += heigth;
		g2.drawString("实收:" + actualCollection + "元", (float) x + 15, (float) y + line);
		g2.drawString("找零:" + giveChange + "元", (float) x + 80, (float) y + line);
		line += heigth;

		if (cardNumber != null && !"".equals(cardNumber)) {
			g2.drawString("当前会员:" + cardNumber, (float) x + 15, (float) y + line);
			line += heigth;
			g2.drawString("积分:" + integral, (float) x + 15, (float) y + line);
		}
		g2.drawString("时间:" + sdf.format(new Date()), (float) x + 15, (float) y + line);
		line += heigth;
		g2.drawString("钱票请当面点清，离开柜台恕不负责", (float) x + 15, (float) y + line);
		switch (pageIndex) {
		case 0:
			return PAGE_EXISTS; // 0
		default:
			return NO_SUCH_PAGE; // 1
		}
	}

	@Override
	public String toString() {
		return "SalesTicket [goods=" + goods + ", operatorName=" + operatorName + ", orderId=" + orderId + ", totalGoodsNum=" + totalGoodsNum + ", totalPrice=" + totalPrice + ", actualCollection="
				+ actualCollection + ", giveChange=" + giveChange + ", cardNumber=" + cardNumber + ", integral=" + integral + ", sdf=" + sdf + "]";
	}

}
