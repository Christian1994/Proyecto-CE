import java.util.ArrayList;

public class AlgoritmoGenetico {
	
	Plantel plantel = new Plantel();

	// Longitud del cromosoma: 6 jugadores (Formación titular del equipo de voleibol).
	ArrayList<Jugador> jugadores = new ArrayList<Jugador>(6);
	
	// Lista auxiliar para asegurar la no repetición de los números enteros en el cromosoma.
	ArrayList<Jugador> listaAux = new ArrayList<Jugador>(6);
	
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

		// Se asigna la formación titular a la lista auxiliar para asegurar la no repetición de los genes (jugadores).
		listaAux = jugadores;
		
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
		System.out.print("\nCromosoma " + (pos + 1) + ": ");
		for(Jugador player : jugadores)
		{
			System.out.print(player.getNumero() + " ");
		}
	}
	
	// Método que genera la población de cromosomas. 100 cromosomas se generarán en este problema
	public void generarPoblacion()
	{
		System.out.println("\nPoblación: ");
		for(int i = 0; i < 100; i++)
		{
			jugadores.clear();
			generarCromosoma();
			printCromosoma(i);
		}
	}
	
}
