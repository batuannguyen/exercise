package game;

import java.util.Random;

public class Dice {
	private int dot;
	private float[] arr = new float[7];
	public Dice(int dot) {
		this.dot = dot;
	}
	private void setArr() {
		arr[0] = 0f;
		arr[6] = 1f;
		for (int i=1;i<6;i++) {
			if (i==dot) {
				arr[i]=arr[i-1]+0.2f;
			}
			else {
				arr[i]=arr[i-1]+0.16f;
			}
		}
		
	}
	public int getScore() {
		this.setArr();
		Random rd = new Random();
		float f = rd.nextFloat();
		for (int i=1;i<=6;i++) {
			if (f>arr[i-1] && f<=arr[i]) return i;
		}
		return 0;
	}
	
	
}
