package blockingQueue;

public class Consumer extends Thread {
	private BlockingQueue bk;

	public Consumer(BlockingQueue bk) {
		this.bk = bk;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				System.out.println("Consumato " + bk.get());
			} catch (InterruptedException e) {
			}

		}
	}

}
