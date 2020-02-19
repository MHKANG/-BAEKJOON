package algo_basic_day1;

import java.util.Scanner;

public class SWEA_2058_D1_자릿수더하기 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//입력의 방향을 바꾸자.
		//scanner = new Scanner(str);
		
		int n = scanner.nextInt();
		//  입력 값을 확인 하자
		//System.out.println(n);
		int sum  = 0;
		while(n>0) {
			sum+=n%10;
			n/=10;
		}
		System.out.println(sum);
	}
	
	//private static String str = "6789";
}
