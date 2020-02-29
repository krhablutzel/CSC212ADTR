package edu.smith.cs.csc212.adtr.real;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.SetADT;


/**
 * Java Set Data Structure from Map Data Structure
 * wrapped in our SetADT interface.
 * @author khablutzel
 *
 * @param <T> - the type of items in the set
 */
public class SetFromMap<T> extends SetADT<T>{
	/**
	 * The private Java map on the inside; does all the work.
	 */
	private LinkedHashMap<T, String> data;
	
	/**
	 * Create an empty SetFromMap.
	 */
	public SetFromMap() {
		this.data =  new LinkedHashMap<T, String>();
	}
	
	/**
	 * Create a SetFromMap copied from a Java Set.
	 * @param toCopy - set to copy
	 */
	public SetFromMap(Set<T> toCopy) {
		this.data = new LinkedHashMap<T, String>();
		for (T elem : toCopy) {
			this.data.put(elem, "");
		}
	}
	
	/**
	 * Find the size of the set
	 * @return the size of the set
	 */
	@Override
	public int size() {
		return this.data.size();
	}
	
	/**
	 * Insert new element into the set
	 * @param value to add to the set
	 */
	@Override
	public void insert(T element) {
		this.data.put(element, "");
	}
	
	/**
	 * Check whether the set contains an element
	 * @param element
	 * @return whether the set contains the element
	 */
	@Override
	public boolean contains(T element) {
		return this.data.containsKey(element);
	}
	
	/**
	 * Remove an element from the set.
	 * @param element to remove
	 */
	@Override
	public void remove(T element) {
		this.data.remove(element);
	}
	
	/**
	 * Turn the set into a list.
	 * @return a list of the set's elements
	 */
	@Override
	public ListADT<T> toList() {
		return new JavaList<>(new ArrayList<>(this.data.keySet()));
	}
}
