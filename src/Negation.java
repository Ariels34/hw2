public class Negation extends Function{
    protected Function f;//the negation function

    /**
     * constructor that gets all parameters
     * @param f the negation function
     */
    public Negation(Function f){
        this.f = f;
    }

    /**
     * this method returns the value of the function at x
     * @param x the x value of the point we want to check
     * @return the value of the function at x
     */
    @Override
    public double valueAt(double x) {
        return (-1)*this.f.valueAt(x);
    }

    /**
     * @return a string that describes the function
     */
    @Override
    public String toString() {
        return "(-"+this.f.toString()+")";
    }

    /**
     * calculates the derivative of the function
     * @return function object that is the derivative of the function
     */
    @Override
    public Function derivative() {
        return new Negation(this.f.derivative());
    }
}

