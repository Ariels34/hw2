public class Difference extends Sum{
    protected Function f1,f2;//the two functions that describes the difference function

    /**
     * constructor that gets all parameters
     * @param f1 the first function
     * @param f2 the second function
     */
    public Difference(Function f1, Function f2){
        super(f1, f2);
        this.f1 = f1;
        this.f2 = f2;
    }

    /**
     * this method returns the value of the function at x
     * @param x the x value of the point we want to check
     * @return the value of the function at x
     */
    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) - f2.valueAt(x);
    }

    /**
     * calculates the derivative of the function
     * @return function object that is the derivative of the function
     */
    @Override
    public Function derivative() {
        return new Difference(this.f1.derivative(), this.f2.derivative());
    }

    /**
     * @return a string that describes the function
     */
    @Override
    public String toString() {
        return "(" + f1.toString() + " - " + f2.toString() + ")";
    }
}
