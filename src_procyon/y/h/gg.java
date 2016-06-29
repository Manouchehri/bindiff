package y.h;

import y.h.a.*;
import y.c.*;

public abstract class gg
{
    public static boolean a(final bu bu, final Object o) {
        return (o instanceof q && bu.v((q)o)) || (o instanceof d && bu.r((d)o)) || (o instanceof x && bu.a((x)o)) || (o instanceof gZ && bu.a((gZ)o)) || (o instanceof eU && bu.a((eU)o));
    }
    
    public static void a(final bu bu, final q q) {
        final boolean z = fj.z;
        bu.a(q, true);
        final e l = q.l();
        while (l.f()) {
            final d a = l.a();
            Label_0094: {
                if (a.e()) {
                    final y bends = bu.i(a).bends();
                    while (bends.f()) {
                        bu.a(bends.a(), true);
                        bends.g();
                        if (z) {
                            break Label_0094;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                l.g();
            }
            if (z) {
                break;
            }
        }
    }
    
    public static void b(final bu bu, final q q) {
        final boolean z = fj.z;
        bu.a(q, false);
        final e l = q.l();
        while (l.f()) {
            final d a = l.a();
            Label_0094: {
                if (a.e()) {
                    final y bends = bu.i(a).bends();
                    while (bends.f()) {
                        bu.a(bends.a(), false);
                        bends.g();
                        if (z) {
                            break Label_0094;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                l.g();
            }
            if (z) {
                break;
            }
        }
    }
    
    public static A a(final bu bu) {
        return new gl(bu);
    }
    
    public static h b(final bu bu) {
        return new gk(bu);
    }
    
    public static void a(final bu bu, final y.c.y y, final y.c.y y2, final z z) {
        a(bu, new gh(bu), new gi(bu), y, y2, z);
    }
    
    static void a(final bu bu, final y.g.z z, final y.g.z z2, final y.c.y y, final y.c.y y2, final z z3) {
        final boolean z4 = fj.z;
        final v a = v.a(bu);
        if (a == null) {
            return;
        }
        final boolean[] array = new boolean[bu.e()];
        final y.c.x o = bu.o();
        while (o.f()) {
            o.e();
        Label_0048:
            while (true) {
                q q2 = null;
                final q q = q2;
                if (z.a(q)) {
                    if (a.k(q) && !array[q.d()]) {
                        a(a, bu, z, z2, q, q, y, z3, array);
                    }
                    q q3 = a.n(q);
                    while (a.k(q3)) {
                        q2 = q3;
                        if (z4) {
                            continue Label_0048;
                        }
                        if (q2.e() != bu || array[q3.d()]) {
                            break;
                        }
                        Label_0184: {
                            if (z.a(q3)) {
                                a(a, bu, z, z2, q3, q3, y, z3, array);
                                if (!z4) {
                                    break Label_0184;
                                }
                            }
                            y2.add(q3);
                        }
                        array[q3.d()] = true;
                        q3 = a.n(q3);
                        if (z4) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            o.g();
            if (z4) {
                break;
            }
        }
    }
    
    private static void a(final v v, final bu bu, final y.g.z z, final y.g.z z2, final q q, final q q2, final y.c.y y, final z z3, final boolean[] array) {
        final boolean z4 = fj.z;
        final y.c.x p9 = v.p(q2);
        do {
            Label_0013: {
                p9.f();
            }
            int i = 0;
            Label_0020:
            while (i != 0) {
                final q e = p9.e();
                if (y != null && !array[e.d()] && !z.a(e)) {
                    y.add(e);
                    array[e.d()] = true;
                }
                if (v.k(e)) {
                    a(v, bu, z, z2, q, e, y, z3, array);
                }
                if (z3 != null) {
                    d d = e.f();
                    while (d != null) {
                        final aB j = bu.i(d);
                        i = j.bendCount();
                        if (z4) {
                            continue Label_0020;
                        }
                        if (i > 0 && v.b(q, d.d())) {
                            final y bends = j.bends();
                            while (bends.f()) {
                                final boolean a;
                                final boolean b = a = z2.a(bends.a());
                                if (z4) {
                                    continue Label_0020;
                                }
                                if (!b) {
                                    z3.add(bends.a());
                                }
                                bends.g();
                                if (z4) {
                                    break;
                                }
                            }
                        }
                        d = d.g();
                        if (z4) {
                            break;
                        }
                    }
                }
                p9.g();
                continue Label_0013;
            }
            break;
        } while (!z4);
    }
}
