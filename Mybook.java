import javax.swing.*;
import java.awt.*;

public class book extends JFrame {
	public book() {
		setTitle("My Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(8, 2);
		grid.setVgap(5); 	//�׸��� ���� ���� ���� 5�ȼ�

		Container c = getContentPane();
		c.setLayout(grid);
		c.add(new JLabel(" ����"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �й�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �а�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �巡���"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �������� ��ȹ"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �����б� ��ȹ"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �¿��"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �� �λ��� ����"));
		c.add(new JTextField(""));
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new book();
	}
}
