/**
 * Project: A00123456Lab8
 * File: Lab8.java
 * Date: Nov 8, 2015
 * Time: 7:33:59 AM
 */

package a00123456;

import java.util.Random;

/**
 * @author iNoah, A00123456
 *
 */
// Tortiose vs Hare

public class Lab8 implements Runnable {
	private Thread tortoise, hare;
	private Random r = new Random();
	private int[] anArray = new int[2];
	private int counter = 0;
	private boolean flag = true;

	public Lab8() throws InterruptedException {
		tortoise = new Thread(this, "Tortoise");
		hare = new Thread(this, "Hare");

		tortoise.start();
		hare.start();
	}

	/**
	 * Reports the race progress.
	 * With each iteration the accumulated sum for each thread is displayed.
	 * When one of the Threads reaches or surpasses 100 the program reports who
	 * the winner is and then stops.
	 */
	public void report(int sum) {

		if (Thread.currentThread().getName().equals("Tortoise")) {
			anArray[0] = sum;
			counter++;
		} else {
			anArray[1] = sum;
			counter++;
		}
		if (counter % 2 == 0) { // determine if one iteration finished (each iteration has two counter)
			System.out.println("Tortoise" + ": " + anArray[0] + ", Hare: " + anArray[1]);
		}
		if (sum >= 100) {
			flag = false;
			System.out.println(Thread.currentThread().getName() + " WINS!!!");
		}

	}

	/**
	 * Random numbers between 1 and 5 are generated and accumulated here.
	 * Each thread should also be made to sleep so we can follow the program flow.
	 * Progress is displayed with each iteration by calling the report() method.
	 */
	@Override
	public void run() {
		int sum = 0;
		while (flag) {
			sum += (r.nextInt(5) + 1);
			report(sum);
			try {
				Thread.sleep(200);
			} catch (InterruptedException ie) {
			}
		}

	}

	public static void main(String args[]) throws InterruptedException {

		new Lab8();

	}
}