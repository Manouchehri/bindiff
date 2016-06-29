package y.f.c.a;

import java.util.*;
import y.d.*;
import y.f.*;
import y.c.*;

public class bu
{
    private static final double g;
    private List h;
    private bv[] i;
    public static final Object a;
    public static final Object b;
    public static final Object c;
    public static final Object d;
    public static final Object e;
    public static final Object f;
    private double j;
    private double k;
    private double l;
    
    public bu(final double n, final double l) {
        this.h = new ArrayList(60);
        this.i = new bv[60];
        this.l = l;
        this.k = n;
        this.j = n;
    }
    
    void a(final X x, final q q, p a, final c c, final c c2, final y.d.c[] array) {
        final boolean x2 = N.x;
        int n = 0;
        while (true) {
            while (a != null) {
                final d a2 = (d)a.c();
                final int e = a2.e() ? 1 : 0;
                if (x2) {
                    if (e > 0) {
                        this.a(x, q, n, array);
                    }
                    return;
                }
                if (e != 0) {
                    bv bv = null;
                    Label_0090: {
                        if (this.h.size() > n) {
                            bv = this.h.get(n);
                            if (!x2) {
                                break Label_0090;
                            }
                        }
                        bv = new bv();
                        this.h.add(bv);
                    }
                    bv.a = a2;
                    bv.b = ((c == null) ? 3 : bY.a((aE)c.b(a2), 3));
                    bv.c = ((c2 == null) ? 3 : bY.a((aE)c2.b(a2), 0));
                    ++n;
                }
                a = a.a();
                if (x2) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void a(final X x, final q q, final int n, final y.d.c[] array) {
        final boolean x2 = N.x;
        this.i = this.h.toArray(this.i);
        final am a = x.a((Object)q);
        final double a2 = this.a(x, q);
        final cr[] array2 = new cr[4];
        int i = 0;
        while (true) {
            y.d.c c;
            int j;
            bv bv;
            I b;
            int n2;
            t n3;
            t o;
            C m;
            t t;
            y.d.c c2;
            y.d.c c3;
            y.d.d d;
            y.d.d d2;
            y.d.d d3;
            y.d.d d4;
            Label_0668_Outer:Label_0265_Outer:Label_0383_Outer:Label_0503_Outer:
            while (i < 4) {
                (array2[i] = new cr()).c(a2);
                c = new y.d.c(-1.7976931348623157E308, Double.MAX_VALUE, 0.0);
                if (x2) {
                    j = 0;
                    while (true) {
                        while (j < 4) {
                            array2[j].j();
                            ++j;
                            if (x2) {
                            Label_0859:
                                while (j < n) {
                                    bv = this.i[j];
                                    b = x.b((Object)bv.a);
                                    b.clearPoints();
                                    n2 = (4 + bv.c - bv.b & 0x3);
                                    n3 = x.n(bv.a);
                                    o = x.o(bv.a);
                                    m = (this.b(x, bv.a) ? b(a, array2, bv, n2, n3, o) : a(a, array2, bv, n2, n3, o)).m();
                                    while (true) {
                                        while (m.f()) {
                                            t = (t)m.d();
                                            b.addPoint(t.a, t.b);
                                            m.g();
                                            if (!x2) {
                                                if (x2) {
                                                    break;
                                                }
                                                continue Label_0668_Outer;
                                            }
                                            else {
                                                if (x2) {
                                                    break Label_0859;
                                                }
                                                continue Label_0668;
                                            }
                                        }
                                        ++j;
                                        continue;
                                    }
                                }
                                return;
                            }
                            if (x2) {
                                break;
                            }
                        }
                        j = 0;
                        continue;
                    }
                }
                if (array != null && array.length > i && array[i] != null) {
                    c2 = array[i];
                    c3 = new y.d.c(-1.7976931348623157E308, Double.MAX_VALUE, 0.0);
                    Label_0508: {
                        switch (i) {
                            case 0: {
                                c2.b(-a.getWidth() * 0.5);
                                d = c2.f();
                                while (true) {
                                    while (d != null) {
                                        c3.c(c2.b(d), c2.d(d), -c2.a(d));
                                        d = d.b();
                                        if (!x2) {
                                            if (x2) {
                                                break;
                                            }
                                            continue Label_0265_Outer;
                                        }
                                        else {
                                            if (x2) {
                                                break Label_0508;
                                            }
                                            break Label_0508;
                                        }
                                    }
                                    c2.b(a.getWidth() * 0.5);
                                    continue;
                                }
                            }
                            case 1: {
                                c2.b(-a.getHeight() * 0.5);
                                c2.a(-a.getWidth());
                                d2 = c2.f();
                                while (true) {
                                    while (d2 != null) {
                                        c3.c(c2.b(d2), c2.d(d2), c2.a(d2));
                                        d2 = d2.b();
                                        if (!x2) {
                                            if (x2) {
                                                break;
                                            }
                                            continue Label_0383_Outer;
                                        }
                                        else {
                                            if (x2) {
                                                break Label_0508;
                                            }
                                            break Label_0508;
                                        }
                                    }
                                    c2.a(a.getWidth());
                                    c2.b(a.getHeight() * 0.5);
                                    continue;
                                }
                            }
                            case 2: {
                                c2.b(-a.getWidth() * 0.5);
                                c2.a(-a.getHeight());
                                d3 = c2.f();
                                while (true) {
                                    while (d3 != null) {
                                        c3.c(-c2.d(d3), -c2.b(d3), c2.a(d3));
                                        d3 = d3.b();
                                        if (!x2) {
                                            if (x2) {
                                                break;
                                            }
                                            continue Label_0503_Outer;
                                        }
                                        else {
                                            if (x2) {
                                                break Label_0508;
                                            }
                                            break Label_0508;
                                        }
                                    }
                                    c2.a(a.getHeight());
                                    c2.b(a.getWidth() * 0.5);
                                    continue;
                                }
                            }
                            case 3: {
                                c2.b(-a.getHeight() * 0.5);
                                d4 = c2.f();
                                while (d4 != null) {
                                    c3.c(-c2.d(d4), -c2.b(d4), -c2.a(d4));
                                    d4 = d4.b();
                                    if (x2) {
                                        break Label_0508;
                                    }
                                    if (x2) {
                                        break;
                                    }
                                }
                                c2.b(a.getHeight() * 0.5);
                                break;
                            }
                        }
                    }
                    c.a(c3);
                }
                array2[i].b(c);
                ++i;
                if (x2) {
                    break;
                }
            }
            this.a(x, n, a, array2, 1.0);
            continue;
        }
    }
    
    private void a(final X x, final int n, final am am, final cr[] array, final double n2) {
        final boolean x2 = N.x;
        final double n3 = (Math.max(am.getWidth(), am.getHeight()) + 50.0) * 4.0;
        final cB b = cB.b((i)x);
        int i = 0;
        while (i < n) {
            final bv bv = this.i[i];
            final int n4 = 4 + bv.c - bv.b & 0x3;
            final t n5 = x.n(bv.a);
            final t o = x.o(bv.a);
            final boolean b2 = this.b(x, bv.a);
            final double c = this.c(x, bv.a);
            final double n6 = c / bu.g;
            final double n7 = c;
            final double e = this.e(x, bv.a);
            final double a = this.a(x, bv.a);
            final double d = this.d(x, bv.a);
            final double[] array2 = new double[2];
            final double n8 = b2 ? n6 : 0.0;
            Label_0720: {
                switch (n4) {
                    case 0: {
                        Label_0603: {
                            switch (bv.b) {
                                default: {
                                    final double a2 = n5.a;
                                    final double a3 = o.a;
                                    b.a(x, bv.a, (byte)0, array2, true, n5.a < o.a);
                                    array[bv.b].a(bv, n2, Math.max(e, array2[1] * 2.0), Math.max(e, array2[0] * 2.0), a2, true, a3, true, b2, c).k = Math.max(a, d);
                                    if (x2) {
                                        break Label_0603;
                                    }
                                    break Label_0720;
                                }
                                case 1: {
                                    final double b3 = n5.b;
                                    final double b4 = o.b;
                                    b.a(x, bv.a, (byte)1, array2, false, n5.b < o.b);
                                    array[bv.b].a(bv, n2, Math.max(e, array2[0] * 2.0), Math.max(e, array2[1] * 2.0), b3, true, b4, true, b2, c).k = Math.max(a, d);
                                    if (x2) {
                                        break Label_0603;
                                    }
                                    break Label_0720;
                                }
                                case 2: {
                                    final double n9 = -n5.a;
                                    final double n10 = -o.a;
                                    b.a(x, bv.a, (byte)0, array2, true, n5.a < o.a);
                                    array[bv.b].a(bv, n2, Math.max(e, array2[0] * 2.0), Math.max(e, array2[1] * 2.0), n9, true, n10, true, b2, c).k = Math.max(a, d);
                                    if (x2) {
                                        break Label_0603;
                                    }
                                    break Label_0720;
                                }
                                case 3: {
                                    final double n11 = -n5.b;
                                    final double n12 = -o.b;
                                    b.a(x, bv.a, (byte)1, array2, false, n5.b < o.b);
                                    array[bv.b].a(bv, n2, Math.max(e, array2[1] * 2.0), Math.max(e, array2[0] * 2.0), n11, true, n12, true, b2, c).k = Math.max(a, d);
                                    if (x2) {
                                        break Label_0720;
                                    }
                                    break Label_0720;
                                }
                            }
                        }
                        break;
                    }
                    case 1: {
                        switch (bv.b) {
                            default: {
                                final double a4 = n5.a;
                                final double b5 = o.b;
                                final double n13 = n3 + o.b;
                                final double n14 = -n3 + n5.a;
                                final double max = Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, true).a - am.getWidth() * 0.5 + a4 + n8);
                                array[bv.b].a(bv, n2, Math.max(e, array2[1] * 2.0), Math.max(e, array2[0] * 2.0), a4, true, n13, true, b2, c).k = (b2 ? Math.max(a, n6 + n7 - (am.getHeight() * 0.5 + o.b)) : a);
                                array[bv.c].a(bv, n2, e, b5, true, n14, true, b2, c).k = Math.max(b2 ? Math.max(d, n6 + n7 - (am.getWidth() * 0.5 - n5.a)) : d, max);
                                break Label_0720;
                            }
                            case 1: {
                                final double b6 = n5.b;
                                final double n15 = -o.a;
                                final double n16 = n3 - o.a;
                                final double n17 = -n3 + n5.b;
                                array[bv.b].a(bv, n2, e, b6, true, n16, true, b2, c).k = Math.max(b2 ? Math.max(a, n6 + n7 - (am.getWidth() * 0.5 - o.a)) : a, Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, false).a - am.getWidth() * 0.5 - n15 + n8));
                                array[bv.c].a(bv, n2, Math.max(e, array2[0] * 2.0), Math.max(e, array2[1] * 2.0), n15, true, n17, true, b2, c).k = (b2 ? Math.max(d, n6 + n7 - (am.getHeight() * 0.5 - n5.b)) : d);
                                break Label_0720;
                            }
                            case 2: {
                                final double n18 = -n5.a;
                                final double n19 = -o.b;
                                final double n20 = n3 - o.b;
                                final double n21 = -n3 - n5.a;
                                final double max2 = Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, false).a - am.getWidth() * 0.5 + n18 + n8);
                                array[bv.b].a(bv, n2, Math.max(e, array2[0] * 2.0), Math.max(e, array2[1] * 2.0), n18, true, n20, true, b2, c).k = (b2 ? Math.max(a, n6 + n7 - (am.getHeight() * 0.5 - o.b)) : a);
                                array[bv.c].a(bv, n2, e, n19, true, n21, true, b2, c).k = Math.max(b2 ? Math.max(d, n6 + n7 - (am.getWidth() * 0.5 + n5.a)) : d, max2);
                                break Label_0720;
                            }
                            case 3: {
                                final double n22 = -n5.b;
                                final double a5 = o.a;
                                final double n23 = n3 + o.a;
                                final double n24 = -n3 - n5.b;
                                array[bv.b].a(bv, n2, e, n22, true, n23, true, b2, c).k = Math.max(b2 ? Math.max(a, n6 + n7 - (am.getWidth() * 0.5 + o.a)) : a, Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, true).a - am.getWidth() * 0.5 - a5 + n8));
                                array[bv.c].a(bv, n2, Math.max(e, array2[1] * 2.0), Math.max(e, array2[0] * 2.0), a5, true, n24, true, b2, c).k = (b2 ? Math.max(d, n6 + n7 - (am.getHeight() * 0.5 + n5.b)) : d);
                                break Label_0720;
                            }
                        }
                        break;
                    }
                    case 2: {
                        final double[] array3 = new double[2];
                        switch (bv.b) {
                            default: {
                                final double a6 = n5.a;
                                final double n25 = -o.a;
                                final double n26 = n3 - o.a;
                                final double n27 = -n3 + n5.a;
                                final double max3 = Math.max(Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, true, (byte)2).a - am.getWidth() * 0.5 + a6 + n8), b.a(x, bv.a, (byte)0, array3, true, false, (byte)1).a - am.getWidth() * 0.5 - n25 + n8);
                                array[bv.b].a(bv, n2, Math.max(e, array2[1] * 2.0), Math.max(e, array2[0] * 2.0), a6, true, n26 + n3, true, b2, c).k = (b2 ? Math.max(a, (n7 - am.getHeight()) * 0.5) : a);
                                array[bv.b + 1 & 0x3].a(bv, n2, e, n26, true, n27, true, b2, c).k = Math.max(b2 ? Math.max(d, n6 + n7 - (am.getWidth() * 0.5 - Math.max(n5.a, o.a))) : d, max3);
                                array[bv.c].a(bv, n2, Math.max(e, array3[0] * 2.0), Math.max(e, array3[1] * 2.0), n25, true, n27 - n3, true, b2, c).k = (b2 ? Math.max(d, (n7 - am.getHeight()) * 0.5) : d);
                                break Label_0720;
                            }
                            case 1: {
                                final double b7 = n5.b;
                                final double n28 = -o.b;
                                final double n29 = n3 - o.b;
                                final double n30 = -n3 + n5.b;
                                array[bv.b].a(bv, n2, e, b7, true, n29 + n3, true, b2, c).k = Math.max(b2 ? Math.max(a, (n7 - am.getWidth()) * 0.5) : a, Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, false).a - am.getWidth()));
                                array[bv.b + 1 & 0x3].a(bv, n2, Math.max(e, array2[0] * 2.0), Math.max(e, array2[1] * 2.0), n29, true, n30, true, b2, c).k = (b2 ? Math.max(d, n6 + n7 - (am.getHeight() * 0.5 - Math.max(n5.b, o.b))) : d);
                                array[bv.c].a(bv, n2, e, n28, true, n30 - n3, true, b2, c).k = (b2 ? Math.max(d, (n7 - am.getWidth()) * 0.5) : d);
                                break Label_0720;
                            }
                            case 2: {
                                final double n31 = -n5.a;
                                final double a7 = o.a;
                                final double n32 = n3 + o.a;
                                final double n33 = -n3 - n5.a;
                                final double max4 = Math.max(Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, false, (byte)2).a - am.getWidth() * 0.5 + n31 + n8), b.a(x, bv.a, (byte)0, array3, true, true, (byte)1).a - am.getWidth() * 0.5 - a7 + n8);
                                array[bv.b].a(bv, n2, Math.max(e, array2[0] * 2.0), Math.max(e, array2[1] * 2.0), n31, true, n32 + n3, true, b2, c).k = (b2 ? Math.max(a, (n7 - am.getHeight()) * 0.5) : a);
                                array[bv.b + 1 & 0x3].a(bv, n2, e, n32, true, n33, true, b2, c).k = Math.max(b2 ? Math.max(d, n6 + n7 - (am.getWidth() * 0.5 + Math.min(n5.a, o.a))) : d, max4);
                                array[bv.c].a(bv, n2, Math.max(e, array3[1] * 2.0), Math.max(e, array3[0] * 2.0), a7, true, n33 - n3, true, b2, c).k = (b2 ? Math.max(d, (n7 - am.getHeight()) * 0.5) : d);
                                break Label_0720;
                            }
                            case 3: {
                                final double n34 = -n5.b;
                                final double b8 = o.b;
                                final double n35 = n3 + o.b;
                                final double n36 = -n3 - n5.b;
                                array[bv.b].a(bv, n2, e, n34, true, n35 + n3, true, b2, c).k = Math.max(b2 ? Math.max(a, (n7 - am.getWidth()) * 0.5) : a, Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, true).a - am.getWidth()));
                                array[bv.b + 1 & 0x3].a(bv, n2, Math.max(e, array2[1] * 2.0), Math.max(e, array2[0] * 2.0), n35, true, n36, true, b2, c).k = (b2 ? Math.max(d, n6 + n7 - (am.getHeight() * 0.5 + Math.min(n5.b, o.b))) : d);
                                array[bv.c].a(bv, n2, e, b8, true, n36 - n3, true, b2, c).k = (b2 ? Math.max(d, (n7 - am.getWidth()) * 0.5) : d);
                                break Label_0720;
                            }
                        }
                        break;
                    }
                    case 3: {
                        switch (bv.b) {
                            default: {
                                final double a8 = n5.a;
                                final double n37 = -o.b;
                                final double n38 = -n3 - o.b;
                                final double n39 = n3 + n5.a;
                                final double max5 = Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, false).a - am.getWidth() * 0.5 - a8 + n8);
                                array[bv.b].a(bv, n2, Math.max(e, array2[1] * 2.0), Math.max(e, array2[0] * 2.0), a8, true, n38, true, b2, c).k = (b2 ? Math.max(a, n6 + n7 - (am.getHeight() * 0.5 + o.b)) : a);
                                array[bv.c].a(bv, n2, e, n37, true, n39, true, b2, c).k = Math.max(b2 ? Math.max(d, n6 + n7 - (am.getWidth() * 0.5 + n5.a)) : d, max5);
                                break Label_0720;
                            }
                            case 1: {
                                final double b9 = n5.b;
                                final double a9 = o.a;
                                final double n40 = -n3 + o.a;
                                final double n41 = n3 + n5.b;
                                array[bv.b].a(bv, n2, e, b9, true, n40, true, b2, c).k = Math.max(b2 ? Math.max(a, n6 + n7 - (am.getWidth() * 0.5 - o.a)) : a, Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, false).a - am.getWidth() * 0.5 + a9 + n8));
                                array[bv.c].a(bv, n2, Math.max(e, array2[1] * 2.0), Math.max(e, array2[0] * 2.0), a9, true, n41, true, b2, c).k = (b2 ? Math.max(d, n6 + n7 - (am.getHeight() * 0.5 + n5.b)) : d);
                                break Label_0720;
                            }
                            case 2: {
                                final double n42 = -n5.a;
                                final double b10 = o.b;
                                final double n43 = -n3 + o.b;
                                final double n44 = n3 - n5.a;
                                final double max6 = Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, true).a - am.getWidth() * 0.5 - n42 + n8);
                                array[bv.b].a(bv, n2, Math.max(e, array2[0] * 2.0), Math.max(e, array2[1] * 2.0), n42, true, n43, true, b2, c).k = (b2 ? Math.max(a, n6 + n7 - (am.getHeight() * 0.5 - o.b)) : a);
                                array[bv.c].a(bv, n2, e, b10, true, n44, true, b2, c).k = Math.max(b2 ? Math.max(d, n6 + n7 - (am.getWidth() * 0.5 - n5.a)) : d, max6);
                                break Label_0720;
                            }
                            case 3: {
                                final double n45 = -n5.b;
                                final double n46 = -o.a;
                                final double n47 = -n3 - o.a;
                                final double n48 = n3 - n5.b;
                                array[bv.b].a(bv, n2, e, n45, true, n47, true, b2, c).k = Math.max(b2 ? Math.max(a, n6 + n7 - (am.getWidth() * 0.5 + o.a)) : a, Math.max(0.0, b.a(x, bv.a, (byte)0, array2, true, true).a - am.getWidth() * 0.5 + n46 + n8));
                                array[bv.c].a(bv, n2, Math.max(e, array2[0] * 2.0), Math.max(e, array2[1] * 2.0), n46, true, n48, true, b2, c).k = (b2 ? Math.max(d, n6 + n7 - (am.getHeight() * 0.5 - n5.b)) : d);
                                break Label_0720;
                            }
                        }
                        break;
                    }
                }
            }
            ++i;
            if (x2) {
                break;
            }
        }
    }
    
    private static D a(final am am, final cr[] array, final bv bv, final int n, final t t, final t t2) {
        final boolean x = N.x;
        final D d = new D();
        final int b = bv.b;
        final int c = bv.c;
        final boolean b2 = (bv.c & 0x1) == 0x0;
        Label_0250: {
            switch (n) {
                case 0: {
                    d.add(a(am, t, b, array[bv.b].d(bv)));
                    d.add(a(am, t2, c, array[bv.c].d(bv)));
                    if (x) {
                        break Label_0250;
                    }
                    break;
                }
                case 1:
                case 3: {
                    final t a = a(am, t, b, array[bv.b].d(bv));
                    d.add(a);
                    final t a2 = a(am, t2, c, array[bv.c].d(bv));
                    Label_0237: {
                        if (b2) {
                            d.add(new t(a.a, a2.b));
                            if (!x) {
                                break Label_0237;
                            }
                        }
                        d.add(new t(a2.a, a.b));
                    }
                    d.add(a2);
                    if (x) {
                        break Label_0250;
                    }
                    break;
                }
                case 2: {
                    final t a3 = a(am, t, b, array[bv.b].d(bv));
                    final t a4 = a(am, t2, c, array[bv.c].d(bv));
                    final double d2 = array[bv.b + 1 & 0x3].d(bv);
                    d.add(a3);
                    Label_0553: {
                        switch (bv.b) {
                            case 0: {
                                d.add(new t(am.getX() + am.getWidth() + d2, a3.b));
                                d.add(new t(am.getX() + am.getWidth() + d2, a4.b));
                                if (x) {
                                    break Label_0553;
                                }
                                break;
                            }
                            case 1: {
                                d.add(new t(a3.a, am.getY() + am.getHeight() + d2));
                                d.add(new t(a4.a, am.getY() + am.getHeight() + d2));
                                if (x) {
                                    break Label_0553;
                                }
                                break;
                            }
                            case 2: {
                                d.add(new t(am.getX() - d2, a3.b));
                                d.add(new t(am.getX() - d2, a4.b));
                                if (x) {
                                    break Label_0553;
                                }
                                break;
                            }
                            case 3: {
                                d.add(new t(a3.a, am.getY() - d2));
                                d.add(new t(a4.a, am.getY() - d2));
                                break;
                            }
                        }
                    }
                    d.add(a4);
                    break;
                }
            }
        }
        return d;
    }
    
    protected double a(final X x, final d d) {
        final c c = x.c(bu.d);
        if (c != null) {
            return c.c(d);
        }
        return this.j;
    }
    
    protected boolean b(final X x, final d d) {
        final c c = x.c(bu.b);
        return c != null && c.d(d);
    }
    
    protected double c(final X x, final d d) {
        final c c = x.c(bu.c);
        if (c != null) {
            return c.c(d);
        }
        return 0.0;
    }
    
    protected double d(final X x, final d d) {
        final c c = x.c(bu.e);
        if (c != null) {
            return c.c(d);
        }
        return this.k;
    }
    
    protected double e(final X x, final d d) {
        final c c = x.c(bu.f);
        if (c != null) {
            return c.c(d);
        }
        return this.l;
    }
    
    protected double a(final X x, final q q) {
        final c c = x.c(bu.a);
        if (c != null) {
            return c.c(q);
        }
        return Math.max(this.l, Math.max(this.j, this.k));
    }
    
    private static D b(final am am, final cr[] array, final bv bv, final int n, final t t, final t t2) {
        final boolean x = N.x;
        final D d = new D();
        final double n2 = am.getX() + am.getWidth();
        final double n3 = am.getY() + am.getHeight();
        Label_3912: {
            switch (n) {
                case 0: {
                    final cy a = array[bv.b].a(bv);
                    Label_0885: {
                        switch (bv.b) {
                            default: {
                                final double n4 = am.getX() + am.getWidth() * 0.5 + t.a;
                                final double n5 = am.getX() + am.getWidth() * 0.5 + t2.a;
                                final t t3 = new t(n4, am.getY() - a.d + (a.p - a.b));
                                d.add(t3);
                                final t t4 = new t((n4 < n5) ? (n4 + (a.p - a.b)) : (n4 - (a.p - a.b)), am.getY() - a.d);
                                d.add(t4);
                                d.add(new t((n4 < n5) ? (n5 - (a.p - a.b)) : (n5 + (a.p - a.b)), t4.b));
                                d.add(new t(n5, t3.b));
                                if (x) {
                                    break Label_0885;
                                }
                                break Label_3912;
                            }
                            case 1: {
                                final double n6 = am.getY() + am.getHeight() * 0.5 + t.b;
                                final double n7 = am.getY() + am.getHeight() * 0.5 + t2.b;
                                final t t5 = new t(n2 + a.d - (a.p - a.b), n6);
                                d.add(t5);
                                final t t6 = new t(n2 + a.d, (n6 < n7) ? (n6 + (a.p - a.b)) : (n6 - (a.p - a.b)));
                                d.add(t6);
                                d.add(new t(t6.a, (n6 < n7) ? (n7 - (a.p - a.b)) : (n7 + (a.p - a.b))));
                                d.add(new t(t5.a, n7));
                                if (x) {
                                    break Label_0885;
                                }
                                break Label_3912;
                            }
                            case 2: {
                                final double n8 = am.getX() + am.getWidth() * 0.5 + t.a;
                                final double n9 = am.getX() + am.getWidth() * 0.5 + t2.a;
                                final t t7 = new t(n8, n3 + a.d - (a.p - a.b));
                                d.add(t7);
                                final t t8 = new t((n8 < n9) ? (n8 + (a.p - a.b)) : (n8 - (a.p - a.b)), n3 + a.d);
                                d.add(t8);
                                d.add(new t((n8 < n9) ? (n9 - (a.p - a.b)) : (n9 + (a.p - a.b)), t8.b));
                                d.add(new t(n9, t7.b));
                                if (x) {
                                    break Label_0885;
                                }
                                break Label_3912;
                            }
                            case 3: {
                                final double n10 = am.getY() + am.getHeight() * 0.5 + t.b;
                                final double n11 = am.getY() + am.getHeight() * 0.5 + t2.b;
                                final t t9 = new t(am.getX() - a.d + (a.p - a.b), n10);
                                d.add(t9);
                                final t t10 = new t(am.getX() - a.d, (n10 < n11) ? (n10 + (a.p - a.b)) : (n10 - (a.p - a.b)));
                                d.add(t10);
                                d.add(new t(t10.a, (n10 < n11) ? (n11 - (a.p - a.b)) : (n11 + (a.p - a.b))));
                                d.add(new t(t9.a, n11));
                                if (x) {
                                    break Label_3912;
                                }
                                break Label_3912;
                            }
                        }
                    }
                    break;
                }
                case 1: {
                    final cy a2 = array[bv.b].a(bv);
                    final cy a3 = array[bv.c].a(bv);
                    Label_2087: {
                        switch (bv.b) {
                            default: {
                                final double n12 = am.getX() + am.getWidth() * 0.5 + t.a;
                                final double n13 = am.getY() + am.getHeight() * 0.5 + t2.b;
                                d.add(new t(n12, am.getY() - a2.d + (a2.p - a2.b)));
                                final t t11 = new t(n12 + (a2.p - a2.b), am.getY() - a2.d);
                                d.add(t11);
                                final t t12 = new t(n2 + a3.d - (a3.c - a3.q), t11.b);
                                d.add(t12);
                                final t t13 = new t(n2 + a3.d, t12.b + (a3.c - a3.q));
                                d.add(t13);
                                final t t14 = new t(t13.a, n13 - (a3.c - a3.q));
                                d.add(t14);
                                d.add(new t(t14.a - (a3.c - a3.q), n13));
                                if (x) {
                                    break Label_2087;
                                }
                                break Label_3912;
                            }
                            case 1: {
                                final double n14 = am.getY() + am.getHeight() * 0.5 + t.b;
                                final double n15 = am.getX() + am.getWidth() * 0.5 + t2.a;
                                d.add(new t(n2 + a2.d - (a2.p - a2.b), n14));
                                final t t15 = new t(n2 + a2.d, n14 + (a2.p - a2.b));
                                d.add(t15);
                                final t t16 = new t(t15.a, n3 + a3.d - (a3.c - a3.q));
                                d.add(t16);
                                final t t17 = new t(t16.a - (a3.c - a3.q), n3 + a3.d);
                                d.add(t17);
                                final t t18 = new t(n15 + (a3.c - a3.q), t17.b);
                                d.add(t18);
                                d.add(new t(n15, t18.b - (a3.c - a3.q)));
                                if (x) {
                                    break Label_2087;
                                }
                                break Label_3912;
                            }
                            case 2: {
                                final double n16 = am.getX() + am.getWidth() * 0.5 + t.a;
                                final double n17 = am.getY() + am.getHeight() * 0.5 + t2.b;
                                d.add(new t(n16, n3 + a2.d - (a2.p - a2.b)));
                                final t t19 = new t(n16 - (a2.p - a2.b), n3 + a2.d);
                                d.add(t19);
                                final t t20 = new t(am.getX() - a3.d + (a3.c - a3.q), t19.b);
                                d.add(t20);
                                final t t21 = new t(am.getX() - a3.d, t20.b - (a3.c - a3.q));
                                d.add(t21);
                                final t t22 = new t(t21.a, n17 + (a3.c - a3.q));
                                d.add(t22);
                                d.add(new t(t22.a + (a3.c - a3.q), n17));
                                if (x) {
                                    break Label_2087;
                                }
                                break Label_3912;
                            }
                            case 3: {
                                final double n18 = am.getY() + am.getHeight() * 0.5 + t.b;
                                final double n19 = am.getX() + am.getWidth() * 0.5 + t2.a;
                                d.add(new t(am.getX() - a2.d + (a2.p - a2.b), n18));
                                final t t23 = new t(am.getX() - a2.d, n18 - (a2.p - a2.b));
                                d.add(t23);
                                final t t24 = new t(t23.a, am.getY() - a3.d + (a3.c - a3.q));
                                d.add(t24);
                                final t t25 = new t(t24.a + (a3.c - a3.q), am.getY() - a3.d);
                                d.add(t25);
                                final t t26 = new t(n19 - (a3.c - a3.q), t25.b);
                                d.add(t26);
                                d.add(new t(n19, t26.b + (a3.c - a3.q)));
                                if (x) {
                                    break Label_3912;
                                }
                                break Label_3912;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    final cy a4 = array[bv.b].a(bv);
                    final cy a5 = array[bv.b + 1 & 0x3].a(bv);
                    final cy a6 = array[bv.c].a(bv);
                    Label_3547: {
                        switch (bv.b) {
                            default: {
                                final double n20 = am.getX() + am.getWidth() * 0.5 + t.a;
                                final double n21 = am.getX() + am.getWidth() * 0.5 + t2.a;
                                final t t27 = new t(n20, am.getY() - a4.d + (a4.p - a4.b));
                                d.add(t27);
                                final t t28 = new t(n20 + (a4.p - a4.b), am.getY() - a4.d);
                                d.add(t28);
                                d.add(new t(n2 + a5.d - (a4.p - a4.b), t28.b));
                                final t t29 = new t(n2 + a5.d, t27.b);
                                d.add(t29);
                                final t t30 = new t(t29.a, n3 + a6.d - (a6.c - a6.q));
                                d.add(t30);
                                final t t31 = new t(t30.a - (a6.c - a6.q), n3 + a6.d);
                                d.add(t31);
                                d.add(new t(n21 + (a6.c - a6.q), t31.b));
                                d.add(new t(n21, t30.b));
                                if (x) {
                                    break Label_3547;
                                }
                                break Label_3912;
                            }
                            case 1: {
                                final double n22 = am.getY() + am.getHeight() * 0.5 + t.b;
                                final double n23 = am.getY() + am.getHeight() * 0.5 + t2.b;
                                final t t32 = new t(n2 + a4.d - (a4.p - a4.b), n22);
                                d.add(t32);
                                final t t33 = new t(n2 + a4.d, n22 + (a4.p - a4.b));
                                d.add(t33);
                                d.add(new t(t33.a, n3 + a5.d - (a4.p - a4.b)));
                                final t t34 = new t(t32.a, n3 + a5.d);
                                d.add(t34);
                                final t t35 = new t(am.getX() - a6.d + (a6.c - a6.q), t34.b);
                                d.add(t35);
                                final t t36 = new t(am.getX() - a6.d, t35.b - (a6.c - a6.q));
                                d.add(t36);
                                d.add(new t(t36.a, n23 + (a6.c - a6.q)));
                                d.add(new t(t35.a, n23));
                                if (x) {
                                    break Label_3547;
                                }
                                break Label_3912;
                            }
                            case 2: {
                                final double n24 = am.getX() + am.getWidth() * 0.5 + t.a;
                                final double n25 = am.getX() + am.getWidth() * 0.5 + t2.a;
                                final t t37 = new t(n24, n3 + a4.d - (a4.p - a4.b));
                                d.add(t37);
                                final t t38 = new t(n24 - (a4.p - a4.b), n3 + a4.d);
                                d.add(t38);
                                d.add(new t(am.getX() - a5.d + (a4.p - a4.b), t38.b));
                                final t t39 = new t(am.getX() - a5.d, t37.b);
                                d.add(t39);
                                final t t40 = new t(t39.a, am.getY() - a6.d + (a6.c - a6.q));
                                d.add(t40);
                                final t t41 = new t(t40.a + (a6.c - a6.q), am.getY() - a6.d);
                                d.add(t41);
                                d.add(new t(n25 - (a6.c - a6.q), t41.b));
                                d.add(new t(n25, t40.b));
                                if (x) {
                                    break Label_3547;
                                }
                                break Label_3912;
                            }
                            case 3: {
                                final double n26 = am.getY() + am.getHeight() * 0.5 + t.b;
                                final double n27 = am.getY() + am.getHeight() * 0.5 + t2.b;
                                final t t42 = new t(am.getX() - a4.d + (a4.p - a4.b), n26);
                                d.add(t42);
                                final t t43 = new t(am.getX() - a4.d, n26 - (a4.p - a4.b));
                                d.add(t43);
                                d.add(new t(t43.a, am.getY() - a5.d + (a4.p - a4.b)));
                                final t t44 = new t(t42.a, am.getY() - a5.d);
                                d.add(t44);
                                final t t45 = new t(n2 + a6.d - (a6.c - a6.q), t44.b);
                                d.add(t45);
                                final t t46 = new t(n2 + a6.d, t45.b + (a6.c - a6.q));
                                d.add(t46);
                                d.add(new t(t46.a, n27 - (a6.c - a6.q)));
                                d.add(new t(t45.a, n27));
                                if (x) {
                                    break Label_3912;
                                }
                                break Label_3912;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    final cy a7 = array[bv.b].a(bv);
                    final cy a8 = array[bv.c].a(bv);
                    Label_4863: {
                        switch (bv.b) {
                            default: {
                                final double n28 = am.getX() + am.getWidth() * 0.5 + t.a;
                                final double n29 = am.getY() + am.getHeight() * 0.5 + t2.b;
                                d.add(new t(n28, am.getY() - a7.d + (a7.p - a7.b)));
                                final t t47 = new t(n28 - (a7.p - a7.b), am.getY() - a7.d);
                                d.add(t47);
                                final t t48 = new t(am.getX() - a8.d + (a8.c - a8.q), t47.b);
                                d.add(t48);
                                final t t49 = new t(am.getX() - a8.d, t48.b + (a8.c - a8.q));
                                d.add(t49);
                                final t t50 = new t(t49.a, n29 - (a8.c - a8.q));
                                d.add(t50);
                                d.add(new t(t50.a + (a8.c - a8.q), n29));
                                if (x) {
                                    break Label_4863;
                                }
                                break Label_3912;
                            }
                            case 1: {
                                final double n30 = am.getY() + am.getHeight() * 0.5 + t.b;
                                final double n31 = am.getX() + am.getWidth() * 0.5 + t2.a;
                                d.add(new t(n2 + a7.d - (a7.p - a7.b), n30));
                                final t t51 = new t(n2 + a7.d, n30 - (a7.p - a7.b));
                                d.add(t51);
                                final t t52 = new t(t51.a, am.getY() - a8.d + (a8.c - a8.q));
                                d.add(t52);
                                final t t53 = new t(t52.a - (a8.c - a8.q), am.getY() - a8.d);
                                d.add(t53);
                                final t t54 = new t(n31 + (a8.c - a8.q), t53.b);
                                d.add(t54);
                                d.add(new t(n31, t54.b + (a8.c - a8.q)));
                                if (x) {
                                    break Label_4863;
                                }
                                break Label_3912;
                            }
                            case 2: {
                                final double n32 = am.getX() + am.getWidth() * 0.5 + t.a;
                                final double n33 = am.getY() + am.getHeight() * 0.5 + t2.b;
                                d.add(new t(n32, n3 + a7.d - (a7.p - a7.b)));
                                final t t55 = new t(n32 + (a7.p - a7.b), n3 + a7.d);
                                d.add(t55);
                                final t t56 = new t(n2 + a8.d - (a8.c - a8.q), t55.b);
                                d.add(t56);
                                final t t57 = new t(n2 + a8.d, t56.b - (a8.c - a8.q));
                                d.add(t57);
                                final t t58 = new t(t57.a, n33 + (a8.c - a8.q));
                                d.add(t58);
                                d.add(new t(t58.a - (a8.c - a8.q), n33));
                                if (x) {
                                    break Label_4863;
                                }
                                break Label_3912;
                            }
                            case 3: {
                                final double n34 = am.getY() + am.getHeight() * 0.5 + t.b;
                                final double n35 = am.getX() + am.getWidth() * 0.5 + t2.a;
                                d.add(new t(am.getX() - a7.d + (a7.p - a7.b), n34));
                                final t t59 = new t(am.getX() - a7.d, n34 + (a7.p - a7.b));
                                d.add(t59);
                                final t t60 = new t(t59.a, n3 + a8.d - (a8.c - a8.q));
                                d.add(t60);
                                final t t61 = new t(t60.a + (a8.c - a8.q), n3 + a8.d);
                                d.add(t61);
                                final t t62 = new t(n35 - (a8.c - a8.q), t61.b);
                                d.add(t62);
                                d.add(new t(n35, t62.b - (a8.c - a8.q)));
                                break Label_3912;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return d;
    }
    
    static final t a(final am am, final t t, final int n, final double n2) {
        switch (n) {
            default: {
                return new t(t.a + am.getX() + am.getWidth() * 0.5, am.getY() - n2);
            }
            case 1: {
                return new t(am.getX() + am.getWidth() + n2, am.getY() + am.getHeight() * 0.5 + t.b);
            }
            case 2: {
                return new t(t.a + am.getX() + am.getWidth() * 0.5, am.getY() + am.getHeight() + n2);
            }
            case 3: {
                return new t(am.getX() - n2, am.getY() + am.getHeight() * 0.5 + t.b);
            }
        }
    }
    
    static {
        g = Math.sqrt(2.0);
        a = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_NODE_DISTANCE_DPKEY";
        b = "y.layout.hierarchic.incremental.SelfloopCalculator.IS_OCTILINEAR_DPKEY";
        c = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_OCTILINEAR_SEGMENT_LENGTH_DPKEY";
        d = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_FIRST_SEGMENT_LENGTH_DPKEY";
        e = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_LAST_SEGMENT_LENGTH_DPKEY";
        f = "y.layout.hierarchic.incremental.SelfloopCalculator.MINIMUM_EDGE_DISTANCE_DPKEY";
    }
}
