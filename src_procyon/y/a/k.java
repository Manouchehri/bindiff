package y.a;

import y.g.a.*;
import y.g.*;
import y.c.*;

public class k
{
    public static y[] a(final i i) {
        final boolean a = h.a;
        final D d = new D();
        final I j = new I(i);
    Label_0097_Outer:
        while (!i.i()) {
            final y b = b(i);
            d.add(b);
            final D d2;
            final y y = (y)(d2 = b);
            if (!a) {
                final x a2 = y.a();
                while (true) {
                    while (a2.f()) {
                        j.a(a2.e().j());
                        a2.g();
                        if (!a) {
                            if (a) {
                                break;
                            }
                            continue Label_0097_Outer;
                        }
                        else {
                            if (a) {
                                break Label_0097_Outer;
                            }
                            continue Label_0097_Outer;
                        }
                    }
                    j.a(b);
                    continue;
                }
            }
            return (y[])d2.toArray(new y[d.size()]);
        }
        j.f();
        D d2 = d;
        return (y[])d2.toArray(new y[d.size()]);
    }
    
    public static y b(final i i) {
        final boolean a = h.a;
        final y y = new y();
        final d d = new d(i);
        final x o = i.o();
        while (o.f()) {
            final q e = o.e();
            d.a(e, e.a());
            o.g();
            if (a) {
                break;
            }
        }
        final A a2 = M.a(new boolean[i.f()]);
    Label_0300:
        while (true) {
            d.a();
            boolean d2 = false;
        Label_0238_Outer:
            while (!d2) {
                final q c = d.c();
                y.add(c);
                a2.a(c, true);
                x x = c.m();
                while (true) {
                    do {
                        Label_0112: {
                            x.f();
                        }
                        boolean d3 = false;
                        Label_0119:
                        while (d3) {
                            final q e2 = x.e();
                            final boolean d4 = a2.d(e2);
                            if (!a) {
                                if (!d4) {
                                    final x m = e2.m();
                                    while (m.f()) {
                                        final q e3 = m.e();
                                        d3 = a2.d(e3);
                                        if (a) {
                                            continue Label_0119;
                                        }
                                        if (!d3) {
                                            d.b(e3, d.b(e3) - 1);
                                        }
                                        m.g();
                                        if (a) {
                                            break;
                                        }
                                    }
                                }
                                x.g();
                                continue Label_0112;
                            }
                            while (true) {
                                if (!d4) {
                                    continue Label_0300;
                                }
                                final q e4 = x.e();
                                d2 = a2.d(e4);
                                if (a) {
                                    continue Label_0238_Outer;
                                }
                                if (!d2) {
                                    d.c(e4);
                                    a2.a(e4, true);
                                }
                                x.g();
                                if (a) {
                                    break Label_0300;
                                }
                                x.f();
                                continue Label_0238_Outer;
                            }
                        }
                        break;
                    } while (!a);
                    x = c.m();
                    continue;
                }
            }
            break;
        }
        return y;
    }
}
