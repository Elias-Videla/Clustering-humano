package clustering;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> listaCargada = new ArrayList<Persona>();
	
	public static void cargar() 
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
		
		try 
		{
			FileOutputStream fos = new FileOutputStream("personas.txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			
			out.writeObject(lista);
			//out.writeObject(lista2); para cargar otra lista mas
			out.close();
			
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public static void traer() 
	{
		try 
		{
			FileInputStream fis = new FileInputStream("personas.txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			//ArrayList<Persona> lista = new ArrayList<Persona>();
			listaCargada = (ArrayList<Persona>) in.readObject();
			//listaCargada_2 = (ArrayList<Persona>) in.readObject(); para traer la segunda lista
			in.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
		System.out.println(listaCargada.get(0).nombre());
	}
	
	
	
}
