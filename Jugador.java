
public class Jugador {

	private int numero;
	private int ataque;
	private int defensa;
	
	public Jugador(int num, int attack, int defense)
	{
		numero = num;
		ataque = attack;
		defensa = defense;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}	
}
