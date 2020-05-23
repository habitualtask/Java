import java.awt.*;
import javax.swing.*;
import java.util.*;
class North extends JPanel{
	public North() {
		setBackground(Color.LIGHT_GRAY);
		add(new JLabel("수식입력"));
		add(new JTextField(16));
		setLayout(new FlowLayout());
	}
}
class Center extends JPanel{
	JButton b[]= {new JButton("+"),new JButton("-"),new JButton("x"),new JButton("/")};
	public Center(){
		setLayout(new GridLayout(4,4,2,2));
		for(int i=0; i<10;i++)
			add(new JButton(Integer.toString(i)));
		
		add(new JButton("CE"));
		add(new JButton("계산"));
		
		for(int i=0;i<b.length;i++) {
			b[i].setBackground(Color.BLUE);
			add(b[i]);
		}
	}
}
class South extends JPanel{
	public South() {
		setBackground(Color.YELLOW);
		add(new JLabel("계산결과"));
		add(new JTextField(16));
		setLayout(new FlowLayout());
	}
}
public class calculator extends JFrame {
	public calculator() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c= getContentPane();
		
		c.add(new North(), BorderLayout.NORTH);
		c.add(new Center(), BorderLayout.CENTER);
		c.add(new South(), BorderLayout.SOUTH);
		
		setSize(300,250);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new calculator();
	}

}
