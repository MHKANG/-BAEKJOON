package algo.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BAEK_2667_단지번호붙이기 {
	static int map[][];
	static int cnt;
	static int dir[][] = {{0,1}, {0,-1}, {1, 0}, {-1,0}}; //사방 탐색
	static List<Integer>list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 지도의 크기
		 //몇개의 단지가 있는지 확인하기 위한 변수
		String []arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		map = new int[N][N];
		for(int i = 0; i < N; i++) { //지도 초기화
			for(int j = 0; j < N; j++)
				map[i][j] = (arr[i].charAt(j)-'0');
		}
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <N; j++) {
				cnt = 0;
				if(map[i][j] ==1) {
					map[i][j] = 0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);;
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	public static void dfs(int x, int y) {
		cnt++;
		for(int d = 0; d <dir.length; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(isIn(nx, ny) && map[nx][ny] ==1) {
				map[nx][ny] = 0;
				dfs(nx, ny);
			}
		}
	}
	
	public static boolean isIn(int nx, int ny ) {
		return nx>=0 && nx<map.length && ny>=0 && ny <map.length;
	}
}
