public class Sum extends MultiSum{
    protected Function f1,f2;//the two functions that describes the multi function

    /**
     * constructor that gets all parameters
     * @param f1 the first function
     * @param f2 the second function
     */
    public Sum(Function f1, Function f2){
        super(f1, f2);
        this.f1 = f1;
        this.f2 = f2;
    }

}
