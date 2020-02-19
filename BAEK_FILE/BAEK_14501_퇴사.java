package BAEK.Algorithm;

import java.util.Scanner;

public class BAEK_14501_퇴사 {
	private static int N;
	private static int[] time, money, sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N+1];
		money = new int [N+1];
		sum = new int[N+1];
		for(int i = 1; i <= N; i++) {
			time[i] = sc.nextInt();
			money[i] = sc.nextInt();
			sum[i] = money[i];
		}
		
		//sum[n] = n일 때까지 얻은 수익
		//N일차 까지 가장 많이 얻을 수 있는 이익을 비교해서 sum 배열에 저장한다.
		for(int i = 2; i <= N; i++) {
			for(int j =1; j <i; j++) {
				if(i-j >=time[j]) {
					sum[i] = Math.max(money[i]+ sum[j], sum[i]);
				}
			}
		}
		int max = 0;
		
		for(int i = 1; i <=N; i++) {
			if(i+time[i] <= N+1) {
				if(max < sum[i]) {
					max = sum[i];
				}
			}
		}
		System.out.println(max);
	}
	
}
