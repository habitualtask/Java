import java.util.Scanner;
class Phone{
	String name;
	String tel;
	Phone(String name, String tel){
		this.name=name;
		this.tel=tel;
	}
	String getName() {
		return name;
	}String getTel(){
		return tel;
	}
}
 public class PhoneBook {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		System.out.println("habitualtask song");
		Scanner scanner =new Scanner(System.in);
		System.out.print("�ο��� �Է�>>");
		n=scanner.nextInt();
		Phone[] phone =new Phone[n];
		for(int i=0;i<n;i++) {
			System.out.print("�̸��� ��ȭ��ȣ >> ");
			phone[i]=new Phone(scanner.next(),scanner.next());
		}System.out.println("����Ǿ����ϴ� . . .");
		
		while(true) {
			System.out.print("�˻��� �̸� >> ");
			String searchName=scanner.next();
			for(int i=0;i<n;i++) {
				if(searchName.equals("�׸�"))
					System.exit(1);
				else if(searchName.equals(phone[i].name)) {
					System.out.println(phone[i].getName()+"�� ��ȭ��ȣ "+phone[i].getTel()+" �Դϴ�.");
					break;
				}else if(!searchName.equals(phone[i].name) && i==(n-1)){
					System.out.println(searchName+"�� �����ϴ�.");
				}
			}
		}
	}

}