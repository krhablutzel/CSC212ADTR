package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}
	
	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}
	
	@Test(expected=EmptyListError.class) // Test is expected to crash
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}
	
	@Test
	public void testAddToBack() {
		ListADT<String> data =  makeEmptyList();
		assertTrue(data.isEmpty());
		data.addBack("b");
		assertEquals(1, data.size());
		assertEquals("b", data.getIndex(0));
		assertFalse(data.isEmpty());
		data.addBack("e");
		assertEquals(2, data.size());
		assertEquals("b", data.getIndex(0));
		assertEquals("e", data.getIndex(1));
		assertFalse(data.isEmpty());
		data.addBack("e");
		assertEquals(3, data.size());
		assertEquals("b", data.getIndex(0));
		assertEquals("e", data.getIndex(1));
		assertEquals("e", data.getIndex(2));
		assertFalse(data.isEmpty());
		data.addBack("s");
		assertEquals("b", data.getIndex(0));
		assertEquals("e", data.getIndex(1));
		assertEquals("e", data.getIndex(2));
		assertEquals("s", data.getIndex(3));
		assertFalse(data.isEmpty());
	}
	
	@Test
	public void testAddIndex() {
		ListADT<String> data = makeFullList();
		assertFalse(data.isEmpty());
		int dSize = data.size();
		data.addIndex(0, "b");
		assertEquals(dSize + 1, data.size());
		assertEquals("b", data.getIndex(0));
		assertEquals("a", data.getIndex(1));
		assertEquals("b", data.getIndex(2));
		assertEquals("c", data.getIndex(3));
		assertEquals("d", data.getIndex(4));
		assertFalse(data.isEmpty());
		data.addIndex(1, "e");
		assertEquals(dSize + 2, data.size());
		assertEquals("b", data.getIndex(0));
		assertEquals("e", data.getIndex(1));
		assertEquals("a", data.getIndex(2));
		assertEquals("b", data.getIndex(3));
		assertEquals("c", data.getIndex(4));
		assertEquals("d", data.getIndex(5));
		assertFalse(data.isEmpty());
		data.addIndex(3,  "e");
		assertEquals(dSize + 3, data.size());
		assertEquals("b", data.getIndex(0));
		assertEquals("e", data.getIndex(1));
		assertEquals("a", data.getIndex(2));
		assertEquals("e", data.getIndex(3));
		assertEquals("b", data.getIndex(4));
		assertEquals("c", data.getIndex(5));
		assertEquals("d", data.getIndex(6));
		assertFalse(data.isEmpty());
		data.addIndex(6, "e");
		assertEquals(dSize + 4, data.size());
		assertEquals("b", data.getIndex(0));
		assertEquals("e", data.getIndex(1));
		assertEquals("a", data.getIndex(2));
		assertEquals("e", data.getIndex(3));
		assertEquals("b", data.getIndex(4));
		assertEquals("c", data.getIndex(5));
		assertEquals("e", data.getIndex(6));
		assertEquals("d", data.getIndex(7));
		assertFalse(data.isEmpty());
		data.addIndex(8, "s");
		assertEquals(dSize + 5, data.size());
		assertEquals("b", data.getIndex(0));
		assertEquals("e", data.getIndex(1));
		assertEquals("a", data.getIndex(2));
		assertEquals("e", data.getIndex(3));
		assertEquals("b", data.getIndex(4));
		assertEquals("c", data.getIndex(5));
		assertEquals("e", data.getIndex(6));
		assertEquals("d", data.getIndex(7));
		assertEquals("s", data.getIndex(8));
		assertFalse(data.isEmpty());
	}
	
	@Test
	public void testRemoveFront() {
		ListADT<String> data = makeFullList();
		assertFalse(data.isEmpty());
		int dSize = data.size();
		
		String result = data.removeFront();
		assertEquals(dSize - 1, data.size());
		assertEquals(result, "a");
		assertEquals("b", data.getIndex(0));
		assertEquals("c", data.getIndex(1));
		assertEquals("d", data.getIndex(2));

		result = data.removeFront();
		assertEquals(dSize - 2, data.size());
		assertEquals(result, "b");
		assertEquals("c", data.getIndex(0));
		assertEquals("d", data.getIndex(1));
		
		result = data.removeFront();
		assertEquals(dSize - 3, data.size());
		assertEquals(result, "c");
		assertEquals("d", data.getIndex(0));
		
		result = data.removeFront();
		assertEquals(dSize - 4, data.size());
		assertEquals(0, data.size());
		assertEquals(result, "d");
	}
	
	@Test
	public void testRemoveBack() {
		ListADT<String> data = makeFullList();
		assertFalse(data.isEmpty());
		int dSize = data.size();
		
		String result = data.removeBack();
		assertEquals(dSize - 1, data.size());
		assertEquals(result, "d");
		assertEquals("a", data.getIndex(0));
		assertEquals("b", data.getIndex(1));
		assertEquals("c", data.getIndex(2));

		result = data.removeBack();
		assertEquals(dSize - 2, data.size());
		assertEquals(result, "c");
		assertEquals("a", data.getIndex(0));
		assertEquals("b", data.getIndex(1));
		
		result = data.removeBack();
		assertEquals(dSize - 3, data.size());
		assertEquals(result, "b");
		assertEquals("a", data.getIndex(0));
		
		result = data.removeBack();
		assertEquals(dSize - 4, data.size());
		assertEquals(0, data.size());
		assertEquals(result, "a");
	}
	
	@Test
	public void testRemoveIndex() {
		ListADT<String> data = makeFullList();
		assertFalse(data.isEmpty());
		int dSize = data.size();
		
		String result = data.removeIndex(0);
		assertEquals(dSize - 1, data.size());
		assertEquals(result, "a");
		assertEquals("b", data.getIndex(0));
		assertEquals("c", data.getIndex(1));
		assertEquals("d", data.getIndex(2));
		
		result = data.removeIndex(1);
		assertEquals(dSize - 2, data.size());
		assertEquals(result, "c");
		assertEquals("b", data.getIndex(0));
		assertEquals("d", data.getIndex(1));
		
		result = data.removeIndex(1);
		assertEquals(dSize - 3, data.size());
		assertEquals(result, "d");
		assertEquals("b", data.getIndex(0));

		result = data.removeIndex(0);
		assertEquals(dSize - 4, data.size());
		assertEquals(0, data.size());
		assertEquals(result, "b");
	}
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	@Test
	public void testSetIndex() {
		ListADT<String> data = makeFullList();
		int expectedSize = 4;
		
		ListADT<String> expected1 = makeEmptyList();
		expected1.addBack("1");
		expected1.addBack("b");
		expected1.addBack("c");
		expected1.addBack("d");
		
		data.setIndex(0, "1");
		assertEquals(data.size(), expectedSize);
		assertEquals(data, expected1);
		assertFalse(data.isEmpty());
		
		ListADT<String> expected2 = makeEmptyList();
		expected2.addBack("1");
		expected2.addBack("2");
		expected2.addBack("c");
		expected2.addBack("d");
		
		data.setIndex(1, "2");
		assertEquals(data.size(), expectedSize);
		assertEquals(data, expected2);
		assertFalse(data.isEmpty());
		
		ListADT<String> expected3 = makeEmptyList();
		expected3.addBack("1");
		expected3.addBack("2");
		expected3.addBack("3");
		expected3.addBack("d");
		
		data.setIndex(2, "3");
		assertEquals(data.size(), expectedSize);
		assertEquals(data, expected3);
		assertFalse(data.isEmpty());
		
		ListADT<String> expected4 = makeEmptyList();
		expected4.addBack("1");
		expected4.addBack("2");
		expected4.addBack("3");
		expected4.addBack("4");
		
		data.setIndex(3, "4");
		assertEquals(data.size(), expectedSize);
		assertEquals(data, expected4);
		assertFalse(data.isEmpty());
	}
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
	
	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}
	
	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
}
