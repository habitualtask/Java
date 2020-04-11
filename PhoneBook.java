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
		System.out.print("인원수 입력>>");
		n=scanner.nextInt();
		Phone[] phone =new Phone[n];
		for(int i=0;i<n;i++) {
			System.out.print("이름과 전화번호 >> ");
			phone[i]=new Phone(scanner.next(),scanner.next());
		}System.out.println("저장되었습니다 . . .");
		
		while(true) {
			System.out.print("검색할 이름 >> ");
			String searchName=scanner.next();
			for(int i=0;i<n;i++) {
				if(searchName.equals("그만"))
					System.exit(1);
				else if(searchName.equals(phone[i].name)) {
					System.out.println(phone[i].getName()+"의 전화번호 "+phone[i].getTel()+" 입니다.");
					break;
				}else if(!searchName.equals(phone[i].name) && i==(n-1)){
					System.out.println(searchName+"는 없습니다.");
				}
			}
		}
	}

}