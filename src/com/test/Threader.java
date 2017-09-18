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

	//读取目标时间
	public void loadDate(){
		int[] examDate = Modal.examDateIn();
		examDater = new Dater(examDate[0], examDate[1], examDate[2], examDate[3]-1, 59,59);
		//更新目标事件
		examEvent = Modal.eventIn();
		activity.jtf1.setText("距离"+examEvent);
	}
	
	public void run() {
		activity = new Activity(this);
		loadDate();//读取数据

		Dater dates = new Dater();
//		//更新目标事件
//		activity.jtf1.setText(Modal.eventIn());
		
		while (true) {
			Dater nowDater = new Dater(new Date());
			//计算剩余时间
			dates = Modal.setDater( examDater, nowDater);
			
//			System.out.println(String.valueOf(dates.getDay())+"天" + 
//						String.valueOf(dates.getHours())+"时" + 
//						String.valueOf(dates.getMinutes())+"分" + 
//						String.valueOf(dates.getSeconds())+"秒");
			//更新UI
			if(dates!=null){
				activity.jtf2.setText(String.valueOf(dates.getDay())+"天" + 
						String.valueOf(dates.getHours())+"时" + 
						String.valueOf(dates.getMinutes())+"分" + 
						String.valueOf(dates.getSeconds())+"秒");
			}else{
				activity.jtf2.setText("0天0时0分0秒");
				break;
			}
			//休眠1秒
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
			
		
		

	
