import java.util.ArrayList;

public class AlgoritmoGenetico {
	
	// Plantear la posibilidad de crear una clase llamada Cromosoma
	
	private ArrayList<Cromosoma> poblacion = new ArrayList<Cromosoma>();	// Población de cromosomas (Opciones de formación titular)
	private ArrayList<Cromosoma> matingPool = new ArrayList<Cromosoma>();	// Mating pool
	
	// Constructor
	public AlgoritmoGenetico()
	{

	}
	
	// Método que genera la población de cromosomas con su aptitud. 100 cromosomas se generarán en este problema
	public void generarPoblacion(int tam)
	{
		System.out.println("\nPoblación: \n");
		System.out.println("Nº\tCromosoma\t\tAdaptación");
		for(int i = 0; i < tam; i++)
		{
			poblacion.add(new Cromosoma(i));
			System.out.print("\t\t" + poblacion.get(i).getAdaptacion());
		}
		
		System.out.print("\n\nTamaño de población: " + poblacion.size());
	}
		
	// Método que realiza la selección por torneo. Pendiente a mejorar
	public void seleccion()
	{
		// Selección de primer cromosoma de forma aleatoria
		int i1 = (int)Math.floor(poblacion.size() * Math.random());
		Cromosoma crom1 = poblacion.get(i1);
		
		// Selección de segundo cromosoma de forma aleatoria
		int i2 = (int)Math.floor(poblacion.size() * Math.random());
		Cromosoma crom2 = poblacion.get(i2);
		
		// Seleccionar y reemplazar? o sólo seleccionar?
		poblacion.remove(i1);
		poblacion.remove(i2);
		
		// El que tenga la mejor aptitud, éste se enviará al mating pool
		if(crom1.getAdaptacion() > crom2.getAdaptacion())
		{
			matingPool.add(crom1);
		}
		
		else if(crom2.getAdaptacion() > crom1.getAdaptacion())
		{
			matingPool.add(crom2);
		}
		
		System.out.print("\n\nÍndice 1: " + (i1 + 1) + " " + crom1.getAdaptacion());
		System.out.print("\nÍndice 2: " + (i2 + 1) + " " + crom2.getAdaptacion());
		System.out.print("\n\nTamaño de población después de selección: " + poblacion.size());
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
