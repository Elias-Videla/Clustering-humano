package clustering;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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
		
		Cluster cluster = new Cluster();
	}


}
