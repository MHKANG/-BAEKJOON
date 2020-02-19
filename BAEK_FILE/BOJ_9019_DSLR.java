package BAEK.Algorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {
	private static int A, B;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <=T ; t++) {
			
			A = sc.nextInt();
			B = sc.nextInt();
			
			dfs(A, B);
		}
		
		
		/*System.out.println(MethodL(1000));
		System.out.println(MethodR(1000));
		System.out.println(MethodD(5001));*/
		
	}
	public static void dfs(int A, int B) {
		Queue<Command>q = new LinkedList<>();
		
		q.offer(new Command(A, '\u0000'));
		StringBuilder sb = new StringBuilder();   
		while(!q.isEmpty()){
			
			Command front = q.poll();
			
			//sb.append(front.command);
			System.out.println(front.val);
			if(MethodD(front.val) == B) {
				//System.out.println(sb);
				return ;
			}else if(front.val  == B) {
				//System.out.println(sb);
				return ;
			}else if(front.val == B) {
				//System.out.println(sb);
				return ;
			}else if(front.val == B ) {
				//System.out.println(sb);
				return ;
			}
			q.offer(new Command(MethodD(front.val), 'D'));
			q.offer(new Command(MethodS(front.val), 'S'));
			q.offer(new Command(MethodL(front.val), 'L'));
			q.offer(new Command(MethodR(front.val), 'R'));
		}
	}
	static class Command{
		int val;
		char command;
		public Command(int val, char command) {
			this.val = val;
			this.command = command;
		}
		@Override
		public String toString() {
			return "Command [val=" + val + ", command=" + command + "]";
		}
		
	}
	public static int MethodD(int a) {
		
		if(a*2 > 10000) {
			a = (a*2)%10000;
				return a;
		}else {
			return a*2;
		}
	}
	public static int MethodS(int a) {
	
		if(a == 0) {
			a = 9999;
			return a;
		}else {
			return a-1;
		}
	}
	public static int MethodL(int A) {
		String a = Integer.toString(A);
		char[] c1 = a.toCharArray();
		char c0 = c1[0];
		for(int i = 0; i <a.length()-1; i++) {
			c1[i] = c1[i+1];
		}
		c1[a.length()-1] = c0;
		String result = new String(c1);
		int i;
		for(i = 0; i < result.length(); i++) {
			if(result.charAt(i) != '0')
				break;
		}
		result = result.substring(i);
		//System.out.println(result);
		A = Integer.parseInt(result);
		return A;
				
	}
	public static int MethodR(int A) {
		String a = Integer.toString(A);
		char[] c1 = a.toCharArray();
		char c0 = c1[a.length()-1];
		for(int i = a.length()-1; i >0; i--) {
			c1[i] = c1[i-1];
		}
		c1[0] = c0;
		String result2 = new String(c1);
		int i;
		for(i = 0; i < result2.length(); i++) {
			if(result2.charAt(i) != '0')
				break;
		}
		result2 = result2.substring(i);
		A = Integer.parseInt(result2);
		return A;
	}
}
