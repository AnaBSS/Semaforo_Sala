package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Sala extends Thread {
	public int pessoa;
	private int dist_andada= 0;
	public int dist_total;
	public static int andar = 0;
	private Semaphore semaforo;
	
	
	
	public Sala(int pessoa, int dist_total, Semaphore semaforo) {
		this.pessoa = pessoa;
		this.dist_total = dist_total;
		this.semaforo = semaforo;
	}

	
	
	public void PessoaAndando() {
		andar++;
		int andou = new Random().nextInt(6)+4;
		dist_andada += andou;
		System.out.println("A "+pessoa+" já andou "+andou+"m e percorreu "+dist_andada+"m");
		if (dist_andada > dist_total) {
			dist_andada = dist_total;
			System.out.println("A "+pessoa+" chegou á porta e vai abri-lá.");
		}
		
	}
	
	public void Porta () {
		int passar_porta = new Random().nextInt(2000)+1000; 
	    try { 
	    semaforo.acquire();
	     sleep (passar_porta); 
	    } catch (InterruptedException e) { 
	     e.printStackTrace(); 
	    } finally {
	      semaforo.release();
	    }
	    System.out.println("A "+pessoa+" passou pela porta.");
	     
	}
	
	public void run () {
		while (dist_andada < dist_total) {
			PessoaAndando();
		}
		Porta ();
	
	}

}
