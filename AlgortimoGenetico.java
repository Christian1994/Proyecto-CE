import java.util.ArrayList;

public class AlgoritmoGenetico {
	
	private ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();		// Población de cromosomas (Opciones de formación titular)
	private ArrayList<Cromosoma> matingPool = new ArrayList<Cromosoma>();		// Mating pool
	// private ArrayList<Cromosoma> nuevosCromosomas = new ArrayList<Cromosoma>();	// Población de nuevos cromosomas
	
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
	
	// Método que realiza cruce uniforme en codificación entera.
	public void cruce()
	{
		//while(!matingPool.isEmpty())
		//{
			// Selección de primer cromosoma de forma aleatoria
			int i1 = (int)Math.floor(matingPool.size() * Math.random());
			Cromosoma crom1 = matingPool.get(i1);
			matingPool.remove(i1);
			
			// Selección de segundo cromosoma de forma aleatoria
			int i2 = (int)Math.floor(matingPool.size() * Math.random());
			Cromosoma crom2 = matingPool.get(i2);
			matingPool.remove(i2);

			System.out.print("\n\nPareja de cromosomas seleccionada\n\n");
			crom1.printCromosoma();
			System.out.print("\n");
			crom2.printCromosoma();
			
			System.out.print("\n\nTamaño del mating pool: " + matingPool.size());
			
			// Comparación de genes entre padres
	}
	
	public void mutacion()
	{
		
	}
	
	public void reemplazo()
	{
		
	}
}
