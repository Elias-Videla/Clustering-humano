package clustering;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import algoritmos.AGM;

public class ClusterTest 
{ 
	@Test
	public void dividirGrafoCorrectamenteTest() 
	{
		Cluster cluster = new Cluster();
		
		ArrayList< Persona > listaPersonas = creandoListaDePersonas();
		
		Grafo agm = creandoAGM( cluster, listaPersonas );
		
		ArrayList< ArrayList< Integer > > subgrafos = cluster.dividirGrafo( agm );
		
		ArrayList< ArrayList< Integer > > prueba = creandoListaEsperada();
		
		assertEquals( prueba, subgrafos );
		
		
	}
	
	
	
	@Test ( expected = IllegalArgumentException.class )
	public void dividirUnGrafoNoConexoTest() 
	{
		Cluster cluster = new Cluster();
		Grafo grafo = new Grafo( 5 );
		
		grafo.agregarArista( 0, 1, 2 );
		grafo.agregarArista( 2, 3, 1 );
		grafo.agregarArista( 3, 4, 2 );
		
		cluster.dividirGrafo( grafo );
	}

	
	
	//Metodos privados------------------------------------------------------------------------------------------
	
	private ArrayList< ArrayList< Integer > > creandoListaEsperada() 
	{
		ArrayList< ArrayList< Integer > > prueba = new ArrayList< ArrayList< Integer > >();
		
		ArrayList <Integer > subgrafoPrueba_1 = new ArrayList< Integer >();
		ArrayList< Integer > subgrafoPrueba_2 = new ArrayList< Integer >();
		
		subgrafoPrueba_1.add( 2 );
		subgrafoPrueba_1.add( 0 );
		subgrafoPrueba_1.add( 3 );
		
		subgrafoPrueba_2.add( 4 );
		subgrafoPrueba_2.add( 1 );
		
		prueba.add( subgrafoPrueba_1 );
		prueba.add( subgrafoPrueba_2 ); 
		
		return prueba;
	}
	
	
	
	private Grafo creandoAGM( Cluster cluster, ArrayList< Persona > listaPersonas )
	{
		Grafo grafo = cluster.crearGrafo( listaPersonas );
		Grafo agm = AGM.arbolGeneradorMinimo( grafo );
		return agm;
	}
	
	
	
	private ArrayList< Persona > creandoListaDePersonas() 
	{
		Persona p1 = new Persona( 3, 3, 1, 3, "p1" );
		Persona p2 = new Persona( 5, 2, 4, 1, "p2" );
		Persona p3 = new Persona( 2, 5, 1, 2, "p3" );
		Persona p4 = new Persona( 1, 3, 1, 5, "p4" );
		Persona p5 = new Persona( 3, 4, 5, 1, "p5" );
		
		ArrayList< Persona > listaPersonas = new ArrayList< Persona >();
		listaPersonas.add( p1 );
		listaPersonas.add( p2 );
		listaPersonas.add( p3 );
		listaPersonas.add( p4 );
		listaPersonas.add( p5 );
		
		return listaPersonas;
	}
}
