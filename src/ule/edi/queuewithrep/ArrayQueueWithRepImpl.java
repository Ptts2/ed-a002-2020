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
				
			}

			@Override
			public void remove(T element, int times)  {
		
			}

			@Override
			public int remove() throws EmptyCollectionException {
				return 0;
				//TODO		
			}

			@Override
			public void clear() {
				//TODO
			}
			

			@Override
			public boolean contains(T element) {
				//TODO
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
