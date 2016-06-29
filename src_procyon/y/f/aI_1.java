package y.f;

import y.d.*;
import y.c.*;

public class aI extends a
{
    private double a;
    private boolean b;
    
    public aI() {
        this.a = 2.0;
    }
    
    public void c(final X x) {
        final boolean j = X.j;
        this.a(x);
        final e p = x.p();
    Label_0133_Outer:
        while (p.f()) {
            final d a = p.a();
            final I g = x.g(a);
            Label_0319: {
                if (g.pointCount() >= 1) {
                    final D d = new D();
                    d.add(x.p(a));
                    int i = 0;
                    while (true) {
                        while (i < g.pointCount()) {
                            d.add(g.getPoint(i));
                            ++i;
                            if (j) {
                                final p k = d.k();
                                t t = (t)k.c();
                                p a2 = k.a();
                                t t2 = (t)a2.c();
                                p a3 = a2.a();
                                while (true) {
                                    while (a3 != null) {
                                        final t t3 = (t)a3.c();
                                        final p a4 = a3.a();
                                        final int a5;
                                        final boolean b = (a5 = (this.a(t, t2, t3) ? 1 : 0)) != 0;
                                        if (!j) {
                                            Label_0273: {
                                                if (b) {
                                                    d.h(a2);
                                                    if (!j) {
                                                        break Label_0273;
                                                    }
                                                }
                                                if (this.a(this.a(t), this.a(t2), this.a(t3))) {
                                                    d.h(a2);
                                                    if (!j) {
                                                        break Label_0273;
                                                    }
                                                }
                                                t = t2;
                                            }
                                            a2 = a3;
                                            t2 = t3;
                                            a3 = a4;
                                            if (j) {
                                                break;
                                            }
                                            continue Label_0133_Outer;
                                        }
                                        else {
                                            if (a5 != d.size()) {
                                                d.g();
                                                d.j();
                                                x.b(a, d);
                                            }
                                            break Label_0319;
                                        }
                                    }
                                    int a5 = i;
                                    continue;
                                }
                            }
                            if (j) {
                                break;
                            }
                        }
                        d.add(x.q(a));
                        i = d.size();
                        continue;
                    }
                }
            }
            p.g();
            if (j) {
                break;
            }
        }
    }
    
    private boolean a(final t t, final t t2, final t t3) {
        return y.d.e.d(t, t2, t3) && (!this.b || this.b(t, t2, t3));
    }
    
    private boolean b(final t t, final t t2, final t t3) {
        return t.a > t2.a == t2.a > t3.a && t.b > t2.b == t2.b > t3.b;
    }
    
    private t a(final t t) {
        final double pow = Math.pow(10.0, this.a);
        return new t(Math.rint(t.a() * pow) / pow, Math.rint(t.b() * pow) / pow);
    }
}
