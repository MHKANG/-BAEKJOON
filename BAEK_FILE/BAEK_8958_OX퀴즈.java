package BAEK.Algorithm;

import java.util.Scanner;

public class BAEK_8958_OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int []answer = new int[N];
		String[]ary = new String[N];
		for(int i = 0; i < N; i++) {
			ary[i] = sc.next();
			answer[i] = testPoint(ary[i]);
		}
		for(int a : answer) {
			System.out.println(a);
		}
	}
	public static int testPoint(String s) {
		
		int conti = 0; // 몇번의 'O'가 연속인지를 체크
		int p_result =0; // 총 점수가 몇점인지를 저장하기 위한 변수
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) =='O')
				conti++;
			else {
				p_result+= rowSum(conti);
				conti = 0;
			}
		}
		p_result+= rowSum(conti); //마지막에 연속된 O가 나왓을 경우
		return p_result;
	}
	public static int rowSum(int n) {
		int result = 0;
		for(int i = 1; i<=n; i++) {
			result+= i;
		}
		return result;
	}
}
