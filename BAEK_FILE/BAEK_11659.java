package algo_basic_day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BAEK_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		System.out.println(Arrays.toString(s));
		
	}
	
	public static String src = "5 3\r\n" + 
			"5 4 3 2 1\r\n" + 
			"1 3\r\n" + 
			"2 4\r\n" + 
			"5 5";
}
