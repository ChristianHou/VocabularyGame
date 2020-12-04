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
		jf.setTitle("图片");
		jf.setSize(800, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new FlowLayout());
		jf.setLocationRelativeTo(null);
		
		jf.setVisible(true);
		
		//获取画笔一定要在可见之后
		Graphics g = jf.getGraphics();
		//添加监听器
		DrawListener mouse = new DrawListener();
		jf.addMouseListener(mouse);
		//将主类中的画笔传给监听器类中去
		mouse.g = g;
	}
}
