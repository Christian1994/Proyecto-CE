
public class Principal {
	
	public static void main(String[] args) 
	{
		Plantel univalleTeam = new Plantel();
		univalleTeam.mostrarPlantel();
		
		AlgoritmoGenetico ga = new AlgoritmoGenetico();
		ga.generarPoblacion(100);		// Población de 100 individuos
		
		for(int i = 0; i < 100; i++)
		{
			System.out.println("\n-----------------------------------------------------------------");
			System.out.println("\nGeneración " + (i+1));
			
			ga.seleccion(60);				// Población de 60 individuos dentro del mating pool
			ga.reproduccion(0.5, 0.05);		// Reproducción con probabilidad de cruce del 50% y con probabilidad de mutación de 5%
			ga.reemplazo();					// Generación de nueva población
			ga.evaluacion();				// Evaluación de cromosomas
		}

		System.out.println("\n-----------------------------------------------------------------");
		ga.getMejorCromosoma();				// Evaluación de cromosomas de cada generación (óptimo)
	}
}
