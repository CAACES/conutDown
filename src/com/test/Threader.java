package com.test;

import java.util.Date;

class Threader extends Thread{
	private Dater examDater;
	private String examEvent;
	private Activity activity;

	public Dater getExamDater() {
		return examDater;
	}

	public void setExamDater(Dater examDater) {
		this.examDater = examDater;
	}

	public String getExamEvent() {
		return examEvent;
	}

	public void setExamEvent(String examEvent) {
		this.examEvent = examEvent;
	}
	//	private Start start;

//	public Threader(Start start){
//		this.start = start;
//	}

	//��ȡĿ��ʱ��
	public void loadDate(){
		int[] examDate = Modal.examDateIn();
		examDater = new Dater(examDate[0], examDate[1], examDate[2], examDate[3]-1, 59,59);
		//����Ŀ���¼�
		examEvent = Modal.eventIn();
		activity.jtf1.setText("����"+examEvent);
	}
	
	public void run() {
		activity = new Activity(this);
		loadDate();//��ȡ����

		Dater dates = new Dater();
//		//����Ŀ���¼�
//		activity.jtf1.setText(Modal.eventIn());
		
		while (true) {
			Dater nowDater = new Dater(new Date());
			//����ʣ��ʱ��
			dates = Modal.setDater( examDater, nowDater);
			
//			System.out.println(String.valueOf(dates.getDay())+"��" + 
//						String.valueOf(dates.getHours())+"ʱ" + 
//						String.valueOf(dates.getMinutes())+"��" + 
//						String.valueOf(dates.getSeconds())+"��");
			//����UI
			if(dates!=null){
				activity.jtf2.setText(String.valueOf(dates.getDay())+"��" + 
						String.valueOf(dates.getHours())+"ʱ" + 
						String.valueOf(dates.getMinutes())+"��" + 
						String.valueOf(dates.getSeconds())+"��");
			}else{
				activity.jtf2.setText("0��0ʱ0��0��");
				break;
			}
			//����1��
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
			
		
		

	
