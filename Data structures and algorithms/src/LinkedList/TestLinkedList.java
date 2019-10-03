package LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		//单链表测试
//		Node node = new Node(1);
//		node.append(new Node(2));
//		node.append(new Node(3));
//		node.append(new Node(4)).append(new Node(5));
//		System.out.println(node.next().next().next().isLast());
//		node.show();
//		node.removeNext();
//		node.show();
//		node.next.removeNext();
//		node.show();
//		node.insertAfter(new Node(2));
//		node.show();
//		node.next().next().insertAfter(new Node(4));
//		node.show();
//		node.next().next().next().next().insertAfter(new Node(6));
//		node.show();
		
		//循环链表测试
//		LoopNode loop1 = new LoopNode(1);
//		LoopNode loop2 = new LoopNode(2);
//		LoopNode loop3 = new LoopNode(3);
//		LoopNode loop4 = new LoopNode(4);
//		loop1.insertAfter(loop2);
//		loop2.insertAfter(loop3);
//		loop3.insertAfter(loop4);
//		System.out.println(loop4.next().getData());
		
		//双向循环链表测试
		DoubleNode n1 = new DoubleNode(1);
		DoubleNode n2 = new DoubleNode(2);
		DoubleNode n3 = new DoubleNode(3);
		n1.after(n2);
		n2.after(n3);
		System.out.println(n1.getPre().getData());
		System.out.println(n1.getData());
		System.out.println(n1.getNext().getData());
	}

}
