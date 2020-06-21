import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 

public class No1<MyDialog> extends JFrame{
	private MyDialog dialog;
	private JLabel imageLabel = new JLabel();
	No1(){
		setTitle("18113491, 강민송");
		//Container c = getContentPane(); //3번문제 이미지 삽입하기위해
		//c.add(imageLabel);	//3번문제 이미지 삽입하기위해 없으면안됨
		createMenu(); // 메뉴 생성, 프레임에 삽입
		setSize(300,200);
		setVisible(true);
		
		
	}
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu Menu1 = new JMenu("1번문제");
		JMenu Menu2 = new JMenu("2번문제");
		JMenu Menu3 = new JMenu("3번문제");
		JMenu Menu4 = new JMenu("4,5,6,7번문제");
		
		JMenuItem mItem1 = new JMenuItem("실행"); 			//1번문제 정보정리
		Menu1.add(mItem1);
		mItem1.addActionListener(new MyActionListener1());
		
		JMenuItem mItem2 = new JMenuItem("메모장실행"); 		//2번문제 메모장 실행
		Menu2.add(mItem2);
		mItem2.addActionListener(new MyActionListener2());
		
		JMenuItem mItem3 = new JMenuItem("열기");				//3번문제 이미지파일
		Menu3.add(mItem3);
		mItem3.addActionListener(new MyActionListener3());
		
		JMenuItem mItem4 = new JMenuItem("4.게임시작");		//4번문제 게임시작
		Menu4.add(mItem4);
		mItem4.addActionListener(new MyActionListener4());
		
		
		JMenuItem mItem5 = new JMenuItem("5.계산기");			//5번문제 계산기
		Menu4.add(mItem5);
		mItem5.addActionListener(new MyActionListener5());
		
		
		JMenuItem mItem6 = new JMenuItem("6.도형그리기");		//6번문제 도형그리기
		Menu4.add(mItem6);
		mItem6.addActionListener(new MyActionListener6());
		
		JMenuItem mItem7 = new JMenuItem("7.자바란?");		//7번문제 자바란?
		Menu4.add(mItem7);
		mItem7.addActionListener(new MyActionListener7());
		mb.add(Menu1);
		mb.add(Menu2); 
		mb.add(Menu3); 
		mb.add(Menu4); 

		setJMenuBar(mb);
		
	}
	class MyActionListener1 implements ActionListener{		//1번문제 정보정리
		public void actionPerformed(ActionEvent e) {
			new quiz1();									//정보정리 호출
			}
	}
	
	
	class MyActionListener2 implements ActionListener{		//2번문제 메모장실행
		public void actionPerformed(ActionEvent e) {
			new quiz2();									//메모장 호출
			}
	}
	
	class MyActionListener3 implements ActionListener{		//3번문제 이미지열기
		public void actionPerformed(ActionEvent e) {
		new quiz3();
	}
}
	
	class MyActionListener4 implements ActionListener{		//4번문제 메모장실행
		public void actionPerformed(ActionEvent e) {
			new quiz4();new quiz4_Frame();new quiz4_View(); //관련 함수들 모두 호출
			}
	}
	
	class MyActionListener5 implements ActionListener{		//5번문제 계산기
		public void actionPerformed(ActionEvent e) {
			new quiz5();									//계산기 호출
			}
	}
	class MyActionListener6 implements ActionListener{		//6번문제 도형그리기
		public void actionPerformed(ActionEvent e) {
			new quiz6();									//도형그리기 호출
			}
	}
	class MyActionListener7 implements ActionListener{		//7번문제 자바란?
		public void actionPerformed(ActionEvent e) {
			new quiz7(); 									//문서 호출
			}
	}
	
	public static void main(String [] args) {
		new No1();
	}
}

