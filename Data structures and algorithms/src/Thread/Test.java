package Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现4个线程，两个对j每次加1，两个每次对j减1
 */
class TestThread{
    private int j;
    public synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }
    public synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }
}

public class Test {
    public static void main(String[] args) {
        TestThread t = new TestThread();
        for(int i = 0; i < 2; i++){
            Thread inc = new Thread(new Inc(t));
            Thread dec = new Thread(new Dec(t));
            inc.start();
            dec.start();
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
    }
}

class Inc implements Runnable{
    private TestThread obj;
    public Inc(TestThread obj){
        this.obj=obj;
    }
    @Override
    public void run() {
        this.obj.inc();
    }
}

class Dec implements Runnable{
    private TestThread obj;
    public Dec(TestThread obj){
        this.obj=obj;
    }
    @Override
    public void run() {
        this.obj.dec();
    }
}
