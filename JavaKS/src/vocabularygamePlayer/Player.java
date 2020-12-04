package vocabularygamePlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Player extends JFrame{
	private int HP = 20;
	private String name;
	public Player(String name)
	{
		this.name = name;
	}
	public int gHP()
	{
		return HP;
	}
	public void beAttack()
	{
		this.HP --;
	}
	public void getHP()
	{
		this.HP ++;
	}
	public void play() throws IOException
	{
		Vocabulary vb = new Vocabulary(this);
		vb.initV();
	}
	
}
