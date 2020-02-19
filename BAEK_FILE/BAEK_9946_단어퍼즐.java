package BAEK.Algorithm;


import java.util.Scanner;

public class BAEK_9946_단어퍼즐 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 1;
		while(true) {
			String sb1 = sc.next();
			String sb2 = sc.next();
			if(sb2.length() != sb1.length()) //단어 수가 다르면 아예 틀림
			{
				System.out.println("Case " +count+": different");
				count++;
				continue;
			}
			//양끝이 둘다 END일때;
			if(sb1.equals("END") && sb2.equals("END"))
				break;
			boolean visited1[] = new boolean[sb1.length()];
			boolean visited2[] = new boolean[sb2.length()];
			for(int i = 0; i < sb1.length(); i++) {
				for(int j = 0; j < sb2.length(); j++) {
					if(!visited2[j] && sb1.charAt(i) == sb2.charAt(j)) {
						visited1[i] = true;
						visited2[j] = true;
						break;
					}
				}
			}
		
			if(checkSame(visited1) && checkSame(visited2)) {
				System.out.println("Case " +count+": same" );
			}else {
				System.out.println("Case " +count+": different");
			}
			count++;
		}
	}
	public static boolean checkSame(boolean[] ary) {
		for(int i = 0; i < ary.length; i++)
			if(ary[i] == false)
				return false;
		return true;
	}

}
