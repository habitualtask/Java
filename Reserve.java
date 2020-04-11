package jv;
import java.util.Scanner;
class Conduct {
	String[][] seatField = new String[3][10];
	
	public Conduct() { // �������迭�� �¼����� �̿�, ���ڸ��� �ʱ�ȭ
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				seatField[i][j] = "---";
			}
		}
	}
	public void reserve() {
		System.out.println("�̸��� �Է��ϼ���.>>");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		int go = 1;
		
		while (go == 1) {
			if (validName(name)) { // �¼��� ������ ���� ���ٸ�
				System.out.println("�¼�Ÿ���� �����ϼ���.");
				System.out.println("1) S�� 2) A�� 3) B�� 4) ���θ޴�");
				s = new Scanner(System.in);
				int type = s.nextInt();
				
				if (type == 1) { // S���� �����Ͽ��� ��
					while (true) {
						try {
							System.out.println("�¼���ȣ�� �����ϼ���.");
							System.out.print("[S]");

							for (int i = 0; i < 10; i++) {
								System.out.print("[" + (i + 1) + "]"+ seatField[0][i]);
							}

							System.out.println(" ");
							s = new Scanner(System.in);

							int seatNum = s.nextInt();
							if (seatField[0][seatNum - 1] == "---") {
								seatField[0][seatNum - 1] = name;
								System.out.println("������ �Ǿ����ϴ�.");
								go = 0;
								break;
							} else
								System.out.println("����Ұ����� �ڸ��Դϴ�. �ٽ� �����ϼ���.");
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
						}
					}
				} else if (type == 2) {
					while (true) {// A���� �����Ͽ��� ��
						try {
							System.out.println("�¼���ȣ�� �����ϼ���.");
							System.out.print("[A]");

							for (int i = 0; i < 10; i++) {
								System.out.print("[" + (i + 1) + "]"
										+ seatField[1][i]);
							}
							s = new Scanner(System.in);
							int seatNum = s.nextInt();
							
							if (seatField[1][seatNum - 1] == "---") {
								seatField[1][seatNum - 1] = name;
								System.out.println("������ �Ǿ����ϴ�.");
								go = 0;
								break;
							} else
								System.out.println("����Ұ����� �ڸ��Դϴ�. �ٽ� �����ϼ���.");
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
						}
					}
				} else if (type == 3) { // B���� �����Ͽ��� ��

					while (true) {
						try {
							System.out.println("�¼���ȣ�� �����ϼ���.");
							System.out.print("[B]");
							for (int i = 0; i < 10; i++) {

								System.out.print("[" + (i + 1) + "]"

										+ seatField[2][i]);
							}
							s = new Scanner(System.in);
							int seatNum = s.nextInt();
							if (seatField[2][seatNum - 1] == "---") {
								seatField[2][seatNum - 1] = name;
								System.out.println("������ �Ǿ����ϴ�.");
								go = 0;
								break;
							} else {
								System.out.println("����Ұ����� �ڸ��Դϴ�. �ٽ� �����ϼ���.");
							}
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
						}
					}
				} else if (type == 4) // ���� �޴� �����Ͽ��� ��
					break;
				else
					System.out.println("�ٽ� �Է����ּ���.");
			} else { // validName�� false �� ��
				System.out.println("�� �� ������ ���� �ֽ��ϴ�.");
				break;
			}
		}
	}
	public void confirm() { // ��ȸ�� �����Ͽ��� ��

		for (int i = 0; i < 3; i++) {

			if (i == 0) {
				System.out.print("[S��]");
			} else if (i == 1) {
				System.out.print("[A��]");
			} else if (i == 2) {
				System.out.print("[B��]");
			} for (int j = 0; j < 10; j++) {
				System.out.print("[" + (j + 1) + "] " + seatField[i][j]);
			}
			System.out.println(" ");
		}System.out.println("<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
	}
	public void cancel() { // ��Ҹ� �����Ͽ��� ��

		while (true) {
			try {
				System.out.println("����� �¼�Ÿ���� �����ϼ���.");
				System.out.println("1) S�� 2) A�� 3) B�� 4) ���θ޴�");
				Scanner s = new Scanner(System.in);
				int type = s.nextInt();
				if (type == 4)
					break;
				
				for (int i = 0; i < 10; i++) {
					System.out.print("[" + (i + 1) + "] "+ seatField[type - 1][i]);
				}
				System.out.println(" ");
				System.out.println("����� �¼���ȣ�� �����ϼ���.");
				s = new Scanner(System.in);
				int seatNum = s.nextInt();

				if (seatNum >= 1 && seatNum <= 10) {
					if (seatField[type - 1][seatNum - 1] != "---") {
						seatField[type - 1][seatNum - 1] = "---";
						System.out.println("��ҵǼ˽��ϴ�.");
						break;
						
					} else {
						System.out.println("�̹� �� �ڸ� �Դϴ�.");
						continue;
					}
				} else
					System.out.println("�߸��� �Է��Դϴ�.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	boolean validName(String name) { // �Է¹��� �̸����� ����� �¼��� �ִ��� Ȯ��

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				if (seatField[i][j].equals(name))
					return false;
				else
					return true;
			}
		}return true;
	}
}

public class Reserve {
	public static void main(String[] args) {
		System.out.println("habitualtask-song : ��ǰ�ܼ�ƮȦ ���� �ý����Դϴ�.");
		Conduct c = new Conduct();
		int menuNum;
		
		while (true) {
			System.out.println("1) ����  2) ��ȸ  3) ���  4) ����");
			Scanner s = new Scanner(System.in);
			menuNum = s.nextInt();

			if (menuNum == 1 || menuNum == 2 || menuNum == 3) {
				switch (menuNum) {
				case 1: c.reserve();
					break;
				case 2: c.confirm();
					break;
				case 3: c.cancel();
					break;
				}
			} else if (menuNum == 4) {
				System.out.println("�����մϴ�.");
				System.exit(0);
			} else
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
	}
}