package BAEK.Algorithm;

import java.util.Scanner;

public class BAEK_15650_N과M_2 {
	//public static String src = "3 1";
	public static int N;
	public static int M;
	public static int[] numAry;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	//	scanner=  new Scanner(src);
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		numAry = new int[M];
		boolean[] visited = new boolean[N];
		
		permutation(numAry, M, 0, visited);
		
	}
	public static void print() {
		for(int d: numAry) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	//오름 차순
	public static boolean checkAry() {
		boolean result = true;
		for(int i = 0; i < numAry.length -1; i++) {
			for(int j = i+1; j < numAry.length; j++) {
				if(numAry[i] > numAry[j]) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	public static void permutation(int[] arr, int r, int count, boolean[] visit ) {
		if(count == r) {
			if(checkAry()) {
				print();
			}
			return ;
		}
		else {
			for(int i = 0; i < N; i++) {
				if(visit[i]== false) {
					visit[i] = true;
					numAry[count] = i+1;
					permutation(arr, r, count+1, visit);
					visit[i] = false;
				}
			}
		}
	}
}
