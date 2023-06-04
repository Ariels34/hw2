public abstract class Function {

    /**
     * this method returns the value of the function at x
     * @param x the x value of the point we want to check
     * @return the value of the function at x
     */
    public abstract double valueAt(double x);

    /**
     * @return a string that describes the function
     */
    @Override
    public abstract String toString();

    /**
     * calculates the derivative of the function
     * @return function object that is the derivative of the function
     */
    public abstract Function derivative();

    /**
     * calculates the roots of the function
     * @param a the x of the first point in the interval [a,b]
     * @param b the x of the last point in the interval [a,b]
     * @param epsilon epsilon value
     * @return root of the function
     */
    public double bisectionMethod(double a, double b, double epsilon){
        double left = a;
        double right = b;
        while(right - left > epsilon){
            double mid = (left+right) / 2;
            if(valueAt(left) * valueAt(mid) > 0){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return (left+right) / 2;
    }

    /**
     * calculates the roots of the function with epsilon = 10^(-5)
     * @param a the x of the first point in the interval [a,b]
     * @param b the x of the last point in the interval [a,b]
     * @return root of the function
     */
    public double bisectionMethod(double a, double b){
        return bisectionMethod(a, b, Math.pow(10, (-5)));
    }

    /**
     * calculates the roots of the function
     * @param a represents x0
     * @param epsilon epsilon value
     * @return root of the function
     */
    public double newtonRaphsonMethod(double a, double epsilon){
        double x=a;
        while(Math.abs(valueAt(x)) >= epsilon) {
            x = x - (valueAt(x)/ derivative().valueAt(x));
        }
        return x;
    }

    /**
     * calculates the roots of the function with epsilon = 10^(-5)
     * @param a represents x0
     * @return root of the function
     */
    public double newtonRaphsonMethod(double a){
        return newtonRaphsonMethod(a, Math.pow(10, (-5)));
    }

    /**
     * calculates the taylor polynomial of the function
     * @param n the degree of the polynomial
     * @return the taylor polynomial
     */
    public Polynomial taylorPolynomial(int n){
        double[] a = new double[n+1];
        double[] fact = new double[n+1];
        Function[] dev = new Function[n+1];
        fact[0] = 1;
        a[0] = valueAt(0);
        for(int k = 1; k <= n ;k++){
            if(k == 1){
                dev[1] = derivative();
            }
            else{
                dev[k] = dev[k-1].derivative();
            }
            fact[k] = fact[k-1]*k;
        }
        for(int k= 1; k <= n; k++){
            a[k] = (dev[k].valueAt(0)/fact[k]);
        }
        return new Polynomial(a);
    }

    /**
     * removes the first function in the array
     * @param f functions array
     * @return a new array without the first function
     */
    public Function[] breakFunction(Function[] f){
        Function[] newf = new Function[f.length-1];
        for(int i = 1; i < f.length; i++){
            newf[i-1] = f[i];
        }
        return newf;
    }

}
