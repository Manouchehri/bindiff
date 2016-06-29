package y.a;

import java.util.*;
import y.c.*;
import y.g.*;

class ad
{
    private static void a(final List list, final h h) {
        final boolean a = h.a;
        final ListIterator<d> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            final d d = listIterator.next();
            if (d.c().a() == 1 || d.d().a() == 1) {
                h.a(d, 0.0);
                if (a) {
                    break;
                }
                continue;
            }
        }
    }
    
    private void a(final i i, final d[] array) {
        final boolean a = y.a.h.a;
        int j = array.length - 1;
        while (j >= 0) {
            if (!i.f(array[j])) {
                i.e(array[j]);
            }
            --j;
            if (a) {
                break;
            }
        }
    }
    
    private void a(final i i, final A a, final A a2) {
        final boolean a3 = y.a.h.a;
        final x o = i.o();
        while (o.f()) {
            a2.a(o.e(), a.a(o.e()));
            o.g();
            if (a3) {
                break;
            }
        }
    }
    
    private static ArrayList a(final List list) {
        final boolean a = y.a.h.a;
        final ArrayList<d> list2 = new ArrayList<d>();
        final ListIterator<q> listIterator = list.listIterator();
        ArrayList<d> list3 = null;
    Label_0079:
        while (listIterator.hasNext()) {
            d d = listIterator.next().f();
            Label_0080: {
                while (d != null) {
                    list3 = list2;
                    if (a) {
                        break Label_0080;
                    }
                    list3.add(d);
                    d = d.g();
                    if (a || a) {
                        break Label_0079;
                    }
                }
                continue;
            }
            return list3;
        }
        return list3;
    }
    
    private void b(final List list, final h h) {
        final boolean a = h.a;
        final ListIterator<Object> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            h.a(listIterator.next(), 0.0);
            if (a) {
                break;
            }
        }
    }
    
    private ArrayList a(final ArrayList list) {
        final boolean a = y.a.h.a;
        final ArrayList<Object> list2 = new ArrayList<Object>();
        final ListIterator<Object> listIterator = list.listIterator();
        ArrayList<Object> list3 = null;
        while (listIterator.hasNext()) {
            list3 = list2;
            if (a) {
                return list3;
            }
            list3.add(listIterator.next());
            if (a) {
                break;
            }
        }
        return list3;
    }
    
    private List a(final i i, final A a, final int n) {
        final boolean a2 = y.a.h.a;
        final ArrayList<ArrayList<q>> list = new ArrayList<ArrayList<q>>();
        int j = 0;
        while (true) {
            while (j < n) {
                list.add(new ArrayList<q>());
                ++j;
                if (a2) {
                    final x o = i.o();
                    while (o.f()) {
                        final Object o2;
                        final ArrayList<q> list2 = (ArrayList<q>)(o2 = list.get(a.a(o.e())));
                        if (a2) {
                            return (List)o2;
                        }
                        list2.add(o.e());
                        o.g();
                        if (a2) {
                            break;
                        }
                    }
                    Object o2 = list;
                    return (List)o2;
                }
                if (a2) {
                    break;
                }
            }
            if (n == 1) {
                final x o3 = i.o();
                while (o3.f()) {
                    final Object o4;
                    final ArrayList<q> list3 = (ArrayList<q>)(o4 = list.get(0));
                    if (a2) {
                        return (List)o4;
                    }
                    list3.add(o3.e());
                    o3.g();
                    if (a2) {
                        break;
                    }
                }
                Object o4 = list;
                return (List)o4;
            }
            continue;
        }
    }
    
    private double a(final d[] array, final A a, final int n, final boolean b) {
        final boolean a2 = y.a.h.a;
        final double[][] array2 = new double[n][n];
        final int length = array.length;
        Label_0217: {
            Label_0089: {
                if (b) {
                    int i = length - 1;
                    while (i >= 0) {
                        final int a3 = a.a(array[i].c());
                        final int a4 = a.a(array[i].d());
                        ++array2[a3][a4];
                        --i;
                        if (a2) {
                            break Label_0089;
                        }
                    }
                    break Label_0217;
                }
            }
            int j = length - 1;
            while (true) {
                while (j >= 0) {
                    final int a5 = a.a(array[j].c());
                    final int a6 = a.a(array[j].d());
                    ++array2[a5][a6];
                    ++array2[a6][a5];
                    --j;
                    if (a2) {
                        while (j >= 0) {
                            array2[j][j] /= 2.0;
                            --j;
                            if (a2) {
                                break;
                            }
                        }
                        break Label_0217;
                    }
                    if (a2) {
                        break;
                    }
                }
                j = n - 1;
                continue;
            }
        }
        double n2 = 0.0;
        double n3 = 0.0;
        int k = n - 1;
    Label_0319_Outer:
        while (k >= 0) {
            n2 += array2[k][k];
            double n4 = 0.0;
            double n5 = 0.0;
            if (!a2) {
                int l = n - 1;
                while (true) {
                    while (l >= 0) {
                        n4 += array2[k][l];
                        n5 += array2[l][k];
                        --l;
                        if (!a2) {
                            if (a2) {
                                break;
                            }
                            continue Label_0319_Outer;
                        }
                        else {
                            if (a2) {
                                break Label_0319_Outer;
                            }
                            continue Label_0319_Outer;
                        }
                    }
                    n3 += n4 * n5;
                    --k;
                    continue;
                }
            }
            return n2 - n3;
        }
        n2 /= length;
        n3 /= length * length;
        return n2 - n3;
    }
    
    private int a(final i i, final List list, final A a, final List list2, final int n) {
        final boolean a2 = y.a.h.a;
        final boolean[] array = new boolean[i.e()];
        y.a.h.a(i, list.get(0), false, array);
        final ListIterator<q> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (!array[listIterator.next().d()]) {
                final ArrayList<q> list3 = new ArrayList<q>();
                final ArrayList<q> list4 = list2.get(a.a(list.get(0)));
                final ListIterator<q> listIterator2 = list.listIterator();
                int index = 0;
                while (listIterator2.hasNext()) {
                    final q q = listIterator2.next();
                    if (!array[q.d()]) {
                        a.a(q, n);
                        list3.add(q);
                        final int n2 = index = list4.indexOf(q);
                        if (a2) {
                            return index;
                        }
                        if (index < 0) {
                            continue;
                        }
                        list4.remove(n2);
                        if (a2) {
                            break;
                        }
                        continue;
                    }
                }
                list2.add(list3);
                return index;
            }
        }
        return n;
    }
    
    private af c(final List list, final h h) {
        final boolean a = h.a;
        double c = -1.7976931348623157E308;
        final af af = new af(null);
        af.a = -1.0;
        final ListIterator<d> listIterator = list.listIterator();
        af af2 = null;
        while (listIterator.hasNext()) {
            final d b = listIterator.next();
            if (h.c(b) > c) {
                c = h.c(b);
                af.a = h.c(b);
                af2 = af;
                if (a) {
                    return af2;
                }
                af2.b = b;
                if (a) {
                    break;
                }
                continue;
            }
        }
        return af2;
    }
    
    private d a(final List list, final List list2, final h h, final A a, final boolean b, final int n) {
        final boolean a2 = h.a;
        Label_0340: {
            if (n != -1) {
                Label_0136: {
                    if (!b) {
                        double c = -1.7976931348623157E308;
                        final af af = new af(null);
                        af.a = -1.0;
                        final ListIterator<d> listIterator = list2.listIterator();
                        while (true) {
                            while (listIterator.hasNext()) {
                                final d b2 = listIterator.next();
                                if (h.c(b2) > c) {
                                    c = h.c(b2);
                                    af.a = c;
                                    af.b = b2;
                                    if (!a2) {
                                        if (a2) {
                                            break;
                                        }
                                        continue;
                                    }
                                    else {
                                        if (a2) {
                                            break Label_0136;
                                        }
                                        break Label_0340;
                                    }
                                }
                            }
                            list.set(n, af);
                            continue;
                        }
                    }
                }
                double c2 = -1.7976931348623157E308;
                double c3 = -1.7976931348623157E308;
                final af af2 = new af(null);
                final af af3 = new af(null);
                af2.a = -1.0;
                af3.a = -1.0;
                final ListIterator<d> listIterator2 = list2.listIterator();
                while (true) {
                    while (listIterator2.hasNext()) {
                        final d d = listIterator2.next();
                        if (a.a(d.c()) == n) {
                            if (h.c(d) <= c2) {
                                continue;
                            }
                            c2 = h.c(d);
                            af2.b = d;
                            af2.a = c2;
                            if (!a2) {
                                continue;
                            }
                        }
                        if (h.c(d) > c3) {
                            c3 = h.c(d);
                            af3.b = d;
                            af3.a = c3;
                            if (a2) {
                                list.add(af3);
                                break Label_0340;
                            }
                            if (a2) {
                                break;
                            }
                            continue;
                        }
                    }
                    list.set(n, af2);
                    continue;
                }
            }
        }
        double a3 = -1.7976931348623157E308;
        final ListIterator<af> listIterator3 = list.listIterator();
        while (listIterator3.hasNext()) {
            final af af4 = listIterator3.next();
            if (af4.a > a3) {
                a3 = af4.a;
                final d b3 = af4.b;
                if (!a2 && !a2) {
                    continue;
                }
                return b3;
            }
        }
        goto Label_0410;
    }
    
    int a(final i i, final A a, final int n, final int n2, final boolean b, final c c) {
        final boolean a2 = y.a.h.a;
        if (i.g() == 0) {
            return y.a.h.a(i, a);
        }
        final d[] n3 = i.n();
        int a3 = y.a.h.a(i, a);
        final List a4 = this.a(i, a, a3);
        final ArrayList<af> list = new ArrayList<af>();
        double a5 = -1.7976931348623157E308;
        final A a6 = M.a(new int[i.e()]);
        int n4 = 0;
        if (a3 >= n) {
            a5 = this.a(n3, a, a3, b);
            this.a(i, a, a6);
            n4 = a3;
        }
        final h u = i.u();
        List list2 = null;
        int a7 = -1;
        int n5 = 0;
        final ListIterator<ArrayList> listIterator = a4.listIterator();
        while (listIterator.hasNext()) {
            final ArrayList list3 = listIterator.next();
            list2 = a((List)list3);
            Label_0192: {
                if (c == null) {
                    Z.a(i, list3, list2, u, b);
                    if (!a2) {
                        break Label_0192;
                    }
                }
                Z.a(i, list3, list2, u, b, c);
            }
            a(list2, u);
            list.add(this.c(list2, u));
        }
        boolean b3;
        while (true) {
            final d a8 = this.a(list, list2, u, a, n5 != 0, a7);
            i.d(a8);
            a7 = a.a(a8.c());
            final ArrayList a9 = this.a(a4.get(a7));
            final int a10 = this.a(i, a9, a, a4, a3);
            while (true) {
                Label_0358: {
                    if (a10 > a3) {
                        n5 = (true ? 1 : 0);
                        if (a10 >= n && a10 <= n2) {
                            final double a11 = this.a(n3, a, a10, b);
                            if (a11 > a5) {
                                a5 = a11;
                                n4 = a10;
                                this.a(i, a, a6);
                            }
                        }
                        a3 = a10;
                        if (!a2) {
                            break Label_0358;
                        }
                    }
                    final boolean b2 = false;
                    n5 = (b2 ? 1 : 0);
                }
                list2 = a((List)a9);
                this.b(list2, u);
                Label_0409: {
                    if (c == null) {
                        Z.a(i, a9, list2, u, b);
                        if (!a2) {
                            break Label_0409;
                        }
                    }
                    Z.a(i, a9, list2, u, b, c);
                }
                a(list2, u);
                if (a10 >= n2 || i.g() == 0) {
                    this.a(i, n3);
                    this.a(i, a6, a);
                    i.a(u);
                    final boolean b2;
                    b3 = (b2 = (n4 != 0));
                    if (!a2) {
                        break;
                    }
                    continue;
                }
                break;
            }
        }
        return b3 ? 1 : 0;
    }
}
