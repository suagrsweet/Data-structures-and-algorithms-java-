package Queue;
/*
 * 队列工具类
 */
public class MyQueue {

	int[] elements;
	
	public MyQueue() {
		elements = new int[0];
	}
	
	/*
	 * 入队
	 */
	public void add(int element) {
		//创建新数组
		int[] newArr = new int[elements.length + 1];
		//把原数组中的值复制到新数组
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i];
		}
		//目标元素放置队列末尾
		newArr[elements.length] = element;
		//替换数组
		elements = newArr;
	}
	
	/*
	 * 出队
	 */
	public int poll() {
		if(elements.length == 0) {
			throw new RuntimeException("队列为空");
		}
		//出队元素
		int element = elements[0];
		//创建新数组
		int[] newArr = new int[elements.length - 1];
		//把剩余元素复制到新数组
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = elements[i + 1];
		}
		elements = newArr;
		//返回出队元素
		return element;
	}
	
	/*
	 * 是否为空
	 */
	public boolean isEmpty() {
		return elements.length == 0;
	}
}
