package vocabularygamePlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.*;

public class Vocabulary extends JFrame implements Runnable{
	private ConcurrentHashMap<String,String> words = new ConcurrentHashMap<String,String>();
	private String[] ssr;
	private String qw;
	private String ans;
	private StringBuilder s1 = new StringBuilder();
	private Player pl;
	private ArrayList<JLabel> arr;
	public Vocabulary(Player pl) throws IOException
	{
		this.pl = pl;
		BufferedReader in = new BufferedReader(new FileReader("F:\\Users\\admin\\eclipse-workspace\\JavaKS\\src\\vocabularygamePlayer\\word.txt"));
		String valuestr;
		String keystr;
		while((valuestr = in.readLine())!=null)
		{
			keystr = valuestr;
			valuestr = in.readLine();
			words.put(keystr, valuestr);
		}
		ssr = words.keySet().toArray(new String[0]);
	}
	public String getWord()
	{
		Random rd = new Random();
		qw = ssr[rd.nextInt(words.size())];
		return qw;
	}
	
	public String putWord(String str)
	{
		StringBuilder rnd = new StringBuilder(str);
		Random rd = new Random();
		int i = rd.nextInt(rnd.length());
		int j = rd.nextInt(rnd.length());
		while(j==i)
		{
			j = rd.nextInt(rnd.length());
		}
		s1.append(rnd.charAt(i));
		rnd.setCharAt(i, '_');
		s1.append(rnd.charAt(j));
		rnd.setCharAt(j, '_');
		String str1 = rnd.toString();
		return str1;
	}
	
	public boolean judgeWin(String str , String ans)
	{
		if (ans.equals(str)) 
		{
			pl.getHP();
			return true;
		}
		else
		{
			pl.beAttack();
			return false;
		}
	}
	
	public String getAnswer()
	{
		ans = words.get(qw);
		return ans;
	}
	private JPanel jp = new JPanel();
	public void initV()
	{
		this.setSize(500,600);
		this.setTitle("ÓÎÏ·½çÃæ");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.add(jp);
		jp.setLayout(null);
		
		while(pl.gHP() > 0)
		{
			JTextField jtf = new JTextField();
			jp.add(jtf,BorderLayout.SOUTH);
			
			String str = this.getWord();
			JLabel jlb = new JLabel(this.putWord(str));
			JLabel jlb1 = new JLabel(words.get(str));
			JTextField ansJTF = new JTextField();
			jlb1.setBounds(200, 420, 200, 30);
			ansJTF.setBounds(0,500, 500 , 50);
			
			System.out.println(jlb.getText());
			
			String str1  = s1.toString();
			System.out.println(str1);
			
			jp.add(jlb1);
			jp.add(ansJTF,BorderLayout.SOUTH);
			ansJTF.addActionListener(new ansListener(arr,ansJTF,str1,pl));
			this.setVisible(true);
			
			arr.add(jlb);
//			while(y < 400)
//			{
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				y += 7;
//				jlb.setLocation(x, y);
//			}
//			jp.remove(jlb);
			new Thread(this).start();
	}
		}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{	
			for(int i = 0 ; i < arr.size() ; i++)
			{
				JLabel lb = arr.get(i);
//				if(lb.getText().length()>3)
//				{
					int x = (int)((this.getWidth()-lb.getWidth())/2-10);
					int y = lb.getY();
					lb.setBounds(x, y , 100 , 30);
					jp.add(lb);
					this.setVisible(true);
					while(y<350)
					{
						y++;
						lb.setLocation(x, y);
					}
//				}
//				else
//				{
//					JLabel word1 = new JLabel(s1.substring(0, 0));
//					JLabel word2 = new JLabel(s1.substring(1, 1));
//					arr.add(word1);
//					arr.add(word2);
//					int X = (int)((this.getWidth()-lb.getWidth())/2-10)£»
//					int Y = 350;
//					word1.setBounds(X, Y, 10, 10);
//					word2.setBounds(X+10, Y, 10 , 10);
//					jp.add(word1);
//					jp.add(word2);
//					while(word.getY()+10<word1.getY())
//					{
//						word1.setLocation(X, Y--);
//						word2.setLocation(X+10 , Y--);
//					}
//					word.setText(ans);
//					word.setLocation(jp.getWidth(), jp.getHeight());
//					jp.remove(word1);
//					jp.remove(word2);
//				}
			}
		}
	}
}
