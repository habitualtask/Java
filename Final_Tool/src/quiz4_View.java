import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

//���콺 Ŭ�� (MouseListener),Ÿ�̸�(ActionListener)
public class quiz4_View extends JPanel implements MouseListener, ActionListener
{
	final int WIDTH_COUNT;
	final int HEIGHT_COUNT;
	
	int[][] mData;
	int mStartNumber;
	int mNextNumber;
	
	Random mRandom = new Random();
	
	
	Timer mTimer = new Timer(1000, this);	//Timer��ü����,1�ʸ��� actionPerfomed�� ȣ��ǵ��� ����
	int mTime = 0;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(mTimer == arg0.getSource())
		{
			mTime++;
			if(mStartNumber==13)	//12�� �������� ����!!!!!!!!!!!!!!
			{
				mTimer.stop();		//Ÿ�̸Ӹ� �����.
				JOptionPane.showMessageDialog(this,"stop", "info", JOptionPane.INFORMATION_MESSAGE);
			}		//���� ���� ���� 13�� �ɶ� "�����" �� ���....(Ÿ�̸Ӱ� ���� �ʴ´�)
			repaint(); //�� �ٽ� �׸��� �Լ�
		}
	}
	
	public void mixNumber(int count)			//12���� ���ڸ� ���´�.
	{
		int dx = 0;
		int dy = 0;			//�⺻��ġ�� (0,0)���� ��� �� �κ��� �߽����� ��� ���´�.
		
		for(int i=0; i<count; i++)	
		{
			int dir = mRandom.nextInt(4);
			
			switch(dir)
			{
			case 0:
				if(checkMove(dx, dy, dx-1, dy))
				{
					dx--;
				}
				break;
			case 1:
				if(checkMove(dx, dy, dx+1, dy))
				{
					dx++;
				}
				break;
			case 2:
				if(checkMove(dx, dy, dx, dy-1))
				{
					dy--;
				}
				break;
			case 3:
				if(checkMove(dx, dy, dx, dy+1))
				{
					dy++;
				}
				break;
				default:
					break;
			}
		}
	}



//�迭 �����÷ΰ� �Ͼ�� �ʰԲ�
	public boolean checkMove(int sx, int sy, int dx, int dy)
	{
		
		if(sx < 0 || sy < 0 || dx < 0 || dy < 0)	//�̵��� �Ұ������� ���θ� üũ
		{
			return false;
		}
		if(WIDTH_COUNT <= sx || HEIGHT_COUNT <= sy || WIDTH_COUNT <= dx || HEIGHT_COUNT <= dy)
		{		//�̵��� �Ұ������� ���θ� üũ
			return false;
		}
		
		int tmp = mData[dy][dx];	//������ ��ȯ
		
		mData[dy][dx] = mData[sy][sx];
		mData[sy][sx] = tmp;
		
		return true;
	}
	
	public quiz4_View()
	{
		WIDTH_COUNT = 4;		//���ڰ����� �� ����
		HEIGHT_COUNT = 3;		//���ڰ����� �� ����
		
		mData = new int[HEIGHT_COUNT][WIDTH_COUNT];

		mStartNumber = 1;		//�÷��� �Ҷ� 1���� ������� Ŭ���ϱ� ���� ����� ����(������ ���ڿ� ���ϱ�����)
		mNextNumber = 1;
		for(int y=0; y<HEIGHT_COUNT; y++)		//4������
		{
			for(int x=0; x<WIDTH_COUNT; x++)	//3�� ����
			{
				mData[y][x] = mNextNumber;		//�������ڸ� (x,y)�� �ִ´�.
				mNextNumber++;	//�������� ����
			}
		}
		
		mixNumber(12);			//�������ϴ� �Լ�
		
		addMouseListener(this);	//�ڽ���(CLASS) ���콺 �̺�Ʈ�� �ްڴٴ� ����
		mTimer.start();	//Ÿ�̸� ����
	}
	//��� �Լ�
	@Override
	public void paint(Graphics g) {	
		// TODO Auto-generated method stub

		//paintComponent(g);
		super.paint(g);
		drawMap(g);
		drawNumber(g);
		
		String msg = "time: " + mTime;
		g.setFont(g.getFont().deriveFont(15.0f));
		g.drawString(msg, 510, 20);
	}
	
	public void drawNumber(Graphics g)
	{
		int xpos;
		int ypos;
		
		for(int y=0; y<HEIGHT_COUNT; y++)
		{
			for(int x=0; x<WIDTH_COUNT; x++)
			{
				xpos = x * 100 + 40;	//������ ��ġ�� ����ϱ� ���� ���� ����.
				ypos = y * 100 + 60;
				
				String msg = "" + mData[y][x];
				
				g.setFont(g.getFont().deriveFont(30.0f));		//��Ʈũ�� ����
				g.drawString(msg, xpos, ypos);					//���ڿ� ���
			}
		}
	}
	
	public void drawMap(Graphics g)
	{
		int xpos, ypos;
		
		for(int y=0; y<HEIGHT_COUNT; y++)
		{
			for(int x=0; x<WIDTH_COUNT; x++)
			{
				xpos = x * 100;
				ypos = y * 100;
				g.drawRect(xpos, ypos, 100, 100);
			}
		}
	}
//���콺�� �ش� ���ڿ� Ŭ���ߴ����� üũ�Ѵ�.
	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		for(int y=0; y<HEIGHT_COUNT; y++)	//FOR������ �ϳ��ϳ� �� üũ
		{
			for(int x=0; x<WIDTH_COUNT; x++)	//FOR������ �ϳ��ϳ� �� üũ
			{
				Rectangle r = new Rectangle(x*100, y*100, 100, 100);
				if(r.contains(e.getX(), e.getY()))		//R�ȿ� X,Y�� �ִ��� üũ�ϴ� �Լ�
				{
					ClickNumber(x, y);	//����� ������ ��� CLICKNUMBER �Լ� ȣ��
				}
			}
		}
	}
	
	//����� üũ ���� ��� 
	public void ClickNumber(int x, int y)
	{
		if(mData[y][x] == mStartNumber)	//���ڸ� ������� Ŭ��(4)
		{
			mData[y][x] = mNextNumber;	//���� ���ڸ� ����(5)
			mNextNumber++;	//���� ���� ����(6)
			mStartNumber++;	//5�� �����°� Ȯ��
		
			repaint();		//ȭ���� �ٽ� �׸��� ���� �Լ�
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


	
