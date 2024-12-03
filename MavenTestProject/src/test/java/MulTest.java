package programminghub;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MulTest {

	@Test
	void testMul() {
		JunitClass junit = new JunitClass(); 
		int result = junit.mul(30, 20); 
		assertEquals(600,result);
	}

}
