package algo_basic_day2;

import java.util.Scanner;

public class SWEA_1210_D4_SW문제해결기본2일차_Ladder1 {
	// 오른쪽, 왼쪽, 위로 내려 갈 수 있는 방향 배열
	public static int[][] dir = {{1, 0}, {0,1}, {1,0}};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		int TC = 10;
		for(int t = 1; t<= 10; t++) {
			int goal = -1; // 도착 지점 초기화
			int[][] arr = new int [100][100]; //전체 경로가 저장되어 있는 배열
			int[] result = new int[100]; //시작점이 index인 경로의 도착 값 또는 경로 0 ,1, 2
			
			scanner.nextInt(); // 회차 
			// 받은 맵을 저장
			for(int i = 0; i < 100; i ++)
			{
				for(int j = 0; j < 100; j++)
					arr[i][j] = scanner.nextInt();	
			}
			for(int i = 0; i < 100; i++) {
				if(arr[99][i] == 2) {
					goal = i;
					break;
				}
			}
			//방문 확인 배열
			int [][]visited = new int [100][100];
			int row = 99; //시작점 행
			while(row>0) {
				//왼쪽으로 꺽는 경우
				if(check(row, goal-1) && arr[row][goal-1] ==1 && visited[row][goal-1] ==0) {
					visited[row][goal-1] = 1;
					goal = goal -1;
				//오른쪽으로 꺽는 경우
				}else if(check(row, goal+1) && arr[row][goal+1] ==1 && visited[row][goal+1] ==0) {
					visited[row][goal+1] = 1;
					goal = goal +1;
				}
				
				//위로 가는 경우
				else if(check(row-1, goal) && arr[row-1][goal] == 1 && visited[row-1][goal] ==0) {
					visited[row-1][goal] = 1;
					row = row-1;
				}

			}
			
			System.out.println("#"+t +" " +goal);
		}
	}
	//배열의 범위를 벗어나는지 확인
	public static boolean check(int row, int col) {
		
			return 0 <= row && row < 100 && 0 <=col && col <100;
		
	}


}
