package clustering;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTest {


	
	@Test(expected = IllegalArgumentException.class)
	public void detectarArgumentoIllegal_deporte_Test() 
	{
		@SuppressWarnings("unused")
		Persona elias = new Persona( 7, 2, 2, 1, "elias" );
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void detectarArgumentoIllegal_musica_Test() 
	{
		@SuppressWarnings("unused")
		Persona elias = new Persona( 2, 0, 2, 1, "elias" );
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void detectarArgumentoIllegal_espectaculo_Test() 
	{
		@SuppressWarnings("unused")
		Persona elias = new Persona( 2, 5, 6, 1, "elias" ); 
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void detectarArgumentoIllegal_ciencia_Test() 
	{
		@SuppressWarnings("unused")
		Persona elias = new Persona( 2, 4, 2, 9, "elias" );
	}
	
	
	@Test
	public void indiceSimilaridadCorrectaTest() 
	{
		Cluster cluster = new Cluster();
		Persona elias = new Persona( 3, 3, 1, 3, "Elias" );
		Persona pepe  = new Persona( 5, 2, 4, 1, "Pepe" );
		
		assertEquals( 8, cluster.indiceSimilaridad( elias, pepe ) );
	}

}
