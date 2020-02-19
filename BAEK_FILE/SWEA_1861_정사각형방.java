package BAEK.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1861_정사각형방 {
	static int N;
	static int[][]room;
	static int[][]dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static List<Pos>path;
	static int count , start; // 최대 방 이동 개수 , 시작점 
	static boolean [][]visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <=T; t++) {
			N = sc.nextInt();
			room = new int[N][N];
			count = 0;
			start = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++){
					room[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dfs(i, j);
				}
			}
			System.out.println("#" + t + " " + start +" "+count);
		}
		
	}
	public static void dfs(int r, int c) {
		Stack<Pos>s = new Stack<>();
		visited = new boolean[N][N];
		path = new ArrayList<>();
		s.push(new Pos(r, c));
	
		while(!s.isEmpty()) {
			Pos top = s.pop();
			
			if(visited[top.row][top.col])
				continue;
			path.add(top);
			visited[top.row][top.col] = true;
			for(int d = 0; d<dirs.length; d++) {
				int nr = top.row + dirs[d][0];
				int nc = top.col + dirs[d][1];
				if(isIn(nr,nc) && !visited[nr][nc] && room[top.row][top.col]+1 == room[nr][nc]) {
					s.push(new Pos(nr,nc));
	
				}
			}
		}
		if(path.size() > count) {
			count = path.size();
			start = room[path.get(0).row][path.get(0).col];
		}
		else if(path.size() == count) {
			if(start > room[path.get(0).row][path.get(0).col])
				start = room[path.get(0).row][path.get(0).col];
		}
	}
	public static boolean isIn(int nr, int nc) {
		return nr>=0 && nr <N && nc >=0 && nc <N;
	}
	static class Pos{
		int row;
		int col;
		public Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "Pos [row=" + row + ", col=" + col + "]";
		}	
	}
}
