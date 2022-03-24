package view;

import java.util.concurrent.Semaphore;
import controller.Sala;

public class Principal {
	public static void main(String[] args) {
	int pessoa = 4;
	int dist_total = 200;
	Semaphore semaforo = new Semaphore (1);
	
	for (int i = 0 ; i < pessoa ; i++) {
    new Sala (i, dist_total, semaforo).start();
	}
	}
}



