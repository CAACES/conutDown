package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Modal {

	

	//����ʣ�����ڷ���
	protected static Dater setDater(Dater examDater,Dater nowDater){
		Dater dater = new Dater();
		int day = 0,hours = 0,minutes = 0,seconds = 0,t=0;
		
		if(isLegal(examDater, nowDater)){
			//ʣ�������߼�
			for (int year = nowDater.getYear(); year <= examDater.getYear(); year++) {
				for (int month = 1; month <= 12; month++) {
					t = 0;
					if(year < nowDater.getYear()){
					}else if(year==nowDater.getYear() && month<nowDater.getMonth()){
					}else if(year==nowDater.getYear() && month==nowDater.getMonth()){
						if(examDater.getYear() == nowDater.getYear() && examDater.getMonth() == nowDater.getMonth()){
							if(examDater.getDay() > nowDater.getDay()){
								if(examDater.getHours()<nowDater.getHours()){
									t  = examDater.getDay()-nowDater.getDay()-1;
								}else{
									t  = examDater.getDay()-nowDater.getDay();
								}
							}else{
							}
						}else{
							t  = dayOfMonth(year, month)-jianDayCon(examDater,nowDater);
						}
					}else if(year==examDater.getYear() && month==examDater.getMonth()){
						if(examDater.getYear() == nowDater.getYear() && examDater.getMonth() == nowDater.getMonth()){
							if(examDater.getDay() > nowDater.getDay()){
								if(examDater.getHours()>nowDater.getHours()){
									t  = examDater.getDay()-nowDater.getDay();
								}else{
									t  = examDater.getDay()-nowDater.getDay()-1;
								}
							}else{
							}
						}else{
							t  = examDater.getDay() - 1;
						}
					}else if(year==examDater.getYear() && month>examDater.getMonth()){
					}else if(year>examDater.getYear()){
					}else{
						t  = dayOfMonth(year, month);
					}
					day += t ;
	//				System.out.println("��������"+year+"��"+month+"��");
	//				System.out.println("����"+t +"��");
	//				System.out.println("���ڹ���"+day+"��");
	//				System.out.println(" ");
				}
			}
		}else{
			return null;
		}
		
		//�ж�ʱ������߼�
		if(nowDater.getHours()<=examDater.getHours()){
			hours = examDater.getHours() - nowDater.getHours();
			minutes = examDater.getMinutes() - nowDater.getMinutes();
			seconds = examDater.getSeconds() - nowDater.getSeconds();
		}else{
			hours = 24 - (nowDater.getHours() - examDater.getHours());
			minutes =59 - nowDater.getMinutes();
			seconds =59 - nowDater.getSeconds();
		}
		
		dater.setDay(day);
		dater.setHours(hours);
		dater.setMinutes(minutes);
		dater.setSeconds(seconds);
		return dater;
	}
	
	//�ж����귽��
	protected static boolean runyear(int year) {
		boolean isRunYear = false;
		
		//�ж�
		if((year%4==0 && year%100!=0) && year%100!=0)
			isRunYear = true;
		
		return isRunYear;
	}
	
	//�·ݵ���������
	protected static int dayOfMonth(int year, int month){
		int days = 30;
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
			
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
			
		case 2:
			if(runyear(year))
				days = 29;
			else
				days = 28;
			break;
			
		default:
			days = 30;
			break;
		}
		
		return days;
	}
	
	//����Ҫ��ȥ����������
	protected static int jianDayCon(Dater examDater,Dater nowDater) {
		int day = nowDater.getDay();
		
		if(examDater.getHours() < nowDater.getHours()){
			day += 1;
		}
		
		return day;
		
	}
	
	//�ж��Ƿ��ǺϷ�ʱ��
	protected static boolean isLegal(Dater examDater,Dater dater){
		boolean isLegal = false;
		
		
		//��ʼ�ж�
		if(dater.getYear()<examDater.getYear()){
			isLegal = true;
		}else if(dater.getYear()==examDater.getYear()){
			if(dater.getMonth()<examDater.getMonth()){
				isLegal = true;
			}else if(dater.getMonth()==examDater.getMonth()){
				if(dater.getDay()<examDater.getDay()){
					isLegal = true;
				}else if(dater.getDay()==examDater.getDay()){
					if(dater.getHours()-1<examDater.getHours()){
						isLegal = true;
					}
				}
			}
		}
		
		return isLegal;
	}
	
	//��������
	protected static void XYOut(int x, int y) {
		try {
			String location = new String(String.valueOf(x)+"###"+String.valueOf(y)+"##");
			FileOutputStream out = new FileOutputStream("location.txt");
			out.write(location.getBytes());
			
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡ����
	protected static int[] XYIn() {
		int[] XY= new int[2];
		byte[] buff = new byte[100];
		String[] location = new String[2];
		String[] location1 = new String[2];
		String[] location2 = new String[2];
		try {
			
			FileInputStream in = new FileInputStream("location.txt");
			in.read(buff);
			
			String t = new String(buff);
			location1 = t.split("###");
			location2 = location1[1].split("##");
			
			XY[0] = Integer.parseInt(location1[0]);
			XY[1] = Integer.parseInt(location2[0]);
			
			
			in.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return XY;
	}

	//��ȡĿ������
	protected static int[] examDateIn(){
		int[] examDate= new int[4];
		byte[] buff = new byte[100];
		String[] t1 = new String[2];
		String[] t2 = new String[2];
		String[] t3 = new String[2];
		String[] t4 = new String[2];
		try {
			//��ȡ����
			FileInputStream in = new FileInputStream("examDate.txt");
			in.read(buff);
			
			//�и�����
			String t = new String(buff);
			t1 = t.split("#####");
			t2 = t1[1].split("####");
			t3 = t2[1].split("###");
			t4 = t3[1].split("##");
			
			//��װ����
			examDate[0] = Integer.parseInt(t1[0]);
			examDate[1] = Integer.parseInt(t2[0]);
			examDate[2] = Integer.parseInt(t3[0]);
			examDate[3] = Integer.parseInt(t4[0]);
			
			in.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return examDate;
	}
	
	
	
	//����Ŀ������
	protected static void examDateOut(String[] examDate) {
		try {
			//��װ����
			String location = new String(examDate[0]+"#####"+
										examDate[1]+"####"+
										examDate[2]+"###"+
										examDate[3]+"##");
			
			FileOutputStream out = new FileOutputStream("examDate.txt");
			out.write(location.getBytes());
			
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡ�¼�
	protected static String eventIn(){
		byte[] buff = new byte[1024];
		String event = null;
		try {
			//��ȡ����
			FileInputStream in = new FileInputStream("event.txt");
			in.read(buff);
			event = new String(buff);
			System.out.println(event.length());
			in.close();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return event;
	}
		
	//����Ŀ���¼�
	protected static void eventOut(String event) {
		event = new String(event);
		try {
			FileOutputStream out = new FileOutputStream("event.txt");
			out.write(event.getBytes());
			
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




