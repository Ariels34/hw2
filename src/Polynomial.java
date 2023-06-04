public class Polynomial extends Function{
    protected int deg;//the degree of the polynomial
    protected double[] a;//the coefficients of the polynomial

    /**
     * constructor that gets the coefficients
     * @param a the coefficients
     */
    public Polynomial(double...a){
        this.deg = a.length;
        this.a = new double[deg];
        for(int i = 0; i < deg; i++){
            this.a[i] = a[i];
        }
    }

    /**
     * default constructor
     */
    public Polynomial(){}

    /**
     * @return a string that describes the function
     */
    @Override
    public String toString() {
        String poly = "";
        boolean zero = true;

        //dealing with the first coefficient
        if(this.a[0] != 0) {
            zero = false;
            if(a[0] %1 == 0){
                poly += (int)this.a[0];
            }
            else {
                poly += this.a[0];
            }
        }

        for(int i = 1; i <this.deg; i++){
            //dealing with the coefficients
            if(this.a[i] - (int)this.a[i] == 0){
                switch ((int)this.a[i]){
                    case 1:
                        if(zero){
                            poly += "x";
                            zero = false;
                        }
                        else {
                            poly += " + x";
                        }
                        break;
                    case -1:
                        poly+= " - x";
                        break;
                    case 0:
                        break;
                    default:
                        if(a[i] < 0){
                            poly+= " - " + -(int)this.a[i] + "x";
                        }
                        else {
                            //dealing with the degree
                            if(zero){
                                poly += (int) this.a[i] + "x";
                                zero = false;
                            }
                            else {
                                poly += " + " + (int) this.a[i] + "x";
                            }
                        }
                        break;
                }
            }
            else{
                if(a[i] < 0){
                    poly+= " - " + -this.a[i] + "x";
                }
                else {
                    //dealing with the degree
                    if(zero){
                        poly += this.a[i] + "x";
                        zero = false;
                    }
                    else {
                        poly += " + " + this.a[i] + "x";
                    }
                }
            }
            //dealing with the degree
            if(i != 1 && a[i] != 0){
                poly+= "^" + i;
            }
        }
        if(poly == ""){
            poly += "0";
        }
        return "(" + poly + ")";
    }

    /**
     * this method returns the value of the function at x
     * @param x the x value of the point we want to check
     * @return the value of the function at x
     */
    @Override
    public double valueAt(double x) {
        double value = a[0];
        for(int i = 1; i < this.a.length; i++){
            value += (this.a[i] * Math.pow(x, i));
        }
        return value;
    }

    /**
     * calculates the derivative of the function
     * @return polynomial object that is the derivative of the function
     */
    @Override
    public Polynomial derivative() {
        double[] a = new double[this.deg];
        for(int i = 1; i < deg; i++){
            a[i-1] =  i*(this.a[i]);
        }
        return new Polynomial(a);
    }
}
