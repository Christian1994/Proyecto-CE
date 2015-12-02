import java.util.ArrayList;

public class AlgoritmoGenetico {
	
	private ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();	// Población de cromosomas (Opciones de formación titular)
	private ArrayList<Cromosoma> matingPool = new ArrayList<Cromosoma>();	// Mating pool
	private Plantel plantel = new Plantel();
	
	// Constructor
	public AlgoritmoGenetico()
	{

	}
	
	// Método que genera la población de cromosomas con su aptitud. 100 cromosomas se generarán en este problema
	public void generarPoblacion(int tam)
	{
		System.out.println("\nPoblación inicial: \n");
		System.out.println("Nº\tCromosoma\t\tAdaptación");
		for(int i = 0; i < tam; i++)
		{
			System.out.print((i + 1) + "\t");
			Cromosoma crom = new Cromosoma();
			crom.generarCromosoma();
			crom.printCromosoma();
			
			poblacion.add(crom);
			System.out.print("\t\t" + poblacion.get(i).getAdaptacion() + "\n");
		}
		
		System.out.print("\nTamaño de población: " + poblacion.size());
	}
		
	/* Método que realiza la selección por torneo. 
	 * Seleccionamos dos cromosomas al azar hasta llenar el mating pool. 
	 * Tamaño del mating pool: 60 cromosomas */
	public void seleccion(int tam)
	{
		for(int i = 0; i < tam; i++)
		{
			// Selección de primer cromosoma de forma aleatoria
			int i1 = (int)Math.floor(poblacion.size() * Math.random());
			Cromosoma crom1 = poblacion.get(i1);
			
			// Selección de segundo cromosoma de forma aleatoria
			int i2 = (int)Math.floor(poblacion.size() * Math.random());
			Cromosoma crom2 = poblacion.get(i2);
			
			// El que tenga la mejor aptitud, éste se enviará al mating pool
			if(crom1.getAdaptacion() >= crom2.getAdaptacion())
			{
				matingPool.add(crom1);
			}
			
			else if(crom2.getAdaptacion() >= crom1.getAdaptacion())
			{
				matingPool.add(crom2);
			}
			
			/* System.out.print("\n\nÍndice 1: " + (i1 + 1) + " " + crom1.getAdaptacion());
			System.out.print("\nÍndice 2: " + (i2 + 1) + " " + crom2.getAdaptacion());
			System.out.print("\n\nTamaño del mating pool: " + matingPool.size());*/
		}
		
		// Imprime todos los cromosomas enviados al mating pool
		System.out.println("\n\nMating pool. Selección por torneo");
		System.out.println("\nNº\tCromosoma\t\tAdaptación");
		for(int i = 0; i < matingPool.size(); i++)
		{
			System.out.print((i + 1) + "\t");
			matingPool.get(i).printCromosoma();
			System.out.print("\t\t" + matingPool.get(i).getAdaptacion() + "\n");
		}
		
		System.out.print("\nTamaño del mating pool: " + matingPool.size() + "\n");
	}
	
	// Método que realiza la reproducción de cromosomas. Cruce y Mutación
	public void reproduccion(double probCruce, double probMutacion)
	{
		int indCruzados = 0;
		for(int i = 0; i < matingPool.size(); i++)
		{
			double pC = Math.random();
			if(pC < probCruce && i+1 < 60)
			{
				System.out.print("\n\nProb: " + pC);
				cruce(i, i+1);
				i++;
				indCruzados++;
			}
		}

		System.out.print("\n\nIndividuos cruzados: " + indCruzados);
		
		System.out.println("\n\nMating pool luego del cruce");
		System.out.println("\nNº\tCromosoma\t\tAdaptación");
		for(int i = 0; i < matingPool.size(); i++)
		{
			System.out.print((i + 1) + "\t");
			matingPool.get(i).printCromosoma();
			System.out.print("\t\t" + matingPool.get(i).getAdaptacion() + "\n");
		}

		for(int i = 0; i < matingPool.size(); i++)
		{
			mutacion(i, probMutacion);
		}
		
		System.out.println("\n\nMating pool luego de la mutación");
		System.out.println("\nNº\tCromosoma\t\tAdaptación");
		for(int i = 0; i < matingPool.size(); i++)
		{
			System.out.print((i + 1) + "\t");
			matingPool.get(i).printCromosoma();
			System.out.print("\t\t" + matingPool.get(i).getAdaptacion() + "\n");
		}
	}
	
	// Método que realiza el cruce de cromosomas. Cruce uniforme forma aleatoria sin repetición de genes
	public void cruce(int i1, int i2)
	{
		Cromosoma cruzado = new Cromosoma();
		ArrayList<Jugador> nuevaFormacion = cruzado.getJugadores();			// Nuevo cromosoma cruzado
		ArrayList<Jugador> team = new ArrayList<Jugador>();					// Cromosoma filtro para el cruzamiento
		ArrayList<Jugador> aux = new ArrayList<Jugador>();					// Cromosoma auxiliar para asegurar la no repetición de genes
		ArrayList<Cromosoma> parejaCromosomas = new ArrayList<Cromosoma>();	// Parejas de cromosomas seleccionada para su reproducción
		
		// Selección de primer cromosoma
		// int i1 = (int)Math.floor(matingPool.size() * Math.random());
		Cromosoma crom1 = matingPool.get(i1);
		parejaCromosomas.add(crom1);
		
		// Selección de segundo cromosoma
		// int i2 = (int)Math.floor(matingPool.size() * Math.random());
		Cromosoma crom2 = matingPool.get(i2);
		parejaCromosomas.add(crom2);
		
		// Cruce de genes padres
		for(int i = 0; i < 6; i++)
		{
			team = parejaCromosomas.get((int)Math.floor(2 * Math.random())).getJugadores();			
			nuevaFormacion.add(team.get(i));
		}
		
		aux = nuevaFormacion;		// Se asigna el nuevo cromosoma al auxiliar para asegurar la no repetición de los genes.
		
		/* En caso de individuo inválido (cuando hay genes repetidos en el cromosoma) se repite la operación de cruce 
		 * hasta que sus genes no se repitan */
		for(int i = 0; i < nuevaFormacion.size(); i++)
		{
			for(int j = 0; j < aux.size(); j++)
			{
				if(i != j && nuevaFormacion.get(i).getNumero() == aux.get(j).getNumero())
				{
					nuevaFormacion.clear();
					cruce(i1, i2);
					return;
				}
			}
		}
		
		/* Imprime los cromosomas padres y el cromosoma resultante del cruzamiento uniforme*/
		if(!nuevaFormacion.isEmpty())
		{
			System.out.print("\nÍndice 1: " + (i1+1) + " -> ");
			for(int i = 0; i < crom1.getJugadores().size(); i++)
			{
				System.out.print(crom1.getJugadores().get(i).getNumero() + " ");
			}
			
			System.out.print("\n");
			System.out.print("Índice 2: " + (i2+1) + " -> ");
			for(int i = 0; i < crom2.getJugadores().size(); i++)
			{
				System.out.print(crom2.getJugadores().get(i).getNumero() + " ");
			}
			
			System.out.print("\n");
			System.out.print("Individuo cruzado -> ");
			for(int i = 0; i < cruzado.getJugadores().size(); i++)
			{
				System.out.print(cruzado.getJugadores().get(i).getNumero() + " ");
			}			
		}
		
		/* Reemplazo: Como del operador de cruce uniforme sólo resulta en un descendiente, el padre con peor adaptación, será reemplazado por el 
		 * cromosoma cruzado */
		if(crom1.getAdaptacion() <= crom2.getAdaptacion())
		{
			matingPool.remove(i1);
			matingPool.add(i1, cruzado);
		}
		else
		{
			matingPool.remove(i2);
			matingPool.add(i2, cruzado);
		}
	}
	
	// Método que realiza la mutación de todos los cromosomas del mating pool
	public void mutacion(int index, double pMutacion)
	{
		Cromosoma mutado = matingPool.get(index);
		ArrayList<Jugador> teamMutado = mutado.getJugadores();				// Cromosoma mutado
		ArrayList<Jugador> aux = new ArrayList<Jugador>();					// Cromosoma auxiliar para asegurar la no repetición de genes
		
		for(int i = 0; i < mutado.getJugadores().size(); i++)
		{			
			double pM = Math.random();
			if(pM < pMutacion)
			{
				int num = (int)Math.floor(16 * Math.random());
				Jugador newPlayer = plantel.getEquipo().get(num);
				teamMutado.set(i, newPlayer);
			}
		}
		
		aux = teamMutado;		// Se asigna el nuevo cromosoma al auxiliar para asegurar la no repetición de los genes.
		
		/* En caso de individuo inválido (cuando hay genes repetidos en el cromosoma) se repite la operación de mutación 
		 * hasta que sus genes no se repitan */
		for(int i = 0; i < teamMutado.size(); i++)
		{
			for(int j = 0; j < aux.size(); j++)
			{
				if(i != j && teamMutado.get(i).getNumero() == aux.get(j).getNumero())
				{
					mutacion(index, pMutacion);
					return;
				}
			}
		}
	}
	
	// Método que realiza el reemplazo de los cromosomas. Nueva población de cromosomas
	public void reemplazo()
	{
		int tamPoblacion = poblacion.size();
		
		for(int i = 0; i < matingPool.size(); i++)
		{
			int aleatorio = (int) Math.floor((tamPoblacion * Math.random()));
			poblacion.remove(aleatorio);
			poblacion.add(aleatorio, matingPool.get(i));
		}
		
		System.out.println("\nNueva población de cromosomas:\n");
		System.out.println("Nº\tCromosoma\t\tAdaptación");
		for(int i = 0; i < poblacion.size(); i++)
		{
			System.out.print((i + 1) + "\t");
			poblacion.get(i).printCromosoma();
			System.out.print("\t\t" + poblacion.get(i).getAdaptacion() + "\n");
		}
	}
}
