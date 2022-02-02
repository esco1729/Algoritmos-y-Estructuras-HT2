/**
 * 
 */
package src;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author José Auyón
 *
 */
public class MyStackTest {

	/**
	 * Test method for {@link src.MyStack#add(java.lang.Object)}.
	 */
	@Test
	public final void testAdd() {

		MyStack testAdd = new MyStack(new ArrayList<Object>());
		assertEquals(0, testAdd.size()); // TODO
		testAdd.add("test");
		assertEquals(1, testAdd.size());
	}

	/**
	 * Test method for {@link src.MyStack#remove()}.
	 */
	@Test

	public final void testRemove() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add("A");
		lista.add("B");
		lista.add("C");
		MyStack testRemove = new MyStack(lista);
		// TODO
		assertEquals(3, testRemove.size());
		testRemove.remove();
		assertEquals(2, testRemove.size());
	}

	/**
	 * Test method for {@link src.MyStack#peek()}.
	 */
	@Test
	public final void testPeek() {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.add("A");
		lista.add("B");
		lista.add("C");
		MyStack testPeek = new MyStack(lista);
		assertEquals("C", testPeek.peek()); // TODO
	}

	/**
	 * Test method for {@link src.MyStack#size()}.
	 */
	@Test
	public final void testSize() {
		MyStack testSize = new MyStack(new ArrayList<Object>());
		assertEquals(0, testSize.size()); // TODO
	}

}
