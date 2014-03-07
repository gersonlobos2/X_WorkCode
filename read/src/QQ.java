

import java.util.*;
import java.lang.*;

public class QQ {
	static double c;
	static int a;
	static int b;
	static int lvl;
	static LinkedList<String> Var = new LinkedList<String>();
	static ArrayList<Integer> Val = new ArrayList<Integer>();
	static String noVar;
	static LinkedList<String> QQ = new LinkedList<String>();
	static Stack<String> stk = new Stack<String>();

	public static String DeQ() {
		String s = (String) QQ.removeFirst();
		return s;
	}

	public static int size(LinkedList<String> a) {
		return a.size();
	}

	static void infix() {
		System.out.println(TP.read());
	}

	static double op(String aS, char opp, String bS) {
		a = Integer.parseInt(aS);
		b = Integer.parseInt(bS);
		switch (opp) {
		case '+':
			c = a + b;
			lvl = 2;
			break;
		case '-':
			c = a - b;
			lvl = 2;
			break;
		case '*':
			c = a * b;
			lvl = 1;
			break;
		case '/':
			c = a / b;
			lvl = 1;
			break;
		case '%':
			c = a % b;
			lvl = 1;
			break;
		}
		return c;
	}

	public static boolean isSub(String string) {// couldnt get to implement
												// this.

		char[] op = { '-', '+', '/', '*', '%' };
		for (int z = 0; z < op.length; z++) {
			if (string.charAt(z) == '-' && string.charAt(z + 1) == op[z]) {
				return false;
			} else if (string.charAt(z) == op[z] && string.charAt(z + 1) == '-') {
				return false;
			}

		}
		return true;
	}

	public static void Var() {
		Scanner in;
		in = new Scanner(System.in);
		String var;
		System.out.println("Enter the variables used(If none, enter none):  ");
		var = in.next();
		for (int x = 0; x < var.length(); x++) {
			if (var.equals("none"))
				break;
			Var.addLast("" + var.charAt(x));
		}
	}

	public static void varVal() {

		for (int x = 0; x < Var.size(); x++) {
			Scanner in;
			in = new Scanner(System.in);
			int val;
			System.out.println("Enter the value for the variable " + Var.get(x)
					+ "= ");
			val = in.nextInt();
			Val.add(val);

		}
		System.out.println((Var));
		System.out.println(Val);
	}

	public static void replaceVar(String str) {

		for (int x = 0; x < Var.size(); x++) {
			Scanner in;
			in = new Scanner(str);
			in.next();
			String val = Val.get(x).toString();
			str = str.replaceAll(Var.get(x), val);
		}
		noVar = str;
		System.out.println(noVar);
	}

	public static void postfix(String str) {
		String chNum = "";
		String chOp;

		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] op = { '-', '+', '/', '*', '%', '(', ')' };
		for (int x = 0; x < str.length(); x++) {

			int i = x + 1;
			if (i < str.length()) {
				for (int y = 0; y < num.length; y++) {
					if (str.charAt(x) == num[y] && str.charAt(i) == num[y]) {
						chNum = chNum.replace(chNum, chNum + str.charAt(x));

					} else if (str.charAt(x) == num[y]
							&& str.charAt(i) != num[y]) {
						chNum = chNum.replace(chNum, chNum + str.charAt(x));
						QQ.addLast(chNum);
						chNum = "";
					}
				}
				for (int z = 0; z < op.length; z++) {
					if (str.charAt(x) == op[z] && str.charAt(i) != op[z]) {
						chOp = "" + str.charAt(x);
						stk.push(chOp);
					} else if (str.charAt(x) == op[z] && str.charAt(i) == op[z]) {
						if (str.charAt(z) == '-' && str.charAt(i) == op[z]) {

						} else if (str.charAt(z) == op[z]
								&& str.charAt(i) == '-') {

						}

					}
				}

			} else {
				for (int y = 0; y < num.length; y++) {
					if (str.charAt(x) == num[y]) {
						chNum = chNum.replace(chNum, chNum + str.charAt(x));
						QQ.addLast(chNum);
						chNum = "";
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		infix();
		Var();
		varVal();
		replaceVar(TP.read());
		postfix(noVar);
		System.out.println(stk);
		System.out.println(QQ);

	}
}
