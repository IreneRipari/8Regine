package parti;

import java.util.Stack;

public class Karalienes extends Thread {
	private int n;
	private int places[];
	private int column;
	private static Integer solutions = new Integer(0);
	private static Integer startedThreads = 0;
	private static int maxThreads;
	private Stack<Karalienes> stack;

	public Karalienes(int n, int column, int places[]) {
		this.n = n;
		this.column = column;
		this.places = places;
		stack = new Stack<Karalienes>();
	}

	public static void setMaxGSK(int sk) {
		maxThreads = sk;
	}

	private boolean arOk(int row, int column) {
		boolean ok = true;
		int tmpColumn = column - 1;
		for (; tmpColumn >= 1; tmpColumn--) {
			if ((places[tmpColumn] - row) == 0) {
				ok = false;
				break;
			}

			int rowDiff = places[column] - places[tmpColumn];

			if (rowDiff < 0)
				rowDiff = 0 - rowDiff;

			if (rowDiff == column - tmpColumn) {
				ok = false;
				break;
			}
		}
		return ok;
	}

	public void deliojam() {
		for (int i = 1; i <= n; i++) { // dirbam su row
			places[column] = i;
			if (arOk(i, column)) {
				if (column < n) {
					int gSk;
					synchronized (startedThreads) {
						gSk = startedThreads;
					}
					if (gSk < maxThreads) {
						Karalienes kar = new Karalienes(n, column + 1, places.clone());
						kar.start();
						stack.add(kar);
					} else {
						column++;
						deliojam();
						column--;
					}
				}
				if (column == n) {
					Karalienes.incVariantuSkaiciu();
				}
			}
		}

		while (stack.size() != 0) {
			try {
				stack.pop().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Karalienes.incGijuSk();
		deliojam();
		Karalienes.decGijuSk();
	}

	private static synchronized void incVariantuSkaiciu() {
		solutions++;
	}

	private static synchronized void incGijuSk() {
		startedThreads++;
	}

	private static synchronized void decGijuSk() {
		startedThreads--;
	}

	public static int getVariantuSkaiciu() {
		return solutions;
	}

}
