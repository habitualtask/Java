package jv;
import java.util.Scanner;
class Conduct {
	String[][] seatField = new String[3][10];
	
	public Conduct() { // 이차원배열을 좌석으로 이용, 빈자리로 초기화
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				seatField[i][j] = "---";
			}
		}
	}
	public void reserve() {
		System.out.println("이름을 입력하세요.>>");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		int go = 1;
		
		while (go == 1) {
			if (validName(name)) { // 좌석을 예약한 적이 없다면
				System.out.println("좌석타입을 선택하세요.");
				System.out.println("1) S석 2) A석 3) B석 4) 메인메뉴");
				s = new Scanner(System.in);
				int type = s.nextInt();
				
				if (type == 1) { // S석을 선택하였을 때
					while (true) {
						try {
							System.out.println("좌석번호를 선택하세요.");
							System.out.print("[S]");

							for (int i = 0; i < 10; i++) {
								System.out.print("[" + (i + 1) + "]"+ seatField[0][i]);
							}

							System.out.println(" ");
							s = new Scanner(System.in);

							int seatNum = s.nextInt();
							if (seatField[0][seatNum - 1] == "---") {
								seatField[0][seatNum - 1] = name;
								System.out.println("예약이 되었습니다.");
								go = 0;
								break;
							} else
								System.out.println("예약불가능한 자리입니다. 다시 선택하세요.");
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						}
					}
				} else if (type == 2) {
					while (true) {// A석을 선택하였을 때
						try {
							System.out.println("좌석번호를 선택하세요.");
							System.out.print("[A]");

							for (int i = 0; i < 10; i++) {
								System.out.print("[" + (i + 1) + "]"
										+ seatField[1][i]);
							}
							s = new Scanner(System.in);
							int seatNum = s.nextInt();
							
							if (seatField[1][seatNum - 1] == "---") {
								seatField[1][seatNum - 1] = name;
								System.out.println("예약이 되었습니다.");
								go = 0;
								break;
							} else
								System.out.println("예약불가능한 자리입니다. 다시 선택하세요.");
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						}
					}
				} else if (type == 3) { // B석을 선택하였을 때

					while (true) {
						try {
							System.out.println("좌석번호를 선택하세요.");
							System.out.print("[B]");
							for (int i = 0; i < 10; i++) {

								System.out.print("[" + (i + 1) + "]"

										+ seatField[2][i]);
							}
							s = new Scanner(System.in);
							int seatNum = s.nextInt();
							if (seatField[2][seatNum - 1] == "---") {
								seatField[2][seatNum - 1] = name;
								System.out.println("예약이 되었습니다.");
								go = 0;
								break;
							} else {
								System.out.println("예약불가능한 자리입니다. 다시 선택하세요.");
							}
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						}
					}
				} else if (type == 4) // 메인 메뉴 선택하였을 때
					break;
				else
					System.out.println("다시 입력해주세요.");
			} else { // validName가 false 일 때
				System.out.println("한 번 예약한 적이 있습니다.");
				break;
			}
		}
	}
	public void confirm() { // 조회를 선택하였을 때

		for (int i = 0; i < 3; i++) {

			if (i == 0) {
				System.out.print("[S석]");
			} else if (i == 1) {
				System.out.print("[A석]");
			} else if (i == 2) {
				System.out.print("[B석]");
			} for (int j = 0; j < 10; j++) {
				System.out.print("[" + (j + 1) + "] " + seatField[i][j]);
			}
			System.out.println(" ");
		}System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	public void cancel() { // 취소를 선택하였을 때

		while (true) {
			try {
				System.out.println("취소할 좌석타입을 선택하세요.");
				System.out.println("1) S석 2) A석 3) B석 4) 메인메뉴");
				Scanner s = new Scanner(System.in);
				int type = s.nextInt();
				if (type == 4)
					break;
				
				for (int i = 0; i < 10; i++) {
					System.out.print("[" + (i + 1) + "] "+ seatField[type - 1][i]);
				}
				System.out.println(" ");
				System.out.println("취소할 좌석번호를 선택하세요.");
				s = new Scanner(System.in);
				int seatNum = s.nextInt();

				if (seatNum >= 1 && seatNum <= 10) {
					if (seatField[type - 1][seatNum - 1] != "---") {
						seatField[type - 1][seatNum - 1] = "---";
						System.out.println("취소되셧습니다.");
						break;
						
					} else {
						System.out.println("이미 빈 자리 입니다.");
						continue;
					}
				} else
					System.out.println("잘못된 입력입니다.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
		}
	}
	boolean validName(String name) { // 입력받은 이름으로 예약된 좌석이 있는지 확인

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
		System.out.println("habitualtask-song : 명품콘서트홀 예약 시스템입니다.");
		Conduct c = new Conduct();
		int menuNum;
		
		while (true) {
			System.out.println("1) 예약  2) 조회  3) 취소  4) 종료");
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
				System.out.println("종료합니다.");
				System.exit(0);
			} else
				System.out.println("잘못입력하셨습니다.");
		}
	}
}