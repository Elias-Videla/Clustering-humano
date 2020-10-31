package clustering;

public class Persona 
{

	private int interesDeporte;
	private int interesMusica;
	private int interesEspectaculo;
	private int interesCiencia;
	private String nombre;
	
	
	public Persona( int i_deporte, int i_musica, int i_espectaculo, int i_ciencia, String nombre ) 
	{
		verificarParametros(i_deporte, i_musica, i_espectaculo, i_ciencia);
		
		interesDeporte     =  i_deporte;
		interesMusica      =  i_musica;
		interesEspectaculo =  i_espectaculo;
		interesCiencia     =  i_ciencia;
		this.nombre        =  nombre;
	}
	
	
	public String nombre() { return nombre; }
	
	
	public int interesMusica() { return interesMusica; } 
	
	
	public int interesDeporte() { return interesDeporte; }
	
	
	public int interesCiencia() { return interesCiencia; }
	
	
	public int interesEspectaculo() { return interesEspectaculo; }
	
	
	public static int calcularIndiceSimilaridad(Persona p1, Persona p2) 
	{
		int i_musica      = valorAbsoluto( p1.interesMusica() - p2.interesMusica() );
		int i_deportes    = valorAbsoluto( p1.interesDeporte() - p2.interesDeporte() );
		int i_ciencia     = valorAbsoluto( p1.interesCiencia() - p2.interesCiencia() );
		int i_espectaculo = valorAbsoluto( p1.interesEspectaculo() - p2.interesEspectaculo() );
		
		return i_musica + i_deportes + i_ciencia + i_espectaculo ;
	}
	
	//Metodos privados-------------------------------------------------------------------------------------------
	
	private static int valorAbsoluto(int valor) 
	{
		return valor < 0 ? valor*(-1) : valor;
	}
	
	
	private void verificarParametros( int i_deporte, int i_musica, int i_espectaculo, int i_ciencia ) 
	{
		if( i_deporte < 1 || i_deporte > 5)
			throw new IllegalArgumentException( "Numero fuera de rango (del 1 al 5) " + i_deporte );
		
		if( i_musica < 1 || i_musica > 5) 
			throw new IllegalArgumentException( "Numero fuera de rango (del 1 al 5) " + i_musica );
		
		if( i_espectaculo < 1 || i_espectaculo > 5)
			throw new IllegalArgumentException( "Numero fuera de rango (del 1 al 5) " + i_espectaculo );
		
		if( i_ciencia < 1 || i_ciencia > 5)
			throw new IllegalArgumentException( "Numero fuera de rango (del 1 al 5) " + i_ciencia );
	}
}
