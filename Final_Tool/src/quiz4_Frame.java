import javax.swing.JFrame;


public class quiz4_Frame extends JFrame
{
	quiz4_View mView;
	
	public quiz4_Frame()
	{
		mView = new quiz4_View();
		
		add(mView);
		
		setTitle("Game");
		setSize(600, 600);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
