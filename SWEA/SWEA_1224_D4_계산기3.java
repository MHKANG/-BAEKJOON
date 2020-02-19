package algo.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224_D4_계산기3 {
	
	static String src = "113\r\n" + 
			"(9+(5*2+1)+(3*3*7*6*9*1*7+1+8*6+6*1*1*5*2)*4*7+4*3*8*2*6+(7*8*4*5)+3+7+(2+6+5+1+7+6+7*3*(6+2)+6+6)*2+4+2*2+4*9*3)\r\n" + 
			"85\r\n" + 
			"(4+8+4*(8*5*(7*(6*8)+3+(6+(3+7+1*7*5*4)*3)*2*3+5)+6+7*7)*4+2+9*4+7+2*3*(7*6*1*8)+9+9)\r\n" + 
			"97\r\n" + 
			"(9*5+7+8+6+3+9*2+1+7+4+3+9*3*1+4*(4+4*3*1+9*3+(9*5)*1*7*8+2+8+8*7+9*4*9)+(1+1*8+8*9*7+1*4*5*2*5))\r\n" + 
			"89\r\n" + 
			"((3*1*4+6*3+8+4+5+4+2*1+5+3*4)*1+1+(3*2*2+9+5*4*6*9+9+4+1*8+9)*4*8+9+3*7+9*6*9*5+8+3*8+1)\r\n" + 
			"125\r\n" + 
			"(2+(6*5+6+5+3*9+6+2+8*2+2)+6+2*2+2*5*1*2+1*8+1*(4+7*5+8+9+7+3*8*5)+(2+9+5*4*4+1+3*9*6*4*5+(5*(3+4)*9+8+7+9*2)+7+7+2)+8+2+7+5)\r\n" + 
			"113\r\n" + 
			"(8+8*6+3*9*8*7*6*3+5*(7*6*6+3*5+2*4*9*3+5+2+1*4)*1*7+6*8+9+3+2+8*3+8*(2+6*9+2*2*7+8*1*2+9*3+1+5)*(5*8+4*1*2*4*2))\r\n" + 
			"115\r\n" + 
			"(7+9*2+6+5*7+1*7*(9+8+6)*1*2+7+5*9*6*3+4*8*9*6*1*3+7*1+2+5+1*4*9+6*4+7*1*2*4*2+3+((3*4+9+7*1+7+5+3*7*1*7+8*3*8)+7))\r\n" + 
			"99\r\n" + 
			"(9*4+(1+5*7*8+9+1+2)+5+(6*(7+4*5*2+4+8*4+7)+9)*1*3*1+1*2*8+3+(2+9*(1*5*9+7*1+1+7+3*2))+1+3*7*8+9*6)\r\n" + 
			"75\r\n" + 
			"(2*2+((7+8*8*6+(6*6)*7+7*1)*5)*7+3+1*5+1*8*4+(9+6+(7*5+3+1*8*8*9+4+7+9)*3))\r\n" + 
			"117\r\n" + 
			"(8+6*9+2*3+4+2+(6+9+3+7*5*1+2+2+2)*9+4+6*1+6*4+7+7*2+5+2*6*(8*9*8*6+4*2)*5+5*8*3+(6+1+3+3*8*1*2*1+5+6)+1+5+4*7*1*3+1)\r\n" + 
			"";
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		// 총 10개의 test case
		for(int tc= 1; tc <=10; tc++) {
			int N = sc.nextInt(); //문자 열 길이
			String data = sc.next();
			List<Character> postfix = getPostfixNotation(data);
			int result = calculate(postfix);
			
			System.out.println("#"+ tc +" " + result);
		}
	}
	public static int getOrder(char c) {
		if(c == '*'  || c == '/')
			return 4;
		else if(c == '+' || c == '-')
			return 3;
		else if( c== '(')
			return 2;
		else if( c== ')')
			return 1;
		else
			return 0;
	}
	//후위 연산식 계산 함수
	public static int calculate(List<Character> Postfix) {
		Stack<Integer> stack = new Stack<>();
		for(Character c : Postfix) {
			if(getOrder(c) == 0)
				stack.push(c-'0');
			else {
				Integer num1 = stack.pop();
				Integer num2 = stack.pop();
				if(c == '+') {
					stack.push(num2 + num1);
				}
				else if(c == '-') {
					stack.push(num2 - num1);
				}
				else if(c == '*') {
					stack.push(num2 * num1);
				}else
					stack.push(num2 / num1);
			}
		}
		return stack.pop();
	}
	// 입력된 문자열을 후위 연산식으로 변경 함수
	public static List<Character> getPostfixNotation(String data){
		// 출력된 결과를 가질 리스트
		List<Character> postfixNotation = new ArrayList<>();
		// 연산자의 정보를 저장할 Stack
		Stack<Character> stack = new Stack<>();
		
		// 받아온 문자열 파싱 후 처리
		for(int i = 0; i < data.length(); i++) {	
			// 데이터와 그 우선 순위를 확인한다.
			char c = data.charAt(i);
			int order = getOrder(c);
			
			if(order == 0) {  //단순 숫자는 출력
				postfixNotation.add(c);
			}else if(order == 2) { // '(' 는 무조건 push
				stack.push(c);
			}else if(order == 1) { // ')' 여는 괄호를 만날 때까지 pop
				while(true) {
					char top = stack.pop();
					if(top == '(')
						break;
					else {
						postfixNotation.add(top);
					}
				}
			}else { //일반 연산자가 왔을 경우
				while(true) {
					
					if(stack.isEmpty()) {
						break;
					}
					char top = stack.peek();
					if(order <= getOrder(top)) {
						postfixNotation.add(stack.pop());
					}else {
						break;
					}
					
				}
				//가장 높은 우선 순위를 가졌기 때문에 stack에 추가 된다.
				stack.push(c);
			}
		}
		// stack에 남아 있는 값들을 소진
		while(!stack.isEmpty()) {
			postfixNotation.add(stack.pop());
		}
		return postfixNotation;
	}
}
