package clustering;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTest {

	@Test(expected = IllegalArgumentException.class)
	public void agregarPersonaTest() 
	{
		Persona elias = new Persona(7,2,2,1,"elias");
	}

}
