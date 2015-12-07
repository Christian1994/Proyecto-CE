import java.util.ArrayList;

public class Plantel {
	
	private ArrayList<Jugador> equipo = new ArrayList<Jugador>(20);
	
	public Plantel()
	{
		Jugador p1 = new Jugador(1, 50, 80);
		Jugador p2 = new Jugador(2, 72, 94);
		Jugador p3 = new Jugador(3, 83, 65);
		Jugador p4 = new Jugador(4, 65, 92);
		Jugador p5 = new Jugador(5, 70, 87);
		Jugador p6 = new Jugador(6, 81, 62);
		Jugador p7 = new Jugador(7, 63, 82);
		Jugador p8 = new Jugador(8, 81, 60);
		Jugador p9 = new Jugador(9, 92, 93);
		Jugador p10 = new Jugador(10, 58, 75);
		Jugador p11 = new Jugador(11, 90, 72);
		Jugador p12 = new Jugador(12, 91, 58);
		Jugador p13 = new Jugador(13, 82, 69);
		Jugador p14 = new Jugador(14, 95, 78);
		Jugador p15 = new Jugador(15, 59, 64);
		Jugador p16 = new Jugador(16, 93, 90);
		Jugador p17 = new Jugador(17, 55, 70);
		Jugador p18 = new Jugador(18, 84, 56);
		Jugador p19 = new Jugador(19, 52, 63);
		Jugador p20 = new Jugador(20, 60, 82);
		
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
		equipo.add(p17);
		equipo.add(p18);
		equipo.add(p19);
		equipo.add(p20);
	}

	public ArrayList<Jugador> getEquipo() {
		return equipo;
	}

	public void setEquipo(ArrayList<Jugador> equipo) {
		this.equipo = equipo;
	}
	
	public void mostrarPlantel()
	{
		System.out.println("Equipo Voleibol UNIVALLE");
		System.out.println("\nDorsal\tAtaque\tDefensa\t");
		for(int i = 0; i < equipo.size(); i++)
		{
			System.out.print(equipo.get(i).getNumero() + "\t" + 
							 equipo.get(i).getAtaque() + "\t" + 
							 equipo.get(i).getDefensa() + "\n");
		}
	}
}
