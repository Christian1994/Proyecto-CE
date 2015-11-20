
public class Principal {
	
	public static void main(String[] args) 
	{
		Plantel univalleTeam = new Plantel();
		univalleTeam.mostrarPlantel();
		
		AlgoritmoGenetico ga = new AlgoritmoGenetico();
		ga.generarPoblacion(100);		// Población de 100 individuos
		ga.seleccion();
		ga.cruce();
		// ga.mutacion();
		// ga.reemplazo();
	}
	
}
