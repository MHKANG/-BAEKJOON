package IM_Prepare;

import java.util.Scanner;

public class SWEA_2805_D3_농작물수확하기 {
	public static String src = "1\r\n" + 
			"5\r\n" + 
			"14054\r\n" + 
			"44250\r\n" + 
			"02032\r\n" + 
			"51204\r\n" + 
			"52212";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = sc.nextInt();  // 테스트 케이스
		for(int tc = 1; tc<= T; tc++) {
			int N = sc.nextInt(); //농장 사이즈
			int[][] farm = new int[N][N];
			//농장 가치 초기화
			String[] s_farm = new String[N];
			for(int i = 0; i < N; i++) {
				s_farm[i] = sc.next();
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					farm[i][j] = (s_farm[i].charAt(j)-'0');
				} 
			}
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if( i<= (N-1)/2) {
					for(int j = ((N-1)/2)-i; j<= ((N-1)/2)+i; j++) {
						sum += farm[i][j];
					}
				}else if(i>((N-1)/2)) {
					for(int j = (2*i+1-N)/2; j<=(3*N-2*i-3)/2; j++){
						sum += farm[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
