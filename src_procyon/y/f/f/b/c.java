package y.f.f.b;

import y.f.h.*;
import y.c.*;

public class c
{
    private static final int a;
    private static final int b;
    private static final int c;
    private static final int d;
    private static final String[] e;
    private f f;
    private D g;
    private h h;
    private i i;
    
    public c() {
        this.f = new f();
    }
    
    public void a(final i i) {
        final int a = y.f.f.b.h.a;
        final e p = i.p();
        while (p.f()) {
            if (p.a().e()) {
                this.f.c(p.a());
                i.d(p.a());
            }
            p.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    public void a(final h h) {
        this.h = h;
        this.g = (D)this.h.b();
        this.i = this.g.g();
    }
    
    private o a(final q q) {
        final int[][] i = this.h.i(q);
        final int[] h = this.h.h(q);
        final int n = i[y.f.f.b.c.a][0] + i[y.f.f.b.c.b][2];
        final int n2 = h[y.f.f.b.c.a] + h[y.f.f.b.c.b];
        final int n3 = i[y.f.f.b.c.b][0] + i[y.f.f.b.c.c][2];
        final int n4 = h[y.f.f.b.c.b] + h[y.f.f.b.c.c];
        final int n5 = i[y.f.f.b.c.c][0] + i[y.f.f.b.c.d][2];
        final int n6 = h[y.f.f.b.c.c] + h[y.f.f.b.c.d];
        final int n7 = i[y.f.f.b.c.d][0] + i[y.f.f.b.c.a][2];
        final int n8 = h[y.f.f.b.c.d] + h[y.f.f.b.c.a];
        int n9 = n;
        int n10 = n2;
        int n11 = y.f.f.b.c.a;
        if (n3 < n9 || (n3 == n9 && n4 < n10)) {
            n9 = n3;
            n10 = n4;
            n11 = y.f.f.b.c.b;
        }
        if (n5 < n9 || (n5 == n9 && n6 < n10)) {
            n9 = n5;
            n10 = n6;
            n11 = y.f.f.b.c.c;
        }
        if (n7 < n9 || (n7 == n9 && n8 < n10)) {
            n11 = y.f.f.b.c.d;
        }
        return o.a(n11);
    }
    
    private void a(final q q, final o o, final f f) {
        final int a = y.f.f.b.h.a;
        if (f == null || f.size() == 0) {
            return;
        }
        d a2 = null;
        final e l = q.l();
        while (l.f()) {
            if (this.h.d(l.a()) > 0) {
                a2 = l.a();
                break;
            }
            l.g();
        }
        d d = null;
        d a3 = null;
        Label_0202: {
            if (a2 != null) {
                d = null;
                final o h = this.h.h(a2);
                e e = q.a(a2);
                int i = 0;
                while (true) {
                    while (i < e.k()) {
                        final d a4 = e.a();
                        if (a != 0) {
                            a3 = e.a();
                            break Label_0202;
                        }
                        if (this.a(h, this.h.h(a4), o)) {
                            break;
                        }
                        d = a4;
                        e.b();
                        ++i;
                        if (a != 0) {
                            break;
                        }
                    }
                    e = q.a(d);
                    e.b();
                    continue;
                }
            }
        }
        final d d2 = f.d();
        this.i.e(d2);
        d d3 = null;
        Label_0409: {
            if (a2 == null) {
                d3 = this.g.g(d2);
                this.h.a(d2, y.f.f.b.c.e[o.f()]);
                this.h.f(d2);
                this.h.a(d2, 3);
                this.h.a(d3, 1);
                this.g.l();
                this.g.b(this.g.h().a());
                if (a == 0) {
                    break Label_0409;
                }
            }
            this.g.a(a3, d2);
            d3 = this.h.a(d2);
            this.h.a(d2, y.f.f.b.c.e[o.f()]);
            this.h.f(d2);
            this.h.a(d2, this.a(d, d2));
            this.h.a(d3, 1);
            this.h.a(a3, this.a(d3, a3));
            this.g.k();
        }
        d d4 = d3;
        final e a5 = f.a();
        while (a5.f()) {
            final d a6 = a5.a();
            this.i.e(a6);
            this.g.a(d4, a6);
            final d a7 = this.h.a(a6);
            this.h.a(a6, y.f.f.b.c.e[o.f()]);
            this.h.f(a6);
            this.h.a(a6, 0);
            this.h.a(a7, 1);
            this.h.a(d4, 0);
            this.g.k();
            d4 = a7;
            a5.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private boolean a(final o o, final o o2, final o o3) {
        final String s = "^>_<^>_<";
        final int index = s.indexOf(o.toString());
        return s.indexOf(o2.toString(), index) > s.indexOf(o3.toString(), index);
    }
    
    private int a(final d d, final d d2) {
        final String s = "^>_<^>_<";
        final char char1 = this.h.e(d).charAt(0);
        final char char2 = this.h.e(d2).charAt(0);
        final int index = s.indexOf(char1);
        return s.indexOf(char2, index) - index;
    }
    
    public void a() {
        final int a = y.f.f.b.h.a;
        final f[] array = new f[this.i.f()];
        final e a2 = this.f.a();
        while (a2.f()) {
            final d a3 = a2.a();
            final int d = a3.c().d();
            if (array[d] == null) {
                array[d] = new f();
            }
            array[d].add(a3);
            a2.g();
            if (a != 0) {
                break;
            }
        }
        final x o = this.i.o();
        while (o.f()) {
            final q e = o.e();
            if (array[e.d()] != null) {
                this.a(e, this.a(e), array[e.d()]);
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    static {
        a = o.a.f();
        b = o.b.f();
        c = o.c.f();
        d = o.d.f();
        (e = new String[4])[y.f.f.b.c.a] = "^>_<";
        y.f.f.b.c.e[y.f.f.b.c.b] = ">_<^";
        y.f.f.b.c.e[y.f.f.b.c.c] = "_<^>";
        y.f.f.b.c.e[y.f.f.b.c.d] = "<^>_";
    }
}
