package algoritmos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import clustering.Grafo;

public class AGMTest 
{

	@Test
	public void crearGrafoAGMCorrectamenteTest() 
	{
		Grafo agm = creandoGrafoAGM();
		
		ArrayList< Integer > alcanzables = BFS.alcanzables( agm, 0 );
		
		ArrayList< Integer > prueba = creandoListaEsperada();
		
		assertEquals( prueba, alcanzables );
	}

	
	@Test 
	public void grafoParametroEsConexoTest() 
	{
		Grafo grafo = new Grafo( 3 );
		
		grafo.agregarArista( 0, 1, 4 );
		grafo.agregarArista( 0, 2, 4 );
		grafo.agregarArista( 1, 2, 2 );
		
		AGM.arbolGeneradorMinimo( grafo );
	}
	
	
	@Test ( expected = IllegalArgumentException.class )
	public void grafoParametroNoEsConexoTest() 
	{
		Grafo grafo = new Grafo( 5 );
		
		grafo.agregarArista( 0, 3, 4 );
		grafo.agregarArista( 0, 2, 4 );
		grafo.agregarArista( 1, 4, 2 );
		
		AGM.arbolGeneradorMinimo( grafo );
	}
	
	
	
	//Metodos privados------------------------------------------------------------------------------------------
	
	private Grafo creandoGrafoAGM() 
	{
		Grafo grafo = new Grafo( 4 );
		
		grafo.agregarArista( 0, 1, 2 );
		grafo.agregarArista( 0, 3, 4 );
		grafo.agregarArista( 1, 2, 3 );
		grafo.agregarArista( 1, 3, 1 );
		grafo.agregarArista( 2, 3, 2 );
		
		Grafo agm = AGM.arbolGeneradorMinimo( grafo );
		return agm;
	}
	
	
	private ArrayList< Integer > creandoListaEsperada()
	{
		ArrayList< Integer > prueba = new ArrayList< Integer >();
		
		prueba.add( 0 );
		prueba.add( 1 );
		prueba.add( 3 );
		prueba.add( 2 );
		
		return prueba;
	}

}
