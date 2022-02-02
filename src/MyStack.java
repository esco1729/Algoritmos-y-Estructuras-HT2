package src;

import java.util.ArrayList;

public class MyStack implements Stack<Object> {
	private ArrayList<Object> Array;

	MyStack(ArrayList<Object> array) {
		this.Array = array;
	}

	/**
	 * Adds the parameter at the end of the ArrayList
	 * 
	 * @param item item to be appended
	 */
	@Override
	public void add(Object item) {
		Array.add(item);
	}

	/**
	 * Saves the last object of the array into a object variable. Then that object
	 * is deleted of the ArrayList
	 * 
	 * @return object saved in the object variable
	 */
	@Override
	public Object remove() {
		int index;
		Object object;
		if (Array.isEmpty()) {
			return null;
		} else {
			index = Array.size() - 1;
			object = Array.get(index);
			Array.remove(index);
		}
		return object;
	}

	/**
	 * Allows to see the last object in the Array, without removing it or
	 * manipulating it
	 * 
	 * @return
	 */
	@Override
	public Object peek() {
		try {
			int index = Array.size() - 1;
			return Array.get(index);
		} catch (Exception e) {
			String message = "";
			return message;
		}
	}

	/**
	 * Allows to see if the ArrayList is empty
	 * 
	 * @return true for empty, false for else
	 */
	@Override
	public boolean empty() {
		if (Array.isEmpty() == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Allows to see the size of the ArrayList
	 * 
	 * @return size of the ArrayList
	 */
	@Override
	public int size() {
		return Array.size();
	}
}
