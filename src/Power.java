public class Power extends Function{

    protected int n;//the degree - power of the function
    protected Function f;//the function that we raise to a power

    /**
     * constructor that gets all parameters
     * @param f the function that we raise to a power
     * @param n the degree - power of the function
     */
    public Power(Function f,int n){
        this.f = f;
        this.n = n;
    }

    /**
     * this method returns the value of the function at x
     * @param x the x value of the point we want to check
     * @return the value of the function at x
     */
    @Override
    public double valueAt(double x) {
        return Math.pow(this.f.valueAt(x),n);
    }

    /**
     * @return a string that describes the function
     */
    @Override
    public String toString() {
        return "(" + this.f.toString() + "^" + n + ")";
    }

    /**
     * calculates the derivative of the function
     * @return function object that is the derivative of the function
     */
    @Override
    public Function derivative() {
        if(n==1){
            return f.derivative();
        }
        return new MultiProduct(new Constant(n),new Power(this.f,this.n-1), f.derivative());
    }
}
