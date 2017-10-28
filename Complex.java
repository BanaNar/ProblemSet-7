/***********************************************
 * @ file Complex.java
 * @ brief This program is a class to represent complex numbers and perform basic arithmetic.
 * @ author Jianqiu Xu (Tony)
 * @ date October 26, 2017
 ***********************************************/
public class Complex {
    private double realPart;
    private double imaginaryPart;

    // Default Constructor that sets the number to 0
    public Complex(){
        realPart = 0;
        imaginaryPart = 0;
    }

    // Constructor with one parameter a that sets the number to the real value a
    public Complex(double real){
        realPart = real;
    }

    // Constructor with two parameters a and b that sets the number to a + bi
    public Complex(double real, double imag){
        realPart = real;
        imaginaryPart = imag;
    }

    // Returns a String representing the number with format 1.23+4.56i or 1.23-4.56i
    public String format(){
        String format = "";
        if (realPart != 0){
            if (imaginaryPart > 0){
                format = realPart + "+" + imaginaryPart + "i";
            }
            else if (imaginaryPart == 0){
                format = Double.toString(realPart);
            }
            else {
                format = realPart + imaginaryPart + "i";
            }
        }
        else {
            if (imaginaryPart != 0){
                format = imaginaryPart + "i";
            }
            else {
                format = "0";
            }
        }
        return format;
    }

    // Define an accessor for realPart
    public double getRealPart(){
        return realPart;
    }

    // Modifies realPart field
    public void setRealPart(double a){
        realPart = a;
    }

    // Define an accessor for imagnaryPart
    public double getImagPart(){
        return imaginaryPart;
    }

    // Modifies imagPart field
    public void setImagPart(double b){
        imaginaryPart = b;
    }

    // Add z to number and returns Complex result
    public Complex plus(Complex z) {
        Complex result = new Complex();
        result.setRealPart(realPart + z.getRealPart());
        result.setImagPart(imaginaryPart + z.getImagPart());
        return result;
    }

    // Substract z from number and returns Complex result
    public Complex minus(Complex z){
        Complex result = new Complex();
        result.setRealPart(realPart - z.getRealPart());
        result.setImagPart(imaginaryPart - z.getImagPart());
        return result;
    }

    // Multiplies z by number and returns
    public Complex times(Complex z) {
        Complex result = new Complex();
        result.setRealPart(realPart * z.getRealPart() - imaginaryPart * z.getImagPart());
        result.setImagPart(realPart * z.getImagPart() + imaginaryPart * z.getRealPart());
        return result;
    }

    // Multiplies real value a by number and returns Complex result
    public Complex times(double a) {
        Complex result = new Complex();
        result.setRealPart(realPart * a);
        result.setImagPart(realPart * a);
        return result;
    }

    // Returns real-valued modulus of number
    public Complex modulus(){
        Complex result = new Complex();
        result.setRealPart(Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2)));
        result.setImagPart(0);
        return result;
    }

    // Returns complex conjugate of number
    public Complex conjugate() {
        Complex result = new Complex();
        result.setRealPart(realPart);
        result.setImagPart(-(imaginaryPart));
        return result;
    }

}
