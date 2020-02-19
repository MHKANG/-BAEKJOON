package algo_basic_day1;

import java.util.Scanner;

public class SWEA_2050_D1_알파벳을숫자변환 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner = new Scanner(src);
		String str = scanner.next();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++)
		{
			sb.append(str.charAt(i)-'A'+1).append(" ");
		}
		System.out.println(sb);
	}
	private static String src = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
}
