package ule.edi.queuewithrep;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.exceptions.EmptyCollectionException;

public class ArrayQueueWithRepImpl<T> implements QueueWithRep<T> {

	// atributos

	private final int capacityDefault = 10;

	ElemQueueWithRep<T>[] data;
	private int count;

	// Clase interna

	@SuppressWarnings("hiding")
	public class ElemQueueWithRep<T> {
		T elem;
		int num;

		public ElemQueueWithRep(T elem, int num) {
			this.elem = elem;
			this.num = num;
		}
	}

	///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class ArrayQueueWithRepIterator<T> implements Iterator<T> {
		
		private int count;
		private int actual;
		private T[] cola;
		
		@SuppressWarnings("unchecked")
		public ArrayQueueWithRepIterator(ElemQueueWithRep<T>[] cola, int count) {
			this.count = count;
			this.actual = 0;
			this.cola = (T[]) cola;
		}

		@Override
		public boolean hasNext() {
			return actual < count;
		}

		@Override
		public T next() {
			
			if(!this.hasNext()) 
				throw new NoSuchElementException();
			
			count++;
			return cola[count-1];
		}

	}
	////// FIN ITERATOR

	// Constructores

	@SuppressWarnings("unchecked")
	public ArrayQueueWithRepImpl() {
		this.data = new ElemQueueWithRep[capacityDefault];
		this.count = 0;
	}

	@SuppressWarnings("unchecked")
	public ArrayQueueWithRepImpl(int capacity) {
		this.data = new ElemQueueWithRep[capacity];
		this.count = 0;
	}

	@SuppressWarnings("unchecked")
	private void expandCapacity() {

		ElemQueueWithRep<T>[] nuevo = (ElemQueueWithRep<T>[]) new ElemQueueWithRep[data.length * 2];

		for (int i = 0; i < data.length; i++)
			nuevo[i] = data[i];

		data = nuevo;
	}

	@Override
	public void add(T element, int times) {

		if (element == null)
			throw new NullPointerException();
		if (times <= 0)
			throw new IllegalArgumentException();

		boolean found = false;
		int i = 0, firstEmptyPos = -1;

		while (!found && i < this.data.length) {

			if (firstEmptyPos == -1 && this.data[i] == null) {
				firstEmptyPos = i;
			}

			if (this.data[i] != null && this.data[i].elem.equals(element)) {
				found = true;
				this.data[i].num += times;
			}

			i++;
		}

		if (!found) {
			if (firstEmptyPos == -1) {
				firstEmptyPos = data.length;
				expandCapacity();
			}
			this.data[firstEmptyPos] = new ElemQueueWithRep<T>(element, times);
			count++;
		}
	}

	@Override
	public void add(T element) {
		this.add(element, 1);
	}

	@Override
	public void remove(T element, int times) {

		if (element == null)
			throw new NullPointerException();

		boolean found = false;
		int i = 0;
		while (!found && i < this.data.length) {
			if (this.data[i] != null && this.data[i].elem.equals(element)) {
				found = true;
				if (this.data[i].num > times) {
					this.data[i].num -= times;
				} else {
					throw new IllegalArgumentException();
				}
			}
			i++;
		}

		if (!found) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public int remove() throws EmptyCollectionException {
		if (this.data[0] == null)
			throw new EmptyCollectionException("La cola esta vacia");
		else {
			int apariciones = this.data[0].num;

			for (int i = 1; i < this.data.length; i++) {
				this.data[i] = this.data[i - 1];
			}
			this.data[this.data.length] = null;
			return apariciones;
		}

	}

	@Override
	public void clear() {
		for (int i = 0; i < this.data.length; i++) {
			this.data[i] = null;
		}

	}

	@Override
	public boolean contains(T element) {
		if (element == null)
			throw new NullPointerException();

		boolean found = false;
		int i = 0;

		while (!found && i < this.data.length) {

			if (this.data[i] != null && this.data[i].elem.equals(element)) {
				found = true;
			}

			i++;
		}

		return found;

	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		int i = 0;

		while (empty && i < this.data.length) {

			if (this.data[i] != null) {
				empty = false;
			}
			i++;
		}

		return empty;

	}

	@Override
	public long size() {
		long size = 0;
		for (int i = 0; i < this.data.length; i++) {

			if (this.data[i] != null) {
				size += this.data[i].num;
			}
		}
		return size;

	}

	@Override
	public int count(T element) {
		if (element == null)
			throw new NullPointerException();

		boolean found = false;
		int i = 0, elements = 0;

		while (!found && i < this.data.length) {

			if (this.data[i] != null && this.data[i].elem.equals(element)) {
				found = true;
				elements = this.data[i].num;
			}

			i++;
		}

		return elements;

	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayQueueWithRepIterator<T>(this.data, this.count) ;

	}

	@Override
	public String toString() {

		final StringBuffer buffer = new StringBuffer();

		buffer.append("(");

		// TODO Ir anyadiendo en buffer las cadenas para la representacion de la cola.
		// Ejemplo: (A, A, A, B )
		
		for(int i = 0; i<this.data.length; i++) {
			if(this.data[i] != null) {
				buffer.append(this.data[i].elem.toString());
				buffer.append(", ");
			}
		}
		
		buffer.append(")");

		return buffer.toString();
	}

}
