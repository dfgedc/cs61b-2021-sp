package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
        IntList lst1 = IntList.of(31,32,19,49,67);
        System.out.println(lst1.toString());
        boolean c = IntListExercises.squarePrimes(lst1);
        assertEquals("961 -> 32 -> 361 -> 49 -> 4489",lst1.toString());
        assertTrue(c);
        //boolean c = IntListExercises.squarePrimes(lst1);
       // assertEquals();
      //  assertEquals();
    }
}
