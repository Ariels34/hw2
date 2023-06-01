public class Constant extends Polynomial{
    protected double c;

    public Constant(double c){
        this.c = c;
    }

    @Override
    public double valueAt(double x) {
        return this.c;
    }

    @Override
    public String toString() {
        if(c%1 == 0){
            return "(" + (int)this.c + ")";
        }
        return "(" + this.c + ")";
    }

    @Override
    public Polynomial derivative() {
        return new Polynomial(0);
    }
}
