package BAEK.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BAEK_2503_숫자야구 {
	
	public static String src = "4\r\n" + 
			"123 1 1\r\n" + 
			"356 1 0\r\n" + 
			"327 2 0\r\n" + 
			"489 0 1";
	public static List<Integer>Answers = new ArrayList<>();
	public static int [] count_ary = new int [1000];
	public static List<Integer>num_ary = new ArrayList<>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 sc = new Scanner(src);
		 int N  = sc.nextInt();
		 int Answer = 0;
		 int[][] ary = new int [N][3]; //질문한 숫자, 스트라이크, 볼 저장
		 for(int i = 0; i < N; i++) {
			 ary[i][0] = sc.nextInt();
			 ary[i][1] = sc.nextInt();
			 ary[i][2] = sc.nextInt();
		 }
		 make_num(); // 123 ~ 987 까지 수를 생성
		 List<Integer>answer_ary = new ArrayList<Integer>();
		 
		 //조건을 대입하여 맞는 숫자를 추려 냄
		 choice_Num(ary[0][0], ary[0][1], ary[0][2]);
		 for(int i = 1; i < N; i++) {
			 choice_Num(ary[i][0], ary[i][1], ary[i][2]);
		 }
		 for(int i = 0; i < count_ary.length; i++) {
			 if(count_ary[i] == N) {
				 //System.out.println(i +" : " + count_ary[i]);
				 Answer++;
			 }
		 }
		 System.out.println(Answer);
		
	}
	//세자리 수가 같은지 체크
	public static boolean checkSameNum(int h, int t, int u) {
		if(h == t || h == u || t == u)
			return true;
		return false;
	}
	//맨 처음 후보군 생성 
	public static void make_num() {
		for(int i = 1; i <= 9; i++) {

			for(int j = 1; j <=9; j++ ) {
				
				for(int k = 1; k <=9; k++) {
					if(!checkSameNum(i, j, k))
					{
						num_ary.add(i*100+ j*10+k);
					}
				}
			}
		}
	}
	
	//들어온 숫자랑 strike, ball을 통해서 숫자를 유추한다.
	public static void choice_Num(int input_Num, int strike, int ball) {
		
		for(int i = 0; i < num_ary.size(); i++) {
			//스트라이크 또는 ball이 존재 할 경우
			if(check_strike(input_Num, num_ary.get(i)) == strike && check_ball(input_Num, num_ary.get(i)) == ball ) {
				count_ary[num_ary.get(i)]++;
			}
		}
	}
	// strike 체크
	public static int check_strike(int Num1, int Num2) {
		int count = 0;
		int h1 = Num1/100;
		int h2 = Num2/100;
		int t1 = (Num1-h1*100)/10;
		int t2 = (Num2-h2*100)/10;
		int u1 = Num1 -h1*100 -t1*10;
		int u2 = Num2 -h2*100 -t2*10;
		
		//백의 자리
		if(h1 == h2)
			count++;
		//십의 자리
		if(t1 == t2)
			count++;
		//일의 자리
		if(u1 == u2) 
			count++;
	
		return count;	
	}
	// ball 체크
	public static int check_ball(int Num1, int Num2) {
		int count = 0;
		int h1 = Num1/100; //첫번째 숫자 백의 자리
		int h2 = Num2/100; //두번째 숫자 백의 자리
		int t1 = (Num1-h1*100)/10;  //첫번째 숫자 십의 자리
		int t2 = (Num2-h2*100)/10;	//두번째 숫자 십의 자리
		int u1 = Num1 -h1*100 -t1*10;	//첫번째 숫자 십의 자리
		int u2 = Num2 -h2*100 -t2*10;	//두번째 숫자 일의 자리
		if(h1 == t2)
			count++;
		if(h1 == u2)
			count++;
		if(t1 == h2)
			count++;
		if(t1 == u2)
			count++;
		if(u1 == h2)
			count++;
		if(u1 == t2)
			count++;
		
		return count;
	}
}
