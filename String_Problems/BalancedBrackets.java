package String_Problems;

import java.util.Stack;

//If we encounter  opening bracket push it to the stack 
//as soon as we get any type of closing bracket 
//we will pop the last item & matches its corresponding bracket 
//s = [() => for such cases we have to check at the end whether the stack is empty or not
//If its empty then only we can say its balanced
//S = ]() => here we encounter closing bracket at first and stack is empty. So its unbalanced
public class BalancedBrackets {

	public boolean checkBalancedBrackets(String s) {

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
				st.push(s.charAt(i));
			} else {
				if (st.isEmpty())
					return false; // S = ]()
				char c = st.pop();

				if (!((c == '{' && s.charAt(i) == '}') || (c == '[' && s.charAt(i) == ']')
						|| (c == '(' && s.charAt(i) == ')'))) {
					return false;

				}
			}
		}
		return st.isEmpty(); // s = [()

	}
}
