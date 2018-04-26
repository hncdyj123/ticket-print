package com.jzx.print.test;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Print {
	private SalesTicket salesTicket;

	public Print(SalesTicket salesTicket) {
		this.salesTicket = salesTicket;
	}

	public void printer() {
		try {
			// Book 类提供文档的表示形式，该文档的页面可以使用不同的页面格式和页面 painter
			Book book = new Book(); // 要打印的文档

			// PageFormat类描述要打印的页面大小和方向
			PageFormat pf = new PageFormat(); // 初始化一个页面打印对象
			pf.setOrientation(PageFormat.PORTRAIT); // 设置页面打印方向，从上往下，从左往右

			// 设置打印纸页面信息。通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
			Paper paper = new Paper();
			paper.setSize(595, 842); // A4纸张大小
			paper.setImageableArea(10, 10, 585, 832); // 打印区域
			pf.setPaper(paper);

			book.append(salesTicket, pf);

			PrinterJob job = PrinterJob.getPrinterJob(); // 获取打印服务对象

			job.setPageable(book); // 设置打印类

			// 获取可用的打印机服务
			// PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			// DocFlavor flavor = DocFlavor.BYTE_ARRAY.PNG;
			// 可用的打印机列表(字符串数组)
			// PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);
			// for (int i = 0; i < printService.length; i++) {
			// System.out.println(printService[i].getName());
			// }
			// 当前默认打印机
			// PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
			// ps.getName();

			// job.setPrintService(printService[1]);

			// // job.print(); // 开始打印

			// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
			boolean a = job.printDialog();
			if (a) {
				job.print();
			} else {
				job.cancel();
			}

		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
}
