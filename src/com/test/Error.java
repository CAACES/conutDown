package com.test;

import java.awt.*;

import javax.swing.*;
import java.util.*;

public class Error extends JDialog{

	JTextField jtf1,jtf2;
	
	public Error(Frame owner,String title,boolean modal,String error){
		super(owner,title,modal);//调用父类的构造方法，达到模式对话效果
		
		//实例化组件
		jtf1 = new JTextField("日期错误！");
//		jtf2 = new JTextField(error);
		
		//添加组件
		this.add(jtf1);
		
		//设置窗体
		this.setVisible(true);
		this.setSize(50, 50);
//		this.setLocation(arg0, arg1)
	}
		
		
}
