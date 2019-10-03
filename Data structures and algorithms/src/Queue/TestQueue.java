package Queue;

public class TestQueue {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.add(9);
		queue.add(8);
		queue.add(7);
		System.out.println(queue.poll());
		queue.add(6);
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty());
	}

}
