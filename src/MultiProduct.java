public class MultiProduct extends Function{
    protected Function[] f;

    public MultiProduct(Function f1, Function f2, Function...funcs){
        this.f = new Function[funcs.length+2];
        this.f[0] = f1;
        this.f[1] = f2;
        for(int i = 2; i <this.f.length; i++){
            this.f[i] = funcs[i-2];
        }
    }

    @Override
    public double valueAt(double x) {
        double value = 1;
        for(int i = 0; i < this.f.length; i++){
            value *= this.f[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        String func = "(";
        for(int i = 0; i < this.f.length-1; i++){
            func += this.f[i].toString() + " * ";
        }
        func += this.f[this.f.length-1].toString();
        return func +")";
    }


    @Override
    public Function derivative() {
        Function[] der = new Function[this.f.length];

        for(int i = 0; i < this.f.length; i++){
            Function[] func = new Function[this.f.length-1];
            int count = 0;
            for(int j = 0; j < this.f.length; j++) {
                if (j == i) {
                    continue;
                }
                func[count] = this.f[j];
                count++;
            }

            if(func.length == 1){
                der[i] = new Product(this.f[i].derivative(), func[0]);
            }
            else {
                der[i] = new MultiProduct(this.f[i].derivative(),func[0],breakFunction(func));
            }
        }

        return new MultiSum(der[0], der[1], breakFunction(breakFunction(der)));
    }
}
