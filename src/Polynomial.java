public class Polynomial extends Function{
    protected int deg;
    protected double[] a;

    public Polynomial(double...a){
        this.deg = a.length;
        this.a = new double[deg];
        for(int i = 0; i < deg; i++){
            this.a[i] = a[i];
        }
    }
    public Polynomial(){}

    @Override
    public String toString() {
        String poly = "";
        boolean zero = true;

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
                    if(zero){
                        poly += this.a[i] + "x";
                        zero = false;
                    }
                    else {
                        poly += " + " + this.a[i] + "x";
                    }
                }
            }
            if(i != 1 && a[i] != 0){
                poly+= "^" + i;
            }
        }
        if(poly == ""){
            poly += "0";
        }
        return "(" + poly + ")";
    }

    @Override
    public double valueAt(double x) {
        double value = a[0];
        for(int i = 1; i < this.a.length; i++){
            value += (this.a[i] * Math.pow(x, i));
        }
        return value;
    }

    @Override
    public Polynomial derivative() {
        double[] a = new double[this.deg];
        for(int i = 1; i < deg; i++){
            a[i-1] =  i*(this.a[i]);
        }
        return new Polynomial(a);
    }
}
