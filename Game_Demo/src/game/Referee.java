package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Referee extends JFrame{
	private Player[] setPlayer = new Player[4];//mang cac nguoi choi
	private Dice[] setDice = new Dice[4];//Tap hop cac con xuc xac
	private JTextField[] setTextfield = new JTextField[4];
	private JButton button;
	public Referee() {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so nguoi choi that:");
		num = sc.nextInt();
		sc.nextLine();
		for (int i=0;i<num;i++) {
			System.out.println("Nhap ten nguoi thu "+(i+1));
		 
			setPlayer[i] = new Player(sc.nextLine());
		}
		for (int i=num;i<4;i++) {
			setPlayer[i] = new VirtualPlayer("Virtual Player "+(i+1));
		}
		sc.close();
		setSize(370,250);
		setLayout(null);
		setVisible(true);
		setLocation(50,50);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Score");
		for (int i=0;i<4;i++) {
			JLabel label = new JLabel(setPlayer[i].getName());
			label.setSize(200,20);
			label.setLocation(20, 20+40*i);
			this.add(label);
		}
		for (int i=0;i<4;i++) {
			setTextfield[i] = new JTextField();
			setTextfield[i].setSize(100,20);
			setTextfield[i].setLocation(240, 20+40*i);
			setTextfield[i].setText("0");
			this.add(setTextfield[i]);
		}
		for (int i=0;i<4;i++) {
			setDice[i] = new Dice(i+1);
		}
		button = new JButton();
		button.setSize(290, 20);
		button.setLocation(40, 180);
		button.setText("Next turn");
		this.add(button);
	}
	
	
	private int choosePlayer() {//Chon nguoi choi mot cach ngau nhien
		Random rd = new Random();
		return rd.nextInt(4);
	}
	private int winner() {//Tim nguoi chien thang neu ko co tra ve -1
		for (int i=0;i<4;i++) if (setPlayer[i].isWinner()==true) return i;
		return -1;
	}
	
	
	
	private class Action1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (winner()==-1) {//Chua co nguoi chien thang
				int i = choosePlayer();
				System.out.println(setPlayer[i].getName()+" duoc chon");
				setPlayer[i].roll();
				Integer it = setPlayer[i].getScore();
				setTextfield[i].setText(it.toString());
				System.out.println();
			}
			else {
				int p=winner();
				System.out.println(setPlayer[p].getName()+" chien thang");
				for (int i=0;i<4;i++) {
					if (i!=p) {
						if (setPlayer[i] instanceof VirtualPlayer) {
							VirtualPlayer pl = (VirtualPlayer) setPlayer[i];
							pl.lost();
						}
					}
				}
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
				});
			}
		}
		
	}
	
	
	public void action() {
		button.addActionListener(new Action1());
	}
	
	
	
}
