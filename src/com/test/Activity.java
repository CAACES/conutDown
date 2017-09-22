package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Activity extends JWindow implements MouseListener{

	int H=100,W=250;
	int X=900,Y=100,RX=0,RY=0;
	JPanel jp;
	JTextField jtf1,jtf2;
	JButton jb1;
	private Threader threader;
	Alter alter;

	public Threader getThreader() {
		return threader;
	}

	public void setThreader(Threader threader) {
		this.threader = threader;
	}

	//构造方法
	public Activity(Threader threader){
		this.threader = threader;

		//初始化位置
		int[] XY = new int[2];
		XY = Modal.XYIn();
		X = XY[0];
		Y = XY[1];
		
		//实例化组件
		jtf1 = new JTextField("距离");
		jp = new JPanel();
//		jp = new ImagePanel(new Image);
		jtf2 = new JTextField("0天0时0分0秒");
		jb1 = new JButton("X");
		
		//设置组件
		jp.setBackground(new Color(255,255,255));
		jp.setBounds(0, 0, W, H);
		jtf1.setEditable(false);
		jtf1.setFont(new Font(null, 0, 25));
		jtf1.setBorder(null);
		jtf1.setBackground(new Color(255,255,255));
		jtf1.setBounds(20, 20, 200, 30);
		jtf2.setEditable(false);
		jtf2.setFont(new Font(null, 0, 20));
		jtf2.setBorder(null);
		jtf2.setBackground(new Color(255,255,255));
		jtf2.setBounds(80, 60, 200, 40);
		//注册监听
		jp.addMouseListener(this);
		jtf1.addMouseListener(this);
		jtf2.addMouseListener(this);
		//设置背景

		
		//添加组价
		this.add(jtf2);
		this.add(jtf1);
		this.add(jp);
		
		//设置窗体
//		setBackImage(this, new ImageIcon("Tesla_Flag.jpg", null), true);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocation(X, Y);
		this.setSize(W, H);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	//重新加载目标数据
	public void reLoad(){
		this.threader.loadDate();
	}



	//
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount()==2 && this.alter == null)
			new Alter(this);
		if(arg0.getClickCount()==3)
			System.exit(0);
			
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		RX=arg0.getXOnScreen();
		RY=arg0.getYOnScreen();
	}

	//移动窗体
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		RX-=arg0.getXOnScreen();
		RY-=arg0.getYOnScreen();
		X -= RX;
		Y -= RY;
		Modal.XYOut(X, Y);
		this.setLocation(X, Y);
	}


}
