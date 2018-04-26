package com.jzx.print.analysis;

/**
 * 解析实体对象类
 * 
 * @author 杨杰
 * @version 2018年4月25日
 * @see PrintObject
 * @since
 */
public class PrintObject {
	// 匹配的文字(例：{name})
	private String text;
	// 字体大小
	private Integer size;
	// 字体
	private String font;
	// 是否加粗
	private Boolean bold;
	// 是否换行
	private Boolean line;
	// x轴偏移量
	private String x;
	// y轴偏移量(不建议设置，默认为字体高度+行距)
	private String y;
	// 行距(line为true才有效,默认3)
	private Integer linewidth;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public Boolean getBold() {
		return bold;
	}

	public void setBold(Boolean bold) {
		this.bold = bold;
	}

	public Boolean getLine() {
		return line;
	}

	public void setLine(Boolean line) {
		this.line = line;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public Integer getLinewidth() {
		return linewidth;
	}

	public void setLinewidth(Integer linewidth) {
		this.linewidth = linewidth;
	}

}
