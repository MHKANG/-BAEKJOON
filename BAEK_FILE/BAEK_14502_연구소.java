package BAEK.Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_14502_연구소 {
	
	static String src = "4 6\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"1 0 0 0 0 2\r\n" + 
			"1 1 1 0 0 2\r\n" + 
			"0 0 0 0 0 2";
	static int row;
	static int col;
	static int safeArea = Integer.MIN_VALUE;
	static boolean vVisited[][]; //바이러스에 감염이 되어 있는가
	static boolean wallVisited[][]; // 벽이 세워질 수 있는 모든 장소에 벽을 세워 보았는가
	static int[][] dir = {{0,1}, {1, 0},{0,-1}, {-1,0}}; // 오른쪽, 아래, 왼쪽, 위 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		row = sc.nextInt(); // 지도의 행 
		col = sc.nextInt(); // 지도의 열
		int [][] map = new int[row][col]; // 지도 생성
		int [][] copy = new int[row][col];
		vVisited = new boolean [row][col];
		wallVisited = new boolean [row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++ ) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
			}
		}
		// 맵 초기화 0은 빈칸 , 1은 벽, 2는 바이러스
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++ ) {
				if(map[i][j] !=0)
					wallVisited[i][j] = true;	
			}
		}
		makeWall(map, copy, 0);				
		System.out.println("안전 영역 " + safeArea);
		
	}
	public static void print2(boolean arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void print(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	//복사
	public static void copy(int copy[][], int raw[][]) {
		for(int i = 0; i < raw.length; i++){
			copy[i] = raw[i].clone();
		}
	}
	
	public static void makeWall(int m[][],int[][] c, int wall_count) {
		if(wall_count == 3 ){ //벽을 3개 만들면 재귀 종료
			int temp;
			/*for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++ ) {
					if(c[i][j] == 2) // 각 케이스마다 바이러스 퍼트림
						spreadVirus(i, j, c);	
				}
			}*/
			temp = countSafe(c); //안전지대 카운트
			System.out.println("-------------");
			print(c);
			System.out.println("--------------");
			print2(wallVisited);
			if(temp > safeArea) {
				safeArea = temp; //만약 더 많은 안전지대를 가졌다면 값 변경
				/*System.out.println("-------------");
				System.out.println("최대 안전지대" + safeArea);*/
			
			}	
			return;	
		}else {
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) { //방문하지 않았고 벽을 생성 할 수 있을 때 
					
						if(!wallVisited[i][j] && c[i][j] == 0) {
							c[i][j] = 1;
							wallVisited[i][j] = true;
							makeWall(m,c, wall_count+1);
							
							c[i][j] = 0;
							wallVisited[i][j] = false;
						}	
				}
			}
		}
		
	}
	static class Point{  //현재 위치를 저장하는 클래스
		int row;
		int col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
	}
	// 새로운 위치에서 바이러스 생성이 가능한지 확인하고 퍼트리기
	public static void spreadVirus(int r, int c, int m[][]) {
		
		//들어온 위치를 탐색 시작점으로 잡음
		Queue<Point>queue = new LinkedList<>();
		Point start = new Point(r,c);
		queue.offer(start);
		//새로운 시작점이 들어오면 바이러스가 방문했던 행을 초기화 시켜줌
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				if(m[i][j] ==1)
					vVisited[i][j] = true;
				else
					vVisited[i][j] = false;
			}
		}
		while(!queue.isEmpty()) {
			Point front = queue.poll();
			
			if(vVisited[front.row][front.col]) {
				continue;
			}
			//방문 처리
			vVisited[front.row][front.col] = true;
			
			//가능한 인근 근방 좌표 탐방
			for(int d = 0; d < dir.length; d++) {
				int nr = front.row + dir[d][0];
				int nc = front.col + dir[d][1];
				
				//새로운 지점 근처는 탐방이 가능한가?
				if(isIn(nr, nc) && m[nr][nc] == 0 && !vVisited[nr][nc]) {
					//바이러스 전파
						m[nr][nc] = 2;
						queue.offer(new Point(nr, nc));	
				}				
			}
		}
	}
	//범위 안에 있는가
	public static boolean isIn(int nr, int nc) {
		return nr>=0 && nr <row && nc >=0 && nc<col;
	}
	//안전 영역을 세는 함수
	public static int countSafe(int[][] ary) {
		int count = 0;
		for(int i = 0; i < ary.length; i++) {
			for(int j = 0; j <ary[0].length; j++) {
				if(ary[i][j] == 0)
					count++;
			}
		}
		return count;
	}
}
