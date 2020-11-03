package clustering;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import algoritmos.AGM;
import algoritmos.BFS;

public class Cluster implements Serializable
{
	private ArrayList<int[]> listaDeAristas;
	private ArrayList<Persona> listaPersonas;
	private static final long serialVersionUID = 1L;

	
	
	public Cluster() 
	{
		listaPersonas  = new ArrayList<Persona>();
		listaDeAristas = new ArrayList<int[]>();
	}
	
	
	public void agregarPersona(Persona persona) 
	{
		listaPersonas.add(persona);
	}
	
	
	public Grafo crearGrafo(ArrayList<Persona> lista_personas) 
	{
		Grafo grafo = new Grafo(lista_personas.size());

		for( int i = 0; i < grafo.tamano(); i++ ) 
		{
			for( int j = 0; j < grafo.tamano(); j++ ) if( i != j )
			{
				if(!grafo.existeArista(j, i)) //pregunto si ya exite el inverso
				{ 
					Persona vertice_i = lista_personas.get(i);
					Persona vertice_j = lista_personas.get(j);

					int indiceSimilaridad = Persona.calcularIndiceSimilaridad(vertice_i, vertice_j);

					grafo.agregarArista(i, j, indiceSimilaridad);

					int[] arista = new int[3];

					arista[0] = i;
					arista[1] = j;
					arista[2] = indiceSimilaridad;

					listaDeAristas.add(arista);
					//System.out.println(lista_personas.get(i).nombre() + " " + lista_personas.get(j).nombre()
							//+ " " + indiceSimilaridad);
				}
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
		return Persona.calcularIndiceSimilaridad(p1,p2);
	}
	
	
	public ArrayList<ArrayList<Integer>> dividirGrafo(Grafo grafo) //arraylist<set<Integer>>
	{
		if(!BFS.esConexo(grafo))
			throw new IllegalArgumentException("El grafo no es conexo");
	
		int[] aristaParaCortar = buscarAristaMasPesada(grafo);
		
		grafo.eliminarArista(aristaParaCortar[0], aristaParaCortar[1]);
		
		ArrayList<ArrayList<Integer>> subgrafos = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> alcanzables_Subgrafo_A = BFS.alcanzables(grafo, aristaParaCortar[0]);
		ArrayList<Integer> alcanzables_Subgrafo_B = BFS.alcanzables(grafo, aristaParaCortar[1]);
		subgrafos.add(alcanzables_Subgrafo_A);
		subgrafos.add(alcanzables_Subgrafo_B);
		
		return subgrafos; //deberia retornar dos grafos
	}

	
	//Metodos privados-----------------------------------------------------------------------------------------
	
	private int[] buscarAristaMasPesada(Grafo grafo) {
		int mayorPeso = -1;
		int[] aristaParaCortar = new int[2];
		for(int i = 0; i < listaDeAristas.size(); i++) 
		{
			int peso_ij = listaDeAristas.get(i)[2];
			
			if(peso_ij > mayorPeso) 
			{
				if(grafo.existeArista(listaDeAristas.get(i)[0], listaDeAristas.get(i)[1])) 
				{
					mayorPeso = listaDeAristas.get(i)[2];
					aristaParaCortar[0] = listaDeAristas.get(i)[0];
					aristaParaCortar[1] = listaDeAristas.get(i)[1];
				}
			}
		}
		return aristaParaCortar;
	}
	
	
	public static void main(String[] args) {
		
//		Persona elias = new Persona(3,3,1,3,"Elias");
//		Persona pepe = new Persona(5,2,4,1,"Pepe");
//		Persona carlos = new Persona(2,5,1,2,"Carlos"); 
//		Persona juan = new Persona(1,3,1,5,"Juan");
//		Persona javier = new Persona(3,4,5,1,"Javier");
//		
//		ArrayList<Persona> lista = new ArrayList<Persona>();
//		lista.add(pepe);
//		lista.add(carlos);
//		lista.add(juan);
//		lista.add(elias);
//		lista.add(javier);
//		
//		Cluster cluster = new Cluster();
//		//cluster.crearGrafo(lista);
//		Grafo agm = new Grafo(lista.size());
//		agm = cluster.armarAGM(cluster.crearGrafo(lista));
//		int del = 3;
//		System.out.println(BFS.alcanzables(agm, 0));
//		System.out.println("vecinos de " + del +agm.vecinos(del));
//		ArrayList<ArrayList<Integer>> subgrafos = new ArrayList<ArrayList<Integer>>();
//		subgrafos = cluster.dividirGrafo(agm);
//		System.out.println("dividido " + BFS.alcanzables(agm, 0));
//		System.out.println("dividido " + BFS.alcanzables(agm, 4));
//		System.out.println(subgrafos.get(0) + " " + subgrafos.get(1));
//		
//		//Principal.cargar();
//		Principal.traer();
	}
	
}
