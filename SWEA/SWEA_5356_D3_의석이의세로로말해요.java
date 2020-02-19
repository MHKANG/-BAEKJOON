package algo_basic_day2;

import java.util.Scanner;

public class SWEA_5356_D3_의석이의세로로말해요 {
	public static void main(String[] args) {
		//StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		int Tc = scanner.nextInt();
		for(int t = 1; t <=Tc; t++) {
			//5줄을 읽어 온다.
			int max = Integer.MIN_VALUE; // 가장 긴 단어의 수를 저장하는 변수
			//읽어 오는 string 문자열을 char 배열로 변환 후 그 배열을 저장하는 함수
			char[][] arr = new char [5][];
			// 가장 긴 스트링을 열의 개수로 하는 배열을 만들어 출력에 사용
			char[][] result_arr;
			for(int j = 0; j < 5; j++)
			{
				char[] arrayChar = scanner.next().toCharArray();
				if(max < arrayChar.length)
					max = arrayChar.length;
				arr[j] = arrayChar;
			}
			result_arr = new char[5][max];
			for(int i = 0; i < 5; i++)
			{
				if(max > arr[i].length){
					for(int j = 0; j < arr[i].length; j++)
					{
						result_arr[i][j] = arr[i][j];
					}
				}
				else {
					for(int j = 0; j < max; j++)
					{
						result_arr[i][j] = arr[i][j];
					}
				}
			}
			System.out.print("#"+t+" ");
			print_col(result_arr);
			
		}
	}
	public static void print_col(char[][] arr) {
		StringBuilder sb1 = new StringBuilder();
		int row = 0;
		int col = 0;
		for(int i = 0; i< arr[0].length; i++) {
			for(int j = 0; j < arr.length; j++)
			{
				if(arr[j][i] == '\0' )
				{
					
				}
				else {
					sb1.append(arr[j][i]);
				}
			}
		}
		System.out.println(sb1);
	}

	/*public static String src = "2\r\n" + 
			"ABCDE\r\n" + 
			"abcde\r\n" + 
			"01234\r\n" + 
			"FGHIJ\r\n" + 
			"fghij\r\n" + 
			"AABCDD\r\n" + 
			"afzz\r\n" + 
			"09121\r\n" + 
			"a8EWg6\r\n" + 
			"P5h3kx";*/
}
