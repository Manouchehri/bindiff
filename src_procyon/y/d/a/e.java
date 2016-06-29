package y.d.a;

import y.c.*;

public class e
{
    q a;
    p b;
    Object c;
    Object d;
    Object e;
    int f;
    Object g;
    e h;
    private final b i;
    
    public e(final b i, final Object c, final Object d, final Object e, final int f) {
        this.i = i;
        this.c = c;
        this.d = d;
        this.f = f;
        this.e = e;
        this.g = y.d.a.b.a(i).c(this.c, this.d);
        this.h = null;
    }
    
    public void a(final e h) {
        this.h = h;
    }
    
    public void a(final p b) {
        this.b = b;
    }
    
    public String toString() {
        return this.c + " " + this.d;
    }
    
    public boolean a() {
        return this.c.equals(y.d.a.b.a(this.i).c(this.e));
    }
    
    public int b() {
        return this.f;
    }
}
