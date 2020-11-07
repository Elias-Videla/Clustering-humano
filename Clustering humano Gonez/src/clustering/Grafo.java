package clustering;

import java.io.Serializable;
import java.util.ArrayList;


public class Grafo implements Serializable
{
	private int [][] A;
	private static final long serialVersionUID = 1L;

	
	public Grafo( int vertices )  
	{
		A = new int [ vertices ][ vertices ];
		
		for( int i = 0; i < vertices; i++ ) 
		{
			for( int j = 0; j < vertices; j++ ) 
			{
				A[ i ][ j ] = -1;
			}
		}
	}

	
	public void agregarArista( int i, int j, int peso ) 
	{
		verificarVerticeValido( i );
		verificarVerticeValido( j );
		verificarDistintos( i, j ); 

		A[ i ][ j ] = peso;
		A[ j ][ i ] = peso;
	}


	public boolean existeArista( int i , int j ) 
	{
		verificarVerticeValido( i );
		verificarVerticeValido( j );
		verificarDistintos( i, j );
		return A[ i ][ j ] >= 0;    
	}
	
	
	public int pesoDeArista( int i, int j ) 
	{
		return A[ i ][ j ]; 
	}
	
	
	
	public ArrayList< Integer > vecinos ( int i )
	{
		verificarVerticeValido( i );
		
		ArrayList< Integer > ret = new ArrayList< Integer >();
		for( int j = 0; j< tamano(); ++j ) if( i != j )
		{
			if( existeArista( i,j ) )
				ret.add( j );
		}
		return ret;
	}
	
	
	public int tamano()  
	{ 
		return A.length;
	}
	
	
	public void eliminarArista( int i, int j ) 
	{
		verificarVerticeValido( i );
		verificarVerticeValido( j );
		verificarDistintos( i, j );

		A[ i ][ j ] = -1;  
		A[ j ][ i ] = -1;
	}
	
	
	
	
	//Metodos privados-----------------------------------------------------------------------------------------
	private void verificarVerticeValido( int i ) 
	{
		if( i < 0 )
			throw new IllegalArgumentException( "El vertice no puede ser negativo: " + i );
		if( i >= A.length )
			throw new IllegalArgumentException( "Los vertiices deben estar entre 0 y |V| " + i );
	}
	
	private void verificarDistintos( int i, int j ) 
	{
		if( i == j )
			throw new IllegalArgumentException( "No se permiten loops" );
	}
	
	
}
