package y.f.i.a;

import y.f.*;
import y.c.*;

public class v
{
    private final d b;
    private final R c;
    private P d;
    private P e;
    private final y f;
    private final y g;
    private int h;
    private int i;
    private final y[] j;
    private byte k;
    private bC l;
    private D m;
    private ah n;
    private ah o;
    private aW p;
    D a;
    
    public v(final d b, final R c, final P d, final P e, final y f, final y g, final int i) {
        this.k = -1;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.i = i;
        this.j = this.n();
    }
    
    bC a() {
        if (this.l == null) {
            this.l = new bC(this);
        }
        return this.l;
    }
    
    void a(final w w) {
        if (w.c() != this.b) {
            throw new RuntimeException("edgeInfo does not match edge!");
        }
        if (this.d != null) {
            final double e = w.a(this.i).e();
            this.d = new P(e, e, this.d.f(), this.d.a());
        }
        if (this.e != null) {
            final double e2 = w.a(this.h).e();
            this.e = new P(e2, e2, this.e.f(), this.e.a());
        }
        this.l = new bC(this);
    }
    
    private y[] n() {
        if (this.f == null) {
            return new y[] { this.g };
        }
        if (this.g == null) {
            return new y[] { this.f };
        }
        if (this.f == this.g) {
            if (this.e.c(this.d)) {
                return new y[] { this.f };
            }
            return new y[] { this.f, a(this.d, this.f, this.e) ? this.f.b() : this.f.a(), this.g };
        }
        else {
            if (this.f.c() == this.g) {
                return new y[] { this.f, a(this.d, this.f, this.e) ? this.f.b() : this.f.a(), this.g };
            }
            return new y[] { this.f, this.g };
        }
    }
    
    public String toString() {
        final int a = ab.a;
        final StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < this.j.length) {
            final StringBuffer append = sb.append(this.j[i].toString());
            if (a != 0) {
                return append.toString();
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
    
    y[] b() {
        return this.j;
    }
    
    public byte c() {
        if (this.k == -1) {
            this.m();
        }
        return this.k;
    }
    
    public int d() {
        return this.i;
    }
    
    public void a(final int i) {
        this.i = i;
    }
    
    public int e() {
        return this.h;
    }
    
    public void b(final int h) {
        this.h = h;
    }
    
    public void a(final ah n) {
        this.n = n;
        this.d = new P(n.a(), this.d.f(), this.d.a());
        this.p = null;
    }
    
    public void b(final ah o) {
        this.o = o;
        this.e = new P(o.a(), this.e.f(), this.e.a());
        this.p = null;
    }
    
    aW f() {
        if (this.p == null && (this.n != null || this.o != null)) {
            this.p = new aW(this.n, this.o);
        }
        return this.p;
    }
    
    public d g() {
        return this.b;
    }
    
    public R h() {
        return this.c;
    }
    
    public P i() {
        return this.d;
    }
    
    public P j() {
        return this.e;
    }
    
    public y k() {
        return this.f;
    }
    
    public y l() {
        return this.g;
    }
    
    public D m() {
        if (this.m == null) {
            this.m = this.o();
        }
        return this.m;
    }
    
    private D o() {
        final int a = ab.a;
        final D d = new D();
        int i = this.i;
        if (this.d == null || this.e == null) {
            this.b(i);
            this.k = 4;
            return d;
        }
        Label_0660: {
            if (this.d.a() == this.e.a()) {
                final M b = M.b(this.d.e(), this.e.e());
                final M m = this.f.e() ? new M(this.c.i(), this.c.k()) : new M(this.c.h(), this.c.j());
                final M c = M.c(this.d.e(), this.e.e());
                final boolean b2 = this.f != this.g;
                final boolean b3 = !this.e.e().c(this.d.e());
                if (b2 || b3) {
                    this.k = (byte)(b2 ? 3 : 1);
                    d.add(new g(this.b, i, this.f, this.d.e(), new M(this.d.f(), this.d.f()), m, this.c));
                    ++i;
                    d.add(new g(this.b, i, a(this.d, this.f, this.e) ? this.f.b() : this.f.a(), m, c, b, this.c));
                    ++i;
                    d.add(new g(this.b, i, this.g, this.e.e(), new M(this.e.f(), this.e.f()), m, this.c));
                    if (a == 0) {
                        break Label_0660;
                    }
                }
                this.k = 0;
                d.add(new g(this.b, i, this.f, this.e.e(), m, m, this.c));
                if (a == 0) {
                    break Label_0660;
                }
            }
            this.k = 2;
            d.add(new g(this.b, i, this.f, this.d.e(), new M(this.d.f(), this.e.e().c(this.d.f())), M.d(this.e.e(), this.d.f()), this.c));
            ++i;
            d.add(new g(this.b, i, this.g, this.e.e(), new M(this.e.f(), this.d.e().c(this.e.f())), M.d(this.d.e(), this.e.f()), this.c));
        }
        this.b(i);
        return d;
    }
    
    private static boolean a(final P p3, final y y, final P p4) {
        final double c = p3.e().c();
        final double c2 = p4.e().c();
        if (y.c == y || y.d == y) {
            return c <= c2;
        }
        return c > c2;
    }
}
