public abstract class Function {

    public abstract double valueAt(double x);
    @Override
    public abstract String toString();
    public abstract Function derivative();

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

    public double bisectionMethod(double a, double b){
        return bisectionMethod(a, b, Math.pow(10, (-5)));
    }

    public double newtonRaphsonMethod(double a, double epsilon){
        double x=a;
        while(Math.abs(valueAt(x)) >= epsilon) {
            x = x - (valueAt(x)/ derivative().valueAt(x));
        }
        return x;
    }

    public double newtonRaphsonMethod(double a){
        return newtonRaphsonMethod(a, Math.pow(10, (-5)));
    }

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
            a[k] = (dev[k].valueAt(0) /fact[k]);
        }
        return new Polynomial(a);
    }

    public Function[] breakFunction(Function[] f){
        Function[] newf = new Function[f.length-1];
        for(int i = 1; i < f.length; i++){
            newf[i-1] = f[i];
        }
        return newf;
    }

}
