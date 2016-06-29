package y.f.a;

import y.d.*;
import y.f.*;
import java.util.*;
import y.c.*;

class G implements ah
{
    private A e;
    private t f;
    boolean a;
    boolean b;
    double c;
    private double g;
    private y h;
    double d;
    
    G() {
        this.f = new t();
        this.a = true;
        this.b = false;
        this.c = 0.0;
    }
    
    public void a(final t f) {
        this.f = f;
    }
    
    void a(final boolean a) {
        this.a = a;
    }
    
    public void a(final double c) {
        this.c = c;
    }
    
    void b(final double g) {
        this.g = g;
    }
    
    public y a() {
        return this.h;
    }
    
    private D a(final X x, final double n, final double n2, final double n3) {
        final int u = y.f.a.f.u;
        final D d = new D();
        d.add(this.a(n2, n3, n, 0, 0));
        final q[] m = x.m();
        int i = 1;
    Label_0104_Outer:
        while (i < 2 * m.length) {
            int j = 1;
            while (true) {
                while (j < 2 * i) {
                    d.add(this.a(n2, n3, n, j, i));
                    j += 2;
                    if (u == 0) {
                        if (u != 0) {
                            break;
                        }
                        continue Label_0104_Outer;
                    }
                    else {
                        if (u != 0) {
                            break Label_0104_Outer;
                        }
                        continue Label_0104_Outer;
                    }
                }
                i <<= 1;
                continue;
            }
        }
        return d;
    }
    
    private double a(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n3 - n;
        final double n8 = n4 - n2;
        final double n9 = n5 - n;
        final double n10 = n6 - n2;
        final double n11 = n7 * n9 + n8 * n10;
        final double n12 = Math.sqrt(n7 * n7 + n8 * n8) * Math.sqrt(n9 * n9 + n10 * n10);
        return (n12 == 0.0) ? 0.0 : Math.acos(n11 / n12);
    }
    
    private q a(final t t, final X x, final q[] array, final A a, final double n, final double n2) {
        final int u = y.f.a.f.u;
        double n3 = Double.MAX_VALUE;
        int i = 0;
        q q = null;
        while (i < array.length) {
            q = array[i];
            if (u != 0) {
                return q;
            }
            final q q2 = q;
            final double j = x.j(q2);
            final double k = x.k(q2);
            final double a2 = this.a(t.a, t.b, j, k, this.a(t.a, t.b, j, k, n, n2));
            if (a2 < n3) {
                n3 = a2;
            }
            ++i;
            if (u != 0) {
                break;
            }
        }
        return q;
    }
    
    double a(final double n, final double n2, final double n3, final double n4, final double n5) {
        final double a = t.a(n, n2, n3, n4);
        if (a == 0.0) {
            return a;
        }
        return a * (1.0 + Math.pow(4.0 * n5 / 3.141592653589793, 8.0));
    }
    
    private t a(final double n, final double n2, final double n3, final int n4, final int n5) {
        final double n6 = (n4 == 0) ? 0.0 : (3.141592653589793 * n4 / n5);
        return new t(n + Math.cos(n6) * n3, n2 + Math.sin(n6) * n3);
    }
    
    public double b() {
        return this.d;
    }
    
    public void b(final boolean b) {
        this.b = b;
    }
    
    public void c(final X x) {
        final int u = y.f.a.f.u;
        final double a = this.f.a();
        final double b = this.f.b();
        Label_0054: {
            if (this.a) {
                this.d = this.a(x, a, b);
                if (u == 0) {
                    break Label_0054;
                }
            }
            this.d = this.g;
        }
        final D a2 = this.a(x, this.d + this.c, a, b);
        final A t = x.t();
        final A t2 = x.t();
        final q[] m = x.m();
        int n = 0;
        this.h = new y();
        final C i = a2.m();
        while (true) {
            while (i.f()) {
                final int n2 = n;
                if (u != 0) {
                    Label_0412: {
                        if (n2 == 0) {
                            final x o = x.o();
                            while (true) {
                                while (o.f()) {
                                    final q e = o.e();
                                    final t t3 = (t)t2.b(e);
                                    if (u != 0) {
                                        final f f = new f();
                                        f.h(false);
                                        f.c(this.d);
                                        final q b2 = this.h.b();
                                        final double atan2 = Math.atan2(x.n(b2), x.m(b2));
                                        f.a(atan2);
                                        f.b(this.h.a(), atan2);
                                        break Label_0412;
                                    }
                                    if (t3 != null) {
                                        x.a(e, t3);
                                    }
                                    o.g();
                                    if (u != 0) {
                                        break;
                                    }
                                }
                                this.h.sort(new H(this, t2));
                                continue;
                            }
                        }
                    }
                    x.a(t2);
                    x.a(t);
                    return;
                }
                if (n2 > m.length) {
                    break;
                }
                final t t4 = (t)i.d();
                final q a3 = this.a(t4, x, m, t, a, b);
                if (a3 != null && !t.d(a3)) {
                    t2.a(a3, t4);
                    this.h.add(a3);
                    if (this.e != null) {
                        this.e.a(a3, true);
                    }
                    ++n;
                    t.a(a3, true);
                }
                i.g();
                if (u != 0) {
                    break;
                }
            }
            final boolean b3 = this.b;
            continue;
        }
    }
    
    private double a(final X x, final double n, final double n2) {
        final int u = y.f.a.f.u;
        double n3 = 0.0;
        final x o = x.o();
        double max = 0.0;
        while (o.f()) {
            max = Math.max(n3, x.l(o.e()).a(n, n2));
            if (u != 0) {
                return max;
            }
            n3 = max;
            o.g();
            if (u != 0) {
                break;
            }
        }
        return max;
    }
    
    public void a(final A e) {
        this.e = e;
    }
}
