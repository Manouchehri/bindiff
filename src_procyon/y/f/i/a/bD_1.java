package y.f.i.a;

import y.c.*;

class bD
{
    private int a;
    private final d b;
    private final d c;
    private Object d;
    
    bD(final d b, final d c, final Object d, final int a) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.a = a;
    }
    
    public d a() {
        return this.c;
    }
    
    public d b() {
        return this.b;
    }
    
    public int c() {
        return this.a;
    }
    
    public void a(final int a) {
        this.a = a;
    }
    
    public boolean a(final bD bd) {
        return !this.d.equals(bd.d);
    }
    
    static Object b(final bD bd) {
        return bd.d;
    }
    
    static d c(final bD bd) {
        return bd.b;
    }
    
    static d d(final bD bd) {
        return bd.c;
    }
}
