package BarrierS;
import java.util.concurrent.Semaphore;

public class Barrier {
	
	Semaphore bar;
	Semaphore mutex;
	int barCapacity;
	int count= 0;
	
	Barrier(int n) {
		bar = new Semaphore(0);
		mutex = new Semaphore(1);
		barCapacity = n;
	}
	
	public void b_wait() throws InterruptedException{

		mutex.acquire();
		count++;
		mutex.release();

		if(count>=barCapacity){
			bar.release();
		}

		bar.acquire();
		bar.release();

	}

}
