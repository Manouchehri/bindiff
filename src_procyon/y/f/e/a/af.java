package y.f.e.a;

import java.util.*;
import y.c.*;
import y.f.*;

public class af implements w
{
    protected int a;
    private int c;
    private int d;
    private a e;
    private a f;
    private a g;
    private double h;
    private double i;
    private double j;
    private X k;
    private A l;
    private h m;
    private List n;
    public static boolean b;
    
    public af(final X k) {
        this.e = new Z();
        this.f = new Z();
        this.g = new Z();
        this.n = new ArrayList();
        this.k = k;
        this.l = k.t();
        this.m = k.u();
        this.m();
    }
    
    void a(final m m, final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final boolean b = af.b;
        if (this.n.isEmpty()) {
            return;
        }
        final ap ap = new ap(this, m, n, n2, n3, n4, n5, n6);
        final ao[] array = new ao[this.n.size()];
        this.n.toArray(array);
        int i = 0;
        while (i < array.length) {
            array[i].a(ap);
            ++i;
            if (b) {
                break;
            }
        }
    }
    
    private void b(final X x) {
        final boolean b = af.b;
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            this.l.a(e, this.b(e));
            o.g();
            if (b) {
                return;
            }
            if (b) {
                break;
            }
        }
        this.h = this.c * 0.9;
        this.i = 0.81 * this.c;
        this.l();
    }
    
    private void c(final X x) {
        final boolean b = af.b;
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            this.m.a(a, this.c(a));
            p.g();
            if (b) {
                break;
            }
        }
    }
    
    private ah c(final d d) {
        return new ah(this, d);
    }
    
    protected ag b(final q q) {
        return new ag(this, q);
    }
    
    public int g() {
        return this.a;
    }
    
    public double d() {
        return y.f.e.a.c.a(this.k.e(), this.h, this.i);
    }
    
    public double a() {
        return y.f.e.a.c.a(this.k.e(), this.f.d(), this.g.d());
    }
    
    public double b() {
        return y.f.e.a.c.a(this.k.e(), this.f.e(), this.g.e());
    }
    
    private void l() {
        this.j = ((this.c > 0) ? (this.h / this.c) : 0.0);
    }
    
    public k e() {
        this.e.a(this.h());
        this.e.b(this.i());
        this.e.c(this.j());
        return this.e;
    }
    
    public double h() {
        return (this.c > 0) ? (this.f.d() / this.c) : 0.0;
    }
    
    public double i() {
        return (this.c > 0) ? (this.f.e() / this.c) : 0.0;
    }
    
    public double j() {
        return (this.c > 0) ? (this.f.f() / this.c) : 0.0;
    }
    
    public m a(final q q) {
        return (m)this.l.b(q);
    }
    
    public ag c(final q q) {
        return (ag)this.l.b(q);
    }
    
    private void m() {
        this.d = this.k.h();
        this.c = this.k.f();
        this.b(this.k);
        this.c(this.k);
    }
    
    public void k() {
        final boolean b = af.b;
        final x o = this.k.o();
        while (o.f()) {
            final q e = o.e();
            final ag c = this.c(e);
            final am h = this.k.h(e);
            h.setLocation(c.b() - h.getWidth() / 2.0, c.c() - h.getHeight() / 2.0);
            o.g();
            if (b) {
                break;
            }
        }
    }
    
    public X f() {
        return this.k;
    }
    
    public double c() {
        return this.j;
    }
    
    public aq a(final d d) {
        return (aq)this.m.b(d);
    }
    
    public ah b(final d d) {
        return (ah)this.m.b(d);
    }
    
    public void a(final X x) {
        if (x != this.k) {
            throw new IllegalStateException();
        }
        x.a(this.l);
        this.l = null;
        x.a(this.m);
        this.m = null;
        this.k = null;
    }
    
    static X a(final af af) {
        return af.k;
    }
    
    static a b(final af af) {
        return af.f;
    }
    
    static a c(final af af) {
        return af.g;
    }
    
    static double a(final af af, final double n) {
        return af.h += n;
    }
    
    static double b(final af af, final double n) {
        return af.i += n;
    }
    
    static void d(final af af) {
        af.l();
    }
}
