package LinkedList;
/*
 * 双向链表
 */
public class DoubleNode {

	//下一个节点
	DoubleNode next = this;
	//上一个节点
	DoubleNode pre = this;
	//节点数据
	int data;
	
	public DoubleNode(int data) {
		this.data = data;
	}
	
	/*
	 * 追加节点
	 */
	public void after(DoubleNode node) {
		//取出当前节点的下一个节点，作为新节点的下一个节点
		DoubleNode nextNext = this.next;
		//新节点作为当前节点的下一个节点
		this.next = node;
		//新节点的上一个节点是当前节点
		node.pre = this;
		//新节点的下一个节点是当前节点的下一个节点
		node.next = nextNext;
		//新节点是又是（当前节点的下一个节点）的上一个节点
		nextNext.pre = node;
	}
	
	/*
	 * 获取下一个节点
	 */
	public DoubleNode getNext() {
		return this.next;
	}
	
	/*
	 * 获取上一个节点
	 */
	public DoubleNode getPre() {
		return this.pre;
	}
	
	/*
	 * 获取数据
	 */
	public int getData() {
		return this.data;
	}
}
