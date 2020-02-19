package IM_Prepare;

import java.util.Scanner;

public class SWEA_2005_D2_파스칼의삼각형 {
	public static String src = "1\r\n" + 
			"4";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int N = sc.nextInt(); // 삼각형 크기
			int[][]arr = new int [N][N];
			for(int i = 0; i < N; i++) {
				arr[i][0] = 1;
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if( i == j )
						arr[i][j] = 1;
				}
			}
			for(int i = 1; i < N; i++) {
				for(int j = 1 ; j < i; j++) {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] != 0)
						System.out.print(arr[i][j] +" ");
				}
				System.out.println();
			}
		}
	}
}
