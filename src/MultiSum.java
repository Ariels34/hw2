public class MultiSum extends Function{
    protected Function[] f;//the functions that describes the multi sum

    /**
     * constructor that gets at least two functions
     * @param f1 the first function
     * @param f2 the second function
     * @param funcs functions array
     */
    public MultiSum(Function f1, Function f2, Function...funcs){
        this.f = new Function[funcs.length+2];
        this.f[0] = f1;
        this.f[1] = f2;
        for(int i = 2; i <this.f.length; i++){
            this.f[i] = funcs[i-2];
        }
    }

    /**
     * this method returns the value of the function at x
     * @param x the x value of the point we want to check
     * @return the value of the function at x
     */
    @Override
    public double valueAt(double x) {
        double value = 0;
        for(int i = 0; i < this.f.length; i++){
            value += this.f[i].valueAt(x);
        }
        return value;
    }

    /**
     * @return a string that describes the function
     */
    @Override
    public String toString() {
        String func = "(";
        for(int i = 0; i < this.f.length-1; i++){
            func += this.f[i].toString() + " + ";
        }
        func += this.f[this.f.length-1].toString();
        return func +")";
    }

    /**
     * calculates the derivative of the function
     * @return function object that is the derivative of the function
     */
    @Override
    public Function derivative() {
        Function[] derF = new Function[this.f.length];
        for(int i = 0; i < this.f.length; i++){
            derF[i] = this.f[i].derivative();
        }
        return new MultiSum(derF[0], derF[1], breakFunction(breakFunction(derF)));
    }
}
