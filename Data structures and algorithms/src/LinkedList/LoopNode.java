package LinkedList;

/*
 * 节点类，可以组成链表（单链表）
 */
public class LoopNode {

	// 节点内容
	int data;
	// 下一个节点
	LoopNode next = this;

	public LoopNode(int data) {
		this.data = data;
	}

	/*
	 * 获取下一个节点
	 */
	public LoopNode next() {
		return this.next;
	}

	/*
	 * 删除一个节点
	 */
	public void removeNext() {
		// 因为是单链表，找不到上一个节点，所以只能删除当前节点的下一个节点
		// 取出下下一个节点
		LoopNode newNode = this.next.next;
		// 把下下个节点设置为当前节点的下一个节点
		this.next = newNode;
	}
	
	/*
	 * 插入一个节点
	 */
	public void insertAfter(LoopNode node) {
		//单链表只能插入到当前节点后边
		//取出当前节点的下一个节点作为下下个节点
		LoopNode next2 = this.next;
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

}
