public class Sum extends MultiSum{
    protected Function f1,f2;

    public Sum(Function f1, Function f2){
        super(f1, f2);
        this.f1 = f1;
        this.f2 = f2;
    }

}
