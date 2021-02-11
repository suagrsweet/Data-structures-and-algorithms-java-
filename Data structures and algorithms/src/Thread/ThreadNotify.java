package Thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadNotify {

    List list = new ArrayList();
    public void add(Object o){
        list.add(o);
    }
    public int size(){return list.size();}
    public static void main(String[] args) {
        ThreadNotify threadNotify = new ThreadNotify();
        final Object lock = new Object();
        new Thread(() -> {
            synchronized (lock){
                System.out.println("t2启动");
                if (threadNotify.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
                lock.notify();
            }
        }, "t2").start();
        new Thread(() -> {
            synchronized (lock){
                System.out.println("t1启动");
                for (int i = 0; i < 10; i++) {
                    threadNotify.add(new Object());
                    System.out.println("add" + i);
                    if (threadNotify.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, "t1").start();
    }
}
