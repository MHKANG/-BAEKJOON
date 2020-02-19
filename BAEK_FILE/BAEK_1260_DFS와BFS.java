package BAEK.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class BAEK_1260_DFS와BFS {
	
	static String src = "5 5 3\r\n" + 
			"5 4\r\n" + 
			"5 2\r\n" + 
			"1 2\r\n" + 
			"3 4\r\n" + 
			"3 1";
	static List<Integer>[] graph;
	
	static boolean[] visited; //방문
	static Stack<Integer> stack;
	static List<Integer> path; //dfs 방문 기록 path 
	static int N, M; //정점의 수, 간선의 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		N = sc.nextInt(); // 정점의 수
		M = sc.nextInt(); // 간선의 수
		int start = sc.nextInt(); // 시작점
		int s, e;
		graph = new List[N+1]; //그래프 생성
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			s = sc.nextInt();
			e = sc.nextInt();
			graph[s].add(e);
			graph[e].add(s);
		}
		for(int i =0; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}
		  dfs(start); 
		  System.out.println(); 
		  bfs(start);	
	}
	public static void dfs(int start) {
		
		visited = new boolean[N+1];
		stack = new Stack<>();
		path = new ArrayList<>();
		//시작점에서 시작
		stack.push(start);
		
		while(!stack.isEmpty()) {
			Integer top = stack.pop();
			
			if(visited[top])
				continue;
			
			visited[top] = true;
			path.add(top);
			//top을 통해서 갈 수 있는 다음 정점 검색
			List<Integer>children = graph[top];
			for(int i = children.size()-1; i >=0 ; i--) {
				Integer child = children.get(i);
				if(!visited[child]) {
					stack.push(child);
				}
			}
		}
		for(int i = 0; i <path.size(); i++) {
			System.out.print(path.get(i)+" ");
		}
	}
	public static void bfs(int start) {
		visited = new boolean[N+1];
		path = new ArrayList<>();
		Queue<Integer>queue = new LinkedList<>();
		
		queue.offer(start);
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			
			if(visited[front])
				continue;
			
			visited[front] = true;
			path.add(front);
			
			List<Integer>children = graph[front];
			
			
			for(int i = 0; i < children.size(); i++) {
				Integer child = children.get(i);
				if(!visited[child]) {
					queue.offer(child);
				}
			}
		}
		for(int i = 0; i <path.size(); i++) {
			System.out.print(path.get(i)+" ");
		}
	}
	
}
