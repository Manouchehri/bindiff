package y.a;

import y.g.*;
import y.c.*;

public class m
{
    public static boolean a(final i i, final int[] array) {
        return d(i, array);
    }
    
    public static y a(final i i) {
        final int[] array = new int[i.e()];
        if (!a(i, array)) {
            throw new IllegalArgumentException("Graph is not acyclic");
        }
        return c(i, array);
    }
    
    public static void b(final i i, final int[] array) {
        o.a(new o(null), i, array);
    }
    
    public static y b(final i i) {
        return o.a(new o(null), i);
    }
    
    public static y c(final i i, final int[] array) {
        final boolean a = h.a;
        final q[] array2 = new q[i.f()];
        final x o = i.o();
        while (o.f()) {
            final q e = o.e();
            array2[array[e.d()]] = e;
            o.g();
            if (a) {
                break;
            }
        }
        return new y(array2);
    }
    
    public static void a(final y y, final A a) {
        final boolean a2 = h.a;
        int n = 0;
        final x a3 = y.a();
        while (a3.f()) {
            a.a(a3.e(), n);
            a3.g();
            ++n;
            if (a2) {
                break;
            }
        }
    }
    
    private static boolean d(final i i, final int[] array) {
        final boolean a = h.a;
        final int[] array2 = new int[i.f()];
        final c c = new c(i.f());
        int n = 0;
        final x o = i.o();
        while (true) {
        Label_0100:
            while (o.f()) {
                final q e = o.e();
                final int d = e.d();
                final int[] array3 = array2;
                final int n2 = d;
                int j;
                final int n3 = j = e.b();
                array3[n2] = n3;
                if (a) {
                Label_0193:
                    while (j == 0) {
                        final q q = (q)c.b();
                        array[q.d()] = n++;
                        d d2 = q.f();
                        while (d2 != null) {
                            final int[] array4 = array2;
                            final int d3 = d2.d().d();
                            final int n5;
                            final int n4 = j = (n5 = array4[d3] - 1);
                            array4[d3] = n4;
                            if (a) {
                                return n5 == i.f();
                            }
                            if (a) {
                                continue Label_0104;
                            }
                            if (n4 == 0) {
                                c.b(d2.d());
                            }
                            d2 = d2.g();
                            if (a) {
                                break Label_0193;
                            }
                        }
                        break Label_0100;
                    }
                    int n5 = n;
                    return n5 == i.f();
                }
                if (n3 == 0) {
                    c.b(e);
                }
                array[d] = -1;
                o.g();
                if (a) {
                    break;
                }
            }
            int j = c.e() ? 1 : 0;
            continue;
        }
    }
}
