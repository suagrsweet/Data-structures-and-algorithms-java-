package ChatHouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	private ArrayList<TongXinThread> list = new ArrayList<>();

	public void start() {
		new Thread() {
			@Override
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(8000);
					System.out.println("服务已启动");
					while (true) {
						Socket s = ss.accept();
						TongXinThread t = new TongXinThread(s);
						t.start();
						synchronized (list) {
							list.add(t);
						}
					}
				} catch (Exception e) {
					System.out.println("启动错误");
				}
			}
		}.start();
	}

	class TongXinThread extends Thread {
		Socket socket;
		BufferedReader in;
		PrintWriter out;
		private String name;

		public TongXinThread(Socket socket) {
			super();
			this.socket = socket;
		}

		public void send(String msg) {
			out.println(msg);
			out.flush();
		}

		public void sendAll(String msg) {
			synchronized (list) {
				for (TongXinThread t : list) {
					t.send(msg);
				}
			}
		}
		
		@Override
		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
				out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
				this.name = in.readLine();
				send(name + "welcome");
				synchronized (list) {
					sendAll(name + "进入,在线人数：" + list.size());
				}
				String line;
				while((line = in.readLine()) != null) {
					sendAll(name + "说：" + line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			synchronized (list) {
				list.remove(this);
				sendAll(name + "离开了聊天室，在线人数：" + list.size());
			}
		}
	}

	public static void main(String[] args) {
		ChatServer s = new ChatServer();
		s.start();
	}

}
