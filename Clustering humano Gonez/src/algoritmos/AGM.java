package algoritmos;

import java.io.Serializable;
import java.util.ArrayList;
import clustering.Grafo;

public class AGM implements Serializable
{
	private static final long serialVersionUID = 1L;

	//------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------
	public static Grafo arbolGeneradorMinimo( Grafo grafo ) 
	{
		if( !BFS.esConexo( grafo ) )
			throw new IllegalArgumentException( "El grafo no es conexo" );
		
		Grafo grafoAGM = new Grafo( grafo.tamano() );
		
		ArrayList< Integer > marcados = new ArrayList< Integer >();
		
		ArrayList< int[] > vecinosPendientes = new ArrayList< int[] >(); 
		
		marcados.add( 0 );
		
		vecinosPendientes = agregarVecinosPendientes( grafo, 0, vecinosPendientes );
		
		for( int i = 1; i < grafo.tamano(); i++ ) 
		{
			int indiceDelArrayPendientes = buscarVecinoMenorPeso( vecinosPendientes ); 
																	
			int vertice_i = vecinosPendientes.get( indiceDelArrayPendientes )[ 0 ];
			int vertice_j = vecinosPendientes.get( indiceDelArrayPendientes )[ 1 ];
			int peso      = vecinosPendientes.get( indiceDelArrayPendientes )[ 2 ];
			
			grafoAGM.agregarArista( vertice_i, vertice_j, peso );
			
			marcados.add( vecinosPendientes.get( indiceDelArrayPendientes )[0] );
			 
			vecinosPendientes = agregarVecinosPendientes( grafo, vertice_i, vecinosPendientes );
			vecinosPendientes = eliminarMarcados( vecinosPendientes, marcados );
		}
		
		return grafoAGM; 
	}
	//------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------
	

	private static ArrayList< int[] > agregarVecinosPendientes( Grafo grafo, int vertice, ArrayList< int[] > vPendientes ) 
	{
		for( Integer it : grafo.vecinos( vertice ) ) 
		{
			int[] parVerticesYpeso = new int[ 3 ];    
			
			parVerticesYpeso[ 0 ] = it;
			parVerticesYpeso[ 1 ] = vertice;
			parVerticesYpeso[ 2 ] = grafo.pesoDeArista( it, vertice );
			
			vPendientes.add( parVerticesYpeso );
		} 
		
		return vPendientes;
	}
	
	
	
	
	private static ArrayList< int[] > eliminarMarcados( ArrayList< int[] > vecinosPendientes, ArrayList< Integer > marcados )
	{
		ArrayList< int[] > listaSinMarcados = new ArrayList< int[] >();
		
		int rango = vecinosPendientes.size();
		
		for( int i = 0; i < rango; i++ ) 
		{
			if( !marcados.contains( vecinosPendientes.get( i )[ 0 ] ) ) 
			{
				listaSinMarcados.add( vecinosPendientes.get( i ) );
			}
		}
		
		return listaSinMarcados;
	}
	 
	
	
	
	private static int buscarVecinoMenorPeso( ArrayList< int[] > vecinosPendientes ) 
	{
		int indice = 0;
		int menorPeso = vecinosPendientes.get( 0 )[ 2 ];
		
		if( vecinosPendientes.size() == 1 ) 
			return 0;
		
		for( int i = 0; i < vecinosPendientes.size()-1; i++ ) 
		{
			if( vecinosPendientes.get( i )[ 2 ] <= vecinosPendientes.get( i+1 )[ 2 ]) 
			{
					if( vecinosPendientes.get( i )[ 2 ] <= menorPeso )
					{
						menorPeso = vecinosPendientes.get( i )[ 2 ];
						indice = i;
					}
			}
			else 
			{
					if( vecinosPendientes.get( i+1 )[ 2 ] <= menorPeso ) 
					{
						menorPeso = vecinosPendientes.get( i+1 )[ 2 ];
						indice = i+1;
					}
			}
		}
		return indice;
	}
	
	
}
