import javax.swing.*;
import java.awt.*;

public class quiz1 extends JFrame {
	public quiz1() {
		setTitle("My Book");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(8, 2);
		grid.setVgap(3); 	//그리드 사이 수직 간격 5픽셀

		Container c = getContentPane();
		c.setLayout(grid);
		c.add(new JLabel(" 성명"));
		c.add(new JTextField("강민송"));
		c.add(new JLabel(" 학번"));
		c.add(new JTextField("18113491"));
		c.add(new JLabel(" 학과"));
		c.add(new JTextField("컴퓨터공학과"));
		c.add(new JLabel(" 장래희망"));
		c.add(new JTextField("보안컨설턴트"));
		c.add(new JLabel(" 여름방학 계획"));
		c.add(new JTextField("파이썬독학, 해커톤(소개딩대회)준비,kucis프로젝트"));
		c.add(new JLabel(" 다음학기 계획"));
		c.add(new JTextField("BOB 준비"));
		c.add(new JLabel(" 좌우명"));
		c.add(new JTextField("딱히 없다.."));
		c.add(new JLabel(" 내 인생의 멘토"));
		c.add(new JTextField("빛대동"));
		setSize(600, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new quiz1();
	}
}
