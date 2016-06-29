package y.c;

public class E implements C
{
    p a;
    private final D b;
    
    protected E(final D b) {
        this.b = b;
        this.i();
    }
    
    public boolean f() {
        return this.a != null;
    }
    
    public void g() {
        this.a = this.a.a;
    }
    
    public void h() {
        this.a = this.a.b;
    }
    
    public void i() {
        this.a = this.b.b;
    }
    
    public void j() {
        this.a = this.b.c;
    }
    
    public int k() {
        return this.b.a;
    }
    
    public Object d() {
        return this.a.c;
    }
}
