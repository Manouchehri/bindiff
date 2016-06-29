package y.f.c.a;

import y.f.c.*;
import y.f.*;
import y.g.*;
import y.a.*;
import y.c.*;
import java.util.*;

public class bL implements aT
{
    private aT a;
    private aS b;
    
    public bL() {
        this.a = new ba(new aj());
        this.b = new x();
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final c c = x.c(N.t);
        if (c == null) {
            return;
        }
        final ArrayList list = new ArrayList<q>(64);
        final y.c.x o = x.o();
        while (o.f()) {
            final q e = o.e();
            if (c.d(e)) {
                list.add(e);
            }
            o.g();
            if (x2) {
                break;
            }
        }
        final i i = new i();
        final A t = x.t();
        final int[] array = new int[h.a(x, t)];
        int j = 0;
        while (j < array.length) {
            array[j] = j;
            ++j;
            if (x2) {
                break;
            }
        }
        final q[] array2 = new q[x.e()];
        final y.c.h u = i.u();
        final y.c.h u2 = i.u();
        final A t2 = i.t();
        final A t3 = i.t();
        final q[] array3 = new q[au.b()];
        final int n = au.b() + list.size() + 2;
        final int n2 = (au.b() > 0) ? t.a(au.a(0).d().b()) : -1;
        int max = n;
        int k = 0;
    Label_0418_Outer:
        while (k < array3.length) {
            final q d = i.d();
            array3[k] = d;
            int n3 = 0;
            p p3 = au.a(k).d().k();
            while (true) {
                while (p3 != null) {
                    final q q = (q)p3.c();
                    n3 += q.b();
                    array2[q.d()] = d;
                    array[t.a(q)] = n2;
                    p3 = p3.a();
                    if (!x2) {
                        if (x2) {
                            break;
                        }
                        continue Label_0418_Outer;
                    }
                    else {
                        if (x2) {
                            break Label_0418_Outer;
                        }
                        continue Label_0418_Outer;
                    }
                }
                if (k > 0) {
                    final d a = i.a(array3[k - 1], d);
                    u2.a(a, 1);
                    u.a(a, n3);
                    max = Math.max(max, n3);
                }
                ++k;
                continue;
            }
        }
        final y.c.x o2 = x.o();
        while (o2.f()) {
            final q e2 = o2.e();
            if (array[t.a(e2)] == n2) {
                t.a(e2, n2);
            }
            o2.g();
            if (x2) {
                break;
            }
        }
        final ArrayList list2 = new ArrayList<d>(list.size() + 32);
        final Iterator<q> iterator = list.iterator();
        int n5 = 0;
        Label_0844: {
        Label_0843:
            while (true) {
                iterator.hasNext();
                boolean e3 = false;
            Label_0519:
                while (e3) {
                    final q q2 = iterator.next();
                    if (t.a(q2) != n2) {
                        continue Label_0844;
                    }
                    final q d2 = i.d();
                    array2[q2.d()] = d2;
                    final int n4 = n5 = 0;
                    if (!x2) {
                        int n6 = n4;
                        d d3 = q2.g();
                        while (d3 != null) {
                            e3 = d3.e();
                            if (x2) {
                                continue Label_0519;
                            }
                            Label_0696: {
                                if (!e3) {
                                    ++n6;
                                    final q q3 = array2[d3.c().d()];
                                    if (q3 != null) {
                                        final d a2 = q3.a(d2);
                                        if (a2 == null) {
                                            final d a3 = i.a(q3, d2);
                                            list2.add(a3);
                                            u.a(a3, 1);
                                            if (!x2) {
                                                break Label_0696;
                                            }
                                        }
                                        u.a(a2, u.a(a2) + 1);
                                    }
                                }
                            }
                            d3 = d3.h();
                            if (x2) {
                                break;
                            }
                        }
                        d d4 = q2.f();
                        while (d4 != null) {
                            final boolean e4 = d4.e();
                            if (x2) {
                                continue Label_0519;
                            }
                            Label_0831: {
                                if (!e4) {
                                    ++n6;
                                    final q q4 = array2[d4.d().d()];
                                    if (q4 != null) {
                                        final d a4 = d2.a(q4);
                                        if (a4 == null) {
                                            final d a5 = i.a(d2, q4);
                                            list2.add(a5);
                                            u.a(a5, 1);
                                            if (!x2) {
                                                break Label_0831;
                                            }
                                        }
                                        u.a(a4, u.a(a4) + 1);
                                    }
                                }
                            }
                            d4 = d4.g();
                            if (x2) {
                                break Label_0843;
                            }
                        }
                        continue Label_0844;
                    }
                    break Label_0844;
                }
                break;
            }
            n5 = 0;
        }
        int l = n5;
        while (true) {
        Label_1068_Outer:
            while (l < list2.size()) {
                final d d5 = list2.get(l);
                final int n7 = u.a(d5) * max;
                final q d6 = i.d();
                t3.a(d6, true);
                final d a6 = i.a(d6, d5.d());
                u2.a(a6, 1);
                u.a(a6, n7);
                u.a(d5, n * n7);
                i.a(d5, d6, d5.c());
                ++l;
                if (x2) {
                    final y.c.x o3 = i.o();
                    while (true) {
                        while (o3.f()) {
                            final int d7;
                            final int n8 = d7 = (t3.d(o3.e()) ? 1 : 0);
                            if (x2) {
                                int n9 = d7;
                                int n10 = 0;
                            Label_1143:
                                while (n10 < array3.length) {
                                    while (true) {
                                        while (t2.a(array3[n10]) - l > n9) {
                                            au.a((byte)0, n9);
                                            ++n9;
                                            if (!x2) {
                                                if (x2) {
                                                    break;
                                                }
                                                continue Label_1068_Outer;
                                            }
                                            else {
                                                if (x2) {
                                                    break Label_1143;
                                                }
                                                continue Label_1143;
                                            }
                                        }
                                        ++n10;
                                        ++n9;
                                        continue;
                                    }
                                }
                            Label_1150:
                                for (final q q5 : list) {
                                    if (t.a(q5) == n2) {
                                        final q q6 = array2[q5.d()];
                                        Label_1270: {
                                            if (q6 != null) {
                                                final int n11 = t2.a(q6) - l;
                                                while (true) {
                                                    while (n11 >= au.b()) {
                                                        au.a((byte)0, au.b());
                                                        if (!x2) {
                                                            if (x2) {
                                                                break;
                                                            }
                                                            continue Label_1068_Outer;
                                                        }
                                                        else {
                                                            if (x2) {
                                                                break Label_1270;
                                                            }
                                                            continue Label_1150;
                                                        }
                                                    }
                                                    au.a(n11).a(q5);
                                                    continue;
                                                }
                                            }
                                        }
                                        if (au.b() == 0) {
                                            au.a((byte)0, 0);
                                        }
                                        au.a(0).a(q5);
                                        if (x2) {
                                            break;
                                        }
                                        continue Label_1068_Outer;
                                    }
                                }
                                final J m = new J(x, t);
                                int n12 = 0;
                                while (n12 < array.length) {
                                    final int n13 = array[n12];
                                    if (x2) {
                                        return;
                                    }
                                    if (n13 != n2) {
                                        m.c(new Integer(n13));
                                        final aU a7 = au.a();
                                        this.a.a(x, a7, av);
                                        this.b.a(x, av, a7, au);
                                    }
                                    ++n12;
                                    if (x2) {
                                        break;
                                    }
                                }
                                m.b();
                                x.a(t);
                                return;
                            }
                            if (n8 == 0) {
                                l = Math.min(l, t2.a(o3.e()));
                            }
                            o3.g();
                            if (x2) {
                                break;
                            }
                        }
                        int d7 = 0;
                        continue;
                    }
                }
                if (x2) {
                    break;
                }
            }
            y.a.u.a(i, t2, u, u2);
            l = Integer.MAX_VALUE;
            continue;
        }
    }
}
