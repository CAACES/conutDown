package com.test;

import java.awt.*;

import javax.swing.*;
import java.util.*;

public class Error extends JDialog{

	JTextField jtf1,jtf2;
	
	public Error(Frame owner,String title,boolean modal,String error){
		super(owner,title,modal);//���ø���Ĺ��췽�����ﵽģʽ�Ի�Ч��
		
		//ʵ�������
		jtf1 = new JTextField("���ڴ���");
//		jtf2 = new JTextField(error);
		
		//������
		this.add(jtf1);
		
		//���ô���
		this.setVisible(true);
		this.setSize(50, 50);
//		this.setLocation(arg0, arg1)
	}
		
		
}
