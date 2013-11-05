package test.src;

import ft.util.MyTimer;

public class countdown {
	 public static void main(String[] args) {

	        MyTimer c = new MyTimer();
	        MyTimer.testUtilTimer();
	        c.setCallback(new MyTimer.Callback() {
	            @Override
	            public String ok(String time) {
	                System.out.println(time);
	                return time;
	            }
	        });

	    }
}