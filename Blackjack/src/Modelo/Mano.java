package Modelo;

import java.util.ArrayList;

public class Mano extends Mazo {
	

	public Mano( ) {
		this.cartas= new ArrayList<>();
	}
		
	
	public int valorMano() {
		int suma=0;
		for (Carta carta : cartas) {
			suma=suma+carta.getValor();
		}
		return suma;
	}
	public int valorManoVisible() {
		int suma=0;
		for (Carta carta : cartas) {
			if (carta.isVisible()) {
			suma=suma+carta.getValor();
		}
		}
		return suma;
	}
	
		public void descubrir() {
			for (Carta carta : cartas) {
				carta.setVisible(true);
				
				
			}
		}
	public boolean finDeJuego() {
		if (valorMano()>=21) {
			return true;
		}
		return false;
		
		// return valorMano()>=21; Esto se pondria sin el if
	}

	@Override
	public String toString() {
		return "Valor de la mano:" + valorManoVisible() + "\n" + super.toString();
	}
	 
	public void pedirCarta(Mazo m) {
		if (!finDeJuego()) {
			Carta c = m.solicitarCarta();
			this.cartas.add(c);
		}
	}
	public void pedirCarta(Mazo m, boolean visible) {
			if (!finDeJuego()) {
			Carta c = m.solicitarCarta();
			c.setVisible(visible);
			this.cartas.add(c);
	}
			
		}	
	}
