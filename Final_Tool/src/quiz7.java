import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class quiz7 extends JFrame{
	public quiz7() {
		setTitle ("자바란?");
		Container c=getContentPane();
		JTabbedPane pane = createTabbedPane();
		c.add(pane, BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);

	}
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.addTab("자바의 특성", new MyPanel(1));
		pane.addTab("자바의 장단점",new MyPanel(2) );
		pane.addTab("자바의 역사",new MyPanel(3) );
		return pane;	
	}

	class MyPanel extends JPanel {
		public MyPanel(int num) {
			JTextArea tx = new JTextArea(10,10);
			if(num==1) {
				tx.append("1.운영체제에 독립적\n2.객체지향언어");
			}
			else if(num==2) {
				tx.append("<장점>\n1.운영체제에 독립적\n2.단순하여 배우기 쉬움\n\n<단점>\n1.속도가 느림\n2.불편한 예외처리");
			}
			else if(num==3) {
				tx.append("자바는 썬 마이크로시스템즈에서 개발해\n1995년 발표한 객체지향 프로그래밍 언어입니다.");
			}
			add(tx);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new quiz7();
		}
	
	}


