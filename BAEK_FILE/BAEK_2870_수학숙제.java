package BAEK.Algorithm;

import java.math.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BAEK_2870_수학숙제 {
	static String src = "4\r\n" + 
			"43silos0\r\n" + 
			"zita002\r\n" + 
			"le2sim\r\n" + 
			"2312330000000000000000000000000000000000000000000000002";
	static List<String>list = new ArrayList<String>();
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int N = sc.nextInt();
		String[] s = new String[N];
		for(int tc = 0; tc < N; tc++) {
			s[tc] = sc.next();
		}
		for(int i = 0; i <N; i++) {
			findNum(s[i]);
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) {
					return 1;
				}
				else if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				else
					return -1;
				
			}
		});
		for(String s1 : list) {
			System.out.println(s1);
		}
		
	}
	public static boolean checkNum(char c) {
		return c=='1' || c=='2'  || c=='3'  || c=='4'  || c=='5'  || c=='6'
				 || c=='7'  || c=='8'  || c=='9'  || c=='0';
	}
	
	public static String DeleteZero(String s) {
		if(s.charAt(0) == '0') {
			if(s.length() == 1) {
				return s;
			}
			else { // 0 으로 시작하는 숫자가 들어왔을 때
				
			//index가 1인 지점 부터 0이 아닌 지점을 찾고 그 지점부터 끝까지 값을 넣기
				int idx = 0;
				for(int k = 1; k <s.length(); k++) {
					if(s.charAt(k)!= '0') {
						idx = k;
						break;
					}
				}
				if(idx == 0)
					return "0";
				
				s = s.substring(idx);
			}
		}
		return s;
	}
	
	public static void findNum(String s) {
		List<String>temp = new ArrayList<>();
		
		int count = 0;
		int a_count = 0;
		String[] ary = new String[s.length()];
		
		String s_temp = new String("");// 임시 저장 스트링
		for(int i = 0; i < s.length(); i++)
		{
			if(checkNum(s.charAt(i))) {
				 s_temp = s_temp + s.charAt(i);
				count++;
			}
			else {
				if(count != 0) {
					ary[a_count] = s_temp;
					a_count++;
					s_temp = new String("");
					count = 0;
				}		
			}
		}
		if(count != 0) {
			ary[a_count] = s_temp;
			a_count++;
		}
		for(int i = 0; i< a_count; i++) {
			list.add(DeleteZero(ary[i]));
		}
	}
}
