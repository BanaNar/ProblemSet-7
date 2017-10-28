/***********************************************
 * @ file QuadraticPolynomial.java
 * @ brief This program is a class that store complex roots of quadratic polynomials and evaluate polynomials at complex values.
 * @ author Jianqiu Xu (Tony)
 * @ date October 27, 2017
 ***********************************************/
public class QuadraticPolynomial {

    /**
     * @brief computes roots of quadratic polynomial az^2+bz+c
     * @param a double coefficient of z^2 term
     * @param b double coefficient of z term
     * @param c double constant coefficient
     * @return length-2 array of complex roots
     */
    public static Complex[] quadraticFormula(double a, double b, double c){
        Complex[] root = new Complex[2];
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (a == 0){
            root[0] = root[1] = new Complex((-b) / c);
        }
        else if (b == 0) {
            if (((-c) / a) < 0){
                root[0] = new Complex(0, (-c) / a);
                root[1] = new Complex(0, c / a);
            }
            else if (((-c) / a) >= 0){
                root[0] = new Complex((Math.sqrt(((-c) / a))));
                root[1] = new Complex(Math.sqrt(c / a));
            }
        }

        else {
            if (delta >= 0){
                root[0] = new Complex(((-b) + Math.sqrt(delta)) / (2 * a));
                root[1] = new Complex(((-b) - Math.sqrt(delta)) / (2 * a));
            }
            else {
                delta = -delta;
                root[0] = new Complex((-b) / (2 * a), Math.sqrt(delta) / (2 * a));
                root[1] = new Complex((-b) / (2 * a), -(Math.sqrt(delta) / (2 * a)));
            }
        }

        return root;
    }

    /**
     * brief evaluates quadratic polynomial az^2+bz+c at given value
     * @param a double coefficient of z^2 term
     * @param b double coefficient of z term
     * @param c double constant coefficient
     * @param z Complex input value
     * @return Complex output value equal to az^2+bz+c
     */
    public static Complex evaluateQuadratic(double a, double b, double c, Complex z){
        Complex result = new Complex();
        Complex z_square = z.times(z);

        result.setRealPart(a * z_square.getRealPart() + b * z.getRealPart() + c);
        result.setImagPart(a * z_square.getImagPart() + b * z.getImagPart());

        return result;
    }
}