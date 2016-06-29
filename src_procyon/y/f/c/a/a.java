package y.f.c.a;

import java.util.*;
import y.c.*;
import y.f.*;

public abstract class a implements br
{
    private byte a;
    private int b;
    
    protected a() {
        this.a = 0;
        this.b = 4;
        this.a = 0;
        this.b = 4;
    }
    
    public int a() {
        return this.b;
    }
    
    public void a(final int b) {
        this.b = b;
    }
    
    public void a(final byte a) {
        this.a = a;
    }
    
    public byte b() {
        return this.a;
    }
    
    public void optimizeAfterSequencing(final X x, final aU au, final aV av, final aP ap) {
        final b a = this.a(x, au, av, ap);
        final Comparator[] a2 = this.a(a, x, au, av);
        this.a(a2[0], a2[1], x, au, av, ap);
        this.a(a, x, av, ap);
    }
    
    protected void a(final Comparator comparator, final Comparator comparator2, final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        int n = 0;
        do {
            int i = 0;
            Label_0008: {
                i = n;
            }
            Label_0010:
            while (i < au.b()) {
                p p6 = au.a(n).d().k();
                while (p6 != null) {
                    final q q = (q)p6.c();
                    final byte b = (byte)(i = av.a(q).b());
                    if (x2) {
                        continue Label_0010;
                    }
                    if (b == 0) {
                        this.a(q, comparator, comparator2, x, av, ap);
                    }
                    p6 = p6.a();
                    if (x2) {
                        break;
                    }
                }
                ++n;
                continue Label_0008;
            }
            break;
        } while (!x2);
    }
    
    protected abstract void a(final q p0, final Comparator p1, final Comparator p2, final X p3, final aV p4, final aP p5);
    
    protected b a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        final b b = new b();
        int n = 0;
        do {
            int i = 0;
        Label_0019:
            while (i < au.b()) {
                p p4 = au.a(n).d().k();
                while (p4 != null) {
                    final q q = (q)p4.c();
                    final aX a = av.a(q);
                    i = a.e();
                    if (x2) {
                        continue Label_0019;
                    }
                    if (i > 0) {
                        p p5 = a.d();
                        while (p5 != null) {
                            final d d = (d)p5.c();
                            final boolean equals = d.c().equals(q);
                            if (x2) {
                                continue Label_0019;
                            }
                            Label_0244: {
                                if (equals) {
                                    final q d2 = x.d();
                                    b.a(d2, d);
                                    if (av.a(d).j()) {
                                        ap.b(d2, q, d, false, true);
                                        ap.a(d2, d.d(), d, false, true);
                                        if (!x2) {
                                            break Label_0244;
                                        }
                                    }
                                    ap.a(q, d2, d, true, false);
                                    ap.b(d.d(), d2, d, true, false);
                                }
                            }
                            p5 = p5.a();
                            if (x2) {
                                break;
                            }
                        }
                    }
                    p4 = p4.a();
                    if (x2) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!x2);
        return b;
    }
    
    protected void a(final b b, final X x, final aV av, final aP ap) {
        final boolean x2 = N.x;
        x x3 = b.a().a();
        while (true) {
            while (x3.f()) {
                final q e = x3.e();
                final d a = b.a(e);
                x.e(a);
                final A a2 = av.a(a);
                final int c = e.c();
                if (x2) {
                    while (true) {
                        if (c != 0) {
                            x.a(x3.e());
                            x3.g();
                            if (!x2) {
                                x3.f();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                Label_0555: {
                    if (c > 0) {
                        final d f = e.f();
                        final d h = e.h();
                        final A a3 = av.a(f);
                        final A a4 = av.a(h);
                        if (f.d() == a.c()) {
                            if (a3.e() != a2.c()) {
                                ap.a(a, true, a3.e());
                            }
                            if (a4.e() != a2.e()) {
                                ap.a(a, false, a4.e());
                            }
                            x.a(a, x.o(f));
                            x.b(a, x.o(h));
                            if (!x2) {
                                break Label_0555;
                            }
                        }
                        if (a4.e() != a2.c()) {
                            ap.a(a, true, a4.e());
                        }
                        if (a3.e() != a2.e()) {
                            ap.a(a, false, a3.e());
                        }
                        x.a(a, x.o(h));
                        x.b(a, x.o(f));
                        if (!x2) {
                            break Label_0555;
                        }
                    }
                    final d g = e.g();
                    final d i = e.i();
                    final A a5 = av.a(g);
                    final A a6 = av.a(i);
                    if (g.c() == a.c()) {
                        if (a5.c() != a2.c()) {
                            ap.a(a, true, a5.c());
                        }
                        if (a6.c() != a2.e()) {
                            ap.a(a, false, a6.c());
                        }
                        x.a(a, x.n(g));
                        x.b(a, x.n(i));
                        if (!x2) {
                            break Label_0555;
                        }
                    }
                    if (a6.c() != a2.c()) {
                        ap.a(a, true, a6.c());
                    }
                    if (a5.c() != a2.e()) {
                        ap.a(a, false, a5.c());
                    }
                    x.a(a, x.n(i));
                    x.b(a, x.n(g));
                }
                x.d(a);
                x3.g();
                if (x2) {
                    break;
                }
            }
            x3 = b.a().a();
            continue;
        }
    }
    
    private Comparator[] a(final b b, final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final int[] array = new int[x.e()];
        final cF a = cF.a(x, au, av, array, new int[x.e()], new byte[x.g()], new int[x.g()], new byte[x.g()], new int[x.g()], (byte)1, (byte)0);
        final x a2 = b.a().a();
        while (a2.f()) {
            array[a2.e().d()] = -1;
            a2.g();
            if (x2) {
                break;
            }
        }
        final Comparator c = a.c(true);
        if (c instanceof cH) {
            final cH ch = (cH)c;
            ch.a(new c(x.c(ax.b), ch.a(), this.a, this.b));
        }
        final Comparator c2 = a.c(false);
        if (c2 instanceof cS) {
            final cS cs = (cS)c2;
            cs.a(new c(x.c(ax.a), cs.a(), this.a, this.b));
        }
        return new Comparator[] { c2, c };
    }
}
