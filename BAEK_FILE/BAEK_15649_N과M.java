package algo_basic_day2;

import java.util.Scanner;

public class BAEK_15649_N과M {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//scanner=  new Scanner(src);
		
		int Num = scanner.nextInt();
		int M = scanner.nextInt();
		
		int []arr = new int [Num]; // 몇개의 숫자를 이용하기 위해서 만든 배열
		int []result = new int [Num]; // 중복 되지 않는 M개를 고른 수열
		boolean[] visited = new boolean[Num]; //방문 여부 확인 배열
		// 초기화
		for(int i = 0; i < Num; i++)
			arr[i] = i+1;
		Permutation(arr, result, visited, 0, Num, M);
		
		
		
	}
	// depth는 output에 들어갈 숫자의 값
	public static void Permutation(int[]arr, int[] result,boolean[] visited, int depth, int n, int r)
	{
		//만약에 더 이상 숫자를 집어 넣을 공간이 없다면 현재 까지 채워진 내용을 출력하도록 한다.
		if(depth == r) {
			for(int i = 0; i < r; i++)
			{
				System.out.print(result[i] + " ");
			}
			
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			//방문을 하지 않았기 때문에 false로 초기화가 되어 있어 조건문제 진입한다.
			if(visited[i] != true) {
				//방문을 했기 때문에 값을 true로 변경한다.
				visited[i] = true;
				//현재 위치에 값을 대입한다.
				result[depth] = arr[i];
				Permutation(arr, result, visited, depth+1, n, r); //대입 이후 그 다음 자리수를 계산하기 위해서 재귀 함수를 돌린다.
				//모든 경우가 끝까지 끝났기 때문에 다시 처음부터 다시 배치를 해야 되기 때문에 방문의 상태를 방문하지 않은 상태로 변경한다.
				visited[i] = false;
			}
		}
		
	}
	
	//public static String src = "4 2";
}
