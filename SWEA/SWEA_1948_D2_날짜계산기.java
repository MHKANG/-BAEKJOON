package IM_Prepare;

import java.util.Scanner;

public class SWEA_1948_D2_날짜계산기 {
								
	public static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
	public static String src = 
			"10\r\n" + 
			"3 1 3 31\r\n" + 
			"5 5 8 15\r\n" + 
			"7 17 12 24\r\n" + 
			"3 22 5 10\r\n" + 
			"2 13 6 12\r\n" + 
			"4 30 11 9\r\n" + 
			"7 10 9 28\r\n" + 
			"6 30 9 20\r\n" + 
			"4 19 12 12\r\n" + 
			"1 1 12 31\r\n" + 
			"5 23 9 12\r\n" + 
			"2 12 9 4";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner = new Scanner(src);
		int Tc = scanner.nextInt(); //  테스트 케이스 수
		int month1, month2; // 각 달
		int day1, day2; // 각 일 
		//cal1, cal2; 달 + 일 을 일자로 계산한 것;
		for(int i = 0; i < Tc; i++) {
			int result = 0;
			int cal1 = 0;
			int cal2 = 0;
			month1 = scanner.nextInt();
			day1 = scanner.nextInt();
			month2 = scanner.nextInt();
			day2 = scanner.nextInt();
			//첫번 째 일 수 계산
			for(int j = 1; j < month1; j++) {
				cal1+= month[j];
			}
			cal1 += day1;
			//두번 째 일 수 계산
			for(int k = 1; k < month2; k++) {
				cal2+= month[k];
			}
			cal2 += day2;
			result = cal2 - cal1 +1;
			System.out.println("#" + (i+1) + " " + result);
		}
		
	}
}
