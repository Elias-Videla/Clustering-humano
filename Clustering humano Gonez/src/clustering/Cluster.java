package clustering;

import java.util.ArrayList;

public class Cluster
{

	private ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	
	public void agregarPersona(Persona persona) 
	{
		listaPersonas.add(persona);
	}
	
	private int indiceSimilaridad(Persona p1, Persona p2) 
	{
		int i_musica      = p1.interesMusica() - p2.interesMusica();
		int i_deportes    = p1.interesDeporte() - p2.interesDeporte();
		int i_ciencia     = p1.interesCiencia() - p2.interesCiencia();
		int i_espectaculo = p1.interesEspectaculo() - p2.interesEspectaculo();
		
		return valorAbsoluto( i_musica + i_deportes + i_ciencia + i_espectaculo );
	}
	
	private static int valorAbsoluto(int valor) 
	{
		return valor < 0 ? valor*(-1) : valor;
	}
	
}
