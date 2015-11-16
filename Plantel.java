import java.util.ArrayList;

public class Plantel {
	
	private ArrayList<Jugador> equipo = new ArrayList<Jugador>(16);
	
	public Plantel()
	{
		Jugador p1 = new Jugador(1, 60, 88);
		Jugador p2 = new Jugador(2, 75, 63);
		Jugador p3 = new Jugador(3, 81, 75);
		Jugador p4 = new Jugador(4, 68, 92);
		Jugador p5 = new Jugador(5, 72, 87);
		Jugador p6 = new Jugador(6, 71, 82);
		Jugador p7 = new Jugador(7, 83, 92);
		Jugador p8 = new Jugador(8, 61, 80);
		Jugador p9 = new Jugador(9, 91, 83);
		Jugador p10 = new Jugador(10, 78, 85);
		Jugador p11 = new Jugador(11, 90, 62);
		Jugador p12 = new Jugador(12, 81, 58);
		Jugador p13 = new Jugador(13, 62, 89);
		Jugador p14 = new Jugador(14, 95, 61);
		Jugador p15 = new Jugador(15, 79, 74);
		Jugador p16 = new Jugador(16, 93, 90);
		
		equipo.add(p1);
		equipo.add(p2);
		equipo.add(p3);
		equipo.add(p4);
		equipo.add(p5);
		equipo.add(p6);
		equipo.add(p7);
		equipo.add(p8);
		equipo.add(p9);
		equipo.add(p10);
		equipo.add(p11);
		equipo.add(p12);
		equipo.add(p13);
		equipo.add(p14);
		equipo.add(p15);
		equipo.add(p16);
	}
	
	public void mostrarPlantel()
	{
		System.out.println("Dorsal\tAtaque\tDefensa\t");
		for(int i = 0; i < equipo.size(); i++)
		{
			System.out.print(equipo.get(i).getNumero() + "\t" + 
							 equipo.get(i).getAtaque() + "\t" + 
							 equipo.get(i).getDefensa() + "\n");
		}
	}
}
