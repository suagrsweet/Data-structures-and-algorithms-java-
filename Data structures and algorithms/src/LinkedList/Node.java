package LinkedList;

/*
 * 节点类，可以组成链表（单链表）
 */
public class Node {

	// 节点内容
	int data;
	// 下一个节点
	Node next;

	public Node(int data) {
		this.data = data;
	}

	/*
	 * 获取下一个节点
	 */
	public Node next() {
		return this.next;
	}

	/*
	 * 追加节点
	 */
	public Node append(Node node) {
		// 当前节点
		Node currentNode = this;
		// 循环向后找
		while (true) {
			// 取出下一个节点
			Node nextNode = currentNode.next;
			// 如果下一个节点为空，则当前节点是最后一个节点
			if (nextNode == null) {
				break;
			}
			// 当前节点永远是最后一个节点
			currentNode = nextNode;
		}
		// 追加节点到最后一个节点
		currentNode.next = node;
		return this;
	}

	/*
	 * 删除一个节点
	 */
	public void removeNext() {
		// 因为是单链表，找不到上一个节点，所以只能删除当前节点的下一个节点
		// 取出下下一个节点
		Node newNode = this.next.next;
		// 把下下个节点设置为当前节点的下一个节点
		this.next = newNode;
	}
	
	/*
	 * 插入一个节点
	 */
	public void insertAfter(Node node) {
		//单链表只能插入到当前节点后边
		//取出当前节点的下一个节点作为下下个节点
		Node next2 = this.next;
		//新节点为当前节点的下个节点
		this.next = node;
		//next2为新节点的下一个节点
		node.next = next2;
	}

	/*
	 * 获取节点内容
	 */
	public int getData() {
		return this.data;
	}

	/*
	 * 是否为最后一个节点
	 */
	public boolean isLast() {
		return next == null;
	}

	/*
	 * 显示所有节点
	 */
	public void show() {
		// 定位当前节点
		Node currentNode = this;
		// 遍历输出所有节点
		while (true) {
			System.out.print(currentNode.data + "->");
			// 取出下一个节点
			currentNode = currentNode.next;
			if (currentNode == null) {
				break;
			}
		}
		System.out.println();
	}
}
