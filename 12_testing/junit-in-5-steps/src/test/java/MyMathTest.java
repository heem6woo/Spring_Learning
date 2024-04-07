import com.heem.MyMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class MyMathTest {

    @Test
    void test() {

        // absence of failure is success
        //Test Condition or Assert
        MyMath math = new MyMath();
        int[] numbers ={1,2,3};
        int result = math.calculateSum(numbers);

        System.out.println(result);

        int expectedResult = 7;
        assertEquals(expectedResult,result);

    }
}
