package IM_Prepare;

import java.util.Scanner;

public class SWEA_1234_D3_비밀번호 {
	public static String src = "10 1238099084\r\n" + 
			"16 4100112380990844\r\n" + 
			"26 12380990844100112380990844\r\n" + 
			"42 123809908444100112380990844100112380990844\r\n" + 
			"55 1238099084441001123809908441001321238099084432180990844\r\n" + 
			"60 123809908444100145351123809908441001321238099084432180990844\r\n" + 
			"71 12380990844410013218099084441001123809908441001321238099084432180990844\r\n" + 
			"99 123809908444100180990844410013211238099084410013212380990844123809908441238099084410013232180990844\r\n" + 
			"82 1238099084441001410011238099084412380990844100132123809908441238099084432180990844\r\n" + 
			"58 0899809812380990844100132123809908441238099084432180990844";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
		scanner = new Scanner(src);
		int N; // 문자의 총수 
		String s; // 문자 열
		for(int tc = 1; tc<= 10; tc++) {
			StringBuffer sb = new StringBuffer();
			N = scanner.nextInt();
			s = scanner.next();
			sb.append(s);
			while(check_Continue(sb)) {
				int c_index = return_continue_idx(sb);
				sb.delete(c_index, c_index+2);
			}
			System.out.println("#" + tc + " " +sb);
			
		}
	}
	public static boolean check_Continue(StringBuffer input_s) {
		boolean result = false;
		for(int i = 0; i < input_s.length()-1; i++) {
			if(input_s.charAt(i) == input_s.charAt(i+1)) {
				result = true;
			}
		}
		return result;
	}
	public static int return_continue_idx(StringBuffer input_s) {
		int idx = -1;
		for(int i = 0; i < input_s.length()-1; i++) {
			if(input_s.charAt(i) == input_s.charAt(i+1)) {
				idx = i;
			}
		}
		return idx;
	}
}
