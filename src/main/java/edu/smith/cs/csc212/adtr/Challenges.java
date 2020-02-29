package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

// Wow, this class really needs some comments...
public class Challenges {

	/**
	 * This method returns the union of two sets.
	 * @param left - a set of strings
	 * @param right - a set of strings
	 * @return output - the union of the sets (in left OR right)
	 */
	public static SetADT<String> union(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = left;
		
		for (String elem : right) {
			output.insert(elem);
		}
		
		return output;
	}
	
	/**
	 * This method returns the intersection of the two sets.
	 * @param left - a set of strings
	 * @param right - a set of strings
	 * @return output - the intersection of the sets (in left AND right)
	 */
	public static SetADT<String> intersection(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		
		for (String elem : right) {
			if (left.contains(elem)) {
				output.insert(elem);
			}
		}
		
		return output;
	}
	
	/**
	 * Counts how many of each unique word appears in a list
	 * @param words -a ListADT of strings
	 * @return Map with tally of words
	 */
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		
		for (String word : words) {
			if (output.get(word) == null) {
				// If word isn't in the map yet, add it!
				output.put(word, 1);
			} else if (output.get(word) > 0) {
				// If word *is* in the map, add to the tally!
				output.put(word, output.get(word) + 1);
			}
		}
		
		return output;
	}
}
