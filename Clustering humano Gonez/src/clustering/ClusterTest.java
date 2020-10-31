package clustering;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ClusterTest {

	@Test
	public void indiceSimilaridadCorrectaTest() 
	{
		Cluster cluster = new Cluster();
		Persona elias = new Persona(3,3,1,3,"Elias");
		Persona pepe = new Persona(5,2,4,1,"Pepe");
		
		assertEquals(8, cluster.indiceSimilaridad(elias, pepe));
	}

//	@Test 
//	public void crearGrafoAPartirDeUnaListaTest() 
//	{
//		Persona elias = new Persona(3,3,1,3,"Elias");
//		Persona pepe = new Persona(5,2,4,1,"Pepe");
//		Persona carlos = new Persona(2,5,1,2,"Carlos");
//		Persona juan = new Persona(1,3,1,5,"Juan");
//		Persona javier = new Persona(3,4,5,1,"Javier");
//		
//		ArrayList<Persona> lista = new ArrayList<Persona>();
//		lista.add(elias);
//		lista.add(pepe);
//		lista.add(carlos);
//		lista.add(juan);
//		lista.add(javier);
//		
//		Cluster cluster = new Cluster();
//		Grafo agm = new Grafo(lista.size());
//		agm = cluster.armarAGM(cluster.crearGrafo(lista));
//		
//		assertEquals(8,agm.pesoDeArista(0, 1)); //creo que es -1 porque no son vecinos
//	}
}
