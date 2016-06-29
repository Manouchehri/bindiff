package y.f.c;

import y.f.*;
import y.d.*;
import y.c.*;
import y.g.*;

public abstract class a implements v
{
    protected double a;
    protected double b;
    protected double c;
    protected double d;
    protected A e;
    protected Object f;
    protected X g;
    protected A h;
    public static boolean i;
    
    public a() {
        this.a = 20.0;
        this.b = 60.0;
        this.c = 5.0;
        this.d = 0.0;
    }
    
    public void a(final double c) {
        this.c = c;
    }
    
    public void b(final double d) {
        this.d = d;
    }
    
    public double a() {
        return this.c;
    }
    
    public double b() {
        return this.d;
    }
    
    public void c(final double a) {
        this.a = a;
    }
    
    public void d(final double b) {
        this.b = b;
    }
    
    public void a(final A e) {
        this.e = e;
    }
    
    public double c() {
        return this.a;
    }
    
    public double d() {
        return this.b;
    }
    
    public void a(final X x, final y[] array) {
        final boolean i = y.f.c.a.i;
        final x[] array2 = new x[array.length];
        int j = 0;
        while (j < array.length) {
            array2[j] = array[j].a();
            ++j;
            if (i) {
                return;
            }
            if (i) {
                break;
            }
        }
        this.a(x, array2);
    }
    
    public void a(final X x, final x[] array) {
        final boolean i = y.f.c.a.i;
        final double[] array2 = new double[array.length];
        double n = 0.0;
        int j = 0;
    Label_0090_Outer:
        while (j < array.length) {
            double max = 0.0;
            final x x2 = array[j];
            x2.i();
            while (true) {
                while (x2.f()) {
                    max = Math.max(max, x.q(x2.e()));
                    x2.g();
                    if (i) {
                        x2.i();
                        while (true) {
                            while (x2.f()) {
                                double n2 = (array2[j] - x.q(x2.e())) / 2.0;
                                x.b(x2.e(), new t(x.m(x2.e()), n + n2));
                                x2.g();
                                if (!i) {
                                    if (i) {
                                        break;
                                    }
                                    continue Label_0090_Outer;
                                }
                                else {
                                    Object o = this.f;
                                Label_0306:
                                    while (o != null) {
                                        final c c = x.c(this.f);
                                        if (c != null) {
                                            x2.i();
                                        Label_0215:
                                            while (x2.f()) {
                                                final e e = (e)(o = x2.e().l());
                                                if (!i) {
                                                    final e e2 = e;
                                                    while (true) {
                                                        while (e2.f()) {
                                                            n2 = Math.max(n2, c.c(e2.a()));
                                                            e2.g();
                                                            if (!i) {
                                                                if (i) {
                                                                    break;
                                                                }
                                                                continue Label_0090_Outer;
                                                            }
                                                            else {
                                                                if (i) {
                                                                    break Label_0306;
                                                                }
                                                                continue Label_0215;
                                                            }
                                                        }
                                                        x2.g();
                                                        continue;
                                                    }
                                                }
                                                continue Label_0306;
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    n += array2[j] + n2;
                                    x2.i();
                                    ++j;
                                    if (i) {
                                        break Label_0090_Outer;
                                    }
                                    continue Label_0090_Outer;
                                }
                            }
                            double n2 = this.d();
                            continue;
                        }
                    }
                    if (i) {
                        break;
                    }
                }
                array2[j] = max;
                continue;
            }
        }
    }
    
    public void a(final X g, final y[] array, final c c) {
        this.g = g;
        this.a(array);
        this.a(array, c);
        this.e();
    }
    
    protected abstract void a(final y[] p0, final c p1);
    
    public double a(final q q) {
        return this.g.m(q) - this.c(q);
    }
    
    public double b(final q q) {
        return this.g.m(q) + this.g.p(q) + this.d(q);
    }
    
    public double c(final q q) {
        if (this.e.b(q) != null) {
            return 0.0;
        }
        final c c = this.g.c(v.j);
        return (c != null) ? c.c(q) : 0.0;
    }
    
    public double d(final q q) {
        if (this.e.b(q) != null) {
            return 0.0;
        }
        final c c = this.g.c(v.e_);
        return (c != null) ? c.c(q) : 0.0;
    }
    
    public double e(final q q) {
        return this.g.p(q) / 2.0 + this.c(q);
    }
    
    public double f(final q q) {
        return this.g.p(q) / 2.0 + this.d(q);
    }
    
    protected void a(final y[] array) {
        final boolean i = y.f.c.a.i;
        final c c = this.g.c(v.e_);
        final c c2 = this.g.c(v.j);
        final c c3 = this.g.c(v.n);
        this.h = M.a(new double[this.g.e()]);
        Label_0170: {
            if (c3 == null) {
                final ax ax = new ax();
                ax.b(this.a());
                ax.a(this.c());
                ax.a(this.g, array, this.e, this.h);
                if (!i) {
                    break Label_0170;
                }
            }
            final x o = this.g.o();
            while (o.f()) {
                final q e = o.e();
                this.h.a(e, c3.c(e));
                o.g();
                if (i) {
                    break;
                }
            }
        }
        int j = 0;
        while (j < array.length) {
            final x a = array[j].a();
            Label_0318: {
                if (a.f()) {
                    q e2 = a.e();
                    a.g();
                    while (a.f()) {
                        final q e3 = a.e();
                        double c4 = this.h.c(e2);
                        if (i) {
                            break Label_0318;
                        }
                        if (c != null) {
                            c4 += c.c(e2);
                        }
                        if (c2 != null) {
                            c4 += c2.c(e3);
                        }
                        this.h.a(e2, c4);
                        e2 = e3;
                        a.g();
                        if (i) {
                            break;
                        }
                    }
                }
                ++j;
            }
            if (i) {
                break;
            }
        }
    }
    
    protected double g(final q q) {
        return this.h.c(q);
    }
    
    protected void e() {
        this.h = null;
    }
}
