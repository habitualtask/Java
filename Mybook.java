import javax.swing.*;
import java.awt.*;

public class book extends JFrame {
	public book() {
		setTitle("My Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(8, 2);
		grid.setVgap(5); 	//그리드 사이 수직 간격 5픽셀

		Container c = getContentPane();
		c.setLayout(grid);
		c.add(new JLabel(" 성명"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학과"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 장래희망"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 여름방학 계획"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 다음학기 계획"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 좌우명"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 내 인생의 멘토"));
		c.add(new JTextField(""));
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new book();
	}
}
