//label의 활용

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class 연습9_6 extends JFrame{
	public 연습9_6() {
		setSize(300, 300);
		setTitle("Random Labels");
		Container con = getContentPane(); 
		setLayout(null);

		for(int i = 0; i < 20; i++) {
			int x = (int)(Math.random() * 200) + 50;
			int y = (int)(Math.random() * 200) + 50;
			JLabel label = new JLabel("");
			label.setOpaque(true); 		//label에 배경색 보이게함
			label.setLocation(x,y); 	//label을 (x,y)에 배치
			label.setSize(10,10);		//label크기를 10x10으로 설정
   			label.setBackground(Color.BLUE);
   			add(label);
		}
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
	public static void main(String[] args){
		new 연습9_6(); 
	}

}