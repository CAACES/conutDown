package com.test;

import java.util.Date;

class Threader extends Thread{
	Dater examDater;
	
	public void run() {
		int[] examDate = Modal.examDateIn();
		examDater = new Dater(examDate[0], examDate[1], examDate[2], examDate[3]-1, 59,59);
		
		Dater dates = new Dater();
		Activity activity = new Activity();
		//����Ŀ���¼�
		activity.jtf1.setText(Modal.eventIn());
		
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
			
		
		

	
