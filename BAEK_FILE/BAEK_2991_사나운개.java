package BAEK.Algorithm;

import java.util.Scanner;

public class BAEK_2991_사나운개 {
	

	static int[] man = new int[3];
	static int[] dog1 = new int [2];
	static int[] dog2 = new int [2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		dog1[0] = sc.nextInt();
		dog1[1] = sc.nextInt();
		dog2[0] = sc.nextInt();
		dog2[1] = sc.nextInt();
		for(int i = 0; i <3; i++) {
			man[i] = sc.nextInt();
		}
		for(int i = 0; i < 3; i++) {
			System.out.println(dog1Count(man[i]) + dog2Count(man[i]));
		}
		
		
	}
	public static int dog1Count(int time) {
		int d = dog1[0] + dog1[1];
		int count = -1;
		time = time%d;
		if(time == 0)
			count = 0;
		if(time> 0 && time<dog1[0])
			count = 1;
		if(time<d && time >dog1[0])
			count = 0;
		return count;
	}
	public static int dog2Count(int time) {
		int d = dog2[0] + dog2[1];
		int count = -1;
		time = time%d;
		if(time == 0)
			count = 0;
		if(time> 0 && time<dog2[0])
			count = 1;
		if(time<d && time >dog2[0])
			count = 0;
		return count;
	}
	
		
		
}
