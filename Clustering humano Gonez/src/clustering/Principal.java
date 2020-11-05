package clustering;

import java.io.Serializable;
import java.util.ArrayList;

import algoritmos.AGM;


public class Principal implements Serializable 
{
	private static final long serialVersionUID = 1L;
	//private static ArrayList<Persona> listaCargada = new ArrayList<Persona>();
	private ArrayList< Persona > listaPersonas;
	private ArrayList< String > lista_nombres_grupo_1;
	private ArrayList< String > lista_nombres_grupo_2;
	//Grafo grafo;

	public Principal()
	{
		listaPersonas         = new ArrayList< Persona >();
		lista_nombres_grupo_1 = new ArrayList< String >();
		lista_nombres_grupo_2 = new ArrayList< String >();
	}
	
	public void agregarPersona( String nombre,int i_deporte, int i_musica, int i_espectaculo, int i_ciencia ) 
	{
		Persona persona = new Persona( i_deporte, i_musica, i_espectaculo, i_ciencia, nombre );
		
		listaPersonas.add( persona );
	}
	
	
	public int tamanoListaPersona() 
	{
		return listaPersonas.size();
	}
	
	
	
	
	public ArrayList< ArrayList< String > > crearGrupos() 
	{
		Cluster cluster = new Cluster();

		Grafo agm = AGM.arbolGeneradorMinimo( cluster.crearGrafo( listaPersonas ) );
		
		ArrayList <ArrayList< Integer > > grafoDividido = new ArrayList< ArrayList< Integer > >();
		
		grafoDividido = cluster.dividirGrafo( agm );
		
		for( int i = 0; i < grafoDividido.get( 0 ).size(); i++ ) 
			lista_nombres_grupo_1.add( listaPersonas.get( grafoDividido.get( 0 ).get( i ) ).nombre() );

		for( int i = 0; i < grafoDividido.get( 1 ).size(); i++ ) 
			lista_nombres_grupo_2.add( listaPersonas.get( grafoDividido.get( 1 ).get( i ) ).nombre() );

		ArrayList< ArrayList< String > > grupoDeNombres = new ArrayList< ArrayList< String > >();
		
		grupoDeNombres.add( lista_nombres_grupo_1 );
		grupoDeNombres.add( lista_nombres_grupo_2 );
		
		return grupoDeNombres;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void cargar() 
//	{
//		Persona elias    = new Persona( 3, 3, 1, 3, "Elias" );
//		Persona santiago = new Persona( 2, 5, 2, 3, "Santiago" );
//		Persona leandro  = new Persona( 5, 3, 2, 3, "Leandro" ); 
//		Persona daniela  = new Persona( 1, 5, 3, 3, "Daniela" );
//		Persona melanie  = new Persona( 1, 5, 3, 4, "Melanie" );
//		Persona enzo     = new Persona( 5, 5, 2, 5, "Enzo" );
//		Persona marcos   = new Persona( 2, 4, 3, 3, "Marcos" );
//		
//		
//		ArrayList<Persona> lista_A = new ArrayList<Persona>();
//		lista_A.add( santiago );
//		lista_A.add( daniela );
//		lista_A.add( elias );
//		lista_A.add( melanie );
//		lista_A.add( leandro );
//		lista_A.add( enzo );
//		lista_A.add( marcos );
//		
//		Persona nicolas = new Persona(2,4,1,3,"Nicolas.C");
//		Persona rossana = new Persona(1,1,5,3,"Rossana.G");
//		Persona lucila = new Persona(2,3,3,4,"Lucila.M");
//		Persona daniel = new Persona(3,2,2,4,"Daniel.B");
//		Persona esteban = new Persona(5,3,3,3,"Esteban.F");
//		Persona hernan = new Persona(5,2,2,3,"Hernan.N");
//		Persona javiert = new Persona(2,4,4,4,"Javier.T");
//		Persona marta = new Persona(1,3,5,3,"Marta.S");
//		Persona jose = new Persona (4,5,2,3,"Jose.N");
//		Persona patricia = new Persona(3,2,3,4,"Patricia.B");
//		Persona javierm = new Persona(4,3,2,4,"Javier.M");
//		Persona mariano = new Persona(2,2,4,4,"Mariano.V");
//		Persona noelia = new Persona(2,5,2,3,"Noelia");
//		Persona fernando = new Persona(2,3,3,3,"Fernando");
//		Persona andres = new Persona(3,3,1,4,"Andres.R");
//		Persona hvara = new Persona(2,3,3,3,"Hvara.O");
//		Persona claudio = new Persona(3,3,4,3,"Claudio");
//		Persona daiana = new Persona(2,4,1,3,"Daiana.D");
//		
//		ArrayList<Persona> lista_B = new ArrayList<Persona>();
//		lista_B.add(nicolas);
//		lista_B.add(rossana);
//		lista_B.add(lucila);
//		lista_B.add(daniel);
//		lista_B.add(esteban);
//		lista_B.add(hernan);
//		lista_B.add(javiert);
//		lista_B.add(marta);
//		lista_B.add(jose);
//		lista_B.add(patricia);
//		lista_B.add(javierm);
//		lista_B.add(mariano);
//		lista_B.add(noelia);
//		lista_B.add(fernando);
//		lista_B.add(andres);
//		lista_B.add(hvara);
//		lista_B.add(claudio);
//		lista_B.add(daiana);
//
//		
//		Persona monk    = new Persona(1,3,1,4,"A.Monk");
//		Persona santos  = new Persona(4,4,1,4,"M.Santos");
//		Persona house   = new Persona(1,5,5,5,"G.House");
//		Persona jane    = new Persona(1,3,5,3,"P.Jane");
//		Persona michael = new Persona(3,3,5,1,"M.Scott");
//		Persona argento = new Persona(4,2,3,1,"P.Argento");
//		Persona vega    = new Persona(4,4,1,1,"D.de la Vega");
//
//		ArrayList<Persona> lista_C = new ArrayList<Persona>();
//		lista_C.add(monk);
//		lista_C.add(santos);
//		lista_C.add(house);
//		lista_C.add(jane);
//		lista_C.add(michael);
//		lista_C.add(argento);
//		lista_C.add(vega);
//
//		Persona delpo = new Persona(5,4,5,1,"J.Del Potro");
//		Persona fangio = new Persona(4,2,3,3,"J.M.Fangio");
//		Persona messi = new Persona(5,4,3,1,"L.Messi");
//		Persona ginobilli = new Persona(5,2,2,1,"M.Ginobilli");
//		Persona waldner = new Persona(4,2,2,1,"J.O.Waldner");
//		Persona cech = new Persona(5,5,2,1,"P.Cech");
//		Persona federer = new Persona(5,3,4,1,"R.Federer");
//		Persona nalbandian = new Persona(5,3,3,3,"D.Nalbandian");
//		Persona lopez = new Persona(4,3,1,3,"J.M.Lopez");
//		
//		ArrayList<Persona> lista_D = new ArrayList<Persona>();
//		lista_D.add(delpo);
//		lista_D.add(fangio);
//		lista_D.add(messi);
//		lista_D.add(ginobilli);
//		lista_D.add(waldner);
//		lista_D.add(cech);
//		lista_D.add(federer);
//		lista_D.add(nalbandian);
//		lista_D.add(lopez);
//
//		
//		try 
//		{
//			FileOutputStream fos = new FileOutputStream("lista_personas.txt");
//			ObjectOutputStream out = new ObjectOutputStream(fos);
//			
//			out.writeObject(lista_A);
//			out.writeObject(lista_B);
//			out.writeObject(lista_C);
//			out.writeObject(lista_D);
//			//out.writeObject(lista2); para cargar otra lista mas
//			out.close();
//			
//		}
//		catch(Exception ex) 
//		{
//			ex.printStackTrace();
//		}
//	}
//	
//	public static void traer() 
//	{
//		try 
//		{
//			FileInputStream fis = new FileInputStream("personas.txt");
//			ObjectInputStream in = new ObjectInputStream(fis);
//			//ArrayList<Persona> lista = new ArrayList<Persona>();
//			listaCargada = (ArrayList<Persona>) in.readObject();
//			//listaCargada_2 = (ArrayList<Persona>) in.readObject(); para traer la segunda lista
//			in.close();
//		}
//		catch(Exception ex) 
//		{
//			ex.printStackTrace();
//		}
//		
//		System.out.println(listaCargada.get(0).nombre());
//	}
	
	
	
}
