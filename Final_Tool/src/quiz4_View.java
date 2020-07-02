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

//마우스 클릭 (MouseListener),타이머(ActionListener)
public class quiz4_View extends JPanel implements MouseListener, ActionListener
{
	final int WIDTH_COUNT;
	final int HEIGHT_COUNT;
	
	int[][] mData;
	int mStartNumber;
	int mNextNumber;
	
	Random mRandom = new Random();
	
	
	Timer mTimer = new Timer(1000, this);	//Timer객체생성,1초마다 actionPerfomed가 호출되도록 설정
	int mTime = 0;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(mTimer == arg0.getSource())
		{
			mTime++;
			if(mStartNumber==13)	//12를 눌렀을때 멈춤!!!!!!!!!!!!!!
			{
				mTimer.stop();		//타이머를 멈춘다.
				JOptionPane.showMessageDialog(this,"stop", "info", JOptionPane.INFORMATION_MESSAGE);
			}		//다음 누를 수가 13이 될때 "멈춘다" 가 뜬다....(타이머가 뜨지 않는다)
			repaint(); //판 다시 그리는 함수
		}
	}
	
	public void mixNumber(int count)			//12개의 숫자를 섞는다.
	{
		int dx = 0;
		int dy = 0;			//기본위치를 (0,0)으로 잡고 그 부분을 중심으로 계속 섞는다.
		
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



//배열 오버플로가 일어나지 않게끔
	public boolean checkMove(int sx, int sy, int dx, int dy)
	{
		
		if(sx < 0 || sy < 0 || dx < 0 || dy < 0)	//이동이 불가능한지 여부를 체크
		{
			return false;
		}
		if(WIDTH_COUNT <= sx || HEIGHT_COUNT <= sy || WIDTH_COUNT <= dx || HEIGHT_COUNT <= dy)
		{		//이동이 불가능한지 여부를 체크
			return false;
		}
		
		int tmp = mData[dy][dx];	//데이터 교환
		
		mData[dy][dx] = mData[sy][sx];
		mData[sy][sx] = tmp;
		
		return true;
	}
	
	public quiz4_View()
	{
		WIDTH_COUNT = 4;		//숫자게임의 판 개수
		HEIGHT_COUNT = 3;		//숫자게임의 판 개수
		
		mData = new int[HEIGHT_COUNT][WIDTH_COUNT];

		mStartNumber = 1;		//플레이 할때 1부터 순서대로 클릭하기 위해 선언된 변수(선택한 숫자와 비교하기위해)
		mNextNumber = 1;
		for(int y=0; y<HEIGHT_COUNT; y++)		//4번돌림
		{
			for(int x=0; x<WIDTH_COUNT; x++)	//3번 돌림
			{
				mData[y][x] = mNextNumber;		//다음숫자를 (x,y)에 넣는다.
				mNextNumber++;	//다음숫자 증가
			}
		}
		
		mixNumber(12);			//만들어야하는 함수
		
		addMouseListener(this);	//자신이(CLASS) 마우스 이벤트를 받겠다는 설정
		mTimer.start();	//타이머 시작
	}
	//출력 함수
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
				xpos = x * 100 + 40;	//적절한 위치에 출력하기 위해 더한 숫자.
				ypos = y * 100 + 60;
				
				String msg = "" + mData[y][x];
				
				g.setFont(g.getFont().deriveFont(30.0f));		//폰트크기 조절
				g.drawString(msg, xpos, ypos);					//문자열 출력
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
//마우스가 해당 숫자에 클릭했는지를 체크한다.
	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		for(int y=0; y<HEIGHT_COUNT; y++)	//FOR문으로 하나하나 다 체크
		{
			for(int x=0; x<WIDTH_COUNT; x++)	//FOR문으로 하나하나 다 체크
			{
				Rectangle r = new Rectangle(x*100, y*100, 100, 100);
				if(r.contains(e.getX(), e.getY()))		//R안에 X,Y가 있는지 체크하는 함수
				{
					ClickNumber(x, y);	//제대로 눌렀을 경우 CLICKNUMBER 함수 호출
				}
			}
		}
	}
	
	//제대로 체크 했을 경우 
	public void ClickNumber(int x, int y)
	{
		if(mData[y][x] == mStartNumber)	//숫자를 순서대로 클릭(4)
		{
			mData[y][x] = mNextNumber;	//다음 숫자를 넣음(5)
			mNextNumber++;	//다음 숫자 증가(6)
			mStartNumber++;	//5를 눌렀는가 확인
		
			repaint();		//화면을 다시 그릴때 쓰는 함수
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


	
