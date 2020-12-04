package dc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class DrawListener implements MouseListener{
	Graphics g;
	
	public int[][] getImagePixel(String path){
		File file = new File(path);
		
		BufferedImage bufferImage = null;
		try {
			bufferImage = ImageIO.read(file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		int w = bufferImage.getWidth();
		int h = bufferImage.getHeight();
		
		int [][] pixelArray = new int[w][h];
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				//读取每个位置的像素点对应的RGB值
				int pixel = bufferImage.getRGB(i, j);
				pixelArray[i][j] = pixel;
			}
		}
		return pixelArray;
		
	}
	
	//在界面上画出ia数组图像，即卷积结果
	public void drawjj(Graphics g) {
		int[][] ia = getImagePixel("C:\\Users\\admin\\Desktop\\头像.jpeg");
		ia = valide(ia, kArray);
		for(int i = 0; i<ia.length; i++) {
			for(int j = 0; j<ia[0].length; j++) {
				int pie = ia[i][j];
				Color color = new Color(pie,pie,pie);
				g.setColor(color);
				g.fillRect(i, j, 1, 1);
			}
		}
		
	}
	
	//卷积核
	float[][] kArray = {{-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, 25, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}};
	
	
	//实现卷积操作
	public static int[][] valide(int[][] src, float[][] filter){
		int[][] tem = new int[filter.length][filter[0].length];
		int valideWidth = src[0].length - filter[0].length;
		int valideHeigth = src.length - filter.length + 1;
		int[][] valide = new int[valideHeigth][valideWidth];
		
		for(int i = 0; i<valideHeigth; i++) {
			for(int j = 0; j<valideWidth; j++) {
				for(int y = 0; y<filter.length; y++) {
					for(int z = 0; z<filter[0].length; z++ ) {
						tem[y][z] = (int)((src[i+y][j+z])*filter[y][z]); 
					}
				}
				int kk = 0;
				for(int y = 0; y<filter.length; y++) {
					for(int z = 0; z<filter[0].length; z++) {
						kk += tem[y][z];
					}
				}
				if(kk<0)kk=0;
				if(kk>255)kk=255;
				valide[i][j] = kk;
				
				}
			}
			return valide;
		}
		
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");
		drawjj(g);
		
		
	}
	
	public void mousePressed(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
}
