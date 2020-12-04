package vocabularyServer;

import javax.swing.*;
import java.awt.*;
import java.net.*;

public class Server extends JFrame implements Runnable{

	ServerSocket ss = null;
	public static void main(String[] args) throws Exception
	{
		new Server();
	}
	public Server() throws Exception
	{
		this.setSize(600,800);
		this.setTitle("六级游戏服务器");
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		
		JComboBox<String> jbb = new JComboBox<String>(); 
		this.add(jbb, BorderLayout.NORTH);
		
		JTextArea jta = new JTextArea();
		
		this.add(jta);
		try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");}catch(Exception e) {};
			
		this.setVisible(true);
		
		
		ss = new ServerSocket(9999);
		new Thread(this).start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				@SuppressWarnings("unused")
				Socket sk = ss.accept();
				System.out.println("连接成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
