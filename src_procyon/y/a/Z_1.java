package y.a;

import y.g.*;
import java.util.*;
import y.c.*;

class Z
{
    public static void a(final i i, final List list, final List list2, final h h, final boolean b) {
        final boolean a = h.a;
        if (i.h() == 0) {
            return;
        }
        final int e = i.e();
        final A a2 = M.a(new double[e]);
        final A a3 = M.a(new int[e]);
        final A a4 = M.a(new ArrayList[e]);
        final h b2 = M.b(new double[i.h()]);
        final A a5 = M.a(new double[e]);
        final ListIterator<q> listIterator = list.listIterator();
    Label_0075:
        while (true) {
        Label_0092_Outer:
            while (listIterator.hasNext()) {
                I j = listIterator.next();
                ArrayList list3 = null;
            Label_0092:
                while (true) {
                    while (true) {
                        final q q = (q)j;
                        q q2 = null;
                    Label_0267:
                        while (true) {
                            q q3 = null;
                            q2 = q3;
                            list3 = new ArrayList<q>();
                            ListIterator<q> listIterator2 = list2.listIterator();
                            while (true) {
                                while (listIterator2.hasNext()) {
                                    b2.a(listIterator2.next(), 0.0);
                                    if (a) {
                                        while (listIterator2.hasNext()) {
                                            final q q4 = listIterator2.next();
                                            a4.a(q4, new ArrayList());
                                            a5.a(q4, 0.0);
                                            q3 = q4;
                                            if (a) {
                                                continue Label_0267;
                                            }
                                            if (q3 != q2) {
                                                a2.a(q4, 0.0);
                                                a3.a(q4, -1);
                                                if (!a) {
                                                    continue Label_0092_Outer;
                                                }
                                            }
                                            a2.a(q4, 1.0);
                                            a3.a(q4, 0);
                                            if (a) {
                                                break;
                                            }
                                        }
                                        break Label_0267;
                                    }
                                    if (a) {
                                        break;
                                    }
                                }
                                listIterator2 = list.listIterator();
                                continue;
                            }
                        }
                        final c c = new c(e);
                        c.a(q2);
                    Label_0285:
                        while (true) {
                            c.e();
                            int k = 0;
                        Label_0290:
                            while (k == 0) {
                                final q q5 = (q)c.b();
                                list3.add(q5);
                                d d = q5.f();
                                while (true) {
                                    while (d != null) {
                                        final q d2 = d.d();
                                        final int a6 = a3.a(d2);
                                        if (!a) {
                                            if (a6 < 0) {
                                                c.a(d2);
                                                a3.a(d2, a3.a(q5) + 1);
                                            }
                                            if (a3.a(d2) == a3.a(q5) + 1) {
                                                if (a2.c(d2) + a2.c(q5) > Double.MAX_VALUE) {
                                                    throw new ArithmeticException("Number of Paths between " + q2 + " and " + d2 + " overflows double");
                                                }
                                                a2.a(d2, a2.c(d2) + a2.c(q5));
                                                final ArrayList list4 = (ArrayList)a4.b(d2);
                                                list4.add(d);
                                                a4.a(d2, list4);
                                            }
                                            d = d.g();
                                            if (a) {
                                                break;
                                            }
                                            continue Label_0092_Outer;
                                        }
                                        else {
                                            if (a6 != 0) {
                                                continue Label_0285;
                                            }
                                            final d d3 = (d)(j = q5.g());
                                            if (!a) {
                                                d h2 = d3;
                                                while (h2 != null) {
                                                    final q c2 = h2.c();
                                                    k = a3.a(c2);
                                                    if (a) {
                                                        continue Label_0290;
                                                    }
                                                    if (k < 0) {
                                                        c.a(c2);
                                                        a3.a(c2, a3.a(q5) + 1);
                                                    }
                                                    if (a3.a(c2) == a3.a(q5) + 1) {
                                                        if (a2.c(c2) + a2.c(q5) > Double.MAX_VALUE) {
                                                            throw new ArithmeticException("Number of Paths between " + q2 + " and " + c2 + " overflows double");
                                                        }
                                                        a2.a(c2, a2.c(c2) + a2.c(q5));
                                                        final ArrayList list5 = (ArrayList)a4.b(c2);
                                                        list5.add(h2);
                                                        a4.a(c2, list5);
                                                    }
                                                    h2 = h2.h();
                                                    if (a) {
                                                        break Label_0092;
                                                    }
                                                }
                                                continue Label_0285;
                                            }
                                            continue Label_0092;
                                        }
                                    }
                                    continue;
                                }
                            }
                            break Label_0092;
                        }
                    }
                    break;
                }
                while (!list3.isEmpty()) {
                    final q q6 = list3.remove(list3.size() - 1);
                    final ArrayList list6 = (ArrayList)a4.b(q6);
                    if (a) {
                        return;
                    }
                    int l = list6.size() - 1;
                    while (l >= 0) {
                        final d d4 = list6.get(l);
                        final q a7 = d4.a(q6);
                        a5.a(a7, a5.c(a7) + a2.c(a7) * (a5.c(q6) + 1.0) / a2.c(q6));
                        b2.a(d4, a2.c(a7) * (a5.c(q6) + 1.0) / a2.c(q6));
                        h.a(d4, h.c(d4) + b2.c(d4));
                        --l;
                        if (a) {
                            return;
                        }
                        if (a) {
                            continue Label_0075;
                        }
                        if (a) {
                            break Label_0075;
                        }
                    }
                }
            }
            break;
        }
        i.a(a2);
        i.a(a4);
        i.a(a3);
        i.a(b2);
        i.a(a5);
    }
    
    protected static void a(final i i, final List list, final List list2, final h h, final boolean b, final y.c.c c) {
        final boolean a = h.a;
        if (i.h() == 0) {
            return;
        }
        final int f = i.f();
        final double n = 0.01;
        final A a2 = M.a(new double[f]);
        final A a3 = M.a(new double[f]);
        final A a4 = M.a(new ArrayList[f]);
        final A a5 = M.a(new double[f]);
        final A a6 = M.a(new double[f]);
        final A a7 = M.a(new boolean[f]);
        final A a8 = M.a(new double[f]);
        final h b2 = M.b(new double[i.h()]);
        final y.g.a.c c2 = new y.g.a.c(i);
        final ListIterator<q> listIterator = list.listIterator();
    Label_0117:
        while (true) {
            while (listIterator.hasNext()) {
                I j = listIterator.next();
                ArrayList list3 = null;
            Label_0199_Outer:
                while (true) {
                    final q q = (q)j;
                    list3 = new ArrayList<q>();
                    ListIterator<q> listIterator2 = list2.listIterator();
                    while (true) {
                        while (listIterator2.hasNext()) {
                            b2.a(listIterator2.next(), 0.0);
                            if (a) {
                                while (true) {
                                    while (listIterator2.hasNext()) {
                                        final q q2 = listIterator2.next();
                                        a4.a(q2, new ArrayList());
                                        a5.a(q2, 0.0);
                                        a8.a(q2, 0.0);
                                        final q q3 = q2;
                                        if (a) {
                                            d d = q3.f();
                                            while (true) {
                                                while (d != null) {
                                                    final q d2 = d.d();
                                                    final double n2 = dcmpl(c.c(d), Double.POSITIVE_INFINITY);
                                                    if (!a) {
                                                        if (n2 == 0) {
                                                            throw new ArithmeticException("Edge weight between " + q + " and " + d2 + " overflows double");
                                                        }
                                                        a6.a(d2, c.c(d));
                                                        Label_0506: {
                                                            if (!c2.a(d2)) {
                                                                c2.a(d2, a6.c(d2));
                                                                if (!a) {
                                                                    break Label_0506;
                                                                }
                                                            }
                                                            c2.d(d2, a6.c(d2));
                                                        }
                                                        final ArrayList list4 = (ArrayList)a4.b(d2);
                                                        list4.add(d);
                                                        a4.a(d2, list4);
                                                        d = d.g();
                                                        if (a) {
                                                            break;
                                                        }
                                                        continue Label_0199_Outer;
                                                    }
                                                    else {
                                                        Label_0697: {
                                                            if (n2 == 0) {
                                                                d d3 = q.g();
                                                                while (d3 != null) {
                                                                    final q c3 = d3.c();
                                                                    a6.a(c3, c.c(d3));
                                                                    final boolean a9 = c2.a(c3);
                                                                    if (a) {
                                                                        break Label_0697;
                                                                    }
                                                                    Label_0645: {
                                                                        if (!a9) {
                                                                            c2.a(c3, a6.c(c3));
                                                                            if (!a) {
                                                                                break Label_0645;
                                                                            }
                                                                        }
                                                                        c2.d(c3, a6.c(c3));
                                                                    }
                                                                    final ArrayList list5 = (ArrayList)a4.b(c3);
                                                                    list5.add(d3);
                                                                    a4.a(c3, list5);
                                                                    d3 = d3.h();
                                                                    if (a) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            list3.add(q);
                                                        }
                                                    Label_0698:
                                                        while (true) {
                                                            c2.b();
                                                            boolean d4 = false;
                                                        Label_0703:
                                                            while (!d4) {
                                                                final q a10 = c2.a();
                                                                list3.add(a10);
                                                                a3.a(a10, a6.c(a10));
                                                                a7.a(a10, true);
                                                                final ArrayList list6 = (ArrayList)a4.b(a10);
                                                                int k = list6.size() - 1;
                                                                while (true) {
                                                                    while (k >= 0) {
                                                                        a2.a(a10, a2.c(a10) + a2.c(list6.get(k).a(a10)));
                                                                        --k;
                                                                        if (a) {
                                                                            d d5 = a10.f();
                                                                            while (true) {
                                                                                while (d5 != null) {
                                                                                    final q d6 = d5.d();
                                                                                    final boolean d7 = a7.d(d6);
                                                                                    if (!a) {
                                                                                        Label_1166: {
                                                                                            if (!d7) {
                                                                                                final double n3 = a3.c(a10) + c.c(d5);
                                                                                                final double c4 = a6.c(d6);
                                                                                                if (n3 == Double.POSITIVE_INFINITY) {
                                                                                                    throw new ArithmeticException("Distance between " + q + " and " + a10 + " overflows double");
                                                                                                }
                                                                                                if (Math.abs(n3 - c4) < n) {
                                                                                                    final ArrayList list7 = (ArrayList)a4.b(d6);
                                                                                                    list7.add(d5);
                                                                                                    a4.a(d6, list7);
                                                                                                    if (!a) {
                                                                                                        break Label_1166;
                                                                                                    }
                                                                                                }
                                                                                                if (n3 < c4) {
                                                                                                    a6.a(d6, n3);
                                                                                                    Label_1128: {
                                                                                                        if (!c2.a(d6)) {
                                                                                                            c2.a(d6, a6.c(d6));
                                                                                                            if (!a) {
                                                                                                                break Label_1128;
                                                                                                            }
                                                                                                        }
                                                                                                        c2.d(d6, a6.c(d6));
                                                                                                    }
                                                                                                    final ArrayList list8 = (ArrayList)a4.b(d6);
                                                                                                    list8.clear();
                                                                                                    list8.add(d5);
                                                                                                    a4.a(d6, list8);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        d5 = d5.g();
                                                                                        if (a) {
                                                                                            break;
                                                                                        }
                                                                                        continue Label_0199_Outer;
                                                                                    }
                                                                                    else {
                                                                                        if (d7) {
                                                                                            continue Label_0698;
                                                                                        }
                                                                                        final d d8 = (d)(j = a10.g());
                                                                                        if (!a) {
                                                                                            d h2 = d8;
                                                                                            while (h2 != null) {
                                                                                                final q c5 = h2.c();
                                                                                                d4 = a7.d(c5);
                                                                                                if (a) {
                                                                                                    continue Label_0703;
                                                                                                }
                                                                                                Label_1464: {
                                                                                                    if (!d4) {
                                                                                                        final double n4 = a3.c(a10) + c.c(h2);
                                                                                                        final double c6 = a6.c(c5);
                                                                                                        if (n4 == Double.POSITIVE_INFINITY) {
                                                                                                            throw new ArithmeticException("Distance between " + q + " and " + a10 + " overflows double");
                                                                                                        }
                                                                                                        if (Math.abs(n4 - c6) < n) {
                                                                                                            final ArrayList list9 = (ArrayList)a4.b(c5);
                                                                                                            list9.add(h2);
                                                                                                            a4.a(c5, list9);
                                                                                                            if (!a) {
                                                                                                                break Label_1464;
                                                                                                            }
                                                                                                        }
                                                                                                        if (n4 < c6) {
                                                                                                            a6.a(c5, n4);
                                                                                                            Label_1426: {
                                                                                                                if (!c2.a(c5)) {
                                                                                                                    c2.a(c5, a6.c(c5));
                                                                                                                    if (!a) {
                                                                                                                        break Label_1426;
                                                                                                                    }
                                                                                                                }
                                                                                                                c2.d(c5, a6.c(c5));
                                                                                                            }
                                                                                                            final ArrayList list10 = (ArrayList)a4.b(c5);
                                                                                                            list10.clear();
                                                                                                            list10.add(h2);
                                                                                                            a4.a(c5, list10);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                h2 = h2.h();
                                                                                                if (a) {
                                                                                                    break Label_0199_Outer;
                                                                                                }
                                                                                            }
                                                                                            continue Label_0698;
                                                                                        }
                                                                                        continue Label_0199_Outer;
                                                                                    }
                                                                                }
                                                                                continue;
                                                                            }
                                                                        }
                                                                        if (a) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    if (a2.c(a10) == Double.POSITIVE_INFINITY) {
                                                                        throw new ArithmeticException("Number of Paths between " + q + " and " + a10 + " overflows double");
                                                                    }
                                                                    continue;
                                                                }
                                                            }
                                                            break Label_0199_Outer;
                                                        }
                                                    }
                                                }
                                                continue;
                                            }
                                        }
                                        if (q3 != q) {
                                            a2.a(q2, 0.0);
                                            a7.a(q2, false);
                                            a3.a(q2, Double.MAX_VALUE);
                                            a6.a(q2, Double.MAX_VALUE);
                                            if (!a) {
                                                continue Label_0199_Outer;
                                            }
                                        }
                                        a2.a(q2, 1.0);
                                        a3.a(q2, 0.0);
                                        a7.a(q2, true);
                                        if (a) {
                                            break;
                                        }
                                    }
                                    c2.c();
                                    continue;
                                }
                            }
                            if (a) {
                                break;
                            }
                        }
                        listIterator2 = list.listIterator();
                        continue;
                    }
                }
                while (!list3.isEmpty()) {
                    final q q4 = list3.remove(list3.size() - 1);
                    final ArrayList list11 = (ArrayList)a4.b(q4);
                    if (a) {
                        return;
                    }
                    int l = list11.size() - 1;
                    while (l >= 0) {
                        final d d9 = list11.get(l);
                        final q a11 = d9.a(q4);
                        a8.a(a11, a8.c(a11) + a2.c(a11) * (a8.c(q4) + 1.0) / a2.c(q4));
                        b2.a(d9, a2.c(a11) * (a8.c(q4) + 1.0) / a2.c(q4));
                        h.a(d9, h.c(d9) + b2.c(d9));
                        --l;
                        if (a) {
                            return;
                        }
                        if (a) {
                            continue Label_0117;
                        }
                        if (a) {
                            break Label_0117;
                        }
                    }
                }
            }
            break;
        }
        i.a(a2);
        i.a(a5);
        i.a(a4);
        i.a(a6);
        i.a(a3);
        i.a(a7);
        i.a(b2);
        i.a(a8);
    }
}
