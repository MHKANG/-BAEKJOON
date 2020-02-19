package algo_basic_day1;

import java.util.Scanner;

public class SWEA_2056_D1_연월일달력 {
	
	private static int [] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src);
		int t = scanner.nextInt(); //전체 테스트 케이스
		for(int i = 0; i < t; i ++)
		{
			//개별 test case 처리.
			sb.append("#").append(i+1).append(" ");
			//전체 날짜를 입력 받음
			String date = scanner.next();
			//년도
			String year = date.substring(0, 4);
			//월
			String month = date.substring(4, 6);
			//일
			String day = date.substring(6);
			//월과 일을 정수형으로 변환
			int monthNum = Integer.parseInt(month);
			int dayNum = Integer.parseInt(day);
			//월은 1~ 12, 각 월에 따른 날짜는 days 배열을 통해서 조건을 정한다.
			if(1<= monthNum && monthNum <=12 && dayNum > 0 && dayNum <=days[monthNum]) {
				sb.append(year).append("/").append(month).append("/").append(day);
			}
			else {
				//조건이 부합하지 않을 경우 -1 
				sb.append(-1);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
	}
	/*private static String src = "5\r\n" + 
			"22220228\r\n" + 
			"20150002\r\n" + 
			"01010101\r\n" + 
			"20140230\r\n" + 
			"11111111";
			*/
}
