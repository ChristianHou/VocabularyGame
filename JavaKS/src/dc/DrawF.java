package dc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class DrawF {
	public static void main(String[] args) {
		DrawF drawpanel = new DrawF();
		drawpanel.showUI();
		
	}
	
	public void showUI() {
		JFrame jf = new JFrame();
		jf.setTitle("ͼƬ");
		jf.setSize(800, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new FlowLayout());
		jf.setLocationRelativeTo(null);
		
		jf.setVisible(true);
		
		//��ȡ����һ��Ҫ�ڿɼ�֮��
		Graphics g = jf.getGraphics();
		//��Ӽ�����
		DrawListener mouse = new DrawListener();
		jf.addMouseListener(mouse);
		//�������еĻ��ʴ�������������ȥ
		mouse.g = g;
	}
}
