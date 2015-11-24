
public class Principal {
	
	public static void main(String[] args) 
	{
		Plantel univalleTeam = new Plantel();
		univalleTeam.mostrarPlantel();
		
		AlgoritmoGenetico ga = new AlgoritmoGenetico();
		ga.generarPoblacion(100);		// Población de 100 individuos
		ga.seleccion(60);				// Población de 60 individuos dentro del mating pool
		ga.reproduccion(0.5, 0.1667);	// Reproducción con probabilidad de cruce del 50% y con probabilidad de mutación de 16.67%
		// ga.reemplazo();

	}
	
}
