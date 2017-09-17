package com.test;

import java.util.Date;

class Threader extends Thread{
	Dater examDater;
	
	public void run() {
		int[] examDate = Modal.examDateIn();
		examDater = new Dater(examDate[0], examDate[1], examDate[2], examDate[3]-1, 59,59);
		
		Dater dates = new Dater();
		Activity activity = new Activity();
		//更新目标事件
		activity.jtf1.setText(Modal.eventIn());
		
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
			
		
		

	
