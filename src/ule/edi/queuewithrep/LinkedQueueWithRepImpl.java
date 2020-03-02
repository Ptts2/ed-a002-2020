package ule.edi.queuewithrep;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;


public class LinkedQueueWithRepImpl<T> implements QueueWithRep<T> {
 
	// Atributos
	private QueueWithRepNode<T> front;
	int count;
	
	
	// Clase interna
	@SuppressWarnings("hiding")
	public class QueueWithRepNode<T> {
		T elem;
		int num;
		QueueWithRepNode<T> next;
		
		public QueueWithRepNode (T elem, int num){
			this.elem=elem;
			this.num=num;
		}
		
	}
	
	///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class LinkedQueueWithRepIterator<T> implements Iterator<T> {
		
	
		
       	
		public LinkedQueueWithRepIterator(QueueWithRepNode<T> nodo) {
				}
		
		@Override
		public boolean hasNext() {
			//TODO
			return false;
		}

		@Override
		public T next() {
			//TODO
			return null;
		}

		

	}
	////// FIN ITERATOR
	
	public LinkedQueueWithRepImpl() {
		}

	/////////////
	@Override
	public void add(T element) {
		//todo
		
	}
	
	@Override
	public void add(T element, int times) {
		//todo

		}


	@Override
	public void remove(T element, int times) {
		//todo

		
	}

	
	@Override
	public boolean contains(T element) {
		//todo
		return false;
		
	}

	@Override
	public long size() {
		//todo

		return 0;
	}

	@Override
	public boolean isEmpty() {
		//todo

		return false;
	}

	@Override
	public int remove() throws EmptyCollectionException {
		//todo
		return 0;
		
	}

	@Override
	public void clear() {
		//todo

	}

	@Override
	public int count(T element) {
		//todo

		return 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO 
		return null;
	}


	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");
		
		// TODO Ir añadiendo en buffer las cadenas para la representación de la cola. Ejemplo: (A, A, A, B )
		
		
		buffer.append(")");
		return buffer.toString();
	}

	
	

}
