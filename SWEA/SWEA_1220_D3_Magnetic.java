package IM_Prepare;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1220_D3_Magnetic {
	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res\\input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++) { // 총 10개의 테스트 케이스
			int N = sc.nextInt(); //테이블의 한 변
			int[][] table = new int[N][N];
			//테이블 초기화
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			//붉은 색 n극 파란색 s극 
			//n극 1 s극 2
			/*
			 어짜피 s극은 위로 올라 갈 것이고 n극은 아래로 내려 갈 것이다.
			 따라서 n극 밑에 s극이 몇 번있는 지를 전체 행렬에서 구하거나 case1
			 아니면 s극 위에 n극이 몇번 있는지를 계산하면 된다. case 2
			 이때 밑에 있는 경우가 생기면 교착 상태가 생긴 다는 것이고 이것을 count한다.
			 그리고 그 지점에 있는 자성체가 교착이 될 수 있다는 것을 알았기 때문에 다른 위치의
			 자성체를 비교하면 된다. 이때 count를 할 때는 한 방향으로만 계산한다.
			 만약 case1과 case2를 동시에 실행하면 같은 교착 상태를 한번 더 세기 때문이다.
			 */
			int answer = 0;  //교착 상태
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j ++) {
					if(table[i][j] == 1) { //현재 n극
						for(int k = i+1 ; k < N; k++) {
							if(table[k][j] == 2) { //서로 다른 극 만날 때
								answer += 1;
								break;
							}else if(table[k][j] == 1) { //서로 같은 극 만날 때는 D케이스가 되어 pair가 안생기고 탈출 
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
