package BAEK.Algorithm;

import java.util.Scanner;

public class BAEK_17466_NFacmodP {
	
	public static String src = "99999988 99999989";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		long N = sc.nextLong();
		long P = sc.nextLong();
		System.out.println(factorialModP(N,P));
	}
	
	public static long factorialModP(long N, long P) {
		long fac = 1;
		for(long i = N; i >=1; i--) {
			fac = (fac*i)%P;
		}
		return fac;
	}
}
