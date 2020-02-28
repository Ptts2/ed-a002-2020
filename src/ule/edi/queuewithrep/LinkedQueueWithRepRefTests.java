package ule.edi.queuewithrep;

public class LinkedQueueWithRepRefTests extends AbstractQueueWithRefTests {

	@Override
	protected <T> QueueWithRep<T> createQueueWithRep() {
		
		return new LinkedQueueWithRepImpl<T>();
	}

}
