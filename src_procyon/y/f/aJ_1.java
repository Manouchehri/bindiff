package y.f;

import java.util.*;
import y.d.*;

public class aJ implements E
{
    private int a;
    private double b;
    private double c;
    private boolean d;
    private boolean e;
    private boolean f;
    private static final z g;
    
    public aJ() {
        this(63);
    }
    
    public aJ(final int a) {
        this.a = 63;
        this.b = 2.0;
        this.d = true;
        this.e = false;
        this.f = false;
        this.a = a;
    }
    
    public int a() {
        return this.a;
    }
    
    public boolean b() {
        return this.e;
    }
    
    public void a(final double n) {
        this.b = Math.abs(n);
    }
    
    public Object c() {
        if ((this.a & 0x80) != 0x0) {
            return new aK(128);
        }
        if ((this.a & 0x40) != 0x0) {
            return new aK(64);
        }
        if ((this.a & 0x10) != 0x0) {
            return new aK(16);
        }
        if ((this.a & 0x8) != 0x0) {
            return new aK(8);
        }
        return new aK(128);
    }
    
    private Object[] d() {
        final ArrayList list = new ArrayList<aK>();
        list.add(new aK(1));
        list.add(new aK(2));
        list.add(new aK(4));
        list.add(new aK(8));
        list.add(new aK(16));
        list.add(new aK(32));
        list.add(new aK(64));
        list.add(new aK(128));
        list.add(new aK(256));
        return list.toArray();
    }
    
    public Object a(final n n, final I i, final am am, final am am2) {
        if (ae.a(n)) {
            throw new IllegalArgumentException("Invalid label bounds: " + n);
        }
        final D d = new D();
        d.a(n);
        final y.c.D a = this.a(d, i, am, am2);
        if (a.isEmpty()) {
            return this.c();
        }
        return aW.a(a, n.k()).b();
    }
    
    public static Object a(final int n) {
        switch (n) {
            case 1:
            case 2:
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 256: {
                return new aK(n);
            }
            default: {
                throw new IllegalArgumentException("Invalid position: " + n);
            }
        }
    }
    
    public static int a(final Object o) {
        try {
            return ((aK)o).a();
        }
        catch (ClassCastException ex) {
            throw new IllegalArgumentException("Invalid model parameter type.");
        }
    }
    
    public boolean b(final Object o) {
        return o instanceof aK && (this.a() & ((aK)o).a()) != 0x0;
    }
    
    public n a(final q q, final I i, final am am, final am am2, final Object o) {
        return this.a(q, i, am, am2, aK.a((aK)((o instanceof aK) ? o : this.c())));
    }
    
    public y.c.D a(final C c, final I i, final am am, final am am2) {
        final boolean j = X.j;
        final y.c.D d = new y.c.D();
        final Object[] d2 = this.d();
        int k = 0;
        while (k < d2.length) {
            final int a = aK.a((aK)d2[k]);
            if ((this.a & a) != 0x0) {
                boolean b = false;
                Label_0099: {
                    if (a == 128) {
                        b = true;
                        if (!j) {
                            break Label_0099;
                        }
                    }
                    if (a == 64) {
                        b = true;
                        if (!j) {
                            break Label_0099;
                        }
                    }
                    if (a == 256) {
                        b = true;
                    }
                }
                d.add(new B(this.a(c.getOrientedBox().d(), i, am, am2, a), d2[k], c, b));
            }
            ++k;
            if (j) {
                break;
            }
        }
        return d;
    }
    
    protected n a(final q q, final I i, final am am, final am am2, final int n) {
        final boolean j = X.j;
        final n n2 = new n(new t(0.0, 0.0), q);
        n2.a(6.283185307179586 - this.c);
        final t[] f = ae.a(i, am, am2, 0.0).f();
        if (f.length < 2) {
            final y h = n2.h();
            n2.e(am.getX() + h.a * 0.5, am.getY() - h.b * 0.5);
            if (this.b()) {
                ae.b(n2);
            }
            return n2;
        }
        if (f.length == 2 && t.a(f[0], f[1]) < 1.0E-4) {
            n2.e(f[0].a, f[0].b);
            if (this.b()) {
                ae.b(n2);
            }
            return n2;
        }
        int n3 = 0;
        double n4 = 0.0;
        int k = 0;
        while (true) {
            while (k < f.length - 1) {
                final double n5 = n4 + t.a(f[k], f[k + 1]);
                if (j) {
                    final double n6 = n5;
                    double n7 = 0.0;
                    int l = 0;
                    while (true) {
                        while (l < f.length - 1) {
                            n7 += t.a(f[l], f[l + 1]);
                            final double n8 = dcmpl(n7, n6);
                            if (j) {
                                Label_0364: {
                                    if (n8 == 2 || n == 128 || n == 16) {
                                        l = n3;
                                        if (!j) {
                                            break Label_0364;
                                        }
                                    }
                                    if (n == 4 || n == 256 || n == 32) {
                                        l = f.length - 2;
                                    }
                                }
                                final t t = f[l];
                                t t2 = f[l + 1];
                                Label_0605: {
                                    if (t.equals(t2)) {
                                        final double n9 = am.getX() + am.getWidth() * 0.5 + i.getSourcePoint().a - (am2.getX() + am2.getWidth() * 0.5 + i.getTargetPoint().a);
                                        final double n10 = am.getY() + am.getHeight() * 0.5 + i.getSourcePoint().b - (am2.getY() + am2.getHeight() * 0.5 + i.getTargetPoint().b);
                                        if (n9 == 0.0 && n10 == 0.0) {
                                            t2 = new t(t.a + 1.0E-4, t.b);
                                            if (!j) {
                                                break Label_0605;
                                            }
                                        }
                                        final double sqrt = Math.sqrt(n9 * n9 + n10 * n10);
                                        t2 = new t(t.a + 1.0E-4 * n9 / sqrt, t.b + 1.0E-4 * n10 / sqrt);
                                    }
                                }
                                if (this.d) {
                                    n2.a(b(z.d(new z(t2, t), new z(1.0, 0.0)) - this.c));
                                }
                                final m m = new m(t, t2);
                                Label_0873: {
                                    if (n == 1 || n == 64 || n == 8) {
                                        if (a(am, t, 5.0)) {
                                            this.b(n2, m, am, n, l == n3);
                                            if (!j) {
                                                break Label_0873;
                                            }
                                        }
                                        this.a(n2, m, t, n);
                                        if (!j) {
                                            break Label_0873;
                                        }
                                    }
                                    if (n == 4 || n == 256 || n == 32) {
                                        if (a(am2, t2, 5.0)) {
                                            this.a(n2, m, am2, n, l == n3);
                                            if (!j) {
                                                break Label_0873;
                                            }
                                        }
                                        this.a(n2, m, t2, n);
                                        if (!j) {
                                            break Label_0873;
                                        }
                                    }
                                    this.a(n2, m, new t((t.a + t2.a) / 2.0, (t.b + t2.b) / 2.0), n);
                                }
                                if (this.b()) {
                                    ae.b(n2);
                                }
                                return n2;
                            }
                            if (n8 > 0) {
                                n3 = l;
                                if (!j) {
                                    break;
                                }
                            }
                            ++l;
                            if (j) {
                                break;
                            }
                        }
                        l = 0;
                        continue;
                    }
                }
                n4 = n5;
                ++k;
                if (j) {
                    break;
                }
            }
            continue;
        }
    }
    
    private static boolean a(final am am, final t t, final double n) {
        return am.getX() - n < t.a && am.getX() + am.getWidth() + n > t.a && am.getY() - n < t.b && am.getY() + am.getHeight() + n > t.b;
    }
    
    private static double b(double n) {
        final boolean j = X.j;
        if (n < 0.0) {
            n += 6.283185307179586;
        }
        double n2 = 0.0;
        while (n > 6.283185307179586) {
            n2 = n - 6.283185307179586;
            if (j) {
                return n2;
            }
            n = n2;
            if (j) {
                break;
            }
        }
        return n2;
    }
    
    private static byte a(final m m) {
        final double d = z.d(m.i(), aJ.g);
        if (d >= 0.7853981633974483 && d < 2.356194490192345) {
            return 0;
        }
        if (d >= 2.356194490192345 && d < 3.9269908169872414) {
            return 2;
        }
        if (d >= 3.9269908169872414 && d < 5.497787143782138) {
            return 1;
        }
        return 3;
    }
    
    private static byte b(final m m) {
        final double d = z.d(m.i(), aJ.g);
        if (d >= 0.7853981633974483 && d < 2.356194490192345) {
            if (d <= 1.5707963267948966) {
                return 3;
            }
            return 2;
        }
        else if (d >= 2.356194490192345 && d < 3.9269908169872414) {
            if (d <= 3.141592653589793) {
                return 0;
            }
            return 1;
        }
        else if (d >= 3.9269908169872414 && d < 5.497787143782138) {
            if (d <= 4.71238898038469) {
                return 2;
            }
            return 3;
        }
        else {
            if (d <= 3.141592653589793) {
                return 0;
            }
            return 1;
        }
    }
    
    private void a(final n n, final m m, final t t, final int n2) {
        final boolean j = X.j;
        if (n2 == 128 || n2 == 256 || n2 == 64) {
            n.e(t.a, t.b);
            if (!j) {
                return;
            }
        }
        z c = z.c(m.i());
        Label_0196: {
            if (this.f) {
                if (n2 != 16 && n2 != 8 && n2 != 32) {
                    break Label_0196;
                }
                c = new z(-c.a(), -c.b());
                if (!j) {
                    break Label_0196;
                }
            }
            final double d = z.d(aJ.g, c);
            if ((d >= 3.141592653589793 && (n2 == 16 || n2 == 32 || n2 == 8)) || (d < 3.141592653589793 && (n2 == 2 || n2 == 1 || n2 == 4))) {
                c = new z(-c.a(), -c.b());
            }
        }
        c.b(this.b + n.e() + n.f());
        final t a = z.a(t, c);
        n.e(a.a, a.b);
        final t[] a2 = n.a(n);
        double min = Double.MAX_VALUE;
        int i = 0;
        while (i < a2.length) {
            min = Math.min(min, a(m, a2[i]));
            ++i;
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        final z z = new z(-c.a(), -c.b());
        z.c();
        z.b(min - this.b);
        final t a3 = y.d.z.a(a, z);
        n.e(a3.a, a3.b);
    }
    
    private void a(final n n, final m m, final am am, final int n2, final boolean b) {
        this.a(n, m.d(), m.c(), am, n2, false, b);
    }
    
    private void b(final n n, final m m, final am am, final int n2, final boolean b) {
        this.a(n, m.c(), m.d(), am, n2, true, b);
    }
    
    private void a(final n n, final t t, final t t2, final am am, final int n2, final boolean b, final boolean b2) {
        final y y = new y(am.getX(), am.getY(), am.getWidth(), am.getHeight());
        final m m = new m(t, t2);
        final byte a = a(m);
        final t a2 = this.a(a, m, n, am, n2, b, b2);
        n.a(a2);
        final double a3 = aV.a(y, n);
        final y h = n.h();
        if (Math.abs(t.a - t2.a) > 1.0E-4 && Math.abs(t.b - t2.b) > 1.0E-4 && (a3 < 2.5 || a3 > 6.0) && (((a == 0 || a == 1) && (t2.a < y.c() - 5.0 - h.a * 0.5 || t2.a > y.c() + y.a() + 5.0 + h.a * 0.5)) || ((a == 2 || a == 3) && (t2.b < y.d() - 5.0 - h.b * 0.5 || t2.b > y.d() + y.b() + 5.0 + h.b * 0.5)))) {
            n.a(this.a(b(m), m, n, am, n2, b, b2));
            final double a4 = aV.a(y, n);
            if (a4 < 2.5 || (a4 > a3 && a3 > 2.5)) {
                n.a(a2);
            }
        }
    }
    
    private t a(final byte b, final m m, final n n, final am am, final int n2, final boolean b2, final boolean b3) {
        final boolean j = X.j;
        final n n3 = new n(n);
        final t c = m.c();
        final t d = m.d();
        final double d2 = z.d(m.i(), aJ.g);
        final y h = n3.h();
        Label_1212: {
            if (b == 0) {
                boolean b4 = false;
                Label_0142: {
                    if (this.f) {
                        b4 = ((b2 && n2 == 1) || (!b2 && n2 == 4));
                        if (!j) {
                            break Label_0142;
                        }
                    }
                    b4 = (((n2 == 1 || n2 == 4) && d2 <= 1.5707963267948966) || ((n2 == 8 || n2 == 32) && d2 > 1.5707963267948966));
                }
                double b5 = am.getY() - 5.0 - h.b() * 0.5;
                if (b5 < d.b) {
                    b5 = d.b;
                }
                n3.e(b4 ? (Math.min(c.a, d.a) - h.a) : (Math.max(c.a, d.a) + h.a), b5);
                final t t = (n2 == 64 || n2 == 256) ? n3.k() : a(n.a(n3), m);
                n3.d(a(m, t, 1.0, 0.0).a - t.a, 0.0);
                if (n2 == 64 || n2 == 256) {
                    break Label_1212;
                }
                n3.d(b4 ? (-this.b) : this.b, 0.0);
                if (!j) {
                    break Label_1212;
                }
            }
            if (b == 1) {
                boolean b6 = false;
                Label_0447: {
                    if (this.f) {
                        b6 = ((b2 && n2 == 8) || (!b2 && n2 == 32));
                        if (!j) {
                            break Label_0447;
                        }
                    }
                    b6 = (((n2 == 8 || n2 == 32) && d2 > 4.71238898038469) || ((n2 == 1 || n2 == 4) && d2 <= 4.71238898038469));
                }
                double b7 = am.getY() + am.getHeight() + 5.0 + h.b() * 0.5;
                if (b7 > d.b) {
                    b7 = d.b;
                }
                n3.e(b6 ? (Math.min(c.a, d.a) - h.a) : (Math.max(c.a, d.a) + h.a), b7);
                final t t2 = (n2 == 64 || n2 == 256) ? n3.k() : a(n.a(n3), m);
                n3.d(a(m, t2, 1.0, 0.0).a - t2.a, 0.0);
                if (n2 == 64 || n2 == 256) {
                    break Label_1212;
                }
                n3.d(b6 ? (-this.b) : this.b, 0.0);
                if (!j) {
                    break Label_1212;
                }
            }
            if (b == 2) {
                boolean b8 = false;
                Label_0728: {
                    if (this.f) {
                        b8 = ((b2 && n2 == 1) || (!b2 && n2 == 4));
                        if (!j) {
                            break Label_0728;
                        }
                    }
                    b8 = (n2 == 8 || n2 == 32);
                }
                double a = am.getX() - 5.0 - h.a() * 0.5;
                if (a < d.a) {
                    a = d.a;
                }
                n3.e(a, b8 ? (Math.max(c.b, d.b) + h.b) : (Math.min(c.b, d.b) - h.b));
                final t t3 = (n2 == 64 || n2 == 256) ? n3.k() : a(n.a(n3), m);
                n3.d(0.0, a(m, t3, 0.0, 1.0).b - t3.b);
                if (n2 == 64 || n2 == 256) {
                    break Label_1212;
                }
                n3.d(0.0, b8 ? this.b : (-this.b));
                if (!j) {
                    break Label_1212;
                }
            }
            if (b == 3) {
                boolean b9 = false;
                Label_1003: {
                    if (this.f) {
                        b9 = ((b2 && n2 == 8) || (!b2 && n2 == 32));
                        if (!j) {
                            break Label_1003;
                        }
                    }
                    b9 = (n2 == 8 || n2 == 32);
                }
                double a2 = am.getX() + am.getWidth() + 5.0 + h.a() * 0.5;
                if (a2 > d.a) {
                    a2 = d.a;
                }
                n3.e(a2, b9 ? (Math.max(c.b, d.b) + h.b) : (Math.min(c.b, d.b) - h.b));
                final t t4 = (n2 == 64 || n2 == 256) ? n3.k() : a(n.a(n3), m);
                n3.d(0.0, a(m, t4, 0.0, 1.0).b - t4.b);
                if (n2 != 64 && n2 != 256) {
                    n3.d(0.0, b9 ? this.b : (-this.b));
                }
            }
        }
        if (b3 && t.a(n3.k(), c) > t.a(n3.k(), d)) {
            int n4 = 128;
            Label_1271: {
                if (n2 <= 4) {
                    n4 = 2;
                    if (!j) {
                        break Label_1271;
                    }
                }
                if (n2 <= 32) {
                    n4 = 16;
                }
            }
            this.a(n3, m, new t((c.a + d.a) / 2.0, (c.b + d.b) / 2.0), n4);
        }
        return n3.a();
    }
    
    private static t a(final t[] array, final m m) {
        final boolean j = X.j;
        double n = Double.MAX_VALUE;
        t t = null;
        int i = 0;
        while (i < array.length) {
            final double a = a(m, array[i]);
            if (a < n) {
                t = array[i];
                n = a;
            }
            ++i;
            if (j) {
                break;
            }
        }
        return t;
    }
    
    private static double a(final m m, final t t) {
        final t c = m.c();
        final t d = m.d();
        final double n = d.a - c.a;
        final double n2 = d.b - c.b;
        final double n3 = t.a - c.a;
        final double n4 = t.b - c.b;
        final double n5 = n3 * n + n4 * n2;
        double n6 = n3 * n3 + n4 * n4 - n5 * n5 / (n * n + n2 * n2);
        if (n6 < 0.0) {
            n6 = 0.0;
        }
        return Math.sqrt(n6);
    }
    
    private static t a(final m m, final t t, final double n, final double n2) {
        final t d = m.d();
        final t c = m.c();
        final double a = t.a();
        final double b = t.b();
        return e.a(d.a(), d.b(), c.a(), c.b(), a, b, a + n, b + n2);
    }
    
    static {
        g = new z(1.0, 0.0);
    }
}
