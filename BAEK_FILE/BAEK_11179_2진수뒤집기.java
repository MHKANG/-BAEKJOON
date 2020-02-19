package BAEK.Algorithm;

import java.util.Scanner;

public class BAEK_11179_2진수뒤집기 {
	static String src = "13";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int n = sc.nextInt();
		int result = 0;
		String a = Integer.toBinaryString(n);
		char[] ary = new char[a.length()];
		for(int i = 0; i < a.length(); i++) {
			ary[i] = a.charAt(a.length()-i-1);
		}
		for(int i = 0; i < ary.length; i++) {
			result+= (ary[ary.length-1-i]-'0')*Math.pow(2, i);
		}
		
		System.out.println(result);
	}
}
