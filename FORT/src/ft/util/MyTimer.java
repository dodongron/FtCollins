package ft.util;

import java.util.TimerTask;

import javax.swing.SwingUtilities;

public class MyTimer {
	private static Callback callback;

	public void setCallback(Callback callback) {
		testUtilTimer();
		MyTimer.callback = callback;
	}

	public static interface Callback {
		String ok(String time);
	}

	static int s = 60;
	static int m = 30;
	static int h = 0;
	static String ti = "";

	public static void testUtilTimer() {
		final java.util.Timer utilTimer = new java.util.Timer();
		utilTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if (m != 0) {
							s--;
							if (s == 0) {
								s = 59;
								m--;
								if (m == 0 && h != 0) {
									m = 59;
								}
							}
							ti = m + " : " + s;
							callback.ok(ti);
						} else {
							callback.ok("STOP");
							utilTimer.cancel();
						}
					}
				});
			}
		}, 0, 1000);
	}

	
	public static void main(String[]args){
		
		System.out.println(getTime());
		
		
	}
	static String ret="1";
	public static String getTime() {
		new MyTimer().setCallback(new MyTimer.Callback() {
			@Override
			public String ok(String time) {
				ret=time;
//				System.out.println(time);
				return ret;
			}
		});
		return ret;
	}
}
