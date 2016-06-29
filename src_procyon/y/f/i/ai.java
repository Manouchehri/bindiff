package y.f.i;

import y.c.*;
import y.d.*;

class ai extends al
{
    private D q;
    private D[] r;
    private boolean s;
    private D t;
    private boolean u;
    private int v;
    
    public ai(final double n, final double n2, final double n3, final double n4, final boolean b) {
        super(n, n2, n3, n4, b);
        this.r = new D[2];
        this.u = false;
        this.v = -1;
    }
    
    public void a(final d d, final double n, double v, double n2) {
        final int f = v.f;
        if (n < this.t() || n > this.u()) {
            return;
        }
        final double min = Math.min(v, n2);
        n2 = Math.max(v, n2);
        v = min;
        if (v < this.v()) {
            v = this.v();
        }
        if (n2 > this.w()) {
            n2 = this.w();
        }
        if (this.q == null) {
            (this.q = new D()).add(new aj(d, n, v, n2));
        }
        else {
            int n3 = 0;
            p p4 = this.q.k();
            int n4 = 0;
            Label_0278: {
                while (p4 != null) {
                    n4 = n3;
                    if (f != 0 || n4 != 0) {
                        break Label_0278;
                    }
                    final double b = ((aj)p4.c()).b;
                    if (b < n) {
                        p4 = this.q.c(p4);
                        if (f == 0) {
                            continue;
                        }
                    }
                    if (b == n) {
                        if (((aj)p4.c()).a != d) {
                            p4 = this.q.c(p4);
                            if (f == 0) {
                                continue;
                            }
                        }
                        n3 = 1;
                        if (f == 0) {
                            continue;
                        }
                    }
                    p4 = this.q.a(new aj(d, n, v, n2), p4);
                    n3 = 1;
                    if (f != 0) {
                        goto Label_0276;
                    }
                }
                goto Label_0276;
            }
            if (n4 == 0) {
                this.q.add(new aj(d, n, v, n2));
            }
        }
    }
    
    public C a() {
        if (this.q != null) {
            return this.q.m();
        }
        return null;
    }
    
    public void a(final aj aj) {
        final int f = y.f.i.v.f;
        if (this.q == null) {
            return;
        }
        int n = 0;
        final C m = this.q.m();
        while (m.f() && n == 0) {
            if (m.d() == aj) {
                this.q.b(m);
                n = 1;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
    }
    
    public aj a(final d d, final boolean b) {
        final int f = y.f.i.v.f;
        if (this.q == null) {
            return null;
        }
        aj aj = null;
        final double v = this.v();
        final double w = this.w();
        int n = 0;
        final C m = this.q.m();
        while (m.f() && n == 0) {
            final aj aj2 = (aj)m.d();
            if ((b ? (aj2.c == v) : (aj2.d == w)) && d == aj2.a) {
                aj = aj2;
                n = 1;
            }
            m.g();
            if (f != 0) {
                break;
            }
        }
        return aj;
    }
    
    public aj a(final d d) {
        final int f = y.f.i.v.f;
        if (this.q == null) {
            return null;
        }
        this.v();
        this.w();
        final C m = this.q.m();
        aj aj = null;
        while (m.f()) {
            aj = (aj)m.d();
            if (f != 0) {
                return aj;
            }
            if (d == aj.a) {}
            m.g();
            if (f != 0) {
                break;
            }
        }
        return aj;
    }
    
    public void a(final aj aj, final t t, final t t2) {
        final int f = y.f.i.v.f;
        if (this.q == null) {
            return;
        }
        double n = 0.0;
        double n2 = 0.0;
        Label_0077: {
            if (this.m) {
                n = Math.min(t.b, t2.b);
                n2 = Math.max(t.b, t2.b);
                if (f == 0) {
                    break Label_0077;
                }
            }
            n = Math.min(t.a, t2.a);
            n2 = Math.max(t.a, t2.a);
        }
        final aj aj2 = new aj(aj.a, aj.b, Math.max(n, this.v()), Math.min(n2, this.w()));
        int n3 = 0;
        p p3 = this.q.k();
        while (p3 != null && n3 == 0) {
            if (p3.c() == aj) {
                p3.a(aj2);
                n3 = 1;
                if (f == 0) {
                    continue;
                }
            }
            p3 = this.q.c(p3);
            if (f != 0) {
                break;
            }
        }
    }
    
    public void a(final aj aj, final double n) {
        final int f = y.f.i.v.f;
        if (this.q == null) {
            return;
        }
        if (n < this.t() || n > this.u()) {
            return;
        }
        if (n == aj.b) {
            return;
        }
        int n2 = 0;
        Label_0268: {
            if (n < aj.b) {
                p p2 = this.q.k();
                int n3 = 0;
                Label_0200: {
                    while (p2 != null) {
                        n3 = n2;
                        if (f != 0 || n3 != 0) {
                            break Label_0200;
                        }
                        final double b = ((aj)p2.c()).b;
                        if (b < n) {
                            p2 = this.q.c(p2);
                            if (f == 0) {
                                continue;
                            }
                        }
                        if (b == n) {
                            if (((aj)p2.c()).a != aj.a) {
                                p2 = this.q.c(p2);
                                if (f == 0) {
                                    continue;
                                }
                            }
                            n2 = 1;
                            if (f == 0) {
                                continue;
                            }
                        }
                        aj.a(aj, n);
                        final p p3 = p2;
                        this.q.a(aj, p2);
                        p2 = p3;
                        n2 = 1;
                        if (f != 0) {
                            goto Label_0199;
                        }
                    }
                    goto Label_0199;
                }
                n2 = n3;
                while (p2 != null && n2 == 0) {
                    if (((aj)p2.c()).a == aj.a) {
                        this.q.h(p2);
                        n2 = 1;
                        if (f == 0) {
                            continue;
                        }
                    }
                    p2 = this.q.c(p2);
                    if (f != 0) {
                        break Label_0268;
                    }
                }
                return;
            }
        }
        p p4 = this.q.k();
        int n4 = 0;
        Label_0343: {
            while (p4 != null) {
                n4 = n2;
                if (f != 0 || n4 != 0) {
                    break Label_0343;
                }
                if (p4.c() == aj) {
                    this.q.h(p4);
                    n2 = 1;
                    if (f == 0) {
                        continue;
                    }
                }
                p4 = this.q.c(p4);
                if (f != 0) {
                    goto Label_0342;
                }
            }
            goto Label_0342;
        }
        int n5 = n4;
        int n6 = 0;
        Label_0476: {
            while (p4 != null) {
                n6 = n5;
                if (f != 0 || n6 != 0) {
                    break Label_0476;
                }
                final double b2 = ((aj)p4.c()).b;
                if (b2 < n) {
                    p4 = this.q.c(p4);
                    if (f == 0) {
                        continue;
                    }
                }
                if (b2 == n) {
                    if (((aj)p4.c()).a != aj.a) {
                        p4 = this.q.c(p4);
                        if (f == 0) {
                            continue;
                        }
                    }
                    n5 = 1;
                    if (f == 0) {
                        continue;
                    }
                }
                aj.a(aj, n);
                p4 = this.q.a(aj, p4);
                n5 = 1;
                if (f != 0) {
                    goto Label_0474;
                }
            }
            goto Label_0474;
        }
        if (n6 == 0) {
            aj.a(aj, n);
            this.q.add(aj);
        }
    }
    
    public double b() {
        if (this.q == null || this.q.isEmpty()) {
            return Double.NaN;
        }
        return ((aj)this.q.i()).b;
    }
    
    public double c() {
        if (this.q == null || this.q.isEmpty()) {
            return Double.NaN;
        }
        return ((aj)this.q.f()).b;
    }
    
    public ak a(final double n, final double n2, final boolean b) {
        final int n3 = b ? 0 : 1;
        if (this.r[n3] == null) {
            this.r[n3] = new D();
        }
        final ak ak = new ak(n, n2);
        this.r[n3].add(ak);
        return ak;
    }
    
    public D a(final boolean b) {
        return this.r[!b];
    }
    
    public void b(final boolean s) {
        this.s = s;
    }
    
    public boolean d() {
        return this.s;
    }
    
    public void c(final boolean b) {
        final int n = b ? 0 : 1;
        if (this.r[n] != null) {
            this.r[n].clear();
        }
    }
    
    public void b(final aj aj) {
        final int f = y.f.i.v.f;
        if (aj.b < this.v() || aj.b > this.w()) {
            return;
        }
        if (aj.d <= this.t() || aj.c >= this.u()) {
            return;
        }
        final double max = Math.max(this.t(), aj.c);
        final double min = Math.min(this.u(), aj.d);
        if (this.t == null) {
            (this.t = new D()).add(new aj(aj.a, aj.b, max, min));
            this.u = true;
        }
        else {
            int n = 0;
            p p = this.t.k();
            int n2 = 0;
            Label_0304: {
                while (p != null) {
                    n2 = n;
                    if (f != 0 || n2 != 0) {
                        break Label_0304;
                    }
                    final double b = ((aj)p.c()).b;
                    if (b < aj.b) {
                        p = this.t.c(p);
                        if (f == 0) {
                            continue;
                        }
                    }
                    if (b == aj.b) {
                        if (((aj)p.c()).a != aj.a) {
                            p = this.t.c(p);
                            if (f == 0) {
                                continue;
                            }
                        }
                        n = 1;
                        if (f == 0) {
                            continue;
                        }
                    }
                    p = this.t.a(new aj(aj.a, aj.b, max, min), p);
                    n = 1;
                    if (f != 0) {
                        goto Label_0302;
                    }
                }
                goto Label_0302;
            }
            if (n2 == 0) {
                this.t.add(new aj(aj.a, aj.b, max, min));
            }
        }
    }
    
    public boolean a(final double n, final double n2, final d d) {
        final int f = y.f.i.v.f;
        if (this.t == null) {
            return false;
        }
        boolean b = false;
        final C m = this.t.m();
        while (m.f()) {
            final boolean b2 = b;
            if (f != 0 || b2) {
                return b2;
            }
            final aj aj = (aj)m.d();
            Label_0125: {
                if (aj.b == n2 && aj.a != d) {
                    if (n < aj.c || n > aj.d) {
                        break Label_0125;
                    }
                    b = true;
                    if (f == 0) {
                        break Label_0125;
                    }
                }
                if (aj.b > n2) {
                    b = true;
                }
            }
            m.g();
            if (f != 0) {
                goto Label_0137;
            }
        }
        goto Label_0137;
    }
    
    public void e() {
        if (this.t != null && this.u) {
            this.t.clear();
        }
    }
}
