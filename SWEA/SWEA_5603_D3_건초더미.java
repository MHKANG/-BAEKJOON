package IM_Prepare;

import java.util.Scanner;

public class SWEA_5603_D3_건초더미 {
	static String src = "1\r\n" + 
			"4\r\n" + 
			"2\r\n" + 
			"10\r\n" + 
			"7\r\n" + 
			"1";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt(); // 테스트 케이스 수
		for(int tc = 1; tc <= T ; tc++) {
			int answer = 0; // 답
			int N = sc.nextInt(); // 건초 더미 수
			int sum =0; // 전체 건초의 수
			int[] hay_ary = new int [N]; // 건초더미를 저장하는 배열
			for(int i = 0; i < N; i++) {
				//각 건초더미의 크기를 저장
				hay_ary[i] = sc.nextInt(); 
				sum += hay_ary[i] ;
			}
			int avg = sum/N; //건초 더미의 평균 수;
			for(int i = 0; i < N; i++) {
				if(hay_ary[i]>avg) {
					answer += (hay_ary[i]-avg);
				}
			}
			System.out.println("#" + tc + " "+ answer);
		}
	}
}
