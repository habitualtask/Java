import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Ten레이블 extends JFrame{

	 JLabel Label[]=new JLabel[10];
	 Container contentPane;
	 int llog=0;
	
	 Ten레이블() {
	  setTitle("Ten레이블 클릭");
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  contentPane=getContentPane();
	  contentPane.setLayout(null);
	  rLabel(Label);
	  setSize(300,300);
	  setVisible(true);
	 }
	
	 class MyMouseListener extends MouseAdapter {
	  public void mousePressed(MouseEvent e) {
	
	   JLabel jla=(JLabel)e.getSource();
	
	   if(jla==Label[llog]) {
	    if(Label[llog].getText().equals(Integer.toString(llog))) {
	    	Label[llog].setVisible(false);
	    	llog++;
	     System.out.print(llog);
	    }
	
	    if (!Label[9].isVisible()) {
	    	llog = 0;
	        for (int i = 0; i < 10; i++) {
	        	Label[i].setVisible(true);
	            int x = (int) (Math.random() * 150) + 50;
	            int y = (int) (Math.random() * 150) + 50;
	            Label[i].setLocation(x, y);
	            Label[i].addMouseListener(new MyMouseListener());
	           }
	     }
	   }
	 }
	
	  public void mouseEntered(MouseEvent e){};
	  public void mouseExited(MouseEvent e){};
	  public void mouseClicked(MouseEvent e){};
	  public void mouseDragged(MouseEvent e){};
	  public void mouseMoved(MouseEvent e){};
	  public void mouseReleased(MouseEvent e){};
	  
	 }
	
	 public static void main(String[] args){
	  new Ten레이블();
	}
	 public void rLabel(JLabel[] l) {
		    for (int i = 0; i < 10; i++) {
		        l[i] = new JLabel(Integer.toString(i));
		        int x = (int) (Math.random() * 200) + 50;
		        int y = (int) (Math.random() * 200) + 50;
		        l[i].setSize(15, 15); 
		        l[i].setLocation(x, y); 
		        l[i].setOpaque(true);
		        l[i].setBackground(Color.YELLOW);
		        contentPane.add(l[i]); 
		        l[i].addMouseListener(new MyMouseListener());
		    }
	
	}
	}