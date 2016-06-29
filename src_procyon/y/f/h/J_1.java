package y.f.h;

import y.g.*;
import y.a.*;
import java.util.*;
import y.c.*;

public class J
{
    private D c;
    private k d;
    L a;
    M[] b;
    private int[] e;
    private int[] f;
    private d[] g;
    private h h;
    
    public J(final D c) {
        this.h = null;
        this.c = c;
        final int n = 2 * this.c.g().e();
        this.d = new k(c);
        this.e = new int[2 * this.c.g().g()];
        this.f = new int[n];
        this.g = new d[n];
        this.a = new L(n);
        this.b = new M[n];
    }
    
    public void a(final f f) {
        final boolean d = N.d;
        final i i = new i(this.c, f);
        i.a();
        final e a = f.a();
        while (a.f()) {
            final d a2 = a.a();
            this.d.a(this.a(a2, (short)1, i, null), a2);
            if (d) {
                return;
            }
            if (o.b(this) && !this.c.n()) {
                throw new RuntimeException("Combinatorial Embedder failed !");
            }
            a.g();
            if (d) {
                break;
            }
        }
        i.b();
        i.e();
    }
    
    public int b(final f f) {
        final boolean d = N.d;
        int n = 0;
        final i i = new i(this.c, f);
        i.a();
        final e a = f.a();
        while (a.f()) {
            final f a2 = this.a(a.a(), (short)0, i, null);
            if (d) {
                return n;
            }
            if (a2 != null) {
                n += a2.size();
            }
            a.g();
            if (d) {
                break;
            }
        }
        i.b();
        i.e();
        return n;
    }
    
    protected f a(final d d, final short n, final i i, final d[] array) {
        final boolean d2 = N.d;
        final y.c.i g = i.g();
        final q d3 = g.d();
        final q d4 = g.d();
        e e = d.c().l();
        while (true) {
        Label_0202_Outer:
            while (e.f()) {
                g.a(d3, i.a(this.c.i(e.a())));
                e.g();
                if (d2) {
                Label_0238_Outer:
                    while (true) {
                    Label_0238:
                        while (true) {
                            while (e.f()) {
                                g.a(i.a(this.c.i(e.a())), d4);
                                e.g();
                                if (!d2) {
                                    if (d2) {
                                        break;
                                    }
                                    continue Label_0202_Outer;
                                }
                                else {
                                    Label_0282: {
                                        while (this.e.length < g.g()) {
                                            this.e = new int[2 * this.e.length];
                                            if (d2) {
                                                break Label_0282;
                                            }
                                            if (d2) {
                                                break;
                                            }
                                        }
                                        while (this.f.length < g.e()) {
                                            this.f = new int[2 * this.f.length];
                                            if (d2) {
                                                break Label_0282;
                                            }
                                            if (d2) {
                                                break;
                                            }
                                        }
                                        Arrays.fill(this.e, 1);
                                    }
                                    Label_0427: {
                                        if (this.h != null) {
                                            final e p4 = this.c.g().p();
                                            while (p4.f()) {
                                                final d a = p4.a();
                                                this.e[i.b(a).b()] = this.a(a);
                                                p4.g();
                                                if (d2) {
                                                    break Label_0427;
                                                }
                                                if (d2) {
                                                    break;
                                                }
                                            }
                                        }
                                        if (array != null) {
                                            int j = 0;
                                            while (j < array.length) {
                                                this.e[array[j].b()] = 0;
                                                ++j;
                                                if (d2) {
                                                    break Label_0427;
                                                }
                                                if (d2) {
                                                    break;
                                                }
                                            }
                                        }
                                        this.a(g, d3, d4, true, this.e, this.f, this.g);
                                    }
                                    f a2 = v.a(d3, d4, this.g);
                                    if (this.f[d4.d()] == Integer.MAX_VALUE) {
                                        a2 = null;
                                    }
                                    if (a2 == null && o.b(this)) {
                                        final A t = g.t();
                                        y.a.h.a(g, t);
                                        final boolean b = t.a(d3) == t.a(d4);
                                        g.a(t);
                                        if (b) {
                                            throw new RuntimeException("Error computing shortest dual path");
                                        }
                                    }
                                    if (a2 != null) {
                                        a2.d();
                                        a2.remove(a2.i());
                                    }
                                    g.a(d3);
                                    g.a(d4);
                                    switch (n) {
                                        case 0: {
                                            return a2;
                                        }
                                        case 1: {
                                            return this.a(i, a2);
                                        }
                                        default: {
                                            throw new RuntimeException("Unknown return type style in EdgeRouter.routeEdge()");
                                        }
                                    }
                                }
                            }
                            while (this.g.length < g.e()) {
                                this.g = new d[2 * this.g.length];
                                if (d2) {
                                    continue Label_0238;
                                }
                                if (d2) {
                                    break;
                                }
                            }
                            break;
                        }
                        continue Label_0238_Outer;
                    }
                }
                if (d2) {
                    break;
                }
            }
            e = d.d().l();
            continue;
        }
    }
    
    private int a(final d d) {
        if (this.c.n(d)) {
            return this.h.a(this.c.h(d));
        }
        return this.h.a(d);
    }
    
    private f a(final i i, final f f) {
        final boolean d = N.d;
        final f f2 = new f();
        if (f == null) {
            return null;
        }
        if (f.isEmpty()) {
            return f2;
        }
        final e a = f.a();
        a.j();
        f f3 = null;
        while (a.f()) {
            final d a2 = i.a(a.a());
            f3 = f2;
            if (d) {
                return f3;
            }
            f3.a(a2);
            a.h();
            if (d) {
                break;
            }
        }
        return f3;
    }
    
    public void a(final int n, final f f) {
        final boolean d = N.d;
        int i = 0;
        int n2 = 0;
        int n3 = 0;
        final i j = new i(this.c);
        j.a();
    Label_0031:
        while (true) {
        Label_0479:
            while (i == 0) {
                final f f2 = new f(f.a());
                if (d) {
                    if (n3 == 0) {
                        o.a(this, 0, "  no improvement gained by rerouting edges");
                        if (!d) {
                            return;
                        }
                    }
                    o.a(this, 0, "  improvement: " + n3 + " crossing(s) less");
                    return;
                }
                f2.a();
            Label_0139_Outer:
                while (true) {
                    e c = null;
                    final e e = c;
                    while (true) {
                        while (e.f()) {
                            final d a = e.a();
                            final int k = this.c.c(a).k();
                            final int n5;
                            final int n4 = n5 = 1;
                            if (!d) {
                                if (k == n4) {
                                    f2.remove(a);
                                }
                                e.g();
                                if (d) {
                                    break;
                                }
                                continue Label_0139_Outer;
                            }
                            else {
                                if (k != n5 && n2 >= n) {
                                    break Label_0479;
                                }
                                ++n2;
                                f2.sort(new K(this));
                                final e a2 = f2.a();
                            Label_0174:
                                while (a2.f()) {
                                    final d a3 = a2.a();
                                    final d[] array = new d[2 * this.c.c(a3).k()];
                                    int n6 = 0;
                                    c = this.c.c(a3);
                                    if (d) {
                                        continue Label_0139_Outer;
                                    }
                                    final e e2 = c;
                                    while (e2.f()) {
                                        final d b = j.b(e2.a());
                                        array[n6++] = b;
                                        array[n6++] = j.h(b);
                                        e2.g();
                                        if (d) {
                                            continue Label_0174;
                                        }
                                        if (d) {
                                            break;
                                        }
                                    }
                                    final f a4 = this.a(a3, (short)0, j, array);
                                    int n7 = 0;
                                    int n8 = 0;
                                    Label_0394: {
                                        if (a4.size() != 0) {
                                            final e a5 = a4.a();
                                            while (a5.f()) {
                                                n8 = this.e[a5.a().b()];
                                                if (d) {
                                                    break Label_0394;
                                                }
                                                if (n8 > 0) {
                                                    ++n7;
                                                }
                                                a5.g();
                                                if (d) {
                                                    break;
                                                }
                                            }
                                        }
                                        final int n9 = this.c.c(a3).k() - 1;
                                    }
                                    final int n10 = n8;
                                    if (n10 > n7) {
                                        n3 += n10 - n7;
                                        this.b(a3);
                                        this.d.a(this.a(a3, (short)1, j, null), a3);
                                        if (!d) {
                                            continue Label_0031;
                                        }
                                    }
                                    a2.g();
                                    if (d) {
                                        break;
                                    }
                                }
                                break Label_0139_Outer;
                            }
                        }
                        if (f2.size() == 0) {
                            break Label_0479;
                        }
                        int n5 = -1;
                        continue;
                    }
                }
                i = 1;
                if (d) {
                    break;
                }
            }
            j.b();
            j.e();
            continue;
        }
    }
    
    private void b(final d d) {
        final boolean d2 = N.d;
        final y y = new y();
        final e c = this.c.c(d);
        while (c.f()) {
            final d a = c.a();
            if (a.d() != d.d()) {
                y.add(a.d());
            }
            this.c.a(a);
            c.g();
            if (d2) {
                break;
            }
        }
        final x a2 = y.a();
        while (a2.f()) {
            this.c.h(a2.e());
            a2.g();
            if (d2) {
                break;
            }
        }
    }
    
    public void a(final y.c.i i, final q q, final q q2, final boolean b, final int[] array, final int[] array2, final d[] array3) {
        final boolean d = N.d;
        final int e = i.e();
        while (this.b.length < e) {
            this.b = new M[2 * this.b.length];
            if (d) {
                break;
            }
        }
        int j = 0;
        while (true) {
            while (j < e) {
                array3[j] = null;
                array2[j] = Integer.MAX_VALUE;
                ++j;
                if (d) {
                    this.b[j] = this.a.a(0, q, this.b[j], j);
                Label_0327:
                    while (!this.a.c()) {
                        final M b2 = this.a.b();
                        this.a.a(b2);
                        final q b3 = b2.b;
                        if (b3 == q2) {
                            break;
                        }
                        final int n = array2[b2.c];
                        b3.f();
                    Label_0183:
                        while (true) {
                            d d2 = null;
                            d g = d2;
                            while (g != null) {
                                final q d3 = g.d();
                                final int d4 = d3.d();
                                final int n2 = n + array[g.b()];
                                d2 = array3[d4];
                                if (d) {
                                    continue Label_0183;
                                }
                                Label_0315: {
                                    Label_0308: {
                                        if (d2 == null && d3 != q) {
                                            array2[d4] = n2;
                                            this.b[d4] = this.a.a(n2, d3, this.b[d4], d4);
                                            if (!d) {
                                                break Label_0308;
                                            }
                                        }
                                        if (n2 >= array2[d4]) {
                                            break Label_0315;
                                        }
                                        array2[d4] = n2;
                                        this.a.a(this.b[d4], n2);
                                    }
                                    array3[d4] = g;
                                }
                                g = g.g();
                                if (d) {
                                    break Label_0327;
                                }
                            }
                            break;
                        }
                    }
                    return;
                }
                if (d) {
                    break;
                }
            }
            j = q.d();
            array2[j] = 0;
            this.a.a();
            continue;
        }
    }
    
    static D a(final J j) {
        return j.c;
    }
}
