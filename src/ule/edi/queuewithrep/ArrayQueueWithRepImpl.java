package ule.edi.queuewithrep;

import java.util.Iterator;


import ule.edi.exceptions.EmptyCollectionException;

public class ArrayQueueWithRepImpl<T> implements QueueWithRep<T> {
	
	// atributos
	
    private final int capacityDefault = 10;
	
	ElemQueueWithRep<T>[] data;
    private int count; // Numero de elementos distintos en el array
    
	
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
	public class ArrayQueueWithRepIterator<T> implements Iterator<T> {
		
	
		public ArrayQueueWithRepIterator(ElemQueueWithRep<T>[] cola, int count){
			
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
	
	
    
	@SuppressWarnings("unchecked")
	public ArrayQueueWithRepImpl() {
		this.data = new ElemQueueWithRep[this.capacityDefault];
		this.count = 0;
	}
	
	
	
	
			@Override
			public void add(T element, int times) {
				
				if(element == null)
					throw new NullPointerException("Elemento null");
				if(times<=0)
					throw new IllegalArgumentException("Times es negativo o 0");
				
				boolean found = false;
				int i = 0, firstEmptyPos = -1;
				
				while(!found && i<this.data.length)
				{
					
					if(firstEmptyPos == -1 && this.data[i] == null)
					{
						firstEmptyPos = 0;
					}
					if(this.data[i] != null && this.data[i].elem.equals(element))
					{
						found = true;
						this.data[i].num += times;
					}

					i++;
				}
				
				if(!found && firstEmptyPos != -1)
				{
					this.data[firstEmptyPos] = new ElemQueueWithRep<T>(element, times);
					count++;
				}else 
				{
					firstEmptyPos = data.length;
					ElemQueueWithRep<T>[] larger = new ElemQueueWithRep[data.length*2];
					for(i = 0; i<data.length;i++) 
					{
						larger[i] = data[i];
					}
					data[firstEmptyPos] = new ElemQueueWithRep<T>(element, times);
					count++;
				}
			
				
			}
			


			@Override
			public void add(T element) {
				this.add(element, 1);
			}

			@Override
			public void remove(T element, int times)  {
				
				if(element == null)
					throw new NullPointerException("Elemento null");
				
				boolean found = false;
				int i = 0;
				while(!found && i<this.data.length)
				{

					if(this.data[i] != null && this.data[i].elem.equals(element))
					{
						found = true;
						if(this.data[i].num > times) {
							this.data[i].num -= times;
						}else {
							throw new IllegalArgumentException("Numero de times incorrecto");
						}
					}

					i++;
				}
				
				//if(!found) {
					//throw new NoSuchElementException("El elemento no esta en la cola");
				//}
				
			}

			@Override
			public int remove() throws EmptyCollectionException {
				
				if(this.data[0]==null)
					throw new EmptyCollectionException("La lista esta vac�a.");
				else 
				{
					int apariciones = this.data[0].num;
					
					for(int i = 1; i < this.data.length; i++)
					{
						this.data[i] = this.data[i-1];
					}
					this.data[this.data.length] = null;
					return apariciones;
				}
			}

			@Override
			public void clear() {
				
				for(int i = 0; i<this.data.length; i++) {
					this.data[i] = null;
				}
				
			}
			

			@Override
			public boolean contains(T element) {
				
				if(element == null)
					throw new NullPointerException("Elemento null");
				
				boolean found = false;
				int i = 0;
				
				while(!found && i<this.data.length){
					
					if(this.data[i]!= null && this.data[i].elem.equals(element)) {
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
				
				while(empty && i < this.data.length) {
					
					if(this.data[i]!=null) {
						empty = false;
					}
					i++;
				}
				
				return empty;
			}

			@Override
			public long size() {
				
				long size = 0;
				for(int i = 0; i<this.data.length; i++) {
					
					if(this.data[i] != null) {
						size += this.data[i].num; 
					}
				}
			 return size;
			 
			}

			@Override
			public int count(T element) {
				
				if(element == null)
					throw new NullPointerException("Elemento null");
				
				boolean found = false;
				int i = 0, elements = 0;
				
				while(!found && i<this.data.length){
					
					if(this.data[i]!= null && this.data[i].elem.equals(element)) {
						found = true;
						elements = this.data[i].num;
					}
					
					i++;
				}
				
				return elements;
		          
			}

			@Override
			public Iterator<T> iterator() {
				return null;
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String toString() {
				
				final StringBuffer buffer = new StringBuffer();
				
				buffer.append("(");

				// TODO Ir añadiendo en buffer las cadenas para la representación de esta cola
				
				
				buffer.append(")");
				
				return buffer.toString();
			}
	

//
//
//	

	
}
