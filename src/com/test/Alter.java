package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class Alter extends JFrame implements MouseListener{

	//�������
	JPanel jp1,jp2,jp3;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JLabel jl1,jl2,jl3,jl4,jl5;
	JButton jb1,jb2;
	int w=10;
	int X,Y;
	private Activity activity;

	//���췽��
	public Alter(Activity activity){
		this.activity = activity;

		//��ʼ��λ��
		int[] XY = new int[2];
		XY = Modal.XYIn();
		X = XY[0]-200;
		Y = XY[1];


		//ʵ�������
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jtf1 = new JTextField(w);
		jtf2 = new JTextField(w);
		jtf3 = new JTextField(w);
		jtf4 = new JTextField(w);
		jtf5 = new JTextField(w);
//		String examEvent = activity.getThreader().getExamEvent();
//		String[] t = new String[2];
//		t = examEvent.split("����");
//		jtf1.setText(t[1]);
		jtf1.setText(activity.getThreader().getExamEvent());
		jtf2.setText(activity.getThreader().getExamDater().getYear()+"");
		jtf3.setText(activity.getThreader().getExamDater().getMonth()+"");
		jtf4.setText(activity.getThreader().getExamDater().getDay()+"");
		jtf5.setText(activity.getThreader().getExamDater().getHours()+"");
		jl1 = new JLabel("Ŀ���¼�");
		jl2 = new JLabel("Ŀ����");
		jl3 = new JLabel("Ŀ����");
		jl4 = new JLabel("Ŀ����");
		jl5 = new JLabel("Ŀ��ʱ");
		jb1 = new JButton("ȷ��");
		jb2 = new JButton("ȡ��");
		
		//�������
		jb1.addMouseListener(this);
		jb2.addMouseListener(this);
//		jp.setBounds(0, 20, W, H);
//		jtf1.setBounds(0, 0, 20, 5);
//		jtf2.setBounds(0, 0, 0, 0);
//		jtf3.setBounds(0, 0, 0, 0);
//		jtf4.setBounds(0, 0, 0, 0);
//		jtf5.setBounds(0, 0, 0, 0);
//		jl1.add(jtf1);
//		jl2.add(jtf2);
//		jl3.add(jtf3);
//		jl4.add(jtf4);
//		jl5.add(jtf5);
//		jtf1.add(jl1);
//		jtf2.add(jl2);
//		jtf3.add(jl3);
//		jtf4.add(jl4);
//		jtf5.add(jl5);
		
		//������
		jp2.add(jl1);
		jp2.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		jp1.add(jl3);
		jp1.add(jtf3);
		jp1.add(jl4);
		jp1.add(jtf4);
		jp1.add(jl5);
		jp1.add(jtf5);
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp1,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		this.add(jp2,BorderLayout.NORTH);
		
		//���ò���
		
		//���ô���
		this.setVisible(true);
		this.setLocation(X, Y);
		this.setSize(200, 220);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//���ȷ��
		if(arg0.getSource()==jb1){
			Dater nowDate = new Dater(new Date());
			String[] examDate = new String[4];
			boolean isTrue = false;
			if(Integer.parseInt(jtf2.getText())>nowDate.getYear()){
				isTrue = true;
			}else if(Integer.parseInt(jtf2.getText())==nowDate.getYear()){
				if(Integer.parseInt(jtf3.getText())>nowDate.getMonth()){
					isTrue = true;
				}else if(Integer.parseInt(jtf3.getText())==nowDate.getMonth()){
					if(Integer.parseInt(jtf4.getText())>nowDate.getDay()){
						isTrue = true;
					}else if(Integer.parseInt(jtf4.getText())==nowDate.getDay()){
						if(Integer.parseInt(jtf5.getText())>nowDate.getHours()){
							isTrue = true;
						}
					}
				}
			}
			
			if(isTrue){
				//��װ����
				examDate[0] = jtf2.getText();
				examDate[1] = jtf3.getText();
				examDate[2] = jtf4.getText();
				examDate[3] = jtf5.getText();
				//��������
				Modal.examDateOut(examDate);
				//�����¼�
				Modal.eventOut(jtf1.getText());
				//���¼���ʱ��
				activity.reLoad();
				this.dispose();
			}else{
				//���ݲ���ȷ��������ʾ
				new Error(this, "����", true, null);
			}
		}
		
		
		if(arg0.getSource()==jb2){
			this.dispose();
		}
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
