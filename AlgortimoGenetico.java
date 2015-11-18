import java.util.ArrayList;

public class AlgoritmoGenetico {
	
	private Plantel plantel = new Plantel();
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>(6);	// Longitud del cromosoma: 6 jugadores (Formación titular del equipo de voleibol).
	private ArrayList<Jugador> listaAux = new ArrayList<Jugador>(6);	// Lista auxiliar para asegurar la no repetición de los números enteros en el cromosoma.
	private ArrayList<ArrayList<Jugador>> poblacion = new ArrayList<ArrayList<Jugador>>();	// Población de cromosomas (Opciones de formación titular)
	private ArrayList<ArrayList<Jugador>> matingPool = new ArrayList<ArrayList<Jugador>>();	// Mating pool
	private double adaptacion;
	
	public AlgoritmoGenetico()
	{

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
	public void printCromosoma(int pos)
	{
		System.out.print("\n" + (pos + 1) + "\t");
		for(Jugador player : jugadores)
		{
			System.out.print(player.getNumero() + " ");
		}
	}
	
	// Método que genera la población de cromosomas con su aptitud. 100 cromosomas se generarán en este problema
	public void generarPoblacion(int tam)
	{
		System.out.println("\nPoblación: \n");
		System.out.println("Nº\tCromosoma\t\tAdaptación");
		for(int i = 0; i < tam; i++)
		{
			jugadores.clear();
			generarCromosoma();
			printCromosoma(i);
			poblacion.add(jugadores);
			System.out.print("\t\t" + getAdaptacion(jugadores));
		}
	}
	
	// Método que retorna la adaptación de cada cromosoma
	public double getAdaptacion(ArrayList<Jugador> players)
	{
		adaptacion = 0;
		for(int i = 0; i < players.size(); i++)
		{
			if(i < 3){ adaptacion += players.get(i).getAtaque(); }
			else {adaptacion += players.get(i).getDefensa();}
		}
		return adaptacion / 6;
	}
	
	// Método que realiza la selección por torneo. Pendiente a mejorar
	public void seleccion()
	{
		// Selección de primer cromosoma de forma aleatoria
		int i1 = (int)Math.floor(poblacion.size() * Math.random());
		ArrayList<Jugador> crom1 = poblacion.get(i1);
		poblacion.remove(i1);
		
		// Selección de segundo cromosoma de forma aleatoria
		int i2 = (int)Math.floor(poblacion.size() * Math.random());
		ArrayList<Jugador> crom2 = poblacion.get(i2);
		poblacion.remove(i2);
		
		if(getAdaptacion(crom1) > getAdaptacion(crom2))
		{
			matingPool.add(crom1);
		}
		
		else if(getAdaptacion(crom2) > getAdaptacion(crom1))
		{
			matingPool.add(crom2);
		}
	}
	
	public void cruce()
	{
		
	}
	
	public void mutacion()
	{
		
	}
	
	public void reemplazo()
	{
		
	}
}
