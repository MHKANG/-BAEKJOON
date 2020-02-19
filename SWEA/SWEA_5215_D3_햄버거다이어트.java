package algo_basic_day1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_5215_D3_햄버거다이어트 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		int T = scanner.nextInt(); //전체 테스트 케이스
		for(int i = 0; i<T; i++)
		{
			int material = scanner.nextInt(); //햄버거 재료 수
			int cal = scanner.nextInt(); //햄버거 칼로리 제한
			int max_score = Integer.MIN_VALUE;
			int[][] material_array = new int[material][2];
			for(int j = 0; j < material; j++)
			{
				//0 index 점수, 1 index 칼로리
				material_array[j][0] = scanner.nextInt();
				material_array[j][1] = scanner.nextInt();
			}
			//부분 집합 구하는 for문
			for (int k = 0; k < (1<<material); k++) {
				int sum_point = 0;
				int sum_cal = 0;
				List<Integer> subset1 = new ArrayList<>(); //점수만 모은 리스트
				List<Integer> subset2 = new ArrayList<>(); //칼로리만 모은 리스트
				for(int j = 0; j < material; j++) {
					//부분 집합
					if((k & 1 << j) >0) {
						subset1.add(material_array[j][0]);
						subset2.add(material_array[j][1]);
					}
				}
				//각 부분집합별로 칼로리 계산
				for(int x = 0; x < subset2.size(); x++) {
					sum_cal += subset2.get(x); //부분집합 칼로리 합
					sum_point += subset1.get(x); //부분 집합 평가 점수 합
				}
				//제한 칼로리를 넘지 않으면 
				if(sum_cal < cal) {
					if(sum_point > max_score)
						max_score = sum_point;
				}
			}

			System.out.println("#"+(i+1) +" "+max_score);
		}
	}
	/*public static String src = "2\r\n" + 
			"5 1000\r\n" + 
			"100 200\r\n" + 
			"300 500\r\n" + 
			"250 300\r\n" + 
			"500 1000\r\n" + 
			"400 400\r\n" +
			"5 1000\r\n" + 
			"100 200\r\n" + 
			"300 500\r\n" + 
			"250 300\r\n" + 
			"500 1000\r\n" + 
			"400 400";
	*/
			
}
