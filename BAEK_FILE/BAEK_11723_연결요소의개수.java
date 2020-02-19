package algo.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_11723_연결요소의개수 {
	static List<Integer>[]graph = null;
	static boolean[] visited; //각 정점에 대한 방문 여부

	static int V;
	static String src = "6 5\r\n" + 
			"1 2\r\n" + 
			"2 5\r\n" + 
			"5 1\r\n" + 
			"3 4\r\n" + 
			"4 6";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		V = sc.nextInt(); //정점의 수
		int E = sc.nextInt(); //간선의 수

		graph = new List[V+1];
		visited = new boolean[V+1];
		for(int i = 1; i <= V ; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 1; i <= E; i++) { //그래프 생성
			int s = sc.nextInt();
			int e = sc.nextInt();
			// 입력 확인 
			// 그래프 구성 - 무방향 그래프
			graph[s].add(e);
			graph[e].add(s);
		}
		int cnt = 0;
		for(int i = 1; i <=V; i++) {
			if(!visited[i]) {
				visited[i] = true;
				bybfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		//bfs();


	}
	public static void bybfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);

		while(!q.isEmpty()) {
			int front = q.poll();
			List<Integer>childs = graph[front];
			for(int child: childs) {
				if(!visited[child]) {
					visited[child] = true;
					q.offer(child);
				}
			}
			
		}
	}
		public static void bfs() {
			Queue<Integer> q = new LinkedList<>();
			int cnt = 0;
			for(int i =1 ; i < V; i++){
				if(!visited[i]){
					visited[i] = true;
					q.offer(i);
					cnt++;
				}

				while(!q.isEmpty()) {
					Integer front = q.poll();
					List<Integer> children = graph[front];
					for(int j = 0; j< children.size(); j++) {
						if(!visited[children.get(j)]) {
							visited[children.get(j)] = true;
							q.offer(children.get(j));
						}
					}
				}
			}

			System.out.println(cnt);
		}
	}
