package Array.util;
/*
 * 测试类
 */
public class TestMyArray {

	public static void main(String[] args) {
		MyArray arr = new MyArray();
		int size = arr.size();
		System.out.println(size);
		arr.show();
		arr.add(99);
		arr.add(98);
		arr.add(97);
		arr.show();
		arr.delete(1);
		arr.show();
		size = arr.size();
		System.out.println(size);
		int element = arr.get(0);
		System.out.println(element);
		arr.insert(1, 98);
		arr.show();
		arr.insert(3, 96);
		arr.show();
		arr.insert(4, 95);
		arr.show();
		arr.set(4,94);
		arr.show();
		int i = arr.search(98);
		System.out.println(i);
	}
}
