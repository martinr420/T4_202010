package model.data_structures;

public class MaxColaCP<K extends Comparable<K>> implements IMaxColaCP<K>
{
	private int tamano;
	private Nodo<K> primero;
	private Nodo<K> ultimo;

	public MaxColaCP()
	{
		tamano= 0;
		primero = null;
		ultimo = null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return tamano;
	}

	@Override
	public void insert(K key) {
		Nodo<K> nuevo = new Nodo<K>(key);
		if(tamano == 0)
		{
			primero = nuevo;
			ultimo = nuevo;
			tamano++;
		}
		else
		{
			ultimo.cambiarSiguiente(nuevo);
			ultimo = nuevo;
		}
		// TODO Auto-generated method stub

	}

	@Override
	public K max() throws noExisteObjetoException
	{
		if(tamano == 0)
		{
			throw new noExisteObjetoException();
		}
		Nodo<K> mayor = primero;
		Nodo<K> actual = mayor.darSiguiente();

		while(actual.hasNext())
		{
			if(mayor.generic().compareTo(actual.generic()) < 0)
			{
				mayor = actual;
			}
		}
		// TODO Auto-generated method stub
		return mayor.generic();
	}

	@Override
	public K deleteMax() throws noExisteObjetoException
	{
		if(tamano == 0)
		{
			throw new noExisteObjetoException();
		}

		Nodo<K> eliminar = primero;
		Nodo<K> actual = (Nodo<K>) primero.next();
		
		while(actual.hasNext())
		{
			if(eliminar.generic().compareTo(actual.generic()) < 0)
			{
				eliminar = actual;
			}
			actual = (Nodo<K>) actual.next();
		}
		eliminar.darAnterior().cambiarSiguiente(eliminar.darSiguiente());
		eliminar.darSiguiente().cambiarAnterior(eliminar.darAnterior());
		eliminar.desconectarSiguiente();
		eliminar.desconectarAnterior();

		// TODO Auto-generated method stub
		return eliminar.generic();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tamano == 0;
	}



}
