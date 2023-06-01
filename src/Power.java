public class Power extends Function{

    protected int n;
    protected Function f;

    public Power(Function f,int n){
        this.f = f;
        this.n = n;
    }

    @Override
    public double valueAt(double x) {
        return Math.pow(this.f.valueAt(x),n);
    }

    @Override
    public String toString() {
        return "(" + this.f.toString() + "^" + n + ")";
    }

    @Override
    public Function derivative() {
        if(n==1){
            return f.derivative();
        }
        return new MultiProduct(new Constant(n),new Power(this.f,this.n-1), f.derivative());
    }
}
