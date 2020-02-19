package IM_Prepare;

import java.util.Scanner;

public class SWEA_1209_D3_2일차Sum {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		for(int t = 1; t <=10; t++) {
			int tc = sc.nextInt();
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j ++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[]row = new int[100]; // 각 행들의 합
			int[]col = new int[100]; // 각 열들의 합
			int[]cross = new int[2]; //대각 선의 합
			
			for(int i = 0; i < 100; i++) {
				
				for(int j = 0; j < 100; j ++) {
					row[i] += arr[i][j]; // 각 행의 합을 저장
					col[i] += arr[j][i]; // 각 열의 합을 저장
					if(i == j ) {
						cross[0] += arr[i][j]; // 오른쪽 대각선
					}
					if(i == 99 -j) {
						cross[1]+= arr[i][j];
					}
				}
			}
			int rowMax = findMax(row);
			int colMax = findMax(col);
			int crossMax = findMax(cross);
			int result = 0;
			if(rowMax >= colMax && rowMax>= crossMax)
				result = rowMax;
			else if(colMax >= rowMax && colMax>= crossMax)
				result = colMax;
			else if(crossMax>= rowMax && crossMax >= colMax)
				result = crossMax;
			System.out.println("#"+t+" "+result);
		}
	}
	public static int findMax(int[]arr) {
		int MAX = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >MAX)
				MAX = arr[i];
		}
		return MAX;
	}
}
