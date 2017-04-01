package balance;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(final String [] args) {
		try {
			Scanner scan = new Scanner(System.in);

			if (scan.hasNextLine()) {
				int inputs = Integer.parseInt(scan.nextLine());
				Main solution = new Main();
				while (inputs > 0){
					inputs--;
					if (scan.hasNextLine()){
						System.out.println(solution.isInputBalanced(scan.nextLine()));
					}
				}
			}

		} catch (Exception e) {
		}
	}

	private String isInputBalanced(final String input){
		Stack<String> stack = new Stack<String>();
		String temp = "";
		int depth = 0;
		for (int i = 0;i <= input.length()-1;i++){
			char c = input.charAt(i);
			if (c == ','){
				if (temp.equals("?")){
					depth =  calculateDepth('?', depth);
				}
				stack.push(temp);
				temp = "";
				continue;
			} else {
				String operation = shouldPushOrPop(c);
				if (operation.equals("push")){
					depth =  calculateDepth(c, depth);
					stack.push(c+"");
				} else if (operation.equals("pop")){
					int left = getWeight(stack.pop());
					stack.pop();
					int right = getWeight(temp);
					temp = "";
					try{
						stack.peek();
						String value = calculateWeight(left, right, depth);
						if (value.equals("NO")){
							break;
						}
						temp = value;
					} catch(EmptyStackException ex){
						return compareWeight(left, right, depth);
					}
				} else {
					temp = temp + c;
				}
			}

		}
		return "NO";
	}

	private int calculateDepth(final char c, int depth){
		if (c == '['){
			return 0;
		} else if (c == '?'){
			return ++depth;
		} else {
			return depth;
		}
	}

	private int getWeight(final String value){
		if (value.equals("?")){
			return -1;
		} else {
			return Integer.parseInt(value);
		}
	}

	private String compareWeight(final int left, final int right, final int depth){
		if (left == -1 && right == -1){
			return "YES";
		} else if (left == -1 && right != -1) {
			if (depth == 0){
				return "YES";
			} else {
				if (right % 2 != 0) {
					return "NO";
				} else {
					return "YES";
				}
			}
		} else if (left != -1 && right == -1) {
			if (depth == 0){
				return "YES";
			} else {
				if (left % 2 != 0) {
					return "NO";
				} else {
					return "YES";
				}
			}
		} else {
			if (left == right){
				return "YES";
			}
			else {
				return "NO";
			}
		}
	}

	private String calculateWeight(final int left, final int right, final int depth){
		if (compareWeight(left, right, depth).equals("YES")){
			if (left == -1 && right == -1){
				return "?";
			} else if (left == -1 && right != -1) {
				return (2 * right) + "";
			} else if (left != -1 && right == -1) {
				return (2 * left) + "";
			} else {
				return (left + right) + "";
			}
		} else {
			return "NO";
		}
	}

	private String shouldPushOrPop(final char input){
		if (input == '['){
			return "push";
		} else if (input == ']'){
			return "pop";
		}else {
			return "";
		}

	}
}
