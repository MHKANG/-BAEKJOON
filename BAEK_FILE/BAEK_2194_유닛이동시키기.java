package BAEK.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2194_유닛이동시키기 {
	private static int M, N, A, B, K;
	private static int[][] map;
	private static boolean[][] visited;
	private static int Answer;
	private static int MIN ;
	private static int dirs[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; // 벽을 map에 세움
		}
		st = new StringTokenizer(br.readLine());
		pos start = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
		st = new StringTokenizer(br.readLine());
		pos end = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
		//최적 경로 값
		//MIN = Math.abs(start.r- end.r) + Math.abs(start.c -end.c);
		Answer = Integer.MAX_VALUE;
		System.out.println(bfs(start, end));
		//print();
	}
	public static void print() {
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < M+1; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
	}
	// 현재 위치(start)에서 범위 안에 벽이 있는지 없는지 테스트
	public static boolean check(int r, int c) {
		if(!isIn(r+(A-1), c+(B-1)) || !isIn(r, c+(B-1)) || !isIn(r+(A-1),c)) {
			return false;
		}
		for(int i = r; i <= r+A-1; i++) {
			for(int j = c; j <= c+B-1; j++) {
				if(map[i][j] == 1) {
					return false;
				}
			}	
		}
		return true;
	}
	public static boolean isIn(int nr, int nc) {
		return nr >= 1 && nr <= N && nc >=1 && nc <=M;
	}
	static class pos implements Comparable<pos>{
		Integer r;
		Integer c;
		Integer depth;
		public pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.depth = d;
		}
		@Override
		public String toString() {
			return "pos [r=" + r + ", c=" + c + ", depth=" + depth + "]";
		}
		@Override
		public int compareTo(pos o) {
			if(this.r.equals(o.r) && this.c.equals(o.c))
				return 0;
			else
				return this.r.compareTo(o.r);
		}
	}
	public static int bfs(pos start, pos end) {
		Queue<pos>q = new LinkedList<>();
		q.offer(start);
		List<pos>path = new ArrayList<>();

		visited = new boolean[N+1][M+1];

		visited[start.r][start.c] = true;
		int depth = 0;
		pos before = new pos(-1, -1, -1);
		while(!q.isEmpty()) {
			pos front = q.poll();
			if(before.depth != front.depth)
				depth++;
			path.add(front);
			System.out.println(front);

			for(int d = 0; d < dirs.length; d++) {
				int nr = front.r + dirs[d][0];
				int nc = front.c + dirs[d][1];
				// 범위 안에 벽이 없어야 하고, 벽자체가 아니어야 하고, 방문하지 않았어야 함
				if(isIn(nr, nc) &&check(nr, nc) && !visited[nr][nc] && map[nr][nc] !=1) {
					visited[nr][nc] = true;
					if(nr == end.r && nc == end.c) { 
						return front.depth+1;
					}
					q.offer(new pos(nr,nc,depth));
				}
			}
			before = front;
		}
		return -1;
	}
}
