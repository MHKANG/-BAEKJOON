package algo_basic_day2;

import java.util.Scanner;

public class BAEK_3474 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		int Tc = scanner.nextInt(); //테스트 케이스 수
		int[] array = new int[Tc]; // N을 저장하는 배열
		int[] count_ten = new int [Tc]; // 10이 몇개 나오는지 저장하는 배열
		
		for(int i = 0; i < Tc; i++)
		{
			array[i] = scanner.nextInt();
			//System.out.println(array[i]);
		}
		for(int i = 0; i < Tc; i++)
		{
			count_ten[i] = count_five(array[i]);
		}
		
		for(int i = 0; i < Tc; i++)
		{
			System.out.println(count_ten[i]);
		}
	
	}
	//5의 개수를 구하는 함수
	public static int count_five(int n)
	{
		int count = 0;
		for (int i = 5; i<=n; i*=5) {
			count += n/i;
		}
		return count;
	}
	
	/*public static String src = "6\r\n" + 
			"3\r\n" + 
			"60\r\n" + 
			"100\r\n" + 
			"1024\r\n" + 
			"23456\r\n" + 
			"8735373";
			*/
}
