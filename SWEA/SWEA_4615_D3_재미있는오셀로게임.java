package IM_Prepare;

import java.util.Scanner;

public class SWEA_4615_D3_재미있는오셀로게임 {

	static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0},{-1, 1},{1,-1},{-1,-1},{1,1}};
	static int N, M;
	static int black_stone, white_stone; // 흑 백 돌 개수
	static int[][]map;
	static String src = "1\r\n" + 
			"4 12 \r\n" + 
			"1 2 1\r\n" + 
			"1 1 2\r\n" + 
			"4 3 1\r\n" + 
			"4 4 2\r\n" + 
			"2 1 1\r\n" + 
			"4 2 2\r\n" + 
			"3 4 1\r\n" + 
			"1 3 2\r\n" + 
			"2 4 1\r\n" + 
			"1 4 2\r\n" + 
			"4 1 2\r\n" + 
			"3 1 2";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <=T; t++) {
			String[] s = sc.nextLine().split(" ");
			N = Integer.parseInt(s[0]); //보드의 한변 길이
			M = Integer.parseInt(s[1]); //플레이어가 돌을 놓는 횟수
			black_stone = 0;
			white_stone = 0;
			map = new int[N+1][N+1]; // 보드 생성, (1, 1)을 기준으로 하기 때문
			//맨 처음 중앙 4개의 칸 초기화
			map[N/2][N/2] = 2;   
			map[N/2+1][N/2] = 1;
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2+1] = 2;

			int[][]w_ary = new int[M][3]; //어디에 돌을 놓을 것인지를 저장하는 배열
			for(int i = 0; i < M; i++) {
				String[] where = sc.nextLine().split(" ");
				w_ary[i][0] = Integer.parseInt(where[0]); //x 축
				w_ary[i][1] = Integer.parseInt(where[1]); //y 축
				w_ary[i][2] = Integer.parseInt(where[2]); //돌의 색 1 : 흑  2 : 백;
			}
			for(int i = 0; i < M; i++) {
				putStone(w_ary[i][0], w_ary[i][1], w_ary[i][2]);
			}
			countStone();
			System.out.println("#" + t + " " + black_stone + " " + white_stone);
		}
	}
	public static void printMap() {
		for(int i = 1; i < map.length; i++) {
			for(int j = 1; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	//맵에 흑돌 백돌이 얼마나 있는지  counting
	public static void countStone() {
		for(int i = 1; i < map.length; i++) {
			for(int j = 1; j < map.length; j++) {
				if(map[i][j] == 1)
					black_stone++;
				else if(map[i][j] == 2) {
					white_stone++;
				}
			}
		}
	}
	//어느 좌표에 어떤 색의 돌을 두는지를 수행하는 함수
	public static void putStone(int x, int y, int type) {
		if( fullMap() && map[x][y] != 0) { // 돌을 두고자 하는 공간이 빈 공간이 아니라서 돌을 둘 수 없음 , 모든 맵이 다 찼을 경우 돌을 둘 수 없음
			return ;
		}else { //돌을 둘 수 있음
			map[y][x] = type; // (x, y)에 type의 색의 돌을 둠 

			if(type == 1) { // 두고자 하는 돌이 흑돌 일 때
				for(int i = 0; i < dir.length; i++) { //8방 탐색을 통해서 백돌을 찾음
					int nx = x + dir[i][1];
					int ny = y + dir[i][0];
					int count = 0;
					int b_count = 0; //다시 흑돌을 만나는 경우
					while(isIn(ny, nx) && map[ny][nx] == 2) { // 다음에 이동하는 영역이 백돌이고 경계가 아닐 때까지 계속 이동
						//좌표 이동
						count++;
						nx = nx + dir[i][1];
						ny = ny + dir[i][0];
						if(isIn(ny, nx) && map[ny][nx] ==1)
							b_count++;

					}
					if(b_count != 0) {
						int mx = x; 
						int	my = y;
						for(int k = 0; k < count; k++) {
								mx = mx + dir[i][1];
								my = my + dir[i][0];
							map[my][mx] = 1;
						}
					}
				}
			}else if(type ==2) { //두고자 하는 돌이 백돌 일 경우 
				for(int i = 0; i < dir.length; i++) { //8방 탐색을 통해서 백돌을 찾음
					int nx = x + dir[i][1];
					int ny = y + dir[i][0];
					int w_count = 0;
					int count = 0;
					while(isIn(ny, nx) && map[ny][nx] == 1) { // 다음에 이동하는 영역이 백돌이고 경계가 아닐 때까지 계속 이동

						//좌표 이동
						count++;
						nx = nx + dir[i][1];
						ny = ny + dir[i][0];	
						if(isIn(ny, nx) && map[ny][nx] ==2)
							w_count++;
						
					}
					if(w_count!=0) {
					int mx = x, my = y;
					for(int k = 0; k < count; k++) {
							mx = mx+ dir[i][1];
							my = my+ dir[i][0];
						map[my][mx] = 2;
					}
					}
				}
			}
		}
		
	}
	//맵의 끝자락인지 확인
	public static boolean checkEdge(int x, int y) {
		if(x ==1 || x == N)
			return true;
		else if(y == 1 || y == N)
			return true;
		return false;
	}
	//보드의 모든 영역이 돌로 채워 졌을 경우 true를 리턴
	public static boolean fullMap() {
		for(int i = 1; i < map.length; i++) {
			for(int j = 1; j <map.length; j++) {
				if(map[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	// 범위 안인지 체크 check
	public static boolean isIn(int x, int y) {
		return x>=1 && x<=N && y>=1 && y<=N;
	}
}
