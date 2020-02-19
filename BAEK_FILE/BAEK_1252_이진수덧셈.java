package BAEK.Algorithm;

import java.util.Scanner;


public class BAEK_1252_이진수덧셈 {
	
	static String src = "1001101 10010";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		String answer = "";
		String num1 = sc.next(); // 첫 번째 숫자
 		String num2 = sc.next(); // 두 번째 숫자
 		
 		int different_digit = Math.abs(num1.length()-num2.length()); //자리 수 차이.
 		//자리수가 작은 숫자의 빈 길이만큼 0을 채워줄 수 있도록 만듬.
 		if(num1.length()> num2.length()){
 			while(different_digit-- >0) {
 				num2 = "0" + num2;
 			}
 		}
 		else {
 			while(different_digit-- >0) {
 				num1 = "0" + num1;
 			}
 		}
		int up = 0; //같은 자리에서 연산을 했을 때 합이 2가 되면 그 다음 자리로 1이 올라가는 것을 표시
		String cal =""; // 계산된 결과 값.
		//맨 오른쪽부터 계산
		for(int i = num1.length()-1; i >=0; i--) {
			int sum = (num1.charAt(i)-'0') + (num2.charAt(i)-'0') + up; // 자리 수별 연산하고 up값 을 더해줌
			// 각 자리수가 모두 1인데 아래에서 올라온 1값 이 있는 경우 
			if(sum == 3) {
				cal = 1 + cal; //자리 수 계산
				up = 1;
			}else if(sum == 2) {
				cal = 0 + cal;
				up = 1;
			}else if(sum == 1) {
				cal = 1 + cal;
				up = 0;
			}else {
				cal = 0 + cal;
				up = 0;
			}
		}
		//계산의 맨 왼쪽에서 올림이 발생한 경우
		if(up ==1) {
			cal = 1+ cal;
		}
		if(checkNotZero(cal)) {
			int index = findNotZero(cal);
			answer = cal.substring(index);
			System.out.println(answer);
			
		}
		else {
			System.out.print(0);
		}
	}
	//왼쪽의 0을 제거하기 위한 함수
	public static int findNotZero(String s1) {
		for(int i = 0 ; i< s1.length(); i++)
		{
			if(s1.charAt(i)!= '0')
				return i;
		}
		return -1;
	}
	//string문자열이 0인지 아닌지 체크
	public static boolean checkNotZero(String s1) {
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == '1')
				return true;
		}
		return false;
	}
}
