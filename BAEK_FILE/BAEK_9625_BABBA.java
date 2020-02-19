package BAEK.Algorithm;

import java.util.Scanner;

public class BAEK_9625_BABBA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		int calA = 1; // A를 나타냄 A -> B
		int calB = 0; // B를 나타냄 B -> BA
		
		if(k == 0) {
			calA =1; calB = 0;
		}else if( k == 1) {
			calA = 0; calB = 1;
		}else {
			
			calA = fibonacci(k-2);
			calB = fibonacci(k-1);
		}
		
		System.out.println(calA + " " + calB);
	
	}
	public static int fibonacci(int k) {
		int n1 = 1;
		int n2 = 1;
		int result = 0;
		if( k == 0 || k == 1 )
			return 1;
		else {
			for(int i = 2; i <= k; i++) {
				result = n1 + n2;
				n1 = n2;
				n2 = result;
			}
			return result;
		}
	}
}
