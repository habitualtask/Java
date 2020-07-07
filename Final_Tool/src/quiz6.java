import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class quiz6 extends JFrame{
	panel p = new panel();
	quiz6(){
		this.setTitle("그래픽 다각형 연습");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(p);
		this.setSize(300,300);
		this.setVisible(true);
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	new quiz6();
}
	class panel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int w=p.getWidth();
			int h=p.getHeight();
			
			int a=0;
			for(int i=0;i<10;i++) {
				int x[] = {w/2,0+a,w/2,w-a};
				int y[] = {0+a,h/2,h-a,h/2};
				g.drawPolygon(x,y,4);
				a+=10;
				
				
				}
			}
	}

}