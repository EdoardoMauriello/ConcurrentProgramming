package blockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	public final int BUFFSIZE;
	private int number;
	private Queue<Integer> queue;

	public BlockingQueue(int buffersize) {
		BUFFSIZE = buffersize;
		queue = new LinkedList<>();
		number = 0;
	}

	public synchronized void put(int val) throws InterruptedException {
		while (number >= BUFFSIZE) {
			wait();
		}
		queue.add(val);
		number++;
		notify();
	}

	public synchronized int get() throws InterruptedException {
		while (number == 0) {
			wait();
		}
		int temp = queue.remove();
		number--;
		notify();
		return temp;
	}

	public static void main(String[] args) {
		BlockingQueue bk = new BlockingQueue(4);
		Producer prod = new Producer(bk);
		Consumer cons = new Consumer(bk);
		prod.start();
		cons.start();
	}
}
