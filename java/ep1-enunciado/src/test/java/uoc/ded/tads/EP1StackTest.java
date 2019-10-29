package uoc.ded.tads;

import org.junit.After;
import org.junit.Before;
import uoc.ded.tads.EP1Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EP1StackTest {

	EP1Stack ep1q;

	@Before
	public void setUp() {
		this.ep1q= new EP1Stack();

		this.ep1q.newStack();
		assertNotNull(this.ep1q.getStack());
	}

	@After
	public void release() {
		this.ep1q = null;
	}

	
	@org.junit.Test
	public void testPila() {

		this.ep1q.fillStack();
		assertEquals(new Integer(this.ep1q.getStack().numElems()), new Integer(this.ep1q.CAPACITY));
		
		assertEquals(this.ep1q.clearAllStack(), new String("8 7 6 5 4 3 2 1 0 "));
		
		assertEquals(new Integer(this.ep1q.getStack().numElems()), new Integer(0));
	}
}
