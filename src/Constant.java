public class Constant extends Polynomial{
    protected double c;//the constant number

    /**
     * constructor that gets all parameters
     * @param c the constant value
     */
    public Constant(double c){
        this.c = c;
    }

    /**
     * this method returns the value of the function at x
     * @param x the x value of the point we want to check
     * @return the value of the function at x
     */
    @Override
    public double valueAt(double x) {
        return this.c;
    }

    /**
     * @return a string that describes the function
     */
    @Override
    public String toString() {
        if(c%1 == 0){
            return "(" + (int)this.c + ")";
        }
        return "(" + this.c + ")";
    }

    /**
     * calculates the derivative of the function
     * @return polynomial object that is the derivative of the function
     */
    @Override
    public Polynomial derivative() {
        return new Polynomial(0);
    }
}
