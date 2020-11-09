package clustering;

import java.io.Serializable;
import java.util.ArrayList;

import algoritmos.BFS;

public class Cluster implements Serializable
{
	private static final long serialVersionUID = 1L;

	
	public Cluster() 
	{}
	
	
	public static Grafo crearGrafo( ArrayList< Persona > lista_personas ) 
	{
		Grafo grafo = new Grafo( lista_personas.size() );

		for( int i = 0; i < grafo.tamano(); i++ ) 
		{
			for( int j = 0; j < grafo.tamano(); j++ ) if( i != j )
			{
				if( !grafo.existeArista( j, i ) ) 
				{ 
					Persona vertice_i = lista_personas.get( i );
					Persona vertice_j = lista_personas.get( j );

					int indiceSimilaridad = Persona.calcularIndiceSimilaridad( vertice_i, vertice_j );

					grafo.agregarArista( i, j, indiceSimilaridad );
				}
			}
		}
		
		return grafo; 
	}
	

	
	
	public static ArrayList< ArrayList< Integer > > dividirGrafo( Grafo grafo ) 
	{
		if( !BFS.esConexo( grafo ) )
			throw new IllegalArgumentException( "El grafo no es conexo" );
	
		int[] aristaParaCortar = buscarAristaMasPesada( grafo );
		
		grafo.eliminarArista( aristaParaCortar[ 0 ], aristaParaCortar[ 1 ] );
		
		ArrayList< ArrayList< Integer > > subgrafos = new ArrayList< ArrayList< Integer > >(); 
		
		ArrayList< Integer > alcanzables_Subgrafo_A = BFS.alcanzables( grafo, aristaParaCortar[ 0 ] );
		ArrayList< Integer > alcanzables_Subgrafo_B = BFS.alcanzables( grafo, aristaParaCortar[ 1 ] );
		
		subgrafos.add( alcanzables_Subgrafo_A );
		subgrafos.add( alcanzables_Subgrafo_B );
		
		return subgrafos; 
	}
	
	
	
	//Metodos privados-----------------------------------------------------------------------------------------
	
	private static int[] buscarAristaMasPesada( Grafo grafo )
	{
		int mayorPeso = -1;
		
		int[] aristaParaCortar = new int[ 2 ];
		
		for ( int i = 0 ; i < grafo.cantidadVertices(); i++ ) 
		{
			for( int j = 0; j < grafo.cantidadVertices(); j++ ) 
			{
				if( grafo.pesoDeArista( i, j ) > mayorPeso && grafo.existeArista( i, j ) ) 
				{
					aristaParaCortar[ 0 ] = i;
					aristaParaCortar[ 1 ] = j;
					mayorPeso = grafo.pesoDeArista( i, j );
				}
			}
		}
		return aristaParaCortar;
	}
	
	
}
