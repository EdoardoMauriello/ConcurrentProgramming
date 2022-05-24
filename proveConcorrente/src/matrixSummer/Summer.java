package matrixSummer;

public class Summer extends Thread {
	private final Result res;
	private final int ind;
	private int[] elements;

	public Summer(int[] elements, int ind, Result res) {
		this.res = res;
		this.ind = ind;
		this.elements = elements;
		this.setName("Thread " + ind);
		this.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < elements.length; i++) {
			res.addResult(ind, elements[i]);
		}
		System.out.println(getName() + " ha consegnato");
	}

}
