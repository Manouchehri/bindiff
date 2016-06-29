package y.g;

public class d
{
    private Object[] a;
    private int b;
    
    public d(final int n) {
        this.a = new Object[n];
        this.b = -1;
    }
    
    public Object a() {
        return this.a[this.b];
    }
    
    public Object b() {
        return this.a[this.b--];
    }
    
    public void a(final Object o) {
        this.a[++this.b] = o;
    }
    
    public boolean c() {
        return this.b < 0;
    }
}
