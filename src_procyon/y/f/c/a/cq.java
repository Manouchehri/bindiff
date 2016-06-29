package y.f.c.a;

import y.f.*;
import y.d.*;
import y.c.*;

final class cq
{
    public void a(final X x, final aU au, final aV av, final aP ap) {
        final boolean x2 = N.x;
        final d[] n = x.n();
        int i = 0;
        while (i < n.length) {
            final d d = n[i];
            if (av.a(d.d()).j() - av.a(d.c()).j() > 1) {
                this.a(x, d, au, av, ap, false);
            }
            ++i;
            if (x2) {
                break;
            }
        }
    }
    
    public void a(final X x, final aV av) {
        final boolean x2 = N.x;
        x x3 = x.o();
        while (true) {
            while (x3.f()) {
                q e = x3.e();
                final aX a = av.a(e);
                final byte b = a.b();
                final boolean b2 = true;
                if (x2) {
                    while (true) {
                        if (b == (b2 ? 1 : 0)) {
                            x.a(x3.e());
                        }
                        x3.g();
                        if (!x2) {
                            if (x3.f()) {
                                av.a(x3.e()).b();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                Label_0304: {
                    if (b == (b2 ? 1 : 0) && !x.f(a.g())) {
                        q q = e.g().c();
                        while (true) {
                            while (av.a(q).b() == 1) {
                                e = q;
                                q = e.g().c();
                                if (x2) {
                                    d d = e.g();
                                    final D d2 = new D();
                                    while (true) {
                                        while (av.a(d.d()).b() == 1) {
                                            final t p2 = x.p(d);
                                            d2.add(p2);
                                            d2.a(x.k(d));
                                            final t t = x.q(d);
                                            final boolean equals = t.equals(p2);
                                            if (x2) {
                                                if (!equals) {
                                                    d2.add(t);
                                                }
                                                x.a(a.g(), d2);
                                                break Label_0304;
                                            }
                                            if (!equals) {
                                                d2.add(t);
                                            }
                                            d = d.d().f();
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        final t p3 = x.p(d);
                                        d2.add(p3);
                                        d2.a(x.k(d));
                                        final t t = x.q(d);
                                        t.equals(p3);
                                        continue;
                                    }
                                }
                                if (x2) {
                                    break;
                                }
                            }
                            x.e(a.g());
                            continue;
                        }
                    }
                }
                x3.g();
                if (x2) {
                    break;
                }
            }
            x3 = x.o();
            continue;
        }
    }
    
    public f a(final X x, final d d, final aU au, final aV av, final aP ap, final boolean b) {
        final boolean x2 = N.x;
        final aX a = av.a(d.c());
        final aX a2 = av.a(d.d());
        final A a3 = av.a(d);
        if (a.j() + 1 >= a2.j()) {
            return null;
        }
        f f = null;
        if (b) {
            f = new f();
        }
        final c c = x.c("com.yworks.yfiles.bpmn.layout.BpmnLayouter.ASSIGN_DUMMIES_TO_SOURCE_LANE");
        q c2 = d.c();
        int i = a.j() + 1;
        while (i < a2.j()) {
            q q = null;
            Label_0250: {
                if (c != null) {
                    if (c.d(d)) {
                        q = ap.a(au.a(i), d, a3.i() ? a2.h() : a.h());
                        if (!x2) {
                            break Label_0250;
                        }
                    }
                    q = ap.a(au.a(i), d, a3.i() ? a.h() : a2.h());
                    if (!x2) {
                        break Label_0250;
                    }
                }
                q = ap.a(au.a(i), d);
            }
            final d a4 = ap.a(c2, q, d, c2 == d.c(), false);
            if (f != null) {
                f.b(a4);
            }
            c2 = q;
            ++i;
            if (x2) {
                break;
            }
        }
        final d a5 = ap.a(c2, d.d(), d, false, true);
        if (f != null) {
            f.b(a5);
        }
        if (x.f(d)) {
            x.d(d);
        }
        return f;
    }
}
