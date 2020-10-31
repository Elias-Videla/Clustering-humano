package clustering;

import java.util.ArrayList;

import algoritmos.AGM;
import algoritmos.BFS;

public class Cluster
{

	private ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	
	
	public void agregarPersona(Persona persona) 
	{
		listaPersonas.add(persona);
	}
	
	
	public Grafo crearGrafo(ArrayList<Persona> lista_personas) 
	{
		Grafo grafo = new Grafo(lista_personas.size());
		
		for(int i = 0; i < grafo.tamano(); i++) 
		{
			for(int j = 0; j < grafo.tamano(); j++) if(i != j)
			{
				int indiceSimilaridad = calcularIndiceSimilaridad(lista_personas.get(i), lista_personas.get(j));
				grafo.agregarArista(i, j, indiceSimilaridad);
				System.out.println("indice similaridad " + lista_personas.get(i).nombre()
						+" " + lista_personas.get(j).nombre() + " es " + indiceSimilaridad);
			}
		}
		
		return grafo;
	}
	
	
	public Grafo armarAGM(Grafo grafo) 
	{
		return AGM.arbolGeneradorMinimo(grafo);
	}
	
	
	public int indiceSimilaridad(Persona p1, Persona p2) 
	{
		return calcularIndiceSimilaridad(p1,p2);
	}
	
	
	private int calcularIndiceSimilaridad(Persona p1, Persona p2) 
	{
		int i_musica      = valorAbsoluto( p1.interesMusica() - p2.interesMusica() );
		int i_deportes    = valorAbsoluto( p1.interesDeporte() - p2.interesDeporte() );
		int i_ciencia     = valorAbsoluto( p1.interesCiencia() - p2.interesCiencia() );
		int i_espectaculo = valorAbsoluto( p1.interesEspectaculo() - p2.interesEspectaculo() );
		
		return i_musica + i_deportes + i_ciencia + i_espectaculo ;
	}
	
	
	private static int valorAbsoluto(int valor) 
	{
		return valor < 0 ? valor*(-1) : valor;
	}
	
	
	public static void main(String[] args) {
		
		Persona elias = new Persona(3,3,1,3,"Elias");
		Persona pepe = new Persona(5,2,4,1,"Pepe");
		Persona carlos = new Persona(2,5,1,2,"Carlos");
		Persona juan = new Persona(1,3,1,5,"Juan");
		Persona javier = new Persona(3,4,5,1,"Javier");
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(elias);
		lista.add(pepe);
		lista.add(carlos);
		lista.add(juan);
		lista.add(javier);
		
		Cluster cluster = new Cluster();
		//cluster.crearGrafo(lista);
		Grafo agm = new Grafo(lista.size());
		agm = cluster.armarAGM(cluster.crearGrafo(lista));
		System.out.println(BFS.alcanzables(agm, 0));
		System.out.println(agm.vecinos(4));
	}
	
}
