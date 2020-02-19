package BAEK.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BAEK_11502_세개의소수문제 {

	static String src = "3\r\n" + 
			"7\r\n" + 
			"11\r\n" + 
			"25";

	static boolean check ;
	static int[] answer = new int[3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		
		for(int t = 1; t<=N; t++) {
			int i_p = sc.nextInt(); //합치고자 하는 소수 값 받아 옴
			int[]temp = new int[3];
			List<Integer>list = new ArrayList<>();
			
			for(int i = 2; i < i_p; i++) {
				if(check_P(i)) //소수인지 아닌지 테스트
					list.add(i);
			
			}			
			dfs(0,temp,i_p, list);
			if(check == true) {
				Arrays.sort(answer);
				for(int i = 0; i < 3; i++) {
					System.out.print(answer[i] + " ");
				}
			}else
				System.out.println(0);
			System.out.println();
		}
	}
	//dfs 로 탐색
	public static void dfs(int k, int[] temp, int p,List<Integer>list) {
		if(k == 3) {
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				
				sum += temp[i];
			}
			if(sum == p) { //합친 값이 소수라면
				
				for(int i = 0; i < 3; i++) {
					
					answer[i] = temp[i];
				}
				check = true;
			}
			return ;
		}else {
			int sum = 0;
			for (int i = 0; i <= k; i++){
				sum += temp[i];
			}
			for(int i = 0; i < list.size(); i++) {
				if(sum +list.get(i)<= p) {
					temp[k] = list.get(i);
					dfs(k+1,temp , p, list);
					temp[k] = 0;
				}
			}
		}
			
	}
	public static boolean check_P(int a) {
		for(int i = 2; i <a; i++){
			if(a%i == 0)
				return false;
		}
		return true;
	}
}
