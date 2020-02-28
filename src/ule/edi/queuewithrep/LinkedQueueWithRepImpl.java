package ule.edi.queuewithrep;

import java.util.Iterator;

import ule.edi.exceptions.EmptyCollectionException;

public class LinkedQueueWithRepImpl<T> implements QueueWithRep<T> {

	
	@SuppressWarnings("hiding")
	public class ElemQueueWithRep<T> {
		T elem;
		int num;
		public ElemQueueWithRep (T elem, int num){
			this.elem=elem;
			this.num=num;
		}
	}

	
	///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class LinkedQueueWithRepIterator<T> implements Iterator<T> {
		
	
		public LinkedQueueWithRepIterator(ElemQueueWithRep<T>[] cola, int count){
			
			//TODO
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
		//TODO
	}
	
	@Override
	public void add(T element, int times) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		
	}

	
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		//TODO 
		
		final StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");

		// TODO Ir añadiendo en buffer las cadenas para la representación de esta bolsa
		
		buffer.append(")");
		
		return buffer.toString();
	}

	@Override
	public int remove() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove(T element, int times) {
		// TODO Auto-generated method stub
		
	}

}
