package y.a;

import y.c.*;

public class c
{
    public static void a(final i i, final h h, final y.c.c c) {
        final boolean a = h.a;
        final e p3 = i.p();
        while (p3.f()) {
            h.a(p3.a(), false);
            p3.g();
            if (a) {
                break;
            }
        }
        final boolean[] array = new boolean[i.g()];
        final double[] array2 = new double[i.e()];
        final double[] array3 = new double[i.e()];
        final y.g.a.c c2 = new y.g.a.c(i);
        final x o = i.o();
    Label_0247:
        while (true) {
            q e;
            double n;
            double n2;
            q q;
            d d;
            q q2 = null;
            int d2;
            d d3;
            int b;
            boolean b2;
            q d4;
            int d5;
            double[] array4;
            int n3;
            d d6;
            int b3;
            boolean b4;
            q c3;
            int d7;
            double[] array5;
            int n4;
            d d8;
            int b5;
            boolean b6;
            q d9;
            int d10;
            double[] array6;
            int n5;
            d d11;
            int b7;
            boolean b8;
            q c4;
            int d12;
            double[] array7;
            int n6;
            Label_0161_Outer:Label_0255_Outer:
            while (o.f()) {
                e = o.e();
                n = 0.0;
                n2 = 0.0;
                q = e;
                if (!a) {
                    d = q.f();
                    while (true) {
                        while (d != null) {
                            n2 += c.c(d);
                            d = d.g();
                            if (a) {
                                while (true) {
                                    while (d != null) {
                                        n += c.c(d);
                                        d = d.h();
                                        if (!a) {
                                            if (a) {
                                                break;
                                            }
                                            continue Label_0161_Outer;
                                        }
                                        else {
                                            if (a) {
                                                break Label_0161_Outer;
                                            }
                                            continue Label_0247;
                                        }
                                    }
                                    c2.a(e, Math.min(n2, n));
                                    array2[e.d()] = n2;
                                    array3[e.d()] = n;
                                    o.g();
                                    continue Label_0255_Outer;
                                }
                            }
                            if (a) {
                                break;
                            }
                        }
                        d = e.g();
                        continue Label_0255_Outer;
                    }
                }
                Label_0483: {
                    while (true) {
                        q2 = q;
                        d2 = q2.d();
                        if (array3[d2] >= array2[d2]) {
                            d3 = q2.f();
                            while (d3 != null) {
                                b = d3.b();
                                b2 = array[b];
                                if (a) {
                                    break Label_0247;
                                }
                                if (!b2) {
                                    d4 = d3.d();
                                    d5 = d4.d();
                                    array4 = array3;
                                    n3 = d5;
                                    array4[n3] -= c.c(d3);
                                    h.a(d3, true);
                                    c2.d(d4, Math.min(array3[d5], array2[d5]));
                                    array[b] = true;
                                }
                                d3 = d3.g();
                                if (a) {
                                    break;
                                }
                            }
                            d6 = q2.g();
                            while (d6 != null) {
                                b3 = d6.b();
                                b4 = array[b3];
                                if (a) {
                                    break Label_0247;
                                }
                                if (!b4) {
                                    c3 = d6.c();
                                    d7 = c3.d();
                                    array5 = array2;
                                    n4 = d7;
                                    array5[n4] -= c.c(d6);
                                    c2.d(c3, Math.min(array3[d7], array2[d7]));
                                    array[b3] = true;
                                }
                                d6 = d6.h();
                                if (a) {
                                    break Label_0483;
                                }
                            }
                            break;
                        }
                        break Label_0483;
                        if (!b2) {
                            c2.a();
                            continue;
                        }
                        break;
                    }
                    return;
                }
                d8 = q2.f();
                while (d8 != null) {
                    b5 = d8.b();
                    b6 = array[b5];
                    if (a) {
                        continue Label_0247;
                    }
                    if (!b6) {
                        d9 = d8.d();
                        d10 = d9.d();
                        array6 = array3;
                        n5 = d10;
                        array6[n5] -= c.c(d8);
                        c2.d(d9, Math.min(array3[d10], array2[d10]));
                        array[b5] = true;
                    }
                    d8 = d8.g();
                    if (a) {
                        break;
                    }
                }
                d11 = q2.g();
                while (d11 != null) {
                    b7 = d11.b();
                    b8 = array[b7];
                    if (a) {
                        continue Label_0247;
                    }
                    if (!b8) {
                        c4 = d11.c();
                        d12 = c4.d();
                        array7 = array2;
                        n6 = d12;
                        array7[n6] -= c.c(d11);
                        h.a(d11, true);
                        c2.d(c4, Math.min(array3[d12], array2[d12]));
                        array[b7] = true;
                    }
                    d11 = d11.h();
                    if (a) {
                        return;
                    }
                }
                break;
            }
            c2.b();
            continue Label_0247;
        }
    }
    
    public static void a(final i i, final h h) {
        final boolean a = h.a;
        final int[] array = new int[i.e()];
        m.b(i, array);
        final e p2 = i.p();
        while (p2.f()) {
            final d a2 = p2.a();
            h.a(a2, false);
            if (array[a2.c().d()] < array[a2.d().d()]) {
                h.a(a2, true);
            }
            p2.g();
            if (a) {
                break;
            }
        }
    }
    
    public static f a(final i i, final boolean b) {
        final f f = new f();
        final y.a.d d = new y.a.d(f);
        d.a(b);
        d.a(i);
        return f;
    }
}
