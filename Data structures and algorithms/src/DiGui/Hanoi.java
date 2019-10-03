package DiGui;

public class Hanoi {

	public static void main(String[] args) {
		hanoi(3, 'A', 'B', 'C');

	}

	/**
	 * 
	 * @param i      一共有i个盘子
	 * @param from   开始的柱子
	 * @param in	  中间的柱子
	 * @param to     目标柱子
	 */
	private static void hanoi(int i, char from, char in, char to) {
		//只剩一个盘子从A移到C
		if (i == 1) {
			System.out.println("第1个盘子从" + from + "移到" + to);
		//无论有多少个盘子，都只认为只有上面所有盘子和最下面一个盘子
		} else {
			// 把上面所有盘子移到中间
			hanoi(i - 1, from, to, in);
			System.out.println("第" + i + "个盘子从" + from + "移到" + to);
			//把上面所有盘子从中间位置移到目标位置
			hanoi(i - 1, in, from, to);
		}
	}

}
