package y.f.i;

import java.awt.geom.*;
import y.f.*;
import java.util.*;
import y.d.*;
import y.c.*;

class ah
{
    public static Rectangle2D a(final X x, final q q, final y y, final byte b) {
        final int f = v.f;
        final Rectangle2D a = ae.a(x, y.a());
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        Label_0339: {
            switch (b) {
                case 1: {
                    final double min = Math.min(x.m(q), a.getX());
                    final double n = a.getY() + a.getHeight();
                    double1.setFrame(min, n, Math.max(x.m(q) + x.p(q), a.getX() + a.getWidth()) - min, x.n(q) - n);
                    if (f != 0) {
                        break Label_0339;
                    }
                    break;
                }
                case 2: {
                    final double min2 = Math.min(x.m(q), a.getX());
                    final double n2 = x.n(q) + x.q(q);
                    double1.setFrame(min2, n2, Math.max(x.m(q) + x.p(q), a.getX() + a.getWidth()) - min2, a.getY() - n2);
                    if (f != 0) {
                        break Label_0339;
                    }
                    break;
                }
                case 8: {
                    final double n3 = a.getX() + a.getWidth();
                    final double min3 = Math.min(a.getY(), x.n(q));
                    double1.setFrame(n3, min3, x.m(q) - (a.getX() + a.getWidth()), Math.max(x.n(q) + x.q(q), a.getY() + a.getHeight()) - min3);
                    if (f != 0) {
                        break Label_0339;
                    }
                    break;
                }
                case 4: {
                    final double n4 = x.m(q) + x.p(q);
                    final double min4 = Math.min(a.getY(), x.n(q));
                    double1.setFrame(n4, min4, a.getX() - n4, Math.max(x.n(q) + x.q(q), a.getY() + a.getHeight()) - min4);
                    break;
                }
            }
        }
        return double1;
    }
    
    public static y a(final X x, final q q, final y y, final byte b, final double n) {
        final int f = v.f;
        final am h = x.h(q);
        final double x2 = h.getX();
        final double y2 = h.getY();
        final double n2 = x2 + h.getWidth();
        final double n3 = y2 + h.getHeight();
        final y y3 = new y();
        final x a = y.a();
        while (a.f()) {
            final q e = a.e();
            final am h2 = x.h(e);
            Label_0247: {
                switch (b) {
                    case 1: {
                        if (y2 - n < h2.getY() + h2.getHeight()) {
                            break;
                        }
                        y3.add(e);
                        if (f != 0) {
                            break Label_0247;
                        }
                        break;
                    }
                    case 2: {
                        if (n3 + n > h2.getY()) {
                            break;
                        }
                        y3.add(e);
                        if (f != 0) {
                            break Label_0247;
                        }
                        break;
                    }
                    case 8: {
                        if (x2 - n < h2.getX() + h2.getWidth()) {
                            break;
                        }
                        y3.add(e);
                        if (f != 0) {
                            break Label_0247;
                        }
                        break;
                    }
                    case 4: {
                        if (n2 + n <= h2.getX()) {
                            y3.add(e);
                            break;
                        }
                        break;
                    }
                }
            }
            a.g();
            if (f != 0) {
                break;
            }
        }
        return y3;
    }
    
    private static ax a(final d d, final boolean b, final i i) {
        final int f = v.f;
        final c c = i.c(b ? ax.a : ax.b);
        if (c == null || c.b(d) == null) {
            return null;
        }
        final Collection collection = (Collection)c.b(d);
        if (collection.isEmpty()) {
            return null;
        }
        ax ax = null;
        ax ax3 = null;
        for (final ax ax2 : collection) {
            if (ax == null) {
                ax = ax2;
            }
            if (!ax2.b()) {
                ax3 = ax2;
                if (f == 0) {
                    ax = ax3;
                    break;
                }
                return ax3;
            }
        }
        return ax3;
    }
    
    private static boolean a(final ax ax) {
        return ax.a(4) && ax.a(8) && ax.a(1) && ax.a(2);
    }
    
    public static byte a(final X x, final q q, final f f) {
        final int f2 = v.f;
        final am h = x.h(q);
        final double x2 = h.getX();
        final double y = h.getY();
        final double n = x2 + h.getWidth();
        final double n2 = y + h.getHeight();
        final double[] array = new double[4];
        final ax a = a(f.b(), false, x);
        if (a != null && !a(a)) {
            if (a.a(1)) {
                final double[] array2 = array;
                final int n3 = 0;
                ++array2[n3];
            }
            if (a.a(4)) {
                final double[] array3 = array;
                final int n4 = 1;
                ++array3[n4];
            }
            if (a.a(8)) {
                final double[] array4 = array;
                final int n5 = 2;
                ++array4[n5];
            }
            if (a.a(4)) {
                final double[] array5 = array;
                final int n6 = 3;
                ++array5[n6];
            }
        }
        final e a2 = f.a();
    Label_0448_Outer:
        while (true) {
            while (true) {
                while (a2.f()) {
                    final d a3 = a2.a();
                    final ax a4 = a(a3, true, x);
                    if (f2 != 0) {
                        final double[] array6 = array;
                        final int n7 = 1;
                        array6[n7] += 0.5;
                        double n8 = array[0];
                        byte b = 1;
                        if (array[1] > n8) {
                            n8 = array[1];
                            b = 2;
                        }
                        if (array[2] > n8) {
                            n8 = array[2];
                            b = 8;
                        }
                        if (array[3] > n8) {
                            final double n9 = array[3];
                            b = 4;
                        }
                        return b;
                    }
                    if (a4 != null && !a(a4)) {
                        if (a4.a(2)) {
                            final double[] array7 = array;
                            final int n10 = 0;
                            ++array7[n10];
                        }
                        if (a4.a(1)) {
                            final double[] array8 = array;
                            final int n11 = 1;
                            ++array8[n11];
                        }
                        if (a4.a(4)) {
                            final double[] array9 = array;
                            final int n12 = 2;
                            ++array9[n12];
                        }
                        if (a4.a(8)) {
                            final double[] array10 = array;
                            final int n13 = 3;
                            ++array10[n13];
                        }
                    }
                    final am h2 = x.h(a3.c());
                    if (h2.getY() + h2.getHeight() < y) {
                        final double[] array11 = array;
                        final int n14 = 0;
                        ++array11[n14];
                    }
                    if (h2.getY() > n2) {
                        final double[] array12 = array;
                        final int n15 = 1;
                        ++array12[n15];
                    }
                    if (h2.getX() + h2.getWidth() < x2) {
                        final double[] array13 = array;
                        final int n16 = 2;
                        ++array13[n16];
                    }
                    if (h2.getX() > n) {
                        final double[] array14 = array;
                        final int n17 = 3;
                        ++array14[n17];
                    }
                    a2.g();
                    if (f2 != 0) {
                        break;
                    }
                }
                if (a(x, f)) {
                    final double[] array15 = array;
                    final int n18 = 2;
                    array15[n18] += 0.5;
                    final double[] array16 = array;
                    final int n19 = 3;
                    array16[n19] += 0.5;
                    if (f2 == 0) {
                        continue;
                    }
                }
                break;
            }
            final double[] array17 = array;
            final int n20 = 0;
            array17[n20] += 0.5;
            continue Label_0448_Outer;
        }
    }
    
    static boolean a(final X x, final f f) {
        final int f2 = v.f;
        double n = 0.0;
        double n2 = 0.0;
        final e a = f.a();
        while (true) {
            while (a.f()) {
                final d a2 = a.a();
                n += x.j(a2.c());
                n2 += x.k(a2.c());
                a.g();
                if (f2 == 0) {
                    if (f2 != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    double n3 = 0.0;
                    double n4 = 0.0;
                    final e a3 = f.a();
                    while (a3.f()) {
                        final double n5 = n - x.j(a3.a().c());
                        n3 += n5 * n5;
                        final double n6 = n2 - x.k(a3.a().c());
                        n4 += n6 * n6;
                        a3.g();
                        if (f2 != 0) {
                            return false;
                        }
                        if (f2 != 0) {
                            break;
                        }
                    }
                    if (n4 > n3) {
                        return true;
                    }
                    return false;
                }
            }
            n /= f.size();
            n2 /= f.size();
            continue;
        }
    }
    
    public static boolean a(final t t, final t t2) {
        return t.a == t2.a;
    }
    
    public static boolean b(final t t, final t t2) {
        return t.b == t2.b;
    }
    
    public static byte a(final X x, final q q, final D d) {
        final t t = (t)d.a(0);
        if (t.a == ((t)d.a(1)).a) {
            if (t.b < x.k(q)) {
                return 1;
            }
            return 2;
        }
        else {
            if (t.a < x.j(q)) {
                return 8;
            }
            return 4;
        }
    }
}
