/**
* Transaction.java
* @author Truong Phu Vu
* @author Tan Dung Dong
* CIS 22C Lab 2
*/
/**
	 * Defines a singly-linked list class
	 * @author Truong Phu Vu
	 * @author Tan Dung Dong
	 */

import java.util.NoSuchElementException;

public class List<T> {
	private class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private int length;
	private Node first;
	private Node last;

	/**** CONSTRUCTOR ****/

	/**
	 * Instantiates a new List with default values
	 * 
	 * @postcondition an empty list is created
	 */
	public List() {
		first = null;
		last = null;
		length = 0;
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition !isEmpty()
	 * @return the value stored at node first
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getFirst() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getFirst(): " + "List is empty. Cannot return the first element!");
		}
		return first.data;
	}

	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition !isEmpty()
	 * @return the value stored in the node last
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getLast() throws NoSuchElementException {
		if (length == 0) {
			throw new NoSuchElementException("getLast(): " + "List is empty " + ".Cannot return the last element!");
		}
		return last.data;
	}

	/**
	 * Returns the current length of the list
	 * 
	 * @return the length of the list from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns whether the list is currently empty
	 * 
	 * @return whether the list is empty
	 */
	public boolean isEmpty() {
		if (length == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**** MUTATORS ****/

	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the list
	 * @postcondition the first new node is created
	 */
	public void addFirst(T data) {
		Node N = new Node(data);
		// if the list is empty
		if (first == null) {
			first = last = N;
			length++;
		}
		// if the list is not empty
		else {
			N.next = first;
			first = N;
			length++;
		}

	}

	/**
	 * Creates a new last element
	 * 
	 * @param data the data to insert at the end of the list
	 * @postcondition
	 */
	public void addLast(T data) {
		Node N = new Node(data);
		if (first == null) {
			first = last = N;
			length++;
		} else {
			last.next = N;
			last = N;
			length++;
		}
	}

	/**
	 * removes the element at the front of the list
	 * 
	 * @precondition the list is not empty
	 * @postcondition the first node is removed update the first node
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeFirst() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException("removeFirst(): " + "Cannot remove because the list is empty!");
		} else {
			Node temp;
			temp = first;
			first = first.next;
			temp.next = null;
			length--;
		}
	}

	/**
	 * removes the element at the end of the list
	 * 
	 * @precondition List is not empty
	 * @postcondition the last node is removed update the last node
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeLast() throws NoSuchElementException {
		if (first == null)
			throw new NoSuchElementException("removeLast: " + "cannit remove because the list is empty!");

		else if (length == 1) {
			first = last = null;
			length--;
		}

		else {
			/*Node iteration;
			Node previous = null;
			iteration = first;

			while (iteration.next != null) {
				previous = iteration; // previous node before last node
				iteration = iteration.next; // last node

			}

			previous.next = null;
			last = previous;*/
			Node temp = first;
            while (temp.next != last) {
                temp = temp.next;
            }
            last = temp;
            last.next = null;
			length--;

		}

	}

	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * List with each value on its own line At the end of the List a new line
	 * 
	 * @return the List as a String for display
	 */
	@Override
	public String toString() {
			String result = "";
			Node iteration;
			iteration = first;

			while (iteration != null) {
				result += iteration.data + "\n";
				iteration = iteration.next;
			}

			return result + "\n";
		}
}

