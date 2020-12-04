package vocabularygamePlayer;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class ansListener implements ActionListener{
	private JTextField jtf;
	private String str;
	private Player pl;
	private String str1;
	private ArrayList<JLabel> arr;
	public ansListener(ArrayList<JLabel> arr,JTextField jtf , String str , Player pl)
	{
		this.arr = arr;
		this.jtf = jtf;
		this.str = str;
		this.pl = pl;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		str1 = jtf.getText();
		if(str1.equals(str))
		{
			pl.getHP();
			System.out.println("nb");
			JLabel word1 = new JLabel(str1.substring(0, 0));
			JLabel word2 = new JLabel(str1.substring(1, 1));
			
			arr.add(word1);
			arr.add(word2);
//			new Thread(this).start();
		}
		else 
		{
			pl.beAttack();
			System.out.println("Wrong answers!");
		}
		jtf.setText("");
	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true)
//		{
//			
//			
////			int X = word.getX();
////			int Y = 350;
////			word1.setBounds(X, Y, 10, 10);
////			word2.setBounds(X+10, Y, 10 , 10);
////			jp.add(word1);
////			jp.add(word2);
////			while(word.getY()+10<word1.getY())
////			{
////				word1.setLocation(X, Y--);
////				word2.setLocation(X+10 , Y--);
////			}
////			word.setText(ans);
////			word.setLocation(jp.getWidth(), jp.getHeight());
//			jp.remove(word1);
//			jp.remove(word2);
//		}
//	}

}
