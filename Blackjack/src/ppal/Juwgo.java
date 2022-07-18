package ppal;

import java.util.Scanner;

import Modelo.Mano;
import Modelo.Mazo;

public class Juwgo {

	public static void main(String[] args) {
	
		Mazo mazo = new Mazo();
		Mano jugador = new Mano();
		Mano banca = new Mano();
		
		System.out.println("Barajando carta...");
		mazo.barajar();
		
		System.out.println("Repartiendo cartas iniciales...");
		
		jugador.pedirCarta(mazo);
		System.out.println("Jugador: "+jugador);
		
		banca.pedirCarta(mazo);
		System.out.println("Banca "+banca);
		
		jugador.pedirCarta(mazo);
		System.out.println("Jugador: "+jugador);
		
		banca.pedirCarta(mazo,false);
		System.out.println("Banca "+banca);
		
		Scanner entrada = new Scanner(System.in);
		int opcion;
		boolean plantado=false;
		
		do {
		    System.out.println("¿Quieres carta ) (1=Si, 0=No)");
		    opcion = entrada.nextInt();
		    if (opcion ==1) {
			jugador.pedirCarta(mazo);
			System.out.println("Tienes en tu mano \n"+jugador);
		    }else {
			System.out.println("Te has plantado. Tu puntuacion es "
							  +jugador.valorMano());
			//plantado=true;
		}
	} while (opcion!=0 && !jugador.finDeJuego()); // && !plantado);
		
		System.out.println("Juega la banca....");
		banca.descubrir();
		System.out.println("Cartas de la banca:");
	if (jugador.valorMano()>21) {
		System.out.println("Gana la banca"+banca);
	}else {
		
		do {	
			System.out.println("Pidiendo carta");
			banca.pedirCarta(mazo);
			System.out.println(banca);
		}while (banca.valorMano()<=16);
	
		if(jugador.valorMano()>banca.valorMano()|| banca.valorMano()>21){
			System.out.println("Enhorabuena has ganado: "+jugador);
		}else if (jugador.valorMano()==banca.valorMano()) {
			System.out.println("Empate");
			System.out.println("Jugador: "+jugador);
			System.out.println("Banca:"+banca);
		}else	{
			System.out.println("Gana la banca: "+banca);
		}
	}
} 
}
		
		
	/*	System.out.println("Fin de juego. Tu mano es\n"+jugador);
	if (jugador.valorMano()==21) {
		System.out.println("Campeón. Has conseguido 21");
		
	} else if (jugador.valorMano()>21) {
		System.out.println("Te has pasado");
		
		
	} else {
		System.out.println("Te has plantado con "+jugador.valorMano());
	}
		
	}*/
	
