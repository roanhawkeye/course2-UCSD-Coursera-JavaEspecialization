package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode(null);
		this.tail = new LLNode(null);
		this.head.next = tail;
		this.tail.prev = head;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException("Can not add null elements");
		}
		
		LLNode<E> new_node = new LLNode<E>(element);
		//point new node to tail and to the node before the tail.
		new_node.next = tail;
		new_node.prev = tail.prev;
		
		//adjust tail pointer
		tail.prev = new_node;
		new_node.prev.next = new_node;
		
		//increase size
		size++;
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	@SuppressWarnings("unchecked")
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 ){
			throw new IndexOutOfBoundsException("element not found");
		}
		
		//find the element
		LLNode current = head.next; //first position after head
//		System.out.println("Structure of linkedlist");
//		System.out.println(this.toString());
		for(int i=0; i < size; i++){
			if(current.next != null){
//				System.out.println("current node on position: " + i);
//				System.out.println(current);
				
				if(i == index){
					return (E) current.data;
				}
				current = current.next;
			}
		}
		
		throw new IndexOutOfBoundsException("element not found");
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return -1;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}
	
	public String toString(){
		String structure = "";
		LLNode current = head;
		for(int i=0; i < size + 2; i++){
			
			structure = structure + current.toString();
			current = current.next;
			
		}
		
		return structure;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	@Override
	public String toString(){
		return "{data="+ this.data  +"}";
	}

}
