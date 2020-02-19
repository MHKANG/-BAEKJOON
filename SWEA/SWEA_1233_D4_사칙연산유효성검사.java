package algo.day8;


import java.util.Scanner;

public class SWEA_1233_D4_사칙연산유효성검사 {
	private static Node[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = 10;
		for(int t = 1; t <=TC; t++) {
			int N = Integer.parseInt(sc.nextLine());
			tree = new Node[N+1];
			for(int i = 0; i < N; i++) {
				String[] splited = sc.nextLine().split(" ");
				int ver = Integer.parseInt(splited[0]);
				Node node = getNode(ver);
				String val = splited[1];
				node.val = val;
				if(splited.length >=3)
					node.left = getNode(Integer.parseInt(splited[2]));
				if(splited.length >=4)
					node.right = getNode(Integer.parseInt(splited[3]));	
			}
			System.out.print("#" + t + " ");
			StringBuilder sb = new StringBuilder();
			inorder(tree[1], sb);
			if(check(sb))
				System.out.println(1);
			else
				System.out.println(0);
	
		}
	}
	private static boolean checkCal(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
	private static boolean check(StringBuilder sb) {
		boolean check = true;
		for(int i = 0; i < sb.length()-1; i++) {
			if(checkCal(sb.charAt(i))&& checkCal(sb.charAt(i+1)))
				check = false;
				
		}
		return check;
	}
	private static void inorder(Node node, StringBuilder sb) {
		if(node != null) {
			inorder(node.left, sb);
			sb.append(node.val);
			inorder(node.right, sb);
		}
			
	}
	private static Node getNode(int ver) {
		if(tree[ver] == null)
			tree[ver] = new Node(ver);
		return tree[ver];
	}
	private static class Node{
		int vertex;
		String val;
		Node left, right;
		public Node(int vertex) {
			super();
			this.vertex = vertex;
		}
		@Override
		public String toString() {
			return "[=" + val + "]";
		}
		
	}
}
