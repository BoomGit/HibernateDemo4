package com.boom.betwixt;

//再创建一个WriteApp类
public class WriteApp {
	//创建一个例子Bean,并将它转化为XML
	public static void main(String[] args)throws Exception {
		//先创建一个StringWriter,我们将他写入一个字符串
		
		//Betwxit在这里仅仅将一个Bean写入一个片段
		
		//所以如果要想完整xml内容，我们应该写入头格式
		
		//创建一个BeanWriter,其将写入到我们预备的Stream中
		
		//配置betwxit
		//更多详情请参考java docs 或者最新的文档
		
		//如果这个地方不传入XML的根节点名，betwxit将自己猜测是什么
		//但是让我们将例子Bean名作为根节点吧
		
		//输出结果
		
		//Betwxit 写的是片段而不是一个文档，所以不要自动关闭掉writers或者streams
		
		//但这里仅仅是一个例子，不会做更多事情，所以可以关掉
		
	}
}
