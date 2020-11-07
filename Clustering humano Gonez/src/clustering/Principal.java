package clustering;

import java.io.Serializable;
import java.util.ArrayList;

import algoritmos.AGM;


public class Principal implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private ArrayList< Persona > listaPersonas;
	private ArrayList< String > lista_nombres_grupo_1;
	private ArrayList< String > lista_nombres_grupo_2;

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
	
	
	
	public int tamanoListaPersonas() 
	{
		return listaPersonas.size();
	}
	
	
	
	
	public ArrayList< ArrayList< String > > crearGrupos() 
	{
		Cluster cluster = new Cluster();

		Grafo agm = crear_arbol_generador_minimo(cluster);
		
		ArrayList < ArrayList< Integer > > grafoDividido = dividir_el_grafo_en_dos(agm, cluster);
		
		extraer_los_nombres_de_cada_grupo(grafoDividido);

		ArrayList<ArrayList<String>> grupoDeNombres = anadir_los_nombres_a_las_listas();
		
		return grupoDeNombres; 
	}

	
	
	//Metodos privados-------------------------------------------------------------------------------------------
	
	private Grafo crear_arbol_generador_minimo( Cluster cluster )
	{
		Grafo agm = AGM.arbolGeneradorMinimo( cluster.crearGrafo( listaPersonas ) );
		return agm;
	}
	
	
	private ArrayList < ArrayList< Integer > > dividir_el_grafo_en_dos( Grafo grafo, Cluster cluster )
	{
		ArrayList < ArrayList< Integer > > grafoDividido = new ArrayList< ArrayList< Integer > >();
		
		grafoDividido = cluster.dividirGrafo( grafo );
		
		return grafoDividido;

	}
	
	
	private void extraer_los_nombres_de_cada_grupo( ArrayList< ArrayList< Integer > > grafoDividido ) 
	{
		for( int i = 0; i < grafoDividido.get( 0 ).size(); i++ ) 
			lista_nombres_grupo_1.add( listaPersonas.get( grafoDividido.get( 0 ).get( i ) ).nombre() );

		for( int i = 0; i < grafoDividido.get( 1 ).size(); i++ ) 
			lista_nombres_grupo_2.add( listaPersonas.get( grafoDividido.get( 1 ).get( i ) ).nombre() );
	}
	
	
	private ArrayList< ArrayList< String > > anadir_los_nombres_a_las_listas() 
	{
		ArrayList< ArrayList< String > > grupoDeNombres = new ArrayList< ArrayList< String > >();
		
		grupoDeNombres.add( lista_nombres_grupo_1 );
		grupoDeNombres.add( lista_nombres_grupo_2 );
		
		return grupoDeNombres;
	}
	
}
