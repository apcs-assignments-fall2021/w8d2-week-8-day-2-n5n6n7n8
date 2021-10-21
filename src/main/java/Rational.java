public class Rational {
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }
    
    // This method takes two Rationals, add them up,
    // and returns a Rational equal to the sum
    // You will need to:
    // 1) Calculate the value of the new numerator
    // 2) Calculate the value of the new denominator
    // 3) Create a new Rational variable with the two above values
    // 4) Return your new Rational variable
    // (When you write the simplify method later on, you should
    // also call it in this method to return the simplified result)
    public static Rational add(Rational r, Rational s) {
        int newnum = (r.numerator*s.denominator)+(s.numerator*r.denominator);
        int newden = r.denominator*s.denominator;
        return simplify(new Rational(newnum, newden));
    }

    // This method takes two Rationals, subtracts them,
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s) {
        int newnum = (r.numerator*s.denominator)-(s.numerator*r.denominator);
        int newden = r.denominator*s.denominator;
        return simplify(new Rational(newnum, newden));
    }
    
    public static Rational multiply(Rational r, Rational s) {
        int newnum = r.numerator*s.numerator;
        int newden = r.denominator*s.denominator;
        return simplify(new Rational(newnum, newden));
    }
    
    public static Rational divide(Rational r, Rational s) {
        int newnum = r.numerator*s.denominator;
        int newden = r.denominator*s.numerator;
        return simplify(new Rational(newnum, newden));
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor, find the largest number x
    // such that a and b are both multiples of x
    public static int greatestCommonFactor(int a, int b){
        int gcf=0;
        for (int i = 1; i <= Math.min(a,b); i++) {
            if(a%i==0&&b%i==0) {
                gcf=i;
            }
        }
        return gcf;
    }

    // This method is given a rational, and returns a simplified version
    // of the input rational
    // Use the greatestCommonFactor method here
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        while(greatestCommonFactor(r.numerator, r.denominator)>1)
        {
            int gcf=greatestCommonFactor(r.numerator,r.denominator);
            r.denominator/=gcf;
            r.numerator/=gcf;
        }
        return r;
    }

    // This following method is NOT static, we'll talk about it next class!
    // This returns a string representation of a Rational (e.g. "1/2")
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}













