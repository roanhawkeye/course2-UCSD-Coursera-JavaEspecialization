/**
 * 
 */
package textgen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try{
			list1.remove(5);
			fail("out of bound");
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		int previous_size = shortList.size();
		int expected_size = previous_size + 1;
		shortList.add("C");
		assertEquals("Add: check size increment ", expected_size , shortList.size());
		assertEquals("Add: last element is the added", shortList.get(expected_size -1), "C" );
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check size is properly set", shortList.size(), 2);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		int previous_size = shortList.size();
		int expected_size = previous_size + 1;
		int index = 0;
		//add element at first position
		String newElement = "Z";
		shortList.add(index, newElement);
		assertEquals("Add at Index: check size increment ", expected_size , shortList.size());
		assertEquals("Add at Index: element on index same as new element ", shortList.get(index) , newElement);
		//Add element at second position
		String secondElement = "Y";
		int newIndex = 1;
		shortList.add(newIndex, secondElement);
		assertEquals("Add at Index: element on index same as new element ", shortList.get(newIndex) , secondElement);
		
		try {
			shortList.add(5, "F");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    Integer oldValue = list1.set(0, 45);
	    assertEquals("Set: check old value is correct ", (Integer)65, oldValue);
		assertEquals("Set: check new value is correct ", (Integer)45, list1.get(0));
		assertEquals("Set: check size is correct ", 3, list1.size());
		
		Integer oldValue2 = list1.set(1, 100);
	    assertEquals("Set: check old value is correct ", (Integer)21, oldValue2);
		assertEquals("Set: check new value is correct ", (Integer)100, list1.get(1));
		assertEquals("Set: check size is correct ", 3, list1.size());
	    
	    try{
			list1.remove(5);
			fail("out of bound");
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
