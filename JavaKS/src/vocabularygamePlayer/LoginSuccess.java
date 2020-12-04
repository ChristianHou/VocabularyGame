package vocabularygamePlayer;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginSuccess extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  LoginSuccess LC = new LoginSuccess();
	private static  JLabel jtk = new JLabel("登陆成功");
	public static void showtable()
	{
		LC.setSize(300, 300);
		LC.setTitle("登陆成功");
		LC.setLocationRelativeTo(null);
		
		FlowLayout FL = new FlowLayout();
		LC.setLayout(FL);
		
		LC.add(jtk);
		LC.setVisible(true);
		
		try
		{
			Thread.sleep(2000);
		}catch(Exception e){}
		LC.dispose();
	}
}