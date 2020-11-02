package algoritmos;

import static org.junit.Assert.*;

import org.junit.Test;

import clustering.Grafo;

public class BFSTest {

	@Test
	public void esConexoTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(0, 2, 5);
		grafo.agregarArista(1, 2, 5);
		grafo.agregarArista(2, 3, 5);
		
		assertTrue(BFS.esConexo(grafo));
	}

	@Test
	public void noEsConexoTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(0, 2, 4);
		grafo.agregarArista(1, 2, 5);
		grafo.agregarArista(3, 4, 5);
		
		assertFalse(BFS.esConexo(grafo));
	}
}

