package interfaz_visual;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import clustering.Persona;

public class ManejoArchivo 
{
	private static ArrayList<Persona> lista_A; 
	private static ArrayList<Persona> lista_B; 
	private static ArrayList<Persona> lista_C; 
	private static ArrayList<Persona> lista_D; 

	public ManejoArchivo() 
	{
		lista_A = new ArrayList<Persona>();
		lista_B = new ArrayList<Persona>();
		lista_C = new ArrayList<Persona>();
		lista_D = new ArrayList<Persona>();
	}
	
	@SuppressWarnings("unchecked")
	public static void cargarArchivo() 
	{
		try 
		{
			FileInputStream fis = new FileInputStream("personas.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			lista_A = (ArrayList<Persona>) in.readObject();
			in.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
		//System.out.println(listaCargada.get(0).nombre());
	}
	
	public static ArrayList<Persona> lista_A()
	{
		cargarArchivo();
		return lista_A;
	}
}
