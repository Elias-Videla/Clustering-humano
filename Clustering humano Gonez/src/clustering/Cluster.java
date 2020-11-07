package clustering;

import java.io.Serializable;
import java.util.ArrayList;

import algoritmos.BFS;

public class Cluster implements Serializable
{
	private ArrayList< int[] > listaDeAristas;
	private static final long serialVersionUID = 1L;

	
	public Cluster() 
	{
		listaDeAristas = new ArrayList< int[] >();
	}
	
	
	public Grafo crearGrafo( ArrayList< Persona > lista_personas ) 
	{
		Grafo grafo = new Grafo( lista_personas.size() );

		for( int i = 0; i < grafo.tamano(); i++ ) 
		{
			for( int j = 0; j < grafo.tamano(); j++ ) if( i != j )
			{
				if( !grafo.existeArista( j, i ) ) //pregunto si ya exite el inverso
				{ 
					Persona vertice_i = lista_personas.get( i );
					Persona vertice_j = lista_personas.get( j );

					int indiceSimilaridad = Persona.calcularIndiceSimilaridad( vertice_i, vertice_j );

					grafo.agregarArista( i, j, indiceSimilaridad );

					int[] arista = new int[ 3 ];

					arista[ 0 ] = i;
					arista[ 1 ] = j;
					arista[ 2 ] = indiceSimilaridad;

					listaDeAristas.add( arista );
				}
			}
		}
		
		return grafo; 
	}
	


	
	
	public ArrayList< ArrayList< Integer > > dividirGrafo( Grafo grafo ) //arraylist<set<Integer>>
	{
		if( !BFS.esConexo( grafo ) )
			throw new IllegalArgumentException( "El grafo no es conexo" );
	
		int[] aristaParaCortar = buscarAristaMasPesada( grafo );
		
		grafo.eliminarArista( aristaParaCortar[ 0 ], aristaParaCortar[ 1 ] );
		
		ArrayList< ArrayList< Integer > > subgrafos = new ArrayList<ArrayList<Integer>>(); 
		
		ArrayList< Integer > alcanzables_Subgrafo_A = BFS.alcanzables( grafo, aristaParaCortar[ 0 ] );
		ArrayList< Integer > alcanzables_Subgrafo_B = BFS.alcanzables( grafo, aristaParaCortar[ 1 ] );
		
		subgrafos.add( alcanzables_Subgrafo_A );
		subgrafos.add( alcanzables_Subgrafo_B );
		
		return subgrafos; //deberia retornar dos grafos
	}


	
	
	//Metodos privados-----------------------------------------------------------------------------------------
	
	private int[] buscarAristaMasPesada( Grafo grafo )
	{
		int mayorPeso = -1;
		
		int[] aristaParaCortar = new int[ 2 ];
		
		for( int i = 0; i < listaDeAristas.size(); i++ ) 
		{
			int peso_ij = listaDeAristas.get( i )[ 2 ];
			
			if( peso_ij > mayorPeso ) 
			{
				if( grafo.existeArista( listaDeAristas.get( i )[ 0 ], listaDeAristas.get( i )[ 1 ] ) ) 
				{
					mayorPeso = listaDeAristas.get( i )[ 2 ];
					aristaParaCortar[ 0 ] = listaDeAristas.get( i )[ 0 ];
					aristaParaCortar[ 1 ] = listaDeAristas.get( i )[ 1 ];
				}
			}
		}
		return aristaParaCortar;
	}
	
	
}
