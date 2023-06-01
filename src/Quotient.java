public class Quotient extends Product{
    protected Function f1,f2;

    public Quotient(Function f1, Function f2){
        super(f1, f2);
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) / f2.valueAt(x);
    }

    @Override
    public Function derivative() {
        return new Quotient(new Difference(new Product(this.f1.derivative(),this.f2), new Product(this.f2.derivative(),this.f1)), new Power(this.f2, 2));
    }

    @Override
    public String toString() {
        return "(" + f1.toString() + " / " + f2.toString() + ")";
    }
}
