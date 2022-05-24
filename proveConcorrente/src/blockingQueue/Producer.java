package blockingQueue;

public class Producer extends Thread {
	private BlockingQueue bk;
	private int produced;

	public Producer(BlockingQueue bk) {
		this.bk = bk;
		produced = 0;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
				bk.put(produced++);
				System.out.println("p " + (produced - 1));
			} catch (InterruptedException e) {
			}
		}
	}
}
