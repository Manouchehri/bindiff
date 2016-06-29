package y.f.h.a;

import java.util.*;
import y.c.*;

class n extends r
{
    private q b;
    private int c;
    private int d;
    private int e;
    private p f;
    private D g;
    private m h;
    private D i;
    private D j;
    private D k;
    
    n(final q b, final int d, final m h) {
        this.b = null;
        this.c = -1;
        this.d = Integer.MAX_VALUE;
        this.e = Integer.MAX_VALUE;
        this.f = new p();
        this.i = new D();
        this.j = new D();
        this.k = null;
        this.b = b;
        this.c = d;
        this.e = d;
        this.d = d;
        this.h = h;
    }
    
    public String toString() {
        if (this.a != null) {
            return Integer.toString(this.f()) + ": " + this.a.toString();
        }
        return Integer.toString(this.f());
    }
    
    String a() {
        return Integer.toString(this.f());
    }
    
    n b() {
        return this;
    }
    
    h a(final i i) {
        return this.f.a(i);
    }
    
    p c() {
        return this.f;
    }
    
    D d() {
        return this.i;
    }
    
    m a(final i i, final int n, final int n2) {
        final boolean g = y.f.h.a.b.g;
        final m f = i.f(n);
        if (f == null) {
            System.out.println("Error!");
        }
        final r a = f.a(i);
        final int a2 = a.a(f, n ^ 0x1);
        final m f2 = this.f(n2);
        final r a3 = f2.a(this);
        final m t = a3.t();
        final int a4 = a3.a(f2, n2 ^ 0x1);
        final m b = y.f.h.a.b.b(a, a3, a2, a4, f.a() + f2.a());
        Label_0154: {
            if (t != null) {
                if (a4 == 0) {
                    a3.e(t);
                    if (!g) {
                        break Label_0154;
                    }
                    y.c.i.g = !y.c.i.g;
                }
                if (a4 == 1) {
                    a3.d(t);
                }
            }
        }
        i.e();
        if (n == n2) {
            i.d();
        }
        if (n2 == 0) {
            this.a.b(i.r());
            if (!g) {
                return b;
            }
        }
        this.a.a(i.r());
        return b;
    }
    
    void b(final i i) {
        if (this.g == null) {
            this.g = new D();
        }
        this.g.add(i);
    }
    
    void e() {
        final boolean g = y.f.h.a.b.g;
        if (this.g != null) {
            for (final i i : this.g) {
                this.a.a(i.r());
                i.e();
                if (g) {
                    break;
                }
            }
        }
    }
    
    D h() {
        return this.g;
    }
    
    int f() {
        return this.c;
    }
    
    void a(final int e, final m h) {
        this.c = e;
        this.d = e;
        this.e = e;
        this.h = h;
    }
    
    q i() {
        return this.b;
    }
    
    m j() {
        return this.h;
    }
    
    int k() {
        if (this.h == null) {
            return -1;
        }
        return this.h.a(this).f();
    }
    
    void a(final int n) {
        this.d = Math.min(this.d, n);
        this.e = Math.min(this.d, this.e);
    }
    
    void b(final int n) {
        this.e = Math.min(this.e, n);
    }
    
    int l() {
        return this.e;
    }
    
    void a(final m m) {
        this.i.b(m);
    }
    
    D m() {
        return this.j;
    }
    
    void b(final m m) {
        this.j.b(m);
    }
    
    int n() {
        if (this.j.isEmpty()) {
            return -1;
        }
        return ((m)this.j.i()).e().f();
    }
    
    m o() {
        if (this.j.isEmpty()) {
            return null;
        }
        return (m)this.j.j();
    }
    
    m p() {
        if (this.j.isEmpty()) {
            return null;
        }
        return (m)this.j.i();
    }
    
    boolean c(final int n) {
        return this.d < n || (this.f.b() != null && this.f.b().a(n));
    }
    
    boolean d(final int n) {
        return this.f.c() != null && this.f.c().b(n);
    }
    
    boolean e(final int n) {
        return this.d(n) || this.n() == n;
    }
    
    void a(final d d) {
        if (this.k == null) {
            this.k = new D();
        }
        this.k.add(d);
    }
    
    D q() {
        return this.k;
    }
    
    void a(final D k) {
        this.k = k;
    }
}
