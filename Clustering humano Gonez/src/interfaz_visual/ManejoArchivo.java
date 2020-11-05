package interfaz_visual;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import clustering.Persona;

public class ManejoArchivo 
{
	private static ArrayList< Persona > lista_A; 
	private static ArrayList< Persona > lista_B; 
	private static ArrayList< Persona > lista_C; 
	private static ArrayList< Persona > lista_D;

	public ManejoArchivo() 
	{
		lista_A = new ArrayList< Persona >();
		lista_B = new ArrayList< Persona >();
		lista_C = new ArrayList< Persona >();
		lista_D = new ArrayList< Persona >();
	}
	
	@SuppressWarnings("unchecked")
	public static void descargarArchivo() 
	{
		try 
		{
			FileInputStream fis = new FileInputStream( "lista_personas.txt" );
			ObjectInputStream in = new ObjectInputStream( fis );
			lista_A = ( ArrayList< Persona > ) in.readObject();
			lista_B = ( ArrayList< Persona > ) in.readObject();
			lista_C = ( ArrayList< Persona > ) in.readObject();
			lista_D = ( ArrayList< Persona > ) in.readObject();

			in.close();
		}
		catch( Exception ex ) 
		{
			ex.printStackTrace();
		}
	}
	
	public static ArrayList< Persona > lista_A()
	{
		descargarArchivo();
		return lista_A;
	}
	public static ArrayList< Persona > lista_B()
	{
		descargarArchivo();
		return lista_B;
	}
	public static ArrayList< Persona > lista_C()
	{
		descargarArchivo();
		return lista_C;
	}
	public static ArrayList< Persona > lista_D()
	{
		descargarArchivo();
		return lista_D;
	}
	
	
}
