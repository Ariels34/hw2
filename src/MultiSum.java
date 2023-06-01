public class MultiSum extends Function{
    protected Function[] f;


    public MultiSum(Function f1, Function f2, Function...funcs){
        this.f = new Function[funcs.length+2];
        this.f[0] = f1;
        this.f[1] = f2;
        for(int i = 2; i <this.f.length; i++){
            this.f[i] = funcs[i-2];
        }
    }

    @Override
    public double valueAt(double x) {
        double value = 0;
        for(int i = 0; i < this.f.length; i++){
            value += this.f[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        String func = "(";
        for(int i = 0; i < this.f.length-1; i++){
            func += this.f[i].toString() + " + ";
        }
        func += this.f[this.f.length-1].toString();
        return func +")";
    }

    @Override
    public Function derivative() {
        Function[] derF = new Function[this.f.length];
        for(int i = 0; i < this.f.length; i++){
            derF[i] = this.f[i].derivative();
        }
        return new MultiSum(derF[0], derF[1], breakFunction(breakFunction(derF)));
    }
}
