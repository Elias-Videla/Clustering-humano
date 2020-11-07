package algoritmos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import clustering.Grafo;

public class BFSTest
{

	@Test
	public void esConexoTest() {
		Grafo grafo = new Grafo( 4 );
		grafo.agregarArista( 0, 1, 5 );
		grafo.agregarArista( 0, 2, 5 );
		grafo.agregarArista( 1, 2, 5 );
		grafo.agregarArista( 2, 3, 5 );
		
		assertTrue( BFS.esConexo( grafo ) );
	}

	@Test
	public void noEsConexoTest() {
		Grafo grafo = new Grafo( 5 );
		grafo.agregarArista( 0, 1, 5 );
		grafo.agregarArista( 0, 2, 4 );
		grafo.agregarArista( 1, 2, 5 );
		grafo.agregarArista( 3, 4, 5 );
		
		assertFalse( BFS.esConexo( grafo ) );
	}
	
	
	@Test
	public void darAlcanzablesCorrectosTest() 
	{
		Grafo grafo = creandoGrafo();
		
		 ArrayList< Integer > alcanzables = BFS.alcanzables( grafo, 0 );
		 ArrayList< Integer > prueba = creandoListaEsperada();
		 
		 assertEquals( prueba, alcanzables );
		
	}

	

	//Metodos privados-------------------------------------------------------------------------------------------
	
	private Grafo creandoGrafo() 
	{
		Grafo grafo = new Grafo( 5 );
		grafo.agregarArista( 0, 2, 3 );
		grafo.agregarArista( 0, 3, 1 );
		grafo.agregarArista( 1, 4, 5 );
		return grafo;
	}
	
	
	private ArrayList< Integer > creandoListaEsperada()
	{
		ArrayList< Integer > prueba = new  ArrayList< Integer >();
		prueba.add( 0 );
		prueba.add( 2 );
		prueba.add( 3 );
		return prueba;
	}
}

