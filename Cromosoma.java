import java.util.ArrayList;

public class Cromosoma {

	private Plantel plantel = new Plantel();
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>(6);	// Longitud del cromosoma: 6 jugadores (Formación titular del equipo de voleibol).
	private ArrayList<Jugador> listaAux = new ArrayList<Jugador>(6);	// Lista auxiliar para asegurar la no repetición de los números enteros en el cromosoma.
	private double adaptacion;
	
	// Constructor
	public Cromosoma()
	{
		this.generarCromosoma();
		this.printCromosoma();		// Se imprime el cromosoma
	}
	
	public ArrayList<Jugador> getJugadores()
	{
		return jugadores;
	}
	
	// Método que crea el cromosoma. La codificación del cromosoma será entera
	public void generarCromosoma()
	{
		// Creamos los genes (jugadores) que conformarán el cromosoma
		jugadores.add(plantel.getEquipo().get((int)Math.floor(16 * Math.random())));
		jugadores.add(plantel.getEquipo().get((int)Math.floor(16 * Math.random())));
		jugadores.add(plantel.getEquipo().get((int)Math.floor(16 * Math.random())));
		jugadores.add(plantel.getEquipo().get((int)Math.floor(16 * Math.random())));
		jugadores.add(plantel.getEquipo().get((int)Math.floor(16 * Math.random())));
		jugadores.add(plantel.getEquipo().get((int)Math.floor(16 * Math.random())));

		listaAux = jugadores;			// Se asigna la formación titular a la lista auxiliar para asegurar la no repetición de los genes (jugadores).
		
		/* Si encontramos que en el cromosoma hay dos genes iguales, limpiamos la lista
		 * y volvemos a generar el cromosoma hasta que no haya repetición en los genes. */
		for(int i = 0; i < jugadores.size(); i++)
		{
			for(int j = 0; j < listaAux.size(); j++)
			{
				if(i != j && jugadores.get(i) == listaAux.get(j))
				{
					jugadores.clear();
					generarCromosoma();
				}	
			}
		}
	}
	
	// Método que muestra el cromosoma generado
	public void printCromosoma()
	{
		for(Jugador player : jugadores)
		{
			System.out.print(player.getNumero() + " ");
		}
	}
	
	// Método que retorna la adaptación de cada cromosoma
	// F. adaptación = (A[0]+A[1]+A[2]+D[3]+D[4]+D[5])/6
	// Función a optimizar (encontrar el máximo)
	public double getAdaptacion()
	{
		adaptacion = 0;
		for(int i = 0; i < jugadores.size(); i++)
		{
			if(i < 3){ adaptacion += jugadores.get(i).getAtaque(); }
			else {adaptacion += jugadores.get(i).getDefensa();}
		}
		return adaptacion / 6;
	}
}
