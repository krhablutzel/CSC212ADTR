package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// You might want this; if you're using Map<String, Integer> anywhere...
	// JUnit has an assertEquals(Object, Object) and an assertEquals(int, int).
	// When you give it assertEquals(Integer, int) it doesn't know which to use (but both would be OK!)
	// This method gets around that by forcing the (int, int) version.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testOne() {
		MapADT<String, String> one = new JavaMap<>();
		one.put("key", "value");
		assertEquals(one.size(), 1);
	}
	
	@Test
	public void testMany() {
		MapADT<String, String> many = new JavaMap<>();
		int n = 10;
		for (int i = 0; i < n; i++) {
			many.put("key"+i, "value");
		}
		assertEquals(many.size(), n);
	}
	
	@Test
	public void testPutNew() {
		MapADT<String, String> putNew = new JavaMap<>();
		putNew.put("key", "value");
		assertEquals(putNew.size(), 1);
		assertEquals(putNew.get("key"), "value");

	}
	
	@Test
	public void testPutDuplicate() {
		MapADT<String, String> putOld = new JavaMap<>();
		putOld.put("key", "value");
		putOld.put("key", "value2");
		assertEquals(putOld.size(), 1);
		assertEquals(putOld.get("key"), "value2"); // stores latest value

	}
	
	@Test
	public void testGetInMap() {
		MapADT<String, String> inMap = new JavaMap<>();
		inMap.put("key", "value");
		String val = inMap.get("key");
		assertEquals(val, "value");
	}
	
	@Test
	public void testGetNotInMap() {
		MapADT<String, String> notInMap = new JavaMap<>();
		String val = notInMap.get("key");
		assertEquals(val, null);
	}
	
	@Test
	public void testRemoveInMap() {
		MapADT<String, String> inMap = new JavaMap<>();
		inMap.put("key", "value");
		int oldSize = inMap.size();
		inMap.remove("key");
		int newSize = inMap.size();
		assertEquals(oldSize - 1, newSize);
		assertEquals(inMap.get("key"), null);
	}
	
	@Test
	public void testRemoveNotInMap() {
		MapADT<String, String> notInMap = new JavaMap<>();
		int oldSize = notInMap.size();
		notInMap.remove("key");
		int newSize = notInMap.size();
		assertEquals(oldSize, newSize);
		assertEquals(notInMap.get("key"), null);
	}
	
}
