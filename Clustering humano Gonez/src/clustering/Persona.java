package clustering;

public class Persona {

	private int interesDeporte;
	private int interesMusica;
	private int interesEspectaculo;
	private int interesCiencia;
	
	
	public Persona( int i_deporte, int i_musica, int i_espectaculo, int i_ciencia ) 
	{
		verificarParametros(i_deporte, i_musica, i_espectaculo, i_ciencia);
		
		interesDeporte     =  i_deporte;
		interesMusica      =  i_musica;
		interesEspectaculo =  i_espectaculo;
		interesCiencia     =  i_ciencia;
	}
	
	
	public int interesMusica() { return interesMusica; } 
	
	
	public int interesDeporte() { return interesDeporte; }
	
	
	public int interesCiencia() { return interesCiencia; }
	
	
	public int interesEspectaculo() { return interesEspectaculo; }
	
	
	private void verificarParametros( int i_deporte, int i_musica, int i_espectaculo, int i_ciencia ) 
	{
		if( i_deporte < 1 || i_deporte > 5)
			throw new IllegalArgumentException( "Numero fuera de rango (del 1 al 5) " + i_deporte );
		
		if( i_musica < 1 || i_musica > 5) 
			throw new IllegalArgumentException( "Numero fuera de rango (del 1 al 5) " + i_musica );
		
		if( i_espectaculo < 1 || i_espectaculo > 5)
			throw new IllegalArgumentException( "Numero fuera de rango (del 1 al 5) " + i_espectaculo );
		
		if( i_ciencia < 1 || i_ciencia > 5)
			throw new IllegalArgumentException( "Numero fuera de rango (del 1 al 5)" + i_ciencia );
	}
}
