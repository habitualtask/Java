import javax.swing.*;
import java.awt.*;

public class quiz1 extends JFrame {
	public quiz1() {
		setTitle("My Book");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(8, 2);
		grid.setVgap(3); 	//�׸��� ���� ���� ���� 5�ȼ�

		Container c = getContentPane();
		c.setLayout(grid);
		c.add(new JLabel(" ����"));
		c.add(new JTextField("���μ�"));
		c.add(new JLabel(" �й�"));
		c.add(new JTextField("18113491"));
		c.add(new JLabel(" �а�"));
		c.add(new JTextField("��ǻ�Ͱ��а�"));
		c.add(new JLabel(" �巡���"));
		c.add(new JTextField("����������Ʈ"));
		c.add(new JLabel(" �������� ��ȹ"));
		c.add(new JTextField("���̽㵶��, ��Ŀ��(�Ұ�����ȸ)�غ�,kucis������Ʈ"));
		c.add(new JLabel(" �����б� ��ȹ"));
		c.add(new JTextField("BOB �غ�"));
		c.add(new JLabel(" �¿��"));
		c.add(new JTextField("���� ����.."));
		c.add(new JLabel(" �� �λ��� ����"));
		c.add(new JTextField("���뵿"));
		setSize(600, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new quiz1();
	}
}
