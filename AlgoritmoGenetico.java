import java.util.ArrayList;

public class AlgoritmoGenetico {
	
	private ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();	// Población de cromosomas (Opciones de formación titular)
	private ArrayList<Cromosoma> matingPool = new ArrayList<Cromosoma>();	// Mating pool
	
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
			Cromosoma crom = new Cromosoma();
			crom.generarCromosoma();
			crom.printCromosoma();
			
			System.out.print((i + 1) + "\t");
			poblacion.add(crom);
			System.out.print("\t\t" + poblacion.get(i).getAdaptacion() + "\n");
		}
		
		System.out.print("\nTamaño de población: " + poblacion.size());
	}
		
	// Método que realiza la selección por torneo. 
	// Seleccionamos dos cromosomas al azar hasta llenar el mating pool.
	// Tamaño del mating pool: 60 cromosomas
	public void seleccion()
	{
		for(int i = 0; i < 60; i++)
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
		
		System.out.print("\nTamaño del mating pool: " + matingPool.size());
	}
	
	// Método que realiza el cruce de cromosomas. Cruce uniforme forma aleatoria sin repetición de genes
	public void cruce()
	{
		Cromosoma cruzado = new Cromosoma();
		ArrayList<Jugador> nuevaFormacion = cruzado.getJugadores();		// Nuevo cromosoma cruzado
		ArrayList<Jugador> team = new ArrayList<Jugador>();					// Cromosoma filtro para el cruzamiento
		ArrayList<Jugador> aux = new ArrayList<Jugador>();					// Cromosoma auxiliar para asegurar la no repetición de genes
		ArrayList<Cromosoma> parejaCromosomas = new ArrayList<Cromosoma>();	// Parejas de cromosomas seleccionada para su reproducción
		
		// Selección de primer cromosoma de forma aleatoria
		int i1 = (int)Math.floor(matingPool.size() * Math.random());
		Cromosoma crom1 = matingPool.get(i1);
		parejaCromosomas.add(crom1);
		
		// Selección de segundo cromosoma de forma aleatoria
		int i2 = (int)Math.floor(matingPool.size() * Math.random());
		Cromosoma crom2 = matingPool.get(i2);
		parejaCromosomas.add(crom2);
		
		// Cruce de genes padres
		for(int i = 0; i < 6; i++)
		{
			team = parejaCromosomas.get((int)Math.floor(2 * Math.random())).getJugadores();			
			nuevaFormacion.add(team.get(i));
		}
		
		aux = nuevaFormacion;		// Se asigna el nuevo cromosoma al auxiliar para asegurar la no repetición de los genes.
		
		/* En caso de individuo inválido (cuando hay genes repetidos en el cromosoma) se repite la operación de cruce hasta que sus genes no se repitan */
		for(int i = 0; i < nuevaFormacion.size(); i++)
		{
			for(int j = 0; j < aux.size(); j++)
			{
				if((i1 == i2) || (i != j && nuevaFormacion.get(i).getNumero() == aux.get(j).getNumero()))
				{
					nuevaFormacion.clear();
					cruce();
				}
			}
		}
		
		/* Imprime los cromosomas padres y el cromosoma resultante del cruzamiento uniforme*/
		if(!nuevaFormacion.isEmpty())
		{
			System.out.print("\n\n");
			System.out.print("Índice 1: " + (i1+1) + " -> ");
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
	}
	
	public void mutacion()
	{
		
	}
	
	public void reemplazo()
	{
		
	}
}
import java.util.ArrayList;

public class AlgoritmoGenetico {
	
	private ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();	// PoblaciÃ³n de cromosomas (Opciones de formaciÃ³n titular)
	private ArrayList<Cromosoma> matingPool = new ArrayList<Cromosoma>();	// Mating pool
	
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
			poblacion.add(new Cromosoma());
			System.out.print("\t\t" + poblacion.get(i).getAdaptacion() + "\n");
		}
		
		System.out.print("\n\nTamaño de población: " + poblacion.size());
	}
		
	// Método que realiza la selección por torneo. 
	// Seleccionamos dos cromosomas al azar hasta llenar el mating pool.
	// Tamaño del mating pool: 60 cromosomas
	public void seleccion()
	{
		for(int i = 0; i < 60; i++)
		{
			// Selección de primer cromosoma de forma aleatoria
			int i1 = (int)Math.floor(poblacion.size() * Math.random());
			Cromosoma crom1 = poblacion.get(i1);
			
			// Selección de segundo cromosoma de forma aleatoria
			int i2 = (int)Math.floor(poblacion.size() * Math.random());
			Cromosoma crom2 = poblacion.get(i2);
			
			// El que tenga la mejor aptitud, éste se enviará¡ al mating pool
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
		System.out.println("\nNº\tCromosoma\tAdaptación");
		for(int i = 0; i < matingPool.size(); i++)
		{
			System.out.print((i + 1) + "\t");
			matingPool.get(i).printCromosoma();
			System.out.print("\t\t" + matingPool.get(i).getAdaptacion() + "\n");
		}
		
		System.out.print("\n\nTamaño del mating pool: " + matingPool.size());
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
