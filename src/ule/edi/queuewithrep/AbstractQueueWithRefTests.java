package ule.edi.queuewithrep;


import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

import ule.edi.exceptions.EmptyCollectionException;

public abstract class AbstractQueueWithRefTests {

	protected abstract <T> QueueWithRep<T> createQueueWithRep();
	

	private QueueWithRep<String> S1;

	private QueueWithRep<String> S2;
	
	@Before
	public void setupQueueWithReps() {

		this.S1 = createQueueWithRep();
		
		this.S2 = createQueueWithRep();
		
		S2.add("ABC", 5);
		S2.add("123", 5);
		S2.add("XYZ", 10);
	}

	@Test
	public void testConstructionIsEmpty() {
		assertTrue(S1.isEmpty());
		assertFalse(S2.isEmpty());
	}
	
	@Test
	//Las nuevas instancias del TAD tienen tamaño cero: 
	public void testConstructionCardinality() {
		assertEquals(S1.size(), 0);
	}

	@Test
	public void testToStringInEmpty() {
		assertTrue(S1.isEmpty());
		assertEquals(S1.toString(), "()");
	}
	
	@Test
	public void testToString1elem() {
		assertTrue(S1.isEmpty());
		S1.add("A",3);
		assertEquals(S1.toString(), "(A A A )");
	}
	
	@Test
	//Añadir elementos con una multiplicidad incrementa su contador y el tamaño de la cola: ")
	public void testAddWithCount() {
		S1.add("ABC", 5);
		assertEquals(S1.count("ABC"), 5);
		assertEquals(S1.size(), 5);
		S1.add("ABC", 5);
		assertEquals(S1.count("ABC"), 10);
		assertEquals(S1.size(), 10);
		S1.add("123", 5);		
		assertEquals(S1.count("123"), 5);
		assertEquals(S1.count("ABC"), 10);
		assertEquals(S1.size(), 15);
	}
	
	
	@Test
	//Se pueden eliminar cero instancias de un elemento con remove(x, 0): ")
	public void testRemoveZeroInstances() {
		S2.remove("ABC", 0);
	}
	
	@Test
	public void testIterator() {
		Iterator<String> iteradorVacio = S1.iterator();
		S1.add("ABC", 5);
		S1.add("XYZ", 5);
		int ABCs = 0;
		int XYZs = 0;
		Iterator<String> iterador = S1.iterator();
		
		Assert.assertTrue(iterador.hasNext());
		while(iterador.hasNext()) {
			if(ABCs < 5) {
				Assert.assertTrue(iterador.next().equals("ABC"));
				ABCs++;
			}else {
				Assert.assertTrue(iterador.next().equals("XYZ"));
				XYZs++;
			}
		}
		Assert.assertFalse(iterador.hasNext());
		Assert.assertTrue(ABCs == 5);
		Assert.assertTrue(XYZs == 5);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNoNext() {
		Iterator<String> iterador = S1.iterator();
		iterador.next();
	}
	
	@Test
	public void testAddOnlyOne() {
		S1.add("ABC");
		Assert.assertTrue(S1.count("ABC") == 1);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNull() {
		S1.add(null, 3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddNegativeItems() {
		S1.add("ABC", -5);
	}

	
	@Test
	public void testRemoveElements() {
		S1.add("ABC", 5);
		assertEquals(S1.count("ABC"), 5);
		assertEquals(S1.size(), 5);
		S1.remove("ABC", 2);
		assertEquals(S1.count("ABC"), 3);
		assertEquals(S1.size(), 3);
		S1.add("123", 5);		
		assertEquals(S1.count("123"), 5);
		assertEquals(S1.size(), 8);
		S1.remove("123", 1);	
		assertEquals(S1.count("123"), 4);
		assertEquals(S1.size(), 7);
	}
	
	@Test
	public void testRemove() throws Exception{
		S1.add("ABC",3);
		S1.add("XYZ", 4);
		Assert.assertEquals(S1.size(),7);
		Assert.assertEquals(S1.remove(),3);
		Assert.assertEquals(S1.size(),4);
	}
	
	@Test(expected = EmptyCollectionException.class)
	public void restRemoveEmptyQueue() throws Exception{
		S1.remove();
	}
	
	@Test(expected = NullPointerException.class)
	public void testRemoveNull() {
		S1.remove(null, 3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveNegativeItems() {
		S1.remove("ABC", -5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveTooManyItems() {
		S1.add("ABC", 3);
		S1.remove("ABC", 4);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRemoveNonExistingItem() {
		S1.remove("ABC",2);
	}
	
	@Test
	public void testClear() {
		S1.add("ABC",3);
		S1.add("XYZ", 9);
		S1.add("123");
		Assert.assertEquals(S1.size(),13);
		S1.clear();
		Assert.assertEquals(S1.size(),0);
	}
	
	@Test
	public void testContains() {
		S1.add("ABC");
		Assert.assertTrue(S1.contains("ABC"));
		Assert.assertFalse(S1.contains("111"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testContainsNull() {
		S1.contains(null);
	}
	
	@Test
	public void testIsEmpty() {
		Assert.assertTrue(S1.isEmpty());
		S1.add("ABC");
		Assert.assertFalse(S1.isEmpty());
	}
	
	@Test
	public void testSize() {
		Assert.assertEquals(S1.size(),0);
		S1.add("ABC", 10);
		S1.add("XYZ", 12);
		Assert.assertEquals(S1.size(),22);
	}
	
	@Test
	public void testCount() {
		S1.add("ABC", 10);
		S1.add("XYZ", 12);
		Assert.assertEquals(S1.count("ABC"),10);
		Assert.assertEquals(S1.count("XYZ"),12);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCountNull() {
		S1.count(null);
	}
	
	@Test
	public void testToStringManyElements() {

		S1.add("A",3);
		S1.add("B", 4);
		assertEquals(S1.toString(), "(A A A B B B B )");
	}
}
