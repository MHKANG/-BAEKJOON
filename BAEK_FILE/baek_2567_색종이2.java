package BAEK.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baek_2567_색종이2 {
	
	static String src = "4\r\n" + 
			"3 7\r\n" + 
			"5 2\r\n" + 
			"15 7\r\n" + 
			"13 14";
	static int[][] dir = {{0,1}, {0,-1},{1,0}, {-1,0}};
	static int[][]map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int answer = 0;
		int N = sc.nextInt(); //색종이 수;
		map = new int[102][102];
		for(int t = 0; t< N; t++) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for(int i = height; i < height+10; i++) {
				for(int j = width; j< width+10; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		for(int i = 1; i <=100; i++) {
			for(int j = 1; j <=100; j++) {
				if(map[i][j] == 1) { // 겹치는 영역에서 빈 사각형의 둘레를 구함
					answer += inBox(i, j);
				}
			}
		}
		System.out.println(answer);
		
	}
	static boolean isIn(int nx, int  ny) {
		return nx>=0 && nx<101 && ny>=0  && ny<101;
	}
	static int inBox(int x, int y) {
		int count = 0;
		int nx;
		int ny;
		for(int i = 0; i < dir.length; i++) {
			nx = x + dir[i][0];
			ny = y + dir[i][1];
			
			if(isIn(nx, ny) && map[nx][ny] == 0) {
				count++; //만약에 겹치는 사각형 영역 안에서 서로 만나지 않는 공백인 영역이 있다면 이를 계산하는 식임
				/* ex 아래와 같이 중간 영역이 비어있을 경우 이를 계산하기 위해서 4방향에서 만약 0인 지점이 있다면 그 지점만큼 길이를 계산하여 둘레를 계산함
				 * ************
				 * *****   ****
				 * ************
				 */
			}
		}
		return count;
	}
}
