package algoritmos;

import java.util.ArrayList;
import clustering.Grafo;

public class AGM 
{
	//------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------
	public static Grafo arbolGeneradorMinimo(Grafo grafo) 
	{
		//creo que primero tengo que preguntar si es conexo
		Grafo grafoNuevo = new Grafo(grafo.tamano());
		
		ArrayList<Integer> marcados = new ArrayList<Integer>();
		
		ArrayList<int[]> vecinosPendientes = new ArrayList<int[]>(); 
		
		marcados.add(0);
		vecinosPendientes = agregarVecinosPendientes(grafo, 0, vecinosPendientes, marcados);
		
		
		for(int i = 1; i < grafo.tamano(); i++) //for(int i = 1; i < grafo.tamano(); i++) 
		{
			
			int indice = buscarVecinoMenorPeso(vecinosPendientes, marcados); //el indice tiene la posicion del arraylist 
																	//vecinosPendientes del vecino con menor peso
			int vertice_i = vecinosPendientes.get(indice)[0];
			int vertice_j = vecinosPendientes.get(indice)[1];
			int peso      = vecinosPendientes.get(indice)[2];
			
			grafoNuevo.agregarArista( vertice_i, vertice_j, peso );
			
			marcados.add(vecinosPendientes.get(indice)[0]);
			 
			vecinosPendientes = agregarVecinosPendientes(grafo, vertice_i, vecinosPendientes, marcados);
			vecinosPendientes = eliminarMarcados(grafo, vecinosPendientes, marcados);
			//vecinosPendientes.remove(indice);
		}
		return grafoNuevo;
	}
	//------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------
	

	private static ArrayList<int[]> agregarVecinosPendientes(Grafo grafo, int vertice, ArrayList<int[]> vPendientes, ArrayList<Integer> marcados) 
	{
		for(Integer it : grafo.vecinos(vertice)) 
		{
			int[] array = new int[3];   //creo el arreglo que despues se va a guardar en el arraylist
			array[0]= it;
			array[1]= vertice;
			array[2]= grafo.pesoDeArista(it, vertice);
			vPendientes.add(array);
		} 
		return vPendientes;
	}
	
	
	
	private static ArrayList<int[]> eliminarMarcados(Grafo grafo, ArrayList<int[]> vPendientes, ArrayList<Integer>marcados)
	{
		ArrayList<int[]> temporal = new ArrayList<int[]>();
		int rango = vPendientes.size();
		for(int i = 0; i < rango; i++) 
		{
			if(!marcados.contains(vPendientes.get(i)[0])) 
			{
				temporal.add(vPendientes.get(i));
			}
		}
		return temporal;
	}
	 
	
	
	private static int buscarVecinoMenorPeso(ArrayList<int[]> vecinosPendientes, ArrayList<Integer> marcados) 
	{
		int indice = 0;
		int menorPeso = vecinosPendientes.get(0)[2];
		
		if(vecinosPendientes.size() == 1) 
			return 0;
		
		for(int i = 0; i < vecinosPendientes.size()-1; i++) 
		{
			if(vecinosPendientes.get(i)[2] <= vecinosPendientes.get(i+1)[2]) 
			{
					if(vecinosPendientes.get(i)[2] <= menorPeso)
					{
						menorPeso = vecinosPendientes.get(i)[2];
						indice = i;
					}
			}
			else 
			{
					if(vecinosPendientes.get(i+1)[2] <= menorPeso)
					{
						menorPeso = vecinosPendientes.get(i+1)[2];
						indice = i+1;
					}
			}
		}
		return indice;
	}
	
}
