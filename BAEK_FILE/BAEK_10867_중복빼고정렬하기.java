package BAEK.Algorithm;

import java.util.Arrays;

import java.util.Scanner;


public class BAEK_10867_중복빼고정렬하기 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
		StringBuilder sb = new StringBuilder();
		
		int Num = scanner.nextInt(); // 들어오는 수
		int input_Num;
		int[] ary = new int[Num];
		
		for(int i = 0; i < ary.length; i++)
			ary[i] = 1001;
		
		for(int i = 0; i < Num; i++)
		{
			input_Num = scanner.nextInt();
			 if(!check(ary, input_Num )) {
				 ary[i] = input_Num;
			 }
		}
		Arrays.sort(ary);
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] !=1001) {
				sb.append(ary[i] + " ");
			}
		}
		System.out.println(sb);
		
	}
	//동일한 숫자가 있으면 true를 리턴한다.
	public static boolean check(int[] input_ary, int input2) {
		boolean result = false;
		
		for(int i = 0; i < input_ary.length; i++) {
			if(input_ary[i] == input2) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	
}
