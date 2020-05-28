package game;

import javax.swing.JOptionPane;

public class VirtualPlayer extends Player{

	public VirtualPlayer(String name) {
		super(name);
	}
	public void lost() {//phuong thuc bieu lo that bai
		JOptionPane.showMessageDialog(null, "Toi co "+score+" diem.Toi thua roi!!:((((",name, JOptionPane.INFORMATION_MESSAGE);;
	}
	
	
}
