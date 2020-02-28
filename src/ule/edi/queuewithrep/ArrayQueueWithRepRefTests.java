package ule.edi.queuewithrep;

public class ArrayQueueWithRepRefTests extends AbstractQueueWithRefTests {

	@Override
	protected <T> QueueWithRep<T> createQueueWithRep() {
		
		return new ArrayQueueWithRepImpl<T>();
	}

}
