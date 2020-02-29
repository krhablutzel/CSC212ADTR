package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;


import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.SetFromMap;

public class SetFromMapTest {
	
	@Test
	public void testEmpty() {
		SetADT<String> empty = new SetFromMap<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testSizeOne()  {
		SetADT<String> one = new SetFromMap<>();
		one.insert("A");
		assertEquals(one.size(), 1);
	}
	
	@Test
	public void testSizeTwo() {
		SetADT<String> two = new SetFromMap<>();
		two.insert("A");
		two.insert("B");
		assertEquals(two.size(), 2);
	}
	
	@Test
	public void testInsertNew()  {
		SetADT<String> doesntHave = new SetFromMap<>();
		int oldSize = doesntHave.size();
		doesntHave.insert("A");
		int newSize = doesntHave.size();
		assertEquals(oldSize + 1, newSize);
		assertTrue(doesntHave.contains("A"));
	}
	
	@Test
	public void testInsertRepeated() {
		SetADT<String> ab = new SetFromMap<>();
		ab.insert("A");
		for (int i = 0; i < 1000; i++) {
			ab.insert("B");
		}
		ab.insert("B");
		ab.insert("B");
		assertEquals(ab.size(), 2);
	}
	
	@Test
	public void doesContain() {
		SetADT<String> cont  = new SetFromMap<>();
		cont.insert("Q");
		assertTrue(cont.contains("Q"));
	}
	
	@Test
	public void emptyDoesntContain() {
		SetADT<String> empty = new SetFromMap<>();
		assertFalse(empty.contains("Q"));
		
	}
	
	@Test
	public void nonEmptyDoesntContain() {
		SetADT<String> nonEmpty = new SetFromMap<>();
		nonEmpty.insert("Quack"); 
		assertFalse(nonEmpty.contains("Q"));
	}
	
	@Test
	public void removeElement() {
		SetADT<String> ab = new SetFromMap<>();
		ab.insert("A");
		ab.insert("A");
		ab.insert("A");
		ab.insert("A");
		ab.insert("B");
		int oldSize = ab.size();
		ab.remove("A");
		int newSize = ab.size();
		assertEquals(oldSize - 1, newSize);
		assertFalse(ab.contains("A"));
	}
	
	@Test
	public void removeNotThere() {
		SetADT<String> ab = new SetFromMap<>();
		ab.insert("A");
		ab.insert("B");
		ab.insert("A");
		int oldSize = ab.size();
		ab.remove("C");
		int newSize = ab.size();
		assertEquals(oldSize, newSize);
		assertFalse(ab.contains("C"));
		assertTrue(ab.contains("A"));
		assertTrue(ab.contains("B"));
	}
	
	@Test
	public void setToList() {		
		SetADT<String> setAB = new SetFromMap<>();
		setAB.insert("A");
		setAB.insert("A");
		setAB.insert("B");
		ListADT<String> listToSet = setAB.toList();
		
		ListADT<String> expected = new JavaList<>();
		expected.addBack("A");
		expected.addBack("B");
		
		assertEquals(listToSet, expected);
	}
	
	@Test
	public void emptySetToList() {		
		SetADT<String> setAB = new SetFromMap<>();
		ListADT<String> listToSet = setAB.toList();
		
		ListADT<String> expected = new JavaList<>();
		
		assertEquals(listToSet, expected);
	}
}
