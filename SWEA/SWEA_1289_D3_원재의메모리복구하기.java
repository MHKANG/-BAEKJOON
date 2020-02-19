package algo_basic_day1;

import java.util.Scanner;

public class SWEA_1289_D3_원재의메모리복구하기 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(src); 
		int T = scanner.nextInt();
		
		for (int i = 1; i <=T; i++)
		{
			int count = 0;
			
			sb.append("#").append(i).append(" ");
			String data = scanner.next();
			char[] compare = new char[data.length()];
			
			//맨 처음 포맷된 0으로 이루어진 배열 선언
			for (int k = 0; k < data.length(); k++)
				compare[k] = '0';
			
			for(int j = 0; j < data.length(); j++)
			{
				if((data.charAt(j)!=(compare[j])))
				{
					count+=1;
					for(int x = j ; x<data.length(); x++)
						compare[x] = data.substring(j,j+1).charAt(0);
					if(String.valueOf(compare).equals(data))
					{
						break;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	/*public static String src = "2\r\n" + 
			"0011\r\n" + 
			"100";
			*/
}
