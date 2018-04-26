# ticket-print 是什么？
1. ticket-print 是一个java票据打印工具，可以自由扩展。
2. ticket-print 可以打印小票，项目中的打印等等。
2. 用fastjson来解析json模板。
3. maven结构，只依赖2个第三方包。

# ticket-print 怎么用？
##  properties 配置文件说明
``` xml
-- 外部模板路径，如果不配置，则引用classpath下的template.json
ext.template=

--（A4纸 在72像素/英寸大小 585 * 832）
-- （80热敏小票打印在72像素/英寸大小 226 * n）

-- 纸宽度像素
paper.width=585
-- 纸高度像素
paper.height=832
-- 是否直接提交给打印机 (1 是 0 否) 生产建议用1
print.commit=0
```

## 模板文件配置说明
``` json
{
    "header": [
        {
            "text": "{companyName}",
            "size": 12,
            "font": "宋体",
            "bold": true,
            "line": true,
            "x": "28",
            "y": ""
        },
        {
            "text": "会员编号:{merberNo}",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": true,
            "x": "20",
            "y": ""
        },
        {
            "text": "订单号:{orderNo}",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": true,
            "x": "20",
            "y": ""
        },
        {
            "text": "下单时间:{orderDate}",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": true,
            "x": "20",
            "y": ""
        },
        {
            "text": "打印时间:{printDate}",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": true,
            "x": "20",
            "y": ""
        }
    ],
    "gooods": [
        {
            "text": "名称",
            "size": 8,
            "font": "宋体",
            "bold": true,
            "line": false,
            "x": "20",
            "y": ""
        },
        {
            "text": "单价",
            "size": 8,
            "font": "宋体",
            "bold": true,
            "line": false,
            "x": "60",
            "y": ""
        },
        {
            "text": "数量",
            "size": 8,
            "font": "宋体",
            "bold": true,
            "line": false,
            "x": "90",
            "y": ""
        },
        {
            "text": "小计",
            "size": 8,
            "font": "宋体",
            "bold": true,
            "line": false,
            "x": "120",
            "y": ""
        }
    ],
    "footer": [
        {
            "text": "商品总数:{goodsCount}件",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": false,
            "x": "15",
            "y": ""
        },
        {
            "text": "合计金额:{totalmoney}元",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": true,
            "x": "80",
            "y": ""
        },
        {
            "text": "实收:{actualmoney}元",
            "size": 8,
            "font": "宋体",
            "bold": false,
	    "line": false,
            "x": "15",
            "y": ""
        },
        {
            "text": "找零:{changemoney}元",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": true,
            "x": "80",
            "y": ""
        },
	{
            "text": "积分:{score}分",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": false,
            "x": "15",
            "y": ""
        },
        {
            "text": "操作员:{operatorname}",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": true,
            "x": "80",
            "y": ""
        },
        {
            "text": "地址:{address}",
            "size": 8,
            "font": "宋体",
            "bold": false,
            "line": true,
            "x": "0",
            "y": ""
        },
        {
            "text": "钱票请当面点清，离开柜台恕不负责!",
            "size": 8,
            "font": "宋体",
            "bold": true,
            "line": true,
            "x": "15",
            "y": ""
        }
    ]
}
```
1. **header为打印页眉配置**
2. **gooods为打印体（可以是商品，目前用商品做为demo）**
3. **footer为未打印页脚配置**
4. **元素说明**   
text：为打印标题   
size：本行字体大小   
font：字体（打印机支持的字体都可以）  
bold：是否加重字体   
line：是否换行   
   x：x轴的偏移量(第四象限为起点)   
   y：y轴的偏移量(第四象限为起点，不建议设定值，不设定即为：上一字体的高度)   
linewidth：行距(当line为true的时候才会生效，具体效果可以自己试试)

# 试试ticket-print?
## 怎样导入？
项目为maven工具，可以导入任何支持java的IDE中。
## 打包运行？
可以自己扩展maven assembly打包方式。
## 工具中运行？
运行项目中的 **com.jzx.print.PrintMain**  中的maven方法。

# 发散思维
作者为什么会写这样一个项目，主要是之前有个项目中用到了打印，自己封装一个工具试试。   
然后网上搜索了一下，总感觉讲得不是很详细，所以才会自己动手写这样一个项目，希望能够帮助到大家。   

如果您觉得帮助到了您，别忘记点击右上角的小星星哦。  
希望您能慷慨的拿出支付宝，扫我领红包支持一下，谢谢 ^ ~ ^！  
 ![image](https://github.com/hncdyj123/ticket-print/blob/master/image/IMG_0010.PNG)
最终实现效果如下图：  
 ![image](https://github.com/hncdyj123/ticket-print/blob/master/image/IMG_0711.JPG)
