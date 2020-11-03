package clustering;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import algoritmos.AGM;
import algoritmos.BFS;

public class ClusterTest {

	@Test
	public void crearGrafoConexoTest() 
	{
		Persona elias  = new Persona( 3, 4, 1, 2, "Elias Gonez" );
		Persona monk   = new Persona( 1, 2, 1, 3, "Adrian Monk" );
		Persona santos = new Persona( 3, 4, 1, 3, "Mario Santos" ); 
		Persona jane   = new Persona( 1, 3, 2, 4, "Patrick Jane" );
		Persona house  = new Persona( 1, 5, 5, 5, "Greg House" );
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add( monk );
		lista.add( jane );
		lista.add( elias );
		lista.add( house );
		lista.add( santos );
		
		Grafo grafo = new Grafo(lista.size());
		Cluster cluster = new Cluster();
		grafo = cluster.crearGrafo(lista);
		assertTrue(BFS.esConexo(grafo));

	}
	
	
//	@Test
//	public void crearDosVertices() 
//	{
//		Persona elias  = new Persona( 3, 4, 1, 2, "Elias Gonez" );
//		Persona monk   = new Persona( 1, 2, 1, 3, "Adrian Monk" );
//	
//		
//		ArrayList<Persona> lista = new ArrayList<Persona>();
//		lista.add( monk );
//		lista.add( elias );
//	
//		
//		Grafo grafo = new Grafo(lista.size());
//		Cluster cluster = new Cluster();
//		grafo = cluster.crearGrafo(lista);
//		assertTrue(BFS.esConexo(grafo));
//	}
//	
	
	@Test 
	public void dividirGrafo()
	{
		Persona elias  = new Persona( 3, 4, 1, 2, "Elias Gonez" );
		Persona monk   = new Persona( 1, 2, 1, 3, "Adrian Monk" );
	
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add( monk );
		lista.add( elias );
	
		
		Grafo grafo = new Grafo(lista.size());
		Cluster cluster = new Cluster();
		grafo = cluster.crearGrafo(lista);
		ArrayList<Set<Integer>> subgrafos = new ArrayList<Set<Integer>>();
		Grafo agm = AGM.arbolGeneradorMinimo(grafo);
		subgrafos = cluster.dividirGrafo(agm);
		assertEquals(1, agm.vecinos(0).size());
	}

}
