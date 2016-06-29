package y.f.f.a.b;

import y.c.*;
import y.f.f.a.a.*;

public class E
{
    private i a;
    private p b;
    private y.f.f.a.b.i c;
    private f d;
    private int e;
    
    public E(final i a, final p b) {
        this.a = a;
        this.b = b;
        this.c = new y.f.f.a.b.i(this.a, this.b);
        this.d = new f();
    }
    
    public void a() {
        this.c.d();
    }
    
    public f b() {
        return this.d;
    }
    
    public static f a(final i i, final p p2) {
        final E e = new E(i, p2);
        e.c();
        e.a();
        return e.b();
    }
    
    public static boolean b(final i i, final p p2) {
        final E e = new E(i, p2);
        final boolean f = e.f();
        e.a();
        return f;
    }
    
    private void c() {
        this.e = 0;
        this.d();
    }
    
    private void d() {
        this.d.clear();
        this.c.h();
        this.c.e();
        this.e();
        this.c.i();
    }
    
    private void e() {
        this.c.f();
        m.a(new H(this, null), this.c);
        this.c.g();
    }
    
    private boolean f() {
        this.c.h();
        this.c.e();
        this.c.f();
        final G g = new G(this, null);
        m.a(g, this.c);
        this.c.g();
        this.c.i();
        return g.b;
    }
    
    static i a(final E e) {
        return e.a;
    }
    
    static int b(final E e) {
        return e.e;
    }
    
    static f c(final E e) {
        return e.d;
    }
}
