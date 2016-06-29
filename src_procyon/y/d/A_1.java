package y.d;

import y.c.*;

class A
{
    public static D a(final D d) {
        final boolean d2 = t.d;
        final D d3 = new D(d.m());
        final D d4 = new D();
        d3.o();
        if (d3.isEmpty()) {
            return d4;
        }
        final t t = (t)d3.g();
        d4.b(t);
        while (true) {
            while (!d3.isEmpty()) {
                final boolean equals = t.equals(d3.f());
                if (!d2) {
                    if (!equals) {
                        break;
                    }
                    d3.g();
                    if (d2) {
                        break;
                    }
                    continue;
                }
                else {
                    if (equals) {
                        return d4;
                    }
                    t t2 = (t)d3.g();
                    p p = d4.b(t2);
                    final C m = d3.m();
                    while (m.f()) {
                        final t t3 = (t)m.d();
                        Label_0343: {
                            Label_0336: {
                                if (!t3.equals(t2)) {
                                    t2 = t3;
                                    if (d4.size() == 2 && e.d((t)d4.f(), (t)d4.i(), t3)) {
                                        p.a(t3);
                                        if (!d2) {
                                            break Label_0336;
                                        }
                                    }
                                    p f = p;
                                    while (!e.c((t)d4.f(f).c(), (t)f.c(), t3)) {
                                        f = d4.f(f);
                                        if (d2) {
                                            break Label_0343;
                                        }
                                        if (d2) {
                                            break;
                                        }
                                    }
                                    p e = p;
                                    while (true) {
                                        while (!y.d.e.b((t)d4.e(e).c(), (t)e.c(), t3)) {
                                            e = d4.e(e);
                                            if (d2) {
                                                p = d4.b(t3, f);
                                                break Label_0336;
                                            }
                                            if (d2) {
                                                break;
                                            }
                                        }
                                        while (e != d4.e(f)) {
                                            d4.h(d4.e(f));
                                            if (d2) {
                                                break Label_0343;
                                            }
                                            if (d2) {
                                                break;
                                            }
                                        }
                                        continue;
                                    }
                                }
                            }
                            m.g();
                        }
                        if (d2) {
                            break;
                        }
                    }
                    return d4;
                }
            }
            d3.isEmpty();
            continue;
        }
    }
}
