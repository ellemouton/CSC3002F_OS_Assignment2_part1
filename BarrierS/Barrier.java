package BarrierS;
import java.util.concurrent.Semaphore;

public class Barrier {
	
	Semaphore barrier;
	Semaphore mutex;
	int barCapacity;
	int count= 0;
	
	Barrier(int n) {
		barrier = new Semaphore(0);
		mutex = new Semaphore(1);
		barCapacity = n;
	}
	
	public void b_wait() throws InterruptedException{

		//count the number of threads waiting at the barrier
		mutex.acquire();
		count++;
		mutex.release();

		//once the number of threads reaches the barrier capacity, the last thread will signal the barrier and thus allow another thread to pass through
		if(count==barCapacity){
			barrier.release();
		}

		//as a thread passes through the barrier, it signals the barrier again for the next thread
		//This is a turn-style
		barrier.acquire();
		barrier.release();

	}

}
