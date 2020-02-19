package IM_Prepare;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1966_D2_숫자를정렬하자 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int Tc = scanner.nextInt(); //전체 테스트 케이스
		int N; // N개의 숫자
		int[] numAry; // 배열 저장 
		for(int i = 0; i < Tc; i++) {
			
			N = scanner.nextInt();
			numAry = new int[N];
			//받아 오는 값들은 채워 넣어 줌
			for(int j = 0; j < N; j++) {
				numAry[j] = scanner.nextInt();
			}
			Arrays.sort(numAry);
			System.out.print("#" + (i+1) +" ");
			for(int j = 0; j < N; j++) {
				System.out.print(numAry[j] + " ");
			}
			System.out.println();
		}
		
	}
}
