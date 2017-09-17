package com.test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.annotation.processing.Completion;
import javax.swing.*;

public class Activity extends JWindow implements MouseListener{

	int H=100,W=250;
	int X=900,Y=100,RX=0,RY=0;
	JPanel jp;
	JTextField jtf1,jtf2;
	JButton jb1;
	
	//构造方法
	public Activity(){
		
		//初始化位置
		int[] XY = new int[2];
		XY = Modal.XYIn();
		X = XY[0];
		Y = XY[1];
		
		//实例化组件
		jtf1 = new JTextField("距离软考");
		jp = new JPanel();
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
		
		//添加组价
		this.add(jtf2);
		this.add(jtf1);
		this.add(jp);
		
		//设置窗体
//		this.setTitle("软考倒计时器");
		this.setLayout(null);
		this.setVisible(true);
		this.setLocation(X, Y);
		this.setSize(W, H);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	

	//设置背景图片
	public static void setBackImage(JFrame frame, ImageIcon icon, boolean isAutoSize){
		if(frame==null || icon==null)return;
		Container pane = frame.getContentPane();
		((JPanel)pane).setOpaque(false);
		JLayeredPane layerp = frame.getLayeredPane();
		//
		Component[] coms = layerp.getComponentsInLayer(new Integer(Integer.MIN_VALUE));
		if(coms.length>0){
			for(Component com:coms){
				layerp.remove(com);
			}
		}
		//
		JLabel lab = new JLabel(icon);
		if(isAutoSize){
			icon.setImage(icon.getImage().getScaledInstance(frame.getSize().width,
					frame.getSize().height, Image.SCALE_SMOOTH));
		}
		lab.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		layerp.add(lab,new Integer(Integer.MIN_VALUE));
	}
	
	//
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount()==2)
			new Alter();
		if(arg0.getClickCount()==3)
			System.exit(0);
			
	}
	
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
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
