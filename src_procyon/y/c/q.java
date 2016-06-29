package y.c;

import java.util.*;

public class q extends I
{
    i a;
    d b;
    d c;
    d d;
    d e;
    int f;
    int g;
    int h;
    
    protected q(final i i) {
        i.g(this);
    }
    
    public q a(final i i) {
        return i.d();
    }
    
    public int a() {
        return this.f + this.g;
    }
    
    public int b() {
        return this.g;
    }
    
    public int c() {
        return this.f;
    }
    
    public int d() {
        if (this.a.e) {
            this.a.A();
        }
        return this.h;
    }
    
    public i e() {
        return this.a;
    }
    
    public d f() {
        return this.c;
    }
    
    public d g() {
        return this.b;
    }
    
    public d h() {
        return this.d;
    }
    
    public d i() {
        return this.e;
    }
    
    public e j() {
        return new u(this);
    }
    
    public e k() {
        return new s(this);
    }
    
    public e l() {
        return new v(this);
    }
    
    public e a(final d d) {
        return new v(this, d);
    }
    
    public x m() {
        return new r(this);
    }
    
    public x n() {
        return new w(this);
    }
    
    public x o() {
        return new t(this);
    }
    
    public d a(final q q) {
        final boolean e = D.e;
        if (q.g < this.f) {
            return q.b(this);
        }
        d d = this.c;
        while (d != null) {
            if (d.f == q) {
                return d;
            }
            d = d.a;
            if (e) {
                break;
            }
        }
        return null;
    }
    
    public d b(final q q) {
        final boolean e = D.e;
        if (q.f < this.g) {
            return q.a(this);
        }
        d d = this.b;
        while (d != null) {
            if (d.e == q) {
                return d;
            }
            d = d.b;
            if (e) {
                break;
            }
        }
        return null;
    }
    
    public d c(final q q) {
        d d = this.a(q);
        if (d == null) {
            d = this.b(q);
        }
        return d;
    }
    
    public void a(final Comparator comparator) {
        if (this.g > 1) {
            if (this.g > 2 || comparator == null) {
                this.b(comparator, new d[this.g]);
                if (!D.e) {
                    return;
                }
            }
            this.b(comparator, null);
        }
    }
    
    public void b(final Comparator comparator) {
        if (this.f > 1) {
            if (this.f > 2 || comparator == null) {
                this.a(comparator, new d[this.f]);
                if (!D.e) {
                    return;
                }
            }
            this.a(comparator, null);
        }
    }
    
    public String toString() {
        if (this.e() != null) {
            return "node index:" + this.d();
        }
        return "node without a graph";
    }
    
    void a(final i a, final int n) {
        this.a(n);
        this.a = a;
    }
    
    void b(final i a) {
        this.a = a;
    }
    
    void b(final d d) {
        d.c = this.d;
        d.a = null;
        Label_0039: {
            if (this.d != null) {
                this.d.a = d;
                if (!D.e) {
                    break Label_0039;
                }
            }
            this.c = d;
        }
        this.d = d;
        ++this.f;
    }
    
    void c(final d c) {
        c.a = this.c;
        c.c = null;
        Label_0039: {
            if (this.c != null) {
                this.c.c = c;
                if (!D.e) {
                    break Label_0039;
                }
            }
            this.d = c;
        }
        this.c = c;
        ++this.f;
    }
    
    void a(final d d, final d d2, final int n) {
        final boolean e = D.e;
        if (n == 0) {
            if (d2 == null) {
                this.b(d);
                if (!e) {
                    return;
                }
            }
            if (d2 == this.d) {
                this.b(d);
                if (!e) {
                    return;
                }
            }
            Label_0101: {
                if (this.d == null) {
                    d.c = null;
                    d.a = null;
                    this.d = d;
                    this.c = d;
                    if (!e) {
                        break Label_0101;
                    }
                }
                final d a = d2.a;
                d2.a = d;
                d.a = a;
                a.c = d;
                d.c = d2;
            }
            ++this.f;
            if (!e) {
                return;
            }
        }
        if (d2 == null) {
            this.b(d);
            if (!e) {
                return;
            }
        }
        if (d2 == this.c) {
            this.c(d);
            if (!e) {
                return;
            }
        }
        Label_0208: {
            if (this.d == null) {
                d.c = null;
                d.a = null;
                this.d = d;
                this.c = d;
                if (!e) {
                    break Label_0208;
                }
            }
            final d c = d2.c;
            d2.c = d;
            d.c = c;
            c.a = d;
            d.a = d2;
        }
        ++this.f;
    }
    
    void d(final d e) {
        e.d = this.e;
        e.b = null;
        Label_0039: {
            if (this.e != null) {
                this.e.b = e;
                if (!D.e) {
                    break Label_0039;
                }
            }
            this.b = e;
        }
        this.e = e;
        ++this.g;
    }
    
    void e(final d b) {
        b.b = this.b;
        b.d = null;
        Label_0039: {
            if (this.b != null) {
                this.b.d = b;
                if (!D.e) {
                    break Label_0039;
                }
            }
            this.e = b;
        }
        this.b = b;
        ++this.g;
    }
    
    void b(final d d, final d d2, final int n) {
        final boolean e = D.e;
        if (n == 0) {
            if (d2 == null) {
                this.d(d);
                if (!e) {
                    return;
                }
            }
            if (d2 == this.e) {
                this.d(d);
                if (!e) {
                    return;
                }
            }
            Label_0101: {
                if (this.e == null) {
                    d.d = null;
                    d.b = null;
                    this.e = d;
                    this.b = d;
                    if (!e) {
                        break Label_0101;
                    }
                }
                final d b = d2.b;
                d2.b = d;
                d.b = b;
                b.d = d;
                d.d = d2;
            }
            ++this.g;
            if (!e) {
                return;
            }
        }
        if (d2 == null) {
            this.d(d);
            if (!e) {
                return;
            }
        }
        if (d2 == this.b) {
            this.e(d);
            if (!e) {
                return;
            }
        }
        Label_0208: {
            if (this.e == null) {
                d.d = null;
                d.b = null;
                this.e = d;
                this.b = d;
                if (!e) {
                    break Label_0208;
                }
            }
            final d d3 = d2.d;
            d2.d = d;
            d.d = d3;
            d3.b = d;
            d.b = d2;
        }
        ++this.g;
    }
    
    void f(final d d) {
        final boolean e = D.e;
        Label_0035: {
            if (d != this.c) {
                d.c.a = d.a;
                if (!e) {
                    break Label_0035;
                }
            }
            this.c = d.a;
        }
        Label_0066: {
            if (d != this.d) {
                d.a.c = d.c;
                if (!e) {
                    break Label_0066;
                }
            }
            this.d = d.c;
        }
        --this.f;
    }
    
    void g(final d d) {
        final boolean e = D.e;
        Label_0035: {
            if (d != this.b) {
                d.d.b = d.b;
                if (!e) {
                    break Label_0035;
                }
            }
            this.b = d.b;
        }
        Label_0066: {
            if (d != this.e) {
                d.b.d = d.d;
                if (!e) {
                    break Label_0066;
                }
            }
            this.e = d.d;
        }
        --this.g;
    }
    
    void p() {
        final d d = null;
        this.d = d;
        this.e = d;
        this.b = d;
        this.c = d;
        final boolean b = false;
        this.g = (b ? 1 : 0);
        this.f = (b ? 1 : 0);
    }
    
    void a(final Comparator comparator, final d[] array) {
        final boolean e = D.e;
        if (this.f < 2) {
            return;
        }
        if (this.f == 2 && comparator != null) {
            if (comparator.compare(this.c, this.d) > 0) {
                this.d = this.c;
                this.c = this.d.a;
                this.d.c = this.c;
                this.c.a = this.d;
                final d d = this.d;
                final d c = this.c;
                final d d2 = null;
                c.c = d2;
                d.a = d2;
            }
            return;
        }
        final int f = this.f;
        int n = 0;
        d d3 = this.c;
        while (true) {
            while (d3 != null) {
                array[n] = d3;
                ++n;
                d3 = d3.a;
                if (e) {
                    final d c2 = array[0];
                    this.c = c2;
                    d c3 = c2;
                    c3.c = null;
                    int i = 1;
                    while (i < f) {
                        d3 = array[i];
                        d3.c = c3;
                        c3.a = d3;
                        ++i;
                        c3 = d3;
                        if (e) {
                            return;
                        }
                        if (e) {
                            break;
                        }
                    }
                    this.d = d3;
                    d3.a = null;
                    return;
                }
                if (e) {
                    break;
                }
            }
            y.g.e.a(array, 0, f, comparator);
            continue;
        }
    }
    
    void b(final Comparator comparator, final d[] array) {
        final boolean e = D.e;
        if (this.g < 2) {
            return;
        }
        if (this.g == 2 && comparator != null) {
            if (comparator.compare(this.b, this.e) > 0) {
                this.e = this.b;
                this.b = this.e.b;
                this.e.d = this.b;
                this.b.b = this.e;
                final d e2 = this.e;
                final d b = this.b;
                final d d = null;
                b.d = d;
                e2.b = d;
            }
            return;
        }
        final int g = this.g;
        int n = 0;
        d d2 = this.b;
        while (true) {
            while (d2 != null) {
                array[n] = d2;
                ++n;
                d2 = d2.b;
                if (e) {
                    final d b2 = array[0];
                    this.b = b2;
                    d d3 = b2;
                    d3.d = null;
                    int i = 1;
                    while (i < g) {
                        d2 = array[i];
                        d2.d = d3;
                        d3.b = d2;
                        ++i;
                        d3 = d2;
                        if (e) {
                            return;
                        }
                        if (e) {
                            break;
                        }
                    }
                    this.e = d2;
                    d2.b = null;
                    return;
                }
                if (e) {
                    break;
                }
            }
            y.g.e.a(array, 0, g, comparator);
            continue;
        }
    }
}
