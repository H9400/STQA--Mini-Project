package programminghub;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddTest {

	@Test
	void testAdd() {
		JunitClass junit = new JunitClass(); 
		int result = junit.add(300,200); 
		assertEquals(500,result);
	}

}
