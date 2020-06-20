package term;
import java.awt.*;
import java.util.*;
public class Calendar extends Frame {

	Panel pan;				//����, �� ���� ��
	Panel pan2;				//day ��
	Label label;			//���� ��
	Label label2;			//�� ��
	Choice choiceYear;		//���� ����
	Choice choiceMonth;		//�� ����

	Button[] button = new Button[42]; 	//����(7ĭ)�� ������ day(42ĭ)
	int year=0;
	int month=0;
	
	private void init() {
		this.setSize(400, 300);
		this.setTitle("18113491 ���μ�");

		this.add(getPan(), BorderLayout.NORTH);  //month,year
		this.add(getPan2(), BorderLayout.CENTER);  //day
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public Calendar() {
		super();
		init();
	}
	
	Panel getPan() { //����, �� ���� ���������� set��
		if (pan == null) {
			label = new Label();
			label.setText("Year");
			label2 = new Label();
			label2.setText("Month");
			pan = new Panel();
			pan.setLayout(new FlowLayout());
			pan.add(getYear());
			pan.add(label);
			pan.add(getMonth());
			pan.add(label2);
		}
		return pan;
	}

	Choice getYear() {
		if (choiceYear == null) {
			choiceYear = new Choice();
			choiceYear.add("2022");
			choiceYear.add("2021");
			choiceYear.add("2020");
			choiceYear.add("2019");
			choiceYear.add("2018");
			choiceYear.add("2017");
			choiceYear.add("2016");
			choiceYear.add("2015");
			choiceYear.add("2014");
			choiceYear.add("2013");
			choiceYear.add("2012");
			choiceYear.add("2011");
			choiceYear.add("2010");
			choiceYear.add("2009");
			choiceYear.add("2008");
			choiceYear.select(3);		//2019��(0���� ���������� 3��°�� ��ġ) ����
		}
		return choiceYear;		//������ ���� ��ȯ
	}

	Choice getMonth() {
		if (choiceMonth == null) {
			choiceMonth = new Choice();

			choiceMonth.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
	
					for(int i=0 ; i<42 ; i++){
						button[i].setLabel("");
					}
					
					year = Integer.parseInt(choiceYear.getSelectedItem());
					month = Integer.parseInt(choiceMonth.getSelectedItem());
					
					int startDay = 0;
					int endDay = 0;
					
					java.util.Calendar sDay=java.util.Calendar.getInstance();
					java.util.Calendar eDay=java.util.Calendar.getInstance();
					
					sDay.set(year,month-1,1);
					eDay.set(year, month,1);
					eDay.add(java.util.Calendar.DATE, -1);
					
					startDay=sDay.get(java.util.Calendar.DAY_OF_WEEK);
					endDay=eDay.get(java.util.Calendar.DATE);

		            for(int i=1; i<=endDay ; i++){
		            	button[i+startDay-2].setLabel(i+"");
		            }
				}
			});
			choiceMonth.add("1");
			choiceMonth.add("2");
			choiceMonth.add("3");
			choiceMonth.add("4");
			choiceMonth.add("5");
			choiceMonth.add("6");
			choiceMonth.add("7");
			choiceMonth.add("8");
			choiceMonth.add("9");
			choiceMonth.add("10");
			choiceMonth.add("11");
			choiceMonth.add("12");
			choiceMonth.select(0);		//1��(0���� ���������� 0��°�� ��ġ) ����
			
		}
		return choiceMonth;		//������ �� ��ȯ
	}
	
	Panel getPan2() {	//day�� ���������� set�԰� ���ÿ� ���
		if (pan2 == null) {
			pan2= new Panel();
			pan2.setLayout(new GridLayout(7,7));	
			Button[] bt1 = new Button[7];
			String[] day = {"��","��","ȭ","��","��","��","��"};
			for(int i=0 ; i<7 ; i++){
				bt1[i] = new Button(day[i]);
				pan2.add(bt1[i]);
			}
			
			button = new Button[42];
			
			for(int i=0 ; i<42 ; i++){
				button[i] = new Button("");
				pan2.add(button[i]);
			}

			year = Integer.parseInt(choiceYear.getSelectedItem());
			month = Integer.parseInt(choiceMonth.getSelectedItem());
			
			int startDay = 0;
			int endDay = 0;
			
			java.util.Calendar sDay=java.util.Calendar.getInstance();
			java.util.Calendar eDay=java.util.Calendar.getInstance();
			
			sDay.set(year,month-1,1);
			eDay.set(year, month,1);
			eDay.add(java.util.Calendar.DATE, -1);
			
			startDay=sDay.get(java.util.Calendar.DAY_OF_WEEK);
			endDay=eDay.get(java.util.Calendar.DATE);
			
            for(int i=1; i<=endDay ; i++){
            	button[i+startDay-2].setLabel(i+"");
            }
		}
		return pan2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = new Calendar();
		cal.setVisible(true);
	}
}
