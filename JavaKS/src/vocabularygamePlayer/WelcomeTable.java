package vocabularygamePlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class WelcomeTable extends JFrame implements ActionListener{
	JTextField nameJTF = new JTextField();                                   //���������
	JPasswordField passwordJTF = new JPasswordField();                       //���������
	JCheckBox jcb = new JCheckBox("ȷ�����Ķ����û���˽���");              //��ѡ��
	public static void main(String args[]) throws IOException, Exception
	{
		new WelcomeTable();
	}
	
	public WelcomeTable() throws Exception, IOException
	{
		ImageIcon img = new ImageIcon("C:\\Users\\admin\\Desktop\\bg.jpeg");
		JLabel jl1 = new JLabel(img);
		
		this.setSize(img.getIconWidth(), img.getIconHeight());
		this.setTitle("Ӣ������������Ϸ");
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		
		this.getLayeredPane().add(jl1,new Integer(Integer.MIN_VALUE));
		jl1.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		JPanel jp = (JPanel)this.getContentPane();
		
		try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");}catch(Exception e) {};  //Swing���Windows
		
		JButton jb = new JButton("Login");
		
		jcb.setOpaque(false);
		nameJTF.setBorder(null);
		passwordJTF.setBorder(null);
		
		JLabel name = new JLabel("�˺ţ�");                                      //���ֱ�ǩ
		JLabel password = new JLabel("���룺");                                  //���ֱ�ǩ
		
		Dimension D = new Dimension(300,20);                                     //������С
		nameJTF.setPreferredSize(D);
		passwordJTF.setPreferredSize(D);
		
		FlowLayout fl = new FlowLayout();
		jp.setLayout(fl);
		
		jp.add(name);
		jp.add(nameJTF);
		jp.add(password);
		jp.add(passwordJTF);
		jp.add(jb);
		jp.add(jcb);
		
		jp.setOpaque(false);
		
		jb.addActionListener(this);
		
		this.setVisible(true);
		
		Socket sk = new Socket("127.0.0.1",9999);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String m = e.getActionCommand();
		if (m.contentEquals("Login"))
		{
			if(jcb.isSelected())
			{	
				this.dispose();
				Player pl = new Player(nameJTF.getText());
				LoginSuccess.showtable();
				System.out.println("�˺ţ�"+nameJTF.getText());
				System.out.println("���룺"+passwordJTF.getText());
				try {
					Thread.sleep(1000);
					pl.play();
				}catch(Exception ef){
					System.out.println("�������˻�������");
				};
				
			}
			else
			{
				System.out.println("�빴ѡ��ѡ��");
			}
		}
	}

	
}
