package game;

import java.util.Random;

public class Player {
	protected String name;
	protected int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Player(String name) {
		setName(name);
		setScore(0);
	}
	public void roll() {//Gieo xuc xac
		Random rd = new Random();
		int p = rd.nextInt(4)+1;//Chon ngau nhien 1 con xuc xac thu p
		System.out.println(name+" da chon con xuc xac thu "+p);
		Dice dice = new Dice(p);
		int extra = dice.getScore();
		System.out.println("Diem gianh duoc: "+extra);
		if (extra+score>21) {
			score =0;
		}
		else score+=extra;
	}
	public boolean isWinner() {
		return score==21;
	}
}
