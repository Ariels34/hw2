public class Product extends MultiProduct{
    protected Function f1,f2;

    public Product(Function f1, Function f2){
        super(f1, f2);
        this.f1 = f1;
        this.f2 = f2;
    }
}
