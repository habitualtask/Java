import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class quiz7 extends JFrame{
	public quiz7() {
		setTitle ("�ڹٶ�?");
		Container c=getContentPane();
		JTabbedPane pane = createTabbedPane();
		c.add(pane, BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);

	}
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.addTab("�ڹ��� Ư��", new MyPanel(1));
		pane.addTab("�ڹ��� �����",new MyPanel(2) );
		pane.addTab("�ڹ��� ����",new MyPanel(3) );
		return pane;	
	}

	class MyPanel extends JPanel {
		public MyPanel(int num) {
			JTextArea tx = new JTextArea(10,10);
			if(num==1) {
				tx.append("1.�ü���� ������\n2.��ü������");
			}
			else if(num==2) {
				tx.append("<����>\n1.�ü���� ������\n2.�ܼ��Ͽ� ���� ����\n\n<����>\n1.�ӵ��� ����\n2.������ ����ó��");
			}
			else if(num==3) {
				tx.append("�ڹٴ� �� ����ũ�νý������ ������\n1995�� ��ǥ�� ��ü���� ���α׷��� ����Դϴ�.");
			}
			add(tx);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new quiz7();
		}
	
	}


