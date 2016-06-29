package y.a;

import y.c.*;

public class q
{
    public static f a(final i i, final y.c.q q, final y.c.q q2, final boolean b) {
        final boolean a = h.a;
        final f f = new f();
        final A t = i.t();
        final r r = new r(t);
        r.a(b);
        r.b(false);
        r.a(i, q);
        final d d = (d)t.b(q2);
        if (d != null) {
            f.c(d);
            y.c.q q3 = d.a(q2);
            while (t.b(q3) != null) {
                final d d2 = (d)t.b(q3);
                if (d2 != null) {
                    q3 = d2.a(q3);
                    f.c(d2);
                    if (a) {
                        return f;
                    }
                    if (a) {
                        break;
                    }
                    continue;
                }
            }
            if (q3 != q) {
                f.clear();
            }
        }
        i.a(t);
        return f;
    }
    
    public static f a(final i i) {
        final boolean a = h.a;
        final t[] array = new t[i.f()];
        int j = 0;
        while (j < array.length) {
            array[j] = new t(null);
            ++j;
            if (a) {
                break;
            }
        }
        final s s = new s(array);
        s.a(false);
        s.a(i);
        int n = -1;
        y.c.q q = null;
        final x o = i.o();
        while (o.f()) {
            final y.c.q e = o.e();
            final t t = array[e.d()];
            if (t.c + t.d > n) {
                n = t.c + t.d;
                q = e;
            }
            o.g();
            if (a) {
                break;
            }
        }
        final f f = new f();
        y.c.q q2 = q;
        d d = array[q2.d()].a;
        while (true) {
            while (d != null) {
                f.a(d);
                q2 = d.a(q2);
                d = array[q2.d()].a;
                if (a) {
                    d d2 = array[q2.d()].b;
                    f f2 = null;
                    while (d2 != null) {
                        f2 = f;
                        if (a) {
                            return f2;
                        }
                        f2.b(d2);
                        q2 = d2.a(q2);
                        d2 = array[q2.d()].a;
                        if (a) {
                            break;
                        }
                    }
                    return f2;
                }
                if (a) {
                    break;
                }
            }
            q2 = q;
            continue;
        }
    }
}
