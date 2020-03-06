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

		public QueueWithRepNode(T elem, int num) {
			this.elem = elem;
			this.num = num;
		}

	}

	///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class LinkedQueueWithRepIterator<T> implements Iterator<T> {
		
		private QueueWithRepNode<T> nodo;
		private int nodeQty;

		public LinkedQueueWithRepIterator(QueueWithRepNode<T> nodo) {
			this.nodo = nodo;
			this.nodeQty = 0;
			
			if(nodo!=null) {
				this.nodeQty = this.nodo.num;
			}

		}

		@Override
		public boolean hasNext() {
			
			if( this.nodeQty == 0 && this.nodo.next == null ) {
				return false;
			}
			return true;
			
		}

		@Override
		public T next() {
				
			if(!this.hasNext()) 
				throw new NoSuchElementException();
			
			if(this.nodeQty == 0) {
				this.nodo = this.nodo.next;
				this.nodeQty = this.nodo.num;
				
			}
			
			this.nodeQty--;
			return this.nodo.elem;
		}

	}
	////// FIN ITERATOR

	public LinkedQueueWithRepImpl() {
		this.front = null;
		this.count = 0;
	}

	/////////////
	@Override
	public void add(T element) {

		add(element, 1);
	}

	@Override
	public void add(T element, int times) {

		if (element == null)
			throw new NullPointerException();
		if (times <= 0)
			throw new IllegalArgumentException();

		if (this.front == null) {
			this.front = new QueueWithRepNode<T>(element, times);
			front.next = null;
			this.count++;
		} else {
			QueueWithRepNode<T> aux = this.front;
			boolean found = false;
			while (!found & aux != null) {

				if (aux.elem.equals(element)) {
					found = true;
					aux.num += times;
				}

				aux = aux.next;
			}

			if (!found) {
				aux = front;
				while (aux != null) {
					aux = aux.next;
				}
				aux = new QueueWithRepNode<T>(element, times);
				aux.next = null;
				this.count++;
			}

		}

	}

	@Override
	public void remove(T element, int times) {
		
		if (element == null)
			throw new NullPointerException();
		if (times < 0)
			throw new IllegalArgumentException();
		
		boolean found = false;
		QueueWithRepNode<T> aux = this.front;
		
		while (!found && aux!=null) {
			
			if (aux.elem.equals(element)) {
				found = true;
				if (aux.num > times) {
					aux.num -= times;
				} else {
					throw new IllegalArgumentException();
				}
			}
			aux = aux.next;
		}

		if (!found) {
			throw new NoSuchElementException();
		}
		

	}

	@Override
	public boolean contains(T element) {
		if (element == null)
			throw new NullPointerException();	
		
		boolean found = false;
		QueueWithRepNode<T> aux = this.front;
		
		while (!found && aux!=null) {
			if(aux.elem.equals(element)) {
				found = true;
			}
			
			aux = aux.next;
		}
		return found;
	}

	@Override
	public long size() {
		long size = 0;
		QueueWithRepNode<T> aux = this.front;
		while(aux!= null) {
			
			size +=aux.num; 
			aux = aux.next;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return front==null;
	}

	@Override
	public int remove() throws EmptyCollectionException {
		
		if(front == null)
			throw new EmptyCollectionException("Empty Collection");
		
		int apariciones = this.front.num;
		QueueWithRepNode<T> aux = this.front.next;
		this.front.next = null;
		this.front = aux;
		
		this.count--;
		return apariciones;

	}

	@Override
	public void clear() {
		
		while(front !=null) {
			QueueWithRepNode<T> aux = this.front.next;
			front.next = null;
			front = aux;
		}
		count = 0;
	}

	@Override
	public int count(T element) {
		if (element == null)
			throw new NullPointerException();	
		
		int count = 0;
		boolean found = false;
		QueueWithRepNode<T> aux = this.front;
		
		while (!found && aux!=null) {
			if(aux.elem.equals(element)) {
				found = true;
				count = aux.num;
			}
			aux = aux.next;
		}
		return count;
	}

	@Override
	public Iterator<T> iterator() {
				
		return new LinkedQueueWithRepIterator<T>(this.front);
	}

	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("(");

		// TODO Ir añadiendo en buffer las cadenas para la representación de la cola.
		// Ejemplo: (A, A, A, B )
		
		QueueWithRepNode<T> aux = this.front;
		while(aux!= null) {
				
			for(int j = 0; j<aux.num; j++) {
				buffer.append(aux.elem.toString()+" ");
			}
		aux = aux.next;	
		}

		buffer.append(")");
		return buffer.toString();
	}

}
