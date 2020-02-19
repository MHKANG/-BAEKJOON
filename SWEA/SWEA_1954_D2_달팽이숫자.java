package algo_basic_day2;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class SWEA_1954_D2_달팽이숫자 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		int [][] arr;
		int tc = scanner.nextInt(); //테스트 케이스
		
		for (int k= 0; k < tc; k++)
		{
			int Num = scanner.nextInt();
			sb.append("#"+Num+"\n");
			arr = new int[Num][Num];
			int row = 0;
			int col = -1;
			int direction = 1; // 방향
			int start = 1; // 맨 처음 시작 숫자
			int count = Num; //최대 돌 수 있는 숫자
			/*예를 들어 달팽이 크기가 5일때 반복문의 횟수가 5 4 4 3 3 2 2 1 이 된다.
			이때 이를 54 43 34 21 이런식으로 하나씩 감소 되는 것으로 묶을 수 있다.*/
			
			while(true) {
				if(count == 0)
					break;
				 /*(좌 우), (상 하) 는 서로 부호만 반대 이기 때문에
				 열과 행에 대한 for문을 돌리고 direction의 부호만 변경 하면 된다.
				 이동 방향은 오른쪽 , 아래 그 다음 왼쪽 위 이다. 
				 i와 j 즉 arr의 열과 행렬을 한번에 처리하고 direction의 부호를 전환하면 된다*/
				//좌 우
				for(int i = 0; i < count; i++) {
					col += direction;
					arr[row][col] = start;
					start++;
				}
				count--;
				// 상하
				for(int j = 0 ; j < count; j++) {
					row += direction;
					arr[row][col] = start;
					start++;
				}
				direction *= -1;
			}
			//출력을 위해 sb에 저장
			for(int i = 0; i < Num; i++) {
				for(int j = 0; j < Num; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		
		}
		System.out.println(sb);
		
		
	}
	
	/*public static String src = "10\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"5\r\n" + 
			"6\r\n" + 
			"7\r\n" + 
			"8\r\n" + 
			"9\r\n" + 
			"10";*/
}
