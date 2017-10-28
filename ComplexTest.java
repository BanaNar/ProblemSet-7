public class ComplexTest{
    public static int numTests;     // Count the total number of tests
    public static int testsPassed;  // Count the number of tests passed
    public static Complex z1;
    public static final double SMALL = 0.0000000000001; // A very small number

    public static void main(String[] args) {
        numTests = 0;
        testsPassed = 0;

        //
        // Call my test methods
        //
        testDefaulConstructor("Default Constructor");
        testTwoParamConstructor("Constructor(a, b)");
        testOneParamConstructor("Constructor(a)");
        testSetRealPart("setRealPart(a)");
        testSetImaginaryPart("setImaginaryPart()");
        testGetRealPart("getRealPart()");
        testGetImaginaryPart("getImaginaryPart()");
        testAdd("add()");
        testTimes("times()");

        System.out.printf("\nPercentage of tests passed %.2f\n", testsPassed / (double)numTests * 100);
    }

    //
    // Definition of all the test methods
    //

    private static void testTimes(String str) {
        // Create z1 = (3, -4) and z2 = (-2, 5)
        z1 = new Complex( 3, -4);
        Complex z2 = new Complex(-2, 5);
        // Compute the product z3 = z1 * z2
        Complex z3 = z1.times(z2);
        // Test if the values of z3 are correct
        equalsRealImag(z3.getRealPart(),3*(-2) - (-4)*5, z3.getImagPart(), 3*5 + (-4)*(-2), str);
    }

    private static void testAdd(String str) {
        z1 = new Complex( 3, -4);
        Complex z2 = new Complex(-2, 5);
        Complex z3 = z1.plus(z2);
        equalsRealImag(z3.getRealPart(), 3-2, z3.getImagPart(), -4+5, str);
    }


    private static void testGetImaginaryPart(String str) {
        z1 = new Complex( 3, -4);
        equals(z1.getImagPart(), -4, str);
    }

    private static void testGetRealPart(String str) {
        z1 = new Complex( 3, -4);
        equals(z1.getRealPart(), 3, str);
    }


    private static void testSetImaginaryPart(String str) {
        z1 = new Complex( 3, -4);
        z1.setImagPart(-3);
        equals(z1.getImagPart(), -3, str);
    }

    private static void testSetRealPart(String str) {
        z1 = new Complex( 3, -4);
        z1.setRealPart(-4);
        equals(z1.getRealPart(), -4, str);
    }

    private static void testOneParamConstructor(String str) {
        z1 = new Complex(-4);
        equalsRealImag(z1.getRealPart(), -4, z1.getImagPart(), 0, str);
    }

    private static void testDefaulConstructor(String str) {
        z1 = new Complex();
        equalsRealImag(z1.getRealPart(), 0, z1.getImagPart(), 0, str);
    }

    private static void testTwoParamConstructor(String str) {
        z1 = new Complex(2, 3);
        equalsRealImag(z1.getRealPart(), 2, z1.getImagPart(), 3, str);
    }


    //
    // Helper methods
    //

    // Compare if v is nearly equal to x
    // True equality v == x can be false for doubles
    private static void equals(double v, double x, String str) {
        if (Math.abs(v - x) <= SMALL) {
            testPassed(str);
        }
        else {
            testFailed(str);
        }

    }

    // Compare if (v is nearly equal to x and u is nearly equal to w
    private static void equalsRealImag(double v, double x, double u, double w, String str) {
        if (Math.abs(v -x) <= SMALL && Math.abs(u - w) <= SMALL) {
            testPassed(str);
        }
        else {
            testFailed(str);
        }
    }

    // Print test failed and increment the total number of tests
    private static void testFailed(String str) {
        numTests++;
        System.out.println("Test " + str +  "... ****failed****");
    }

    // Print test passed and increment both total number of tests and testsPassed
    private static void testPassed(String str) {
        numTests++;
        testsPassed++;
        System.out.println("Test " + str + "... passed");
    }

}