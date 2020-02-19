package BAEK.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BAEK_10815_숫자카드 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		String[] total = s.split(" ");
		int N = Integer.parseInt(total[0]);
		String[] ary_N = new String[N];
		s = bf.readLine();
		
		for(int i = 0; i < N; i ++) {
		}
		/*int N = Integer.parseInt(total[0]);
		int[] ary_N = new int[N]; // 상근이가 가지고 있는 카드 배열
		int[] ary_M; // 정수 M개 만큼 주어진 카드를 저장하는 배여ㅑㄹ
		int[] result; // 각각 몇개씩 들어 있는지 알려주는 배열
		for(int i = 0; i < ary_N.length; i++) {
			ary_N[i] = Integer.parseInt(total[i+1]);
		}
		
		int M = Integer.parseInt(total[N+1]);
		ary_M = new int [M];
		result = new int [M];
		
		for(int i = 0; i < ary_M.length; i++){
			ary_M[i] = Integer.parseInt(total[N+i+2]);
		}
		
		for(int i = 0; i < ary_N.length; i++) {
			for(int j = 0; j < ary_M.length; j++) {
				if(ary_M[j] == ary_N[i]) {
					result[j]+=1;
					ary_M[j] = Integer.MAX_VALUE; //같은 수가 있을 때 더이상 세지 않도록 범위에서 벗어난 숫자로 초기화
					break;
				}
			}
		}
		for(int i = 0; i < result.length; i++)
			sb.append(result[i]+" ");
		
		System.out.println(sb);*/
	}
	
	
	/*public static String src = "5\r\n" + 
			"6 3 2 10 -10\r\n" + 
			"8\r\n" + 
			"10 9 -5 2 3 4 5 -10";
			*/
}
