package clustering;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import algoritmos.AGM;
import algoritmos.BFS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private static ArrayList<Persona> listaCargada = new ArrayList<Persona>();
	private ArrayList<Persona> listaPersonas;
	private ArrayList<String> nombreVerticesA;
	private ArrayList<String> nombreVerticesB;
	Grafo grafo;

	public Principal()
	{
		listaPersonas = new ArrayList<Persona>();
		nombreVerticesA = new ArrayList<String>();
		nombreVerticesB = new ArrayList<String>();
	}
	
	public void agregarPersona(String nombre,int i_deporte, int i_musica, int i_espectaculo, int i_ciencia) 
	{
		Persona persona = new Persona(i_deporte, i_musica, i_espectaculo, i_ciencia, nombre);
		listaPersonas.add(persona);
	}
	
	
	public int tamanoListaPersona() 
	{
		return listaPersonas.size();
	}
	
	
	public ArrayList<ArrayList<String>> creaGrafo() 
	{
		Cluster cluster = new Cluster();
		//cluster.crearGrafo(listaPersonas);
		Grafo agm = AGM.arbolGeneradorMinimo(cluster.crearGrafo(listaPersonas));
		ArrayList<ArrayList<Integer>> subgrafos = new ArrayList<ArrayList<Integer>>();
		int del = 0;
		System.out.println(BFS.alcanzables(agm, 0));
		System.out.println("vecinos de " + del +agm.vecinos(del));
		//System.out.println("dividido " + BFS.alcanzables(agm, 0));
		//System.out.println("dividido " + BFS.alcanzables(agm, 4));
		subgrafos = cluster.dividirGrafo(agm);
		System.out.println(subgrafos.get(0) + " " + subgrafos.get(1));
		for(int i = 0; i < subgrafos.get(0).size(); i++) 
		{
			nombreVerticesA.add(listaPersonas.get(subgrafos.get(0).get(i)).nombre());
		}
		for(int i = 0; i < subgrafos.get(1).size(); i++) 
		{
			nombreVerticesB.add(listaPersonas.get(subgrafos.get(1).get(i)).nombre());
		}
		ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
		lista.add(nombreVerticesA);
		lista.add(nombreVerticesB);
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
