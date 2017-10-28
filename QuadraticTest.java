public class QuadraticTest {
    public static int numTests;     // Count the total number of tests
    public static int testsPassed;  // Count the number of tests passed
    public static final double SMALL = 0.0000000000001; // A very small number

    public static void main(String[] args) {
        numTests = 0;
        testsPassed = 0;

        // The roots of z^2 + 2z + 0 are z = 0+0i and z = -2+0i
        testQuadraticFormulaResult("quadraticFormula(1, 2, 0)", 1, 2, 0,
                new Complex(0, 0), new Complex(-2, 0));

        // The roots of z^2 + 2z + 1 are z = -1+0i and z = -1+0i
        testQuadraticFormulaResult("quadraticFormula(1, 2, 1)", 1, 2, 1,
                new Complex(-1, 0), new Complex(-1, 0));

        // The roots of 4z^2 + 7z + 2 are z = -1.39038820320221+0i and z = -0.359611796797792+0i
        testQuadraticFormulaResult("quadraticFormula(4, 7, 2)", 4, 7, 2,
                new Complex(-1.39038820320221, 0),
                new Complex(-0.359611796797792, 0));

        // The roots of 1z^2 + 2z + 3 are z = -1-sqrt(2)i and z = -1+sqrt(2)i
        testQuadraticFormulaResult("quadraticFormula(1, 2, 3)", 1, 2, 3,
                new Complex(-1, -Math.sqrt(2)),
                new Complex(-1, Math.sqrt(2)));

        // Evaluate z^2 + 2z + 0 with root z = -2+0i
        testEvaluateQuadratic("evaluateQuadratic(1, 2, 0)", 1, 2, 0, new Complex(-2, 0));

        // Evaluate z^2 + 2z + 1 with root z = -1+0i
        testEvaluateQuadratic("evaluateQuadratic(1, 2, 1)", 1, 2, 1, new Complex(-1, 0));

        // Evaluate 4z^2 + 7z + 2 with root z = -0.359611796797792+0i
        testEvaluateQuadratic("evaluateQuadratic(4, 7, 2)", 4, 7, 2,
                new Complex(-0.359611796797792, 0));

        // Evaluate 1z^2 + 2z + 3 with root z = z = -1-sqrt(2)i
        testEvaluateQuadratic("evaluateQuadratic(1, 2, 3)", 1, 2, 3,
                new Complex(-1, -Math.sqrt(2)));

        System.out.printf("\nPercentage of tests passed %.2f\n", testsPassed / (double)numTests * 100);
    }


    /**
     * @param str Message to be printed
     * @param a     coefficient
     * @param b     coefficient
     * @param c     coefficient
     * @param r     Complex value to calculate a*r^2 + b*r + c
     */
    private static void testEvaluateQuadratic(String str, double a, double b, double c, Complex r) {
        Complex val = QuadraticPolynomial.evaluateQuadratic(a, b, c, r);

        if (equalsRealImag(val.getRealPart(), 0, val.getImagPart(), 0)) {
            testPassed(str);
        }
        else {
            testFailed(str);
        }

    }


    /**
     * @param str   Message to be printed
     * @param a     coefficient
     * @param b     coefficient
     * @param c     coefficient
     * @param r1    root of a*z^2 + b*z + c
     * @param r2    root of a*z^2 + b*z + c
     */
    private static void testQuadraticFormulaResult(String str, double a, double b, double c, Complex r1, Complex r2) {
        Complex[] roots = QuadraticPolynomial.quadraticFormula(a, b, c);
        if( equalsRealImag(roots[0].getRealPart(), r1.getRealPart(), roots[0].getImagPart(), r1.getImagPart())) {
            if (equalsRealImag(roots[1].getRealPart(), r2.getRealPart(), roots[1].getImagPart(), r2.getImagPart())) {
                testPassed(str);
            } else {
                testFailed(str);
            }
        }
        else if (equalsRealImag(roots[0].getRealPart(), r2.getRealPart(), roots[0].getImagPart(), r2.getImagPart())) {
            if (equalsRealImag(roots[1].getRealPart(), r1.getRealPart(), roots[1].getImagPart(), r1.getImagPart())) {
                testPassed(str);
            }
            else {
                testFailed(str);
            }
        }
        else {
            testFailed(str);
        }
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
    private static boolean equalsRealImag(double v, double x, double u, double w) {
        if (Math.abs(v -x) <= SMALL && Math.abs(u - w) <= SMALL) {
            return true;
        }
        else {
            return false;
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