package ChatHouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ChatClient {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String name;
	private LinkedList<String> list = new LinkedList<>();
	private boolean inputFlag;

	public void start() {
		try {
			System.out.println("昵称：");
			name = new Scanner(System.in).nextLine();
			socket = new Socket("192.168.17.1", 8000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
			// 1.把呢城发送到服务器根据ip
			out.println(name);
			out.flush();
			// 启动接收线程，执行阻塞的接收数据操作
			new Thread() {
				@Override
				public void run() {
					receive();
				}
			}.start();
			// 打印线程
			new Thread() {
				@Override
				public void run() {
					print();
				};
			}.start();
			// 启动输入线程，执行阻塞获得输入操作
			new Thread() {
				@Override
				public void run() {
					input();
				};
			}.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void print() {
		while (true) {
			synchronized (list) {
				while (list.size() == 0 || inputFlag) {
					try {
						list.wait();
					} catch (InterruptedException e) {
					}
				}
				String msg = list.removeFirst();
				System.out.println(msg);
			}
		}
	}

	protected void receive() {
		try {
			String line;
			while ((line = in.readLine()) != null) {
				synchronized (list) {
					list.add(line);
					list.notifyAll();
				}
			}
		} catch (Exception e) {
		}
		System.out.println("您已经离开了聊天室");
	}

	protected void input() {
		System.out.println("按回车输入聊天内容");
		while (true) {
			new Scanner(System.in).nextLine();
			inputFlag = true;// 开始输入
			System.out.print("输入聊天内容：");
			String s = new Scanner(System.in).nextLine();
			out.println(s);
			out.flush();
			inputFlag = false;// 输入结束
			synchronized (list) {
				list.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		ChatClient c = new ChatClient();
		c.start();
	}

}
