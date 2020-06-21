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
		setTitle("18113491, ���μ�");
		//Container c = getContentPane(); //3������ �̹��� �����ϱ�����
		//c.add(imageLabel);	//3������ �̹��� �����ϱ����� ������ȵ�
		createMenu(); // �޴� ����, �����ӿ� ����
		setSize(300,200);
		setVisible(true);
		
		
	}
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu Menu1 = new JMenu("1������");
		JMenu Menu2 = new JMenu("2������");
		JMenu Menu3 = new JMenu("3������");
		JMenu Menu4 = new JMenu("4,5,6,7������");
		
		JMenuItem mItem1 = new JMenuItem("����"); 			//1������ ��������
		Menu1.add(mItem1);
		mItem1.addActionListener(new MyActionListener1());
		
		JMenuItem mItem2 = new JMenuItem("�޸������"); 		//2������ �޸��� ����
		Menu2.add(mItem2);
		mItem2.addActionListener(new MyActionListener2());
		
		JMenuItem mItem3 = new JMenuItem("����");				//3������ �̹�������
		Menu3.add(mItem3);
		mItem3.addActionListener(new MyActionListener3());
		
		JMenuItem mItem4 = new JMenuItem("4.���ӽ���");		//4������ ���ӽ���
		Menu4.add(mItem4);
		mItem4.addActionListener(new MyActionListener4());
		
		
		JMenuItem mItem5 = new JMenuItem("5.����");			//5������ ����
		Menu4.add(mItem5);
		mItem5.addActionListener(new MyActionListener5());
		
		
		JMenuItem mItem6 = new JMenuItem("6.�����׸���");		//6������ �����׸���
		Menu4.add(mItem6);
		mItem6.addActionListener(new MyActionListener6());
		
		JMenuItem mItem7 = new JMenuItem("7.�ڹٶ�?");		//7������ �ڹٶ�?
		Menu4.add(mItem7);
		mItem7.addActionListener(new MyActionListener7());
		mb.add(Menu1);
		mb.add(Menu2); 
		mb.add(Menu3); 
		mb.add(Menu4); 

		setJMenuBar(mb);
		
	}
	class MyActionListener1 implements ActionListener{		//1������ ��������
		public void actionPerformed(ActionEvent e) {
			new quiz1();									//�������� ȣ��
			}
	}
	
	
	class MyActionListener2 implements ActionListener{		//2������ �޸������
		public void actionPerformed(ActionEvent e) {
			new quiz2();									//�޸��� ȣ��
			}
	}
	
	class MyActionListener3 implements ActionListener{		//3������ �̹�������
		public void actionPerformed(ActionEvent e) {
		new quiz3();
	}
}
	
	class MyActionListener4 implements ActionListener{		//4������ �޸������
		public void actionPerformed(ActionEvent e) {
			new quiz4();new quiz4_Frame();new quiz4_View(); //���� �Լ��� ��� ȣ��
			}
	}
	
	class MyActionListener5 implements ActionListener{		//5������ ����
		public void actionPerformed(ActionEvent e) {
			new quiz5();									//���� ȣ��
			}
	}
	class MyActionListener6 implements ActionListener{		//6������ �����׸���
		public void actionPerformed(ActionEvent e) {
			new quiz6();									//�����׸��� ȣ��
			}
	}
	class MyActionListener7 implements ActionListener{		//7������ �ڹٶ�?
		public void actionPerformed(ActionEvent e) {
			new quiz7(); 									//���� ȣ��
			}
	}
	
	public static void main(String [] args) {
		new No1();
	}
}

