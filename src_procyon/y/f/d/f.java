package y.f.d;

import y.f.*;
import y.c.*;
import java.util.*;

public class f extends i
{
    private A q;
    
    private y e(final r[] array) {
        final int i = y.f.d.a.f;
        this.q = this.i.t();
        final x o = this.i.o();
        while (o.f()) {
            this.q.a(o.e(), this.a((Q)this.n.b(o.e())));
            o.g();
            if (i != 0) {
                break;
            }
        }
        final y y = new y();
        final boolean[] array2 = new boolean[array.length];
        final g g = new g(this);
        g.a(new y(this.i.o()));
        final boolean[] array3 = new boolean[this.i.f()];
        do {
            Label_0138: {
                g.a();
            }
            boolean b = false;
            Label_0145:
            while (!b) {
                final q b2 = g.b();
                if (i == 0) {
                    if (!array2[this.p.a(b2)]) {
                        y.add(b2);
                        array2[this.p.a(b2)] = true;
                        final e j = b2.j();
                        while (j.f()) {
                            final d a = j.a();
                            final q a2 = a.a(b2);
                            b = array3[a2.d()];
                            if (i != 0) {
                                continue Label_0145;
                            }
                            Label_0343: {
                                if (!b && !array2[this.p.a(a2)]) {
                                    final double n = this.q.c(a2) - this.g.c(a) * this.f();
                                    if (n < -100.0) {
                                        g.b(a2);
                                        array3[a2.d()] = true;
                                        if (i == 0) {
                                            break Label_0343;
                                        }
                                    }
                                    g.a(a2, n);
                                }
                            }
                            j.g();
                            if (i != 0) {
                                break;
                            }
                        }
                    }
                    array3[b2.d()] = true;
                    continue Label_0138;
                }
                return y;
            }
            break;
        } while (i == 0);
        this.i.a(this.q);
        return y;
    }
    
    y a(final r[] array) {
        final int f = y.f.d.a.f;
        if (this.c() != 4) {
            return this.e(array);
        }
        this.q = this.e();
        final y y = new y(this.i.o());
        y.sort(new h(this, array));
        final y y2 = new y();
        final boolean[] array2 = new boolean[array.length];
        final boolean[] array3 = new boolean[this.i.f()];
        final x a = y.a();
        while (a.f()) {
            final q e = a.e();
            Label_0210: {
                if (!array3[e.d()] && !array2[this.p.a(e)]) {
                    y2.add(e);
                    array2[this.p.a(e)] = true;
                    final x m = e.m();
                    while (m.f()) {
                        array3[m.e().d()] = true;
                        m.g();
                        if (f != 0) {
                            break Label_0210;
                        }
                        if (f != 0) {
                            break;
                        }
                    }
                }
                a.g();
            }
            if (f != 0) {
                break;
            }
        }
        return y2;
    }
    
    static A a(final f f) {
        return f.q;
    }
}
