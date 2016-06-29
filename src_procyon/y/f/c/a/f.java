package y.f.c.a;

import y.d.*;
import y.f.*;
import y.a.*;
import y.g.*;
import java.util.*;
import y.c.*;

public class f implements aT
{
    private static final r a;
    private X b;
    private double c;
    private boolean d;
    private aT e;
    
    public f(final aT e) {
        this.c = 1.0;
        this.d = true;
        this.e = e;
    }
    
    public aT a() {
        return this.e;
    }
    
    private boolean a(final X x) {
        final c c = x.c("AspectRatioComponentLayerer.GROUPING_SUPPORT");
        if (c == null) {
            return false;
        }
        final E e = (E)c.b(x);
        return e != null && e.k();
    }
    
    public void a(final X b, final aU au, final aV av) {
        final boolean x = N.x;
        this.b = b;
        final boolean a = this.a(b);
        final aT a2 = this.a();
        final A t = b.t();
        final int a3 = h.a(b, t);
        if (a3 == 1) {
            a2.a(b, au, av);
            if (!x) {
                return;
            }
        }
        final y.f.c.a.i[] array = new y.f.c.a.i[a3];
        final x o = b.o();
        while (o.f()) {
            final q e = o.e();
            final int a4 = t.a(e);
            if (x) {
                return;
            }
            Label_0146: {
                if (array[a4] == null) {
                    array[a4] = new y.f.c.a.i(this, e, a4);
                    if (!x) {
                        break Label_0146;
                    }
                }
                array[a4].a(e);
            }
            o.g();
            if (x) {
                break;
            }
        }
        final J j = new J(b, t);
        int i = 0;
        while (true) {
        Label_0431_Outer:
            while (i < a3) {
                final y.f.c.a.i k = array[i];
                j.c(k.a());
                k.a(au.a());
                a2.a(b, k.b(), av);
                ++i;
                if (!x) {
                    if (x) {
                        break;
                    }
                    continue;
                }
                else {
                    final y.f.c.a.h h = new y.f.c.a.h(this);
                    final aU au2 = a ? au.a() : au;
                    int l = 0;
                    while (l < a3) {
                        h.a(array[l], au2);
                        ++l;
                        if (x) {
                            return;
                        }
                        if (x) {
                            break;
                        }
                    }
                    if (a) {
                        final A a5 = M.a();
                        int n = 0;
                    Label_0333:
                        while (true) {
                        Label_0415_Outer:
                            while (n < au2.b()) {
                                final y d = au2.a(n).d();
                                if (!x) {
                                    final x a6 = d.a();
                                    while (true) {
                                        while (a6.f()) {
                                            a5.a(a6.e(), n);
                                            a6.g();
                                            if (!x) {
                                                if (x) {
                                                    break;
                                                }
                                                continue Label_0415_Outer;
                                            }
                                            else {
                                                if (x) {
                                                    break Label_0415_Outer;
                                                }
                                                continue Label_0333;
                                            }
                                        }
                                        ++n;
                                        continue Label_0431_Outer;
                                    }
                                }
                                final y y = d;
                                final E e2 = (E)b.c("AspectRatioComponentLayerer.GROUPING_SUPPORT").b(b);
                                e2.c();
                                final y.f.b.c c = new y.f.b.c(b);
                                final y a7 = this.a(c);
                                final A a8 = M.a();
                                final x a9 = a7.a();
                                while (a9.f()) {
                                    final q e3 = a9.e();
                                    a8.a(e3, new k(this, e3, c));
                                    a9.g();
                                    if (x) {
                                        return;
                                    }
                                    if (x) {
                                        break;
                                    }
                                }
                                final k m = new k(this, c.b(), c);
                                this.a(array, c, m, a8);
                                final x a10 = a7.a();
                                while (true) {
                                    while (a10.f()) {
                                        ((k)a8.b(a10.e())).a(a5, a8);
                                        a10.g();
                                        if (x) {
                                            int n2 = 0;
                                            int a11 = a5.a(y.b());
                                            final x a12 = y.a();
                                            while (true) {
                                                while (a12.f()) {
                                                    final q e4 = a12.e();
                                                    final int a13;
                                                    final int n3 = a13 = a5.a(e4);
                                                    if (x) {
                                                        int n4 = a13;
                                                        while (n4 <= n2) {
                                                            au.a((byte)((n4 < au2.b()) ? au2.a(n4).e() : 0), n4);
                                                            ++n4;
                                                            if (x) {
                                                                break;
                                                            }
                                                        }
                                                        final x a14 = y.a();
                                                        while (true) {
                                                            while (a14.f()) {
                                                                final q e5 = a14.e();
                                                                au.a(a5.a(e5)).a(e5);
                                                                a14.g();
                                                                if (x) {
                                                                    e2.b();
                                                                    return;
                                                                }
                                                                if (x) {
                                                                    break;
                                                                }
                                                            }
                                                            c.c();
                                                            continue;
                                                        }
                                                    }
                                                    if (a13 != a11) {
                                                        ++n2;
                                                        a11 = n3;
                                                    }
                                                    a5.a(e4, n2);
                                                    a12.g();
                                                    if (x) {
                                                        break;
                                                    }
                                                }
                                                continue;
                                            }
                                        }
                                        if (x) {
                                            break;
                                        }
                                    }
                                    m.a(a5, a8);
                                    y.sort(new g(this, a5));
                                    continue;
                                }
                            }
                            final y y2 = new y(b.o());
                            continue;
                        }
                    }
                    return;
                }
            }
            j.b();
            Arrays.sort(array, new j(this, null));
            continue;
        }
    }
    
    private r a(final q q) {
        if (q == null) {
            return f.a;
        }
        final c c = this.b.c(y.f.b.f.e);
        final r r = (c == null) ? null : y.d.r.a(c.b(q));
        if (r == null) {
            return f.a;
        }
        return r;
    }
    
    private y a(final y.f.b.c c) {
        final boolean x = N.x;
        final y y = new y();
        final y c2 = c.c(c.b());
        c2.n();
        final x a = c2.a();
        while (a.f()) {
            final q e = a.e();
            if (c.d(e)) {
                y.add(e);
            }
            a.g();
            if (x) {
                break;
            }
        }
        return y;
    }
    
    private void a(final y.f.c.a.i[] array, final y.f.b.c c, final k k, final A a) {
        final boolean x = N.x;
        int i = 0;
        while (i < array.length) {
            final y.f.c.a.i j = array[i];
            final y c2 = j.c();
            c.a(c2.b());
            q q = null;
            boolean b = false;
        Label_0037:
            while (true) {
                q q2 = null;
                q = q2;
                b = true;
                final x a2 = c2.a();
                while (a2.f()) {
                    final q a3 = c.a(a2.e());
                    q2 = q;
                    if (x) {
                        continue Label_0037;
                    }
                    if ((q2 == null && a3 != null) || (q != null && !q.equals(a3))) {
                        b = false;
                        if (!x) {
                            break;
                        }
                    }
                    a2.g();
                    if (x) {
                        break;
                    }
                }
                break;
            }
            Label_0168: {
                if (b) {
                    if (q == c.b()) {
                        k.a(j);
                        if (!x) {
                            break Label_0168;
                        }
                    }
                    ((k)a.b(q)).a(j);
                }
            }
            ++i;
            if (x) {
                break;
            }
        }
    }
    
    private double b(final q q) {
        if (!this.d) {
            return 1.0;
        }
        return this.b.p(q);
    }
    
    private double c(final q q) {
        if (!this.d) {
            return 1.0;
        }
        return this.b.q(q);
    }
    
    private boolean a(final double n, final double n2) {
        return ((n > this.c) ? (n / this.c) : (this.c / n)) < ((n2 > this.c) ? (n2 / this.c) : (this.c / n2));
    }
    
    static X a(final f f) {
        return f.b;
    }
    
    static double a(final f f, final q q) {
        return f.c(q);
    }
    
    static double b(final f f, final q q) {
        return f.b(q);
    }
    
    static boolean a(final f f, final double n, final double n2) {
        return f.a(n, n2);
    }
    
    static r c(final f f, final q q) {
        return f.a(q);
    }
    
    static {
        a = new r(0.0, 0.0, 0.0, 0.0);
    }
}
