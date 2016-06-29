package y.f.f.a.b;

import y.f.f.a.a.*;
import y.c.*;

public class z
{
    public static void a(final a a, final h h, final h h2) {
        final boolean c = a.c;
        final i d = a.d();
        final p b = a.b();
        final d[] n = d.n();
        int i = 0;
        while (i < n.length) {
            boolean b2 = false;
            final d d2 = n[i];
            q q = d2.c();
            q q2 = d2.d();
            final b a2 = b.a(q);
            final b a3 = b.a(q2);
            if (!a2.d()) {
                q = ((b)y.f.f.a.a.n.a(a2)).b_();
                b2 = true;
            }
            if (!a3.d()) {
                q2 = ((b)y.f.f.a.a.n.a(a3)).b_();
                b2 = true;
            }
            if (b2) {
                final d a4 = d.a(q, q2);
                a.q(a4);
                a.d(d2, a4);
                if (h != null) {
                    h.a(a4, h.b(d2));
                }
                if (h2 != null) {
                    h2.a(a4, h2.b(d2));
                }
                d.d(d2);
            }
            ++i;
            if (c) {
                break;
            }
        }
    }
    
    public static void a(final a a, final f f) {
        final boolean c = a.c;
        final y.c.e a2 = f.a();
        while (a2.f()) {
            final d a3 = a2.a();
            final f x = a.x(a3);
            Label_0159: {
                if (x != null) {
                    final d d = (d)x.i();
                    final d w = a.w(d);
                    if (w != null) {
                        a(a, a.d(w), d.c(), d.d());
                    }
                    final d d2 = (d)x.f();
                    final d w2 = a.w(d2);
                    if (w2 == null) {
                        break Label_0159;
                    }
                    a(a, a.d(w2), d2.c(), d2.d());
                    if (!c) {
                        break Label_0159;
                    }
                }
                final d w3 = a.w(a3);
                if (w3 != null) {
                    a(a, a.d(w3), a3.c(), a3.d());
                }
            }
            a2.g();
            if (c) {
                break;
            }
        }
    }
    
    private static void a(final a a, final f f, final q q, final q q2) {
        final boolean c = a.c;
        final y.c.e a2 = f.a();
    Label_0104:
        while (true) {
            while (true) {
                while (a2.f()) {
                    final q c2 = a2.a().c();
                    final q q3 = q;
                    if (c) {
                        if (c2 != q3) {
                            a2.g();
                            if (!c) {
                                break;
                            }
                        }
                        final y.c.e e;
                        if (e.f()) {
                            a.o(a2.a());
                            a2.g();
                            if (!c) {
                                continue Label_0104;
                            }
                        }
                        return;
                    }
                    if (c2 == q) {
                        break;
                    }
                    a.o(a2.a());
                    a2.g();
                    if (c) {
                        break;
                    }
                }
                if (!a2.f()) {
                    continue Label_0104;
                }
                final y.c.e e = a2;
                if (!c) {
                    e.a().c();
                    final q q3 = q2;
                    continue;
                }
                break;
            }
            continue Label_0104;
        }
    }
}
