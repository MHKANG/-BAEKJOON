package algo_basic_day2;

public class SWEA_1954_D2_응용_역달팽이 {

	public static void main(String[] args) {
		
		revSnail(4);
	}
	
	public static void revSnail(int N) {
		int [][] snail = new int [N][N];
		int direction = 1;
		int col = N;
		int row = 0;
		int number = 1;
		int move = N;
		//이동 해야 하는 횟수
		while (true) {
			if(move == 0)
				break;
			
			for(int i = 0; i < move; i++) {
				col -= direction;
				snail[row][col] = number;
				number++;
			}
			move--;
			for(int j = 0; j < move; j++ ) {
				row += direction;
				snail[row][col] = number;
				number++;
			}
			direction *= -1;
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j <N; j++)
			{
				System.out.print(snail[i][j] +"  ");
			}
			System.out.println();
		}
	}
}
