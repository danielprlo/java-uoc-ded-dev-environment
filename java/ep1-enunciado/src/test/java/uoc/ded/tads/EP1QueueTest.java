package uoc.ded.tads;

import org.junit.After;
import org.junit.Before;
import uoc.ded.tads.EP1Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EP1QueueTest {

	EP1Queue ep1q;

	@Before
	public void setUp() {
		this.ep1q= new EP1Queue();

		this.ep1q.newQueue();
		assertNotNull(this.ep1q.getQueue());
	}

	@After
	public void release() {
		this.ep1q = null;
	}


	@org.junit.Test
	public void testCua() {
		

		this.ep1q.fillQueue();
		assertEquals(new Integer(this.ep1q.getQueue().numElems()), new Integer(this.ep1q.CAPACITY));
		
		assertEquals(this.ep1q.clearFullQueue(), new String("0 1 2 3 4 5 6 7 8 "));
		
		assertEquals(new Integer(this.ep1q.getQueue().numElems()), new Integer(0));
	}

}
