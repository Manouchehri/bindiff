package y.f.h;

import y.c.*;
import java.util.*;

public class s implements x
{
    protected u a;
    protected v b;
    protected w c;
    protected D d;
    protected i e;
    protected boolean f;
    protected R g;
    protected h h;
    protected d i;
    protected q j;
    protected f k;
    protected q l;
    protected q m;
    private int n;
    private boolean o;
    
    public s() {
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = 50;
        this.f = false;
        this.b = new v();
        this.c = new w();
        this.a = new u();
        this.g = new R();
        this.h = new t(this);
    }
    
    public void a(final boolean o) {
        this.o = o;
    }
    
    public void a(final int n) {
        this.n = n;
    }
    
    public f c_() {
        if (this.f) {
            return this.k;
        }
        throw new RuntimeException("Invalid Execution Order: call 'createPlanarization' first!");
    }
    
    public void a(final D d) {
        this.d = d;
        this.e = d.g();
        if (this.e.f() == 0 || this.e.h() == 0) {
            this.k = new f();
            this.f = true;
            return;
        }
        this.g.a(this.e);
        this.g.a(this.o);
        final int[] array = new int[this.e.e()];
        final z z = new z(this.e, this.h);
        final y a = this.a(array, z);
        z.a(a, array);
        this.k = z.c();
        final A t = this.e.t();
        final A t2 = this.e.t();
        this.a(t, t2, a);
        this.a(new f(z.a().iterator()), new f(z.b().iterator()), t, t2, array);
        this.e.a(t);
        this.e.a(t2);
        d.l();
        if (this.i == null) {
            this.i = this.e.l();
        }
        d.b(d.i(this.i));
        this.f = true;
        this.c();
    }
    
    protected y a(final int[] array, final z z) {
        final boolean d = N.d;
        y y = new y();
        y y2 = null;
        int n = 0;
        Label_0276: {
            if (this.o) {
                int size = Integer.MAX_VALUE;
                int i = 0;
            Label_0124_Outer:
                while (i < this.n) {
                    n = size;
                    if (d) {
                        break Label_0276;
                    }
                    if (n > 0) {
                        this.g.a(y);
                        int n2 = 1;
                        final y.c.x a = y.a();
                        while (true) {
                            while (a.f()) {
                                array[a.e().d()] = n2++;
                                a.g();
                                if (d) {
                                    if (size > this.k.size()) {
                                        size = this.k.size();
                                        y2 = new y();
                                        final y.c.x a2 = y.a();
                                        while (a2.f()) {
                                            y2.b(a2.e());
                                            a2.g();
                                            if (d) {
                                                continue Label_0124_Outer;
                                            }
                                            if (d) {
                                                break;
                                            }
                                        }
                                    }
                                    final e a3 = this.k.a();
                                    while (true) {
                                        while (a3.f()) {
                                            this.e.e(a3.a());
                                            a3.g();
                                            if (!d) {
                                                if (d) {
                                                    break;
                                                }
                                                continue Label_0124_Outer;
                                            }
                                            else {
                                                if (d) {
                                                    break Label_0124_Outer;
                                                }
                                                continue Label_0124_Outer;
                                            }
                                        }
                                        ++i;
                                        continue;
                                    }
                                }
                                if (d) {
                                    break;
                                }
                            }
                            z.a(y, array);
                            this.k = z.c();
                            continue;
                        }
                    }
                    break;
                }
                y = y2;
            }
            else {
                this.g.a(y);
                y2 = y;
            }
        }
        int n3 = n;
        final y.c.x a4 = y2.a();
        while (true) {
            while (a4.f()) {
                array[a4.e().d()] = n3++;
                a4.g();
                if (d) {
                    final y.c.x a5 = y.a();
                    while (a5.f()) {
                        final q e = a5.e();
                        if (e.a() != 0) {
                            this.j = e;
                            if (!d) {
                                break;
                            }
                        }
                        a5.g();
                        if (d) {
                            break;
                        }
                    }
                    return y;
                }
                if (d) {
                    break;
                }
            }
            final y.c.x a6 = y.a();
            a6.i();
            this.l = a6.e();
            a6.j();
            this.m = a6.e();
            continue;
        }
    }
    
    protected void a(final A a, final A a2, final y y) {
        final boolean d = N.d;
        y.c.x x = y.a();
        while (true) {
            while (x.f()) {
                final q e = x.e();
                a.a(e, null);
                a2.a(e, null);
                x.g();
                if (d) {
                    while (x.f()) {
                        final q e2 = x.e();
                        final p d2 = y.d(e2);
                    Label_0100:
                        while (true) {
                            q q = null;
                            final e j = q.j();
                            while (j.f()) {
                                final d a3 = j.a();
                                q = e2;
                                if (d) {
                                    continue Label_0100;
                                }
                                Label_0222: {
                                    if (q != y.f() && a3.a(e2) == y.d(d2).c()) {
                                        a.a(e2, a3);
                                        if (!d) {
                                            break Label_0222;
                                        }
                                    }
                                    if (e2 != y.i() && a3.a(e2) == y.c(d2).c()) {
                                        a2.a(e2, a3);
                                    }
                                }
                                j.g();
                                if (d) {
                                    break;
                                }
                            }
                            break;
                        }
                        x.g();
                        if (d) {
                            break;
                        }
                    }
                    return;
                }
                if (d) {
                    break;
                }
            }
            x = y.a();
            continue;
        }
    }
    
    protected void a(final f f, final A a) {
        final boolean d = N.d;
        final e a2 = f.a();
        while (a2.f()) {
            final d a3 = a2.a();
            final q c = a3.c();
            final q d2 = a3.d();
            Label_0101: {
                if (a.b(c) == null) {
                    final f f2 = new f();
                    f2.add(a3);
                    a.a(c, f2);
                    if (!d) {
                        break Label_0101;
                    }
                }
                ((f)a.b(c)).add(a3);
            }
            Label_0161: {
                if (a.b(d2) == null) {
                    final f f3 = new f();
                    f3.add(a3);
                    a.a(d2, f3);
                    if (!d) {
                        break Label_0161;
                    }
                }
                ((f)a.b(d2)).add(a3);
            }
            a2.g();
            if (d) {
                break;
            }
        }
    }
    
    protected void a(final f f, final f f2, final A a, final A a2, final int[] array) {
        final boolean d = N.d;
        final A t = this.e.t();
        final A t2 = this.e.t();
        this.a(f, t);
        this.a(f2, t2);
        this.b();
        this.b.a(array);
        this.c.a(array);
        final y.c.x o = this.e.o();
        while (o.f()) {
            final q e = o.e();
            final f f3 = new f();
            final f f4 = (f)t.b(e);
            if (d) {
                return;
            }
            if (f4 != null) {
                this.b.a(e);
                f4.sort(this.b);
            }
            final f f5 = (f)t2.b(e);
            if (f5 != null) {
                this.c.a(e);
                f5.sort(this.c);
            }
            final d d2 = (d)a.b(e);
            Label_0231: {
                if (d2 != null) {
                    if (d2.c() == e) {
                        f3.add(d2);
                        if (!d) {
                            break Label_0231;
                        }
                    }
                    f3.add(this.d.h(d2));
                }
            }
        Label_0371:
            while (true) {
                q c = null;
                q q = null;
                if (f4 != null) {
                    final e a3 = f4.a();
                    while (a3.f()) {
                        final d d3 = a3.a();
                        c = d3.c();
                        q = e;
                        if (d) {
                            break Label_0371;
                        }
                        Label_0305: {
                            if (c == q) {
                                f3.add(d3);
                                if (!d) {
                                    break Label_0305;
                                }
                            }
                            f3.add(this.d.h(d3));
                        }
                        if (e == this.j && this.i == null) {
                            this.i = (d)f3.i();
                        }
                        a3.g();
                        if (d) {
                            break;
                        }
                    }
                }
                d d3 = (d)a2.b(e);
                Label_0430: {
                    if (d3 == null) {
                        break Label_0430;
                    }
                    d3.c();
                    Label_0402: {
                        if (c == q) {
                            f3.add(d3);
                            if (!d) {
                                break Label_0402;
                            }
                        }
                        f3.add(this.d.h(d3));
                    }
                    if (e == this.j && this.i == null) {
                        this.i = (d)f3.i();
                    }
                }
                if (f5 != null) {
                    final e a4 = f5.a();
                    while (a4.f()) {
                        d3 = a4.a();
                        final q c2 = d3.c();
                        final q q2 = e;
                        if (d) {
                            continue Label_0371;
                        }
                        Label_0504: {
                            if (c2 == q2) {
                                f3.add(d3);
                                if (!d) {
                                    break Label_0504;
                                }
                            }
                            f3.add(this.d.h(d3));
                        }
                        if (e == this.j && this.i == null) {
                            this.i = (d)f3.i();
                        }
                        a4.g();
                        if (d) {
                            break;
                        }
                    }
                }
                break;
            }
            this.a.a(f3);
            e.b(this.a);
            o.g();
            if (d) {
                break;
            }
        }
        this.e.a(t);
        this.e.a(t2);
    }
    
    protected void b() {
        final boolean d = N.d;
        final e a = new f(this.e.p()).a();
        while (a.f()) {
            this.d.g(a.a());
            a.g();
            if (d) {
                break;
            }
        }
    }
    
    public void c() {
    }
}
