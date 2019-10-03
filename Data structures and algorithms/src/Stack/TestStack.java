package Stack;

public class TestStack {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(7);
		stack.push(8);
		stack.push(9);
		int element = stack.pop();
		System.out.println(element);
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		System.out.println(stack.isEmpty());
	}

}
