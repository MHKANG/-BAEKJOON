package BAEK.Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_1969_DNA {
	public static String src = "5 8\r\n" + 
			"TATGATAC\r\n" + 
			"TAAGCTAC\r\n" + 
			"AAAGATCC\r\n" + 
			"TGAGATAC\r\n" + 
			"TAAGATGT";
	public static char[] DNA = {'A','C','G','T'};
	public static StringBuilder Answer = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt(); //DNA 개수
		int M = sc.nextInt(); //문자열 길이
		String[] ary = new String[N];
		int[] sum_Hamming = new int [N]; //해밍 거리 합을 저장하는 배열
		for(int i = 0; i < N; i++) {
			ary[i] = sc.next();
		}
		calHam(ary);
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += differ(Answer, ary[i]);
		}
		System.out.println(Answer);
		System.out.println(sum);
		
	}
	public static void calHam(String[] ary) {
		
		for(int i = 0; i < ary[0].length(); i++) {
			int[] h_ary = new int [4];
			int index = -1;
			for(int j = 0; j < ary.length; j++) {
				for(int k = 0; k <DNA.length; k++) {
					if(ary[j].charAt(i) == DNA[k]) {
						h_ary[k]++;
					}	
				}
			}
			index = findMaxindex(h_ary);
			Answer.append(DNA[index]);
		}
	}
	public static int findMaxindex(int []ary) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		for(int i = 0; i <ary.length; i++) {
			if(max < ary[i]) {
				max = ary[i];
				index = i;
			}
		}
		return index;
	}
	public static int differ(StringBuilder s1, String s2) {
		int count = 0;
		for(int i = 0; i <s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i))
				count++;
		}
		
		return count;
	}
	
}
