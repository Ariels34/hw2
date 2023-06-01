public class Negation extends Function{
    protected Function f;

    public Negation(Function f){
        this.f = f;
    }

    @Override
    public double valueAt(double x) {
        return (-1)*this.f.valueAt(x);
    }

    @Override
    public String toString() {
        return "(-"+this.f.toString()+")";
    }

    @Override
    public Function derivative() {
        return new Negation(this.f.derivative());
    }
}

