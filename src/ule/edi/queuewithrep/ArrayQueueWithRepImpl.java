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

		public ArrayQueueWithRepIterator(ElemQueueWithRep<T>[] cola, int count) {

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
			throw new NullPointerException("Elemento null");
		if (times <= 0)
			throw new IllegalArgumentException("Times es negativo o 0");

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
			throw new NullPointerException("Elemento null");

		boolean found = false;
		int i = 0;
		while (!found && i < this.data.length) {
			if (this.data[i] != null && this.data[i].elem.equals(element)) {
				found = true;
				if (this.data[i].num > times) {
					this.data[i].num -= times;
				} else {
					throw new IllegalArgumentException("Numero de times incorrecto");
				}
			}
			i++;
		}

		if (!found) {
			throw new NoSuchElementException("El elemento no esta en la cola");
		}
	}

	@Override
	public int remove() throws EmptyCollectionException {
		if (this.data[0] == null)
			throw new EmptyCollectionException("La lista esta vacía.");
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
			throw new NullPointerException("Elemento null");

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
			throw new NullPointerException("Elemento null");

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
		// TODO
		return null;

	}

	@Override
	public String toString() {

		final StringBuffer buffer = new StringBuffer();

		buffer.append("(");

		// TODO Ir añadiendo en buffer las cadenas para la representación de la cola.
		// Ejemplo: (A, A, A, B )

		buffer.append(")");

		return buffer.toString();
	}

}
