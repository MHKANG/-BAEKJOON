package IM_Prepare;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_2001_D2_파리퇴치 {

	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res\\input_fly.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 전체 영역
			int M = sc.nextInt(); // 잡을 영역 
			int Max = Integer.MIN_VALUE;
			int[][] fly_arr = new int [N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					fly_arr[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i <=N-M; i++) {
				for(int j = 0; j <=N-M; j++) {
					int temp = sum(fly_arr, i, j, M);
					if(temp> Max) {
						Max = temp;
					}
				}
			}
		
			System.out.println("#" +tc + " " + Max);
			
		}
	}
	public static int sum(int[][] arr,int row, int col, int M) {
			int sum = 0;
			for(int i = row; i < row+M; i++) {
				for(int j = col; j < col+M; j++) {
					sum += arr[i][j];
				}
			}
			return sum;
	}
	
}
