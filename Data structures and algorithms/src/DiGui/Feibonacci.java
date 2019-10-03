package DiGui;

public class Feibonacci {

	public static void main(String[] args) {
		int i = feibonacci(7);
		System.out.println(i);
	}

	/*
	 * 斐波那契数列 1 1 2 3 5 8 13
	 */
	private static int feibonacci(int i) {
		if (i == 1 || i == 2) {
			return 1;
		} else {
			return feibonacci(i - 1) + feibonacci(i - 2);
		}
	}

}
