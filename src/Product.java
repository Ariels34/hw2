public class Product extends MultiProduct{
    protected Function f1,f2;

    public Product(Function f1, Function f2){
        super(f1, f2);
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double valueAt(double x) {
        return f1.valueAt(x) * f2.valueAt(x);
    }

    @Override
    public Function derivative() {
        return new Sum(new Product(this.f1.derivative(),this.f2), new Product(this.f2.derivative(),this.f1));
    }

    @Override
    public String toString() {
        return "(" + f1.toString() + " * " + f2.toString() + ")";
    }
}
