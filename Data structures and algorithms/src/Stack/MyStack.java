package Stack;
/*
 * 栈工具类
 */
public class MyStack {

	// 栈的底层我们使用数组存储数据
	int[] elements;

	public MyStack() {
		elements = new int[0];
	}

	/*
	 * 压入元素
	 */
	public void push(int element) {
		// 创建新数组，长度为原数组加1
		int[] newArr = new int[elements.length + 1];
		// 把原数组元素复制到新数组
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i];
		}
		// 添加新元素到新数组末尾
		newArr[elements.length] = element;
		// 新数组替换原数组,原数组会被垃圾回收器回收掉
		elements = newArr;
	}
	
	/*
	 * 取出栈顶元素
	 */
	public int pop() {
		if(elements.length == 0) {
			throw new RuntimeException("stack is empty");
		}
		//取出数组最后一个元素
		int element = elements[elements.length - 1];
		//创建新数组
		int[] newArr = new int[elements.length - 1];
		//将剩余的元素复制到新数组
		for(int i = 0; i < newArr.length; i++) {
			newArr[i] = elements[i];
		}
		//替换数组
		elements = newArr;
		//返回栈顶元素
		return element;
	}
	
	/*
	 * 查看栈顶元素
	 */
	public int peek() {
		if(elements.length == 0) {
			throw new RuntimeException("stack is empty");
		}
		return elements[elements.length - 1];
	}
	
	/*
	 * 判断栈是否为空
	 */
	public boolean isEmpty() {
		return elements.length == 0;
	}
}
