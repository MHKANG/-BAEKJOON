package algo.day8;

import java.util.Scanner;



public class SWEA_1231_D4_중위순회 {
	private static StringBuilder sb = new StringBuilder();
	private static Node [] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = 10;
		for(int t = 1; t <=TC; t++) {
			int nodeCnt = Integer.parseInt(sc.nextLine());
			tree = new Node[nodeCnt +1];
			
			for(int i = 1; i <= nodeCnt; i++) {
				String[] splited = sc.nextLine().split(" ");
				int N = Integer.parseInt(splited[0]);
				String alpha = splited[1];
				Node node = getNode(N);
				node.v = alpha;
				if(splited.length>=3)
					node.left = getNode(Integer.parseInt(splited[2]));
				if(splited.length>=4)
					node.right = getNode(Integer.parseInt(splited[3]));
			}
			StringBuilder temp = new StringBuilder();
			inOrder(tree[1], temp);
			sb.append(String.format("#%d %s%n", t, temp));
		}
		System.out.println(sb);
	}
	public static Node getNode(int n) {
		if(tree[n] == null) {
			tree[n] = new Node(n);
		}
		return tree[n];
	}
	
	private static void inOrder(Node node, StringBuilder temp) {
		if(node != null) {
			inOrder(node.left, temp);
			temp.append(node.v);
			inOrder(node.right, temp);
		}
	}
	
	private static class Node{
		int n;
		String v;
		Node left, right;
		public Node(int n) {
			this.n = n;
		}
		
	}
}
