import java.util.ArrayList;

public class AlgoritmoGenetico {
	
	ArrayList<Integer> jugadores = new ArrayList<Integer>(6);
	ArrayList<Integer> listaAux = new ArrayList<Integer>(6);
	
	public AlgoritmoGenetico()
	{
		generarCromosoma();
	}
	
	public void generarCromosoma()
	{		
		jugadores.add(1 + (int)Math.floor(16 * Math.random()));
		jugadores.add(1 + (int)Math.floor(16 * Math.random()));
		jugadores.add(1 + (int)Math.floor(16 * Math.random()));
		jugadores.add(1 + (int)Math.floor(16 * Math.random()));
		jugadores.add(1 + (int)Math.floor(16 * Math.random()));
		jugadores.add(1 + (int)Math.floor(16 * Math.random()));

		listaAux = jugadores;
				
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
	
	public void printCromosoma()
	{
		for(Integer numero : jugadores)
		{
			System.out.print(numero + " ");
		}
	}
	
	public void generarPoblacion()
	{

	}
	
}
