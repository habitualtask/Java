import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class leftkey extends JFrame {

	JPanel contentPane=new JPanel();
	JLabel Label=new JLabel();
	String st=new String("Love Java");

	leftkey() {
		Label=new JLabel(st);
		setTitle("Left키로 문자열이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		
		contentPane.setLayout(new FlowLayout());
		Label.addKeyListener(new keyli());
		Label.setSize(100,100);
		contentPane.add(Label);
		setSize(300,300);
		setVisible(true);
		Label.requestFocus();
	}

	class keyli extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode=e.getKeyCode();
			switch(keyCode){
			case KeyEvent.VK_LEFT:
			st=st.substring(1)+st.substring(0, 1);
			Label.setText(st);
			}
		}
	}
	
	public static void main(String[] args) {
		new leftkey();
	}
}