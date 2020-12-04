package text;

import java.awt.FlowLayout;
import java.io.*;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.*;

public class Vocabulary extends JFrame {
	private ConcurrentHashMap<String,String> words = new ConcurrentHashMap<String,String>();
	private String[] ssr;
	private String qw;
	private String ans;
	public Vocabulary() throws IOException
	{
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
	
	public String getAnswer()
	{
		ans = words.get(qw);
		return ans;
	}
	public void initV()
	{
		this.setSize(500,500);
		this.setTitle("”Œœ∑ΩÁ√Ê");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		
		FlowLayout fl = new FlowLayout();
		this.setLayout(fl);
		
		try {
			new Vocabulary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel jlb = new JLabel(this.getWord());
		this.add(jlb);
		this.setVisible(true);
		jlb.setBounds(jlb.getX(), jlb.getY() , 70 , 30);
		for(int i = jlb.getY() ; i < 500 ; i+=5)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jlb.setLocation(jlb.getX(), i);
		}
		
		this.setVisible(true);
	}
	public static void main(String[] args) throws IOException
	{
		Vocabulary vbl = new Vocabulary();
		vbl.initV();
	}
}
