package y.f;

import java.util.*;
import y.d.*;
import java.awt.geom.*;
import y.c.*;

public class aN extends a
{
    private f b;
    public static final Object a;
    private byte c;
    private boolean d;
    private double e;
    private int f;
    private Map g;
    private int h;
    private int i;
    private int n;
    private int o;
    private boolean p;
    
    public aN() {
        this.c = 0;
        this.d = true;
        this.e = 5.0;
        this.f = 2;
        this.h = 0;
        this.i = 1;
        this.n = 2;
        this.o = 3;
        this.b = new f();
    }
    
    public aN(final ah ah) {
        this();
        this.a(ah);
    }
    
    public void a(final boolean d) {
        this.d = d;
    }
    
    public void a(final byte c) {
        this.c = c;
    }
    
    public void c(final X x) {
        final boolean j = X.j;
        Label_0128: {
            Label_0123: {
                if (x.c(aN.a) != null || this.p) {
                    this.g = new HashMap();
                    final x o = x.o();
                    while (o.f()) {
                        this.g.put(o.e(), x.l(o.e()));
                        o.g();
                        if (j) {
                            break Label_0123;
                        }
                        if (j) {
                            break;
                        }
                    }
                }
                if (this.a() != null) {
                    this.d(x);
                    this.a(x);
                    this.e(x);
                    this.b(x);
                    if (!j) {
                        break Label_0128;
                    }
                }
            }
            this.b(x);
        }
        this.g = null;
    }
    
    private D a(final int n, final t t, final double n2, final boolean b, final int n3) {
        final boolean j = X.j;
        final D d = new D();
        int n4 = 0;
        Label_0078: {
            if (n == this.h) {
                n4 = 3 * (n3 - 1);
                if (!j) {
                    break Label_0078;
                }
            }
            if (n == this.i) {
                n4 = 2 * (n3 - 1);
                if (!j) {
                    break Label_0078;
                }
            }
            if (n == this.n) {
                n4 = n3 - 1;
                if (!j) {
                    break Label_0078;
                }
            }
            n4 = 0;
        }
        final double n5 = 3.141592653589793 / (2 * (n3 - 1));
        D d2 = null;
        Label_0176: {
            if (b) {
                int i = n4;
                while (i < n4 + n3) {
                    final double n6 = Math.cos(i * n5) * n2 + t.a();
                    final double n7 = Math.sin(i * n5) * n2 + t.b();
                    d2 = d;
                    if (j) {
                        break;
                    }
                    d2.add(new t(n6, n7));
                    ++i;
                    if (j) {
                        break Label_0176;
                    }
                }
                return d2;
            }
        }
        int k = n4 + n3 - 1;
        while (k >= n4) {
            final double n8 = Math.cos(k * n5) * n2 + t.a();
            final double n9 = Math.sin(k * n5) * n2 + t.b();
            final D d3 = d;
            if (j) {
                break;
            }
            d3.add(new t(n8, n9));
            --k;
            if (j) {
                break;
            }
        }
        return d2;
    }
    
    protected void b(final X x) {
        final boolean j = X.j;
        x x2 = null;
        boolean e = false;
        t l;
        t t;
        boolean equals = false;
        double n;
        double n2;
        e k;
        D i;
        p p;
        t t2;
        q e2;
        f f;
        e m;
        d a;
        boolean e3;
        int size;
        d[] e4;
        am h;
        double x3;
        double y;
        double n3;
        double n4;
        double n5;
        double n6;
        double min;
        double min2;
        double min3;
        double n7;
        double n8;
        byte c;
        byte c2 = 0;
        boolean b = false;
        double n9;
        double n10;
        double n11;
        double n12;
        int a2;
        int n13;
        d d;
        t[] array;
        double n14;
        D d2;
        double n15;
        D d3;
        int n16;
        d d4;
        byte c3;
        boolean b2;
        t[] array2;
        double n17;
        D d5;
        double n18;
        D d6;
        int n19;
        d d7;
        byte c4;
        boolean b3;
        t[] array3;
        double n20;
        D d8;
        double n21;
        D d9;
        int n22;
        d d10;
        byte c5;
        boolean b4;
        t[] array4;
        double n23;
        D d11;
        double n24;
        D d12;
        Label_0294:Label_0392_Outer:
        while (true) {
            Label_0300: {
                if (this.g != null || this.p) {
                    x2 = x.o();
                    do {
                        Label_0024: {
                            x2.f();
                        }
                        Label_0030:
                        while (e) {
                            l = x.l(x2.e());
                            t = this.g.get(x2.e());
                            equals = l.equals(t);
                            if (!j) {
                                if (!equals && t != null) {
                                    n = l.a - t.a;
                                    n2 = l.b - t.b;
                                    k = x2.e().k();
                                    while (k.f()) {
                                        e = k.a().e();
                                        if (j) {
                                            continue Label_0030;
                                        }
                                        Label_0273: {
                                            if (e && !this.a(x, k.a())) {
                                                i = x.k(k.a());
                                                if (i.size() > 0) {
                                                    p = i.k();
                                                    while (p != null) {
                                                        t2 = (t)p.c();
                                                        p.a(new t(t2.a + n, t2.b + n2));
                                                        p = p.a();
                                                        if (j) {
                                                            break Label_0273;
                                                        }
                                                        if (j) {
                                                            break;
                                                        }
                                                    }
                                                    x.b(k.a(), i);
                                                }
                                            }
                                            k.g();
                                        }
                                        if (j) {
                                            break;
                                        }
                                    }
                                }
                                x2.g();
                                continue Label_0024;
                            }
                            break Label_0300;
                        }
                        break;
                    } while (!j);
                }
                x2 = x.o();
                x2.f();
            }
            if (equals) {
                e2 = x2.e();
                f = new f();
                m = e2.l();
                while (true) {
                    while (m.f()) {
                        a = m.a();
                        e3 = a.e();
                        if (!j) {
                            if (e3 && this.a(x, a)) {
                                f.add(a);
                            }
                            m.g();
                            if (j) {
                                break;
                            }
                            continue Label_0392_Outer;
                        }
                        else {
                            if (!e3) {
                                size = f.size();
                                e4 = f.e();
                                h = x.h(e2);
                                x3 = h.getX();
                                y = h.getY();
                                n3 = h.getX() + h.getWidth();
                                n4 = h.getY() + h.getHeight();
                                n5 = h.getWidth() * 0.5;
                                n6 = h.getHeight() * 0.5;
                                min = Math.min(n5 / (size + 1), this.e);
                                min2 = Math.min(n6 / (size + 1), this.e);
                                min3 = Math.min(min2, min);
                                n7 = (n5 - (size - 1) * min3) / 2.0;
                                n8 = (n6 - (size - 1) * min3) / 2.0;
                                c = this.c;
                            Label_0576:
                                while (true) {
                                    if (c2 == (b ? 1 : 0)) {
                                        n7 = (n5 - (size - 1) * min) / 2.0;
                                        n8 = (n6 - (size - 1) * min2) / 2.0;
                                    }
                                    n9 = 6.0;
                                    n10 = 12.0;
                                    n11 = n9 + Math.max(15.0, n9 + n10 - n8);
                                    n12 = n9 + Math.max(15.0, n9 + n10 - n7);
                                    a2 = this.a(x, e2);
                                    Label_1171: {
                                        if (!this.d || a2 == this.i) {
                                            n13 = 0;
                                            while (n13 < e4.length) {
                                                d = e4[n13];
                                                c2 = this.c;
                                                b = true;
                                                if (j) {
                                                    continue Label_0576;
                                                }
                                                Label_1163: {
                                                    if (c2 == (b ? 1 : 0)) {
                                                        array = new t[5];
                                                        array[0] = new t(x3 + n7 + n13 * min, y);
                                                        array[1] = new t(array[0].a(), y - n11 - n13 * this.e);
                                                        array[4] = new t(x3, y + n8 + n13 * min2);
                                                        array[3] = new t(x3 - n12 - n13 * this.e, array[4].b());
                                                        array[2] = new t(array[3].a(), array[1].b());
                                                        n14 = n9 + 0.25 * n13 * (min + min2);
                                                        d2 = new D();
                                                        d2.add(array[0]);
                                                        d2.a(this.a(array[1], n14, this.h, false, this.f));
                                                        d2.a(this.a(array[2], n14, this.i, false, this.f));
                                                        d2.a(this.a(array[3], n14, this.n, false, this.f));
                                                        d2.add(array[4]);
                                                        x.a(d, d2);
                                                        if (!j) {
                                                            break Label_1163;
                                                        }
                                                    }
                                                    n15 = n13 * min3;
                                                    d3 = new D();
                                                    d3.add(new t(x3 + n7 + n15, y));
                                                    d3.add(new t(x3 + n7 + n15, y - 15.0 - n15));
                                                    d3.add(new t(x3 - 15.0 - n15, y - 15.0 - n15));
                                                    d3.add(new t(x3 - 15.0 - n15, y + n8 + n15));
                                                    d3.add(new t(x3, y + n8 + n15));
                                                    x.a(d, d3);
                                                }
                                                ++n13;
                                                if (j) {
                                                    break Label_1171;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    Label_1666: {
                                        if (a2 == this.n) {
                                            n16 = 0;
                                            while (n16 < e4.length) {
                                                d4 = e4[n16];
                                                c3 = this.c;
                                                b2 = true;
                                                if (j) {
                                                    continue Label_0576;
                                                }
                                                Label_1658: {
                                                    if (c3 == (b2 ? 1 : 0)) {
                                                        array2 = new t[5];
                                                        array2[0] = new t(x3 + n7 + n16 * min, n4);
                                                        array2[1] = new t(array2[0].a(), n4 + n11 + n16 * this.e);
                                                        array2[4] = new t(x3, n4 - n8 - n16 * min2);
                                                        array2[3] = new t(x3 - n12 - n16 * this.e, array2[4].b());
                                                        array2[2] = new t(array2[3].a(), array2[1].b());
                                                        n17 = n9 + 0.25 * n16 * (min + min2);
                                                        d5 = new D();
                                                        d5.add(array2[0]);
                                                        d5.a(this.a(array2[1], n17, this.o, true, this.f));
                                                        d5.a(this.a(array2[2], n17, this.n, true, this.f));
                                                        d5.a(this.a(array2[3], n17, this.i, true, this.f));
                                                        d5.add(array2[4]);
                                                        x.a(d4, d5);
                                                        if (!j) {
                                                            break Label_1658;
                                                        }
                                                    }
                                                    n18 = n16 * min3;
                                                    d6 = new D();
                                                    d6.add(new t(x3 + n7 + n18, n4));
                                                    d6.add(new t(x3 + n7 + n18, n4 + 15.0 + n18));
                                                    d6.add(new t(x3 - 15.0 - n18, n4 + 15.0 + n18));
                                                    d6.add(new t(x3 - 15.0 - n18, n4 - n8 - n18));
                                                    d6.add(new t(x3, n4 - n8 - n18));
                                                    x.a(d4, d6);
                                                }
                                                ++n16;
                                                if (j) {
                                                    break Label_1666;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    Label_2161: {
                                        if (a2 == this.h) {
                                            n19 = 0;
                                            while (n19 < e4.length) {
                                                d7 = e4[n19];
                                                c4 = this.c;
                                                b3 = true;
                                                if (j) {
                                                    continue Label_0576;
                                                }
                                                Label_2153: {
                                                    if (c4 == (b3 ? 1 : 0)) {
                                                        array3 = new t[5];
                                                        array3[0] = new t(n3 - n7 - n19 * min, y);
                                                        array3[1] = new t(array3[0].a(), y - n11 - n19 * this.e);
                                                        array3[4] = new t(n3, y + n8 + n19 * min2);
                                                        array3[3] = new t(n3 + n12 + n19 * this.e, array3[4].b());
                                                        array3[2] = new t(array3[3].a(), array3[1].b());
                                                        n20 = n9 + 0.25 * n19 * (min + min2);
                                                        d8 = new D();
                                                        d8.add(array3[0]);
                                                        d8.a(this.a(array3[1], n20, this.i, true, this.f));
                                                        d8.a(this.a(array3[2], n20, this.h, true, this.f));
                                                        d8.a(this.a(array3[3], n20, this.o, true, this.f));
                                                        d8.add(array3[4]);
                                                        x.a(d7, d8);
                                                        if (!j) {
                                                            break Label_2153;
                                                        }
                                                    }
                                                    n21 = n19 * min3;
                                                    d9 = new D();
                                                    d9.add(new t(n3 - n7 - n21, y));
                                                    d9.add(new t(n3 - n7 - n21, y - 15.0 - n21));
                                                    d9.add(new t(n3 + 15.0 + n21, y - 15.0 - n21));
                                                    d9.add(new t(n3 + 15.0 + n21, y + n8 + n21));
                                                    d9.add(new t(n3, y + n8 + n21));
                                                    x.a(d7, d9);
                                                }
                                                ++n19;
                                                if (j) {
                                                    break Label_2161;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    if (a2 == this.o) {
                                        n22 = 0;
                                        while (n22 < e4.length) {
                                            d10 = e4[n22];
                                            c5 = this.c;
                                            b4 = true;
                                            if (j) {
                                                continue Label_0576;
                                            }
                                            Label_2648: {
                                                if (c5 == (b4 ? 1 : 0)) {
                                                    array4 = new t[5];
                                                    array4[0] = new t(n3 - n7 - n22 * min, n4);
                                                    array4[1] = new t(array4[0].a(), n4 + n11 + n22 * this.e);
                                                    array4[4] = new t(n3, n4 - n8 - n22 * min2);
                                                    array4[3] = new t(n3 + n12 + n22 * this.e, array4[4].b());
                                                    array4[2] = new t(array4[3].a(), array4[1].b());
                                                    n23 = n9 + 0.25 * n22 * (min + min2);
                                                    d11 = new D();
                                                    d11.add(array4[0]);
                                                    d11.a(this.a(array4[1], n23, this.n, false, this.f));
                                                    d11.a(this.a(array4[2], n23, this.o, false, this.f));
                                                    d11.a(this.a(array4[3], n23, this.h, false, this.f));
                                                    d11.add(array4[4]);
                                                    x.a(d10, d11);
                                                    if (!j) {
                                                        break Label_2648;
                                                    }
                                                }
                                                n24 = n22 * min3;
                                                d12 = new D();
                                                d12.add(new t(n3 - n7 - n24, n4));
                                                d12.add(new t(n3 - n7 - n24, n4 + 15.0 + n24));
                                                d12.add(new t(n3 + 15.0 + n24, n4 + 15.0 + n24));
                                                d12.add(new t(n3 + 15.0 + n24, n4 - n8 - n24));
                                                d12.add(new t(n3, n4 - n8 - n24));
                                                x.a(d10, d12);
                                            }
                                            ++n22;
                                            if (j) {
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
                            x2.g();
                            if (j) {
                                return;
                            }
                            continue Label_0294;
                        }
                    }
                    f.isEmpty();
                    continue;
                }
            }
            break;
        }
    }
    
    private D a(final t t, final double n, final int n2, final boolean b, final int n3) {
        final D d = new D();
        if (n3 < 2) {
            d.add(t);
            if (!X.j) {
                return d;
            }
        }
        if (n2 == this.h) {
            return this.a(this.h, t.b(-n, n), n, b, n3);
        }
        if (n2 == this.i) {
            return this.a(this.i, t.b(n, n), n, b, n3);
        }
        if (n2 == this.n) {
            return this.a(this.n, t.b(n, -n), n, b, n3);
        }
        if (n2 == this.o) {
            return this.a(this.o, t.b(-n, -n), n, b, n3);
        }
        if (b) {
            d.n();
        }
        return d;
    }
    
    private int a(final X x, final q q) {
        final boolean j = X.j;
        final t l = x.l(q);
        final y s = x.s(q);
        final int[] array = new int[4];
        final e i = q.j();
        while (true) {
            while (i.f()) {
                final d a = i.a();
                final int n2;
                final int n = n2 = (a.e() ? 1 : 0);
                if (j) {
                    int n3 = n2;
                    if (array[this.i] < array[n3]) {
                        n3 = this.i;
                    }
                    if (array[this.n] < array[n3]) {
                        n3 = this.n;
                    }
                    if (array[this.o] < array[n3]) {
                        n3 = this.o;
                    }
                    return n3;
                }
                Label_0291: {
                    if (n == 0 || !this.a(x, a)) {
                        final D m = x.m(a);
                        final t t = (t)((a.c() == q) ? m.f() : m.i());
                        final t a2 = a(s, t, (t)((a.c() == q) ? m.get(1) : m.get(m.size() - 2)));
                        final t t2 = (a2 != null) ? a2 : t;
                        final double n4 = t2.a() - l.a();
                        final double n5 = t2.b() - l.b();
                        if (n4 > 0.0 && n5 > 0.0) {
                            final int[] array2 = array;
                            final int o = this.o;
                            ++array2[o];
                            if (!j) {
                                break Label_0291;
                            }
                        }
                        if (n4 > 0.0 && n5 < 0.0) {
                            final int[] array3 = array;
                            final int h = this.h;
                            ++array3[h];
                            if (!j) {
                                break Label_0291;
                            }
                        }
                        if (n4 < 0.0 && n5 < 0.0) {
                            final int[] array4 = array;
                            final int k = this.i;
                            ++array4[k];
                            if (!j) {
                                break Label_0291;
                            }
                        }
                        final int[] array5 = array;
                        final int n6 = this.n;
                        ++array5[n6];
                    }
                }
                i.g();
                if (j) {
                    break;
                }
            }
            int n2 = this.h;
            continue;
        }
    }
    
    private static t a(final y y, final t t, final t t2) {
        if (!y.a(t) || y.a(t2)) {
            return null;
        }
        final Point2D.Double a = a(y.c, y.d, y.a(), y.b(), t.a, t.b, t2.a, t2.b, null);
        return new t(a.x, a.y);
    }
    
    private static Point2D.Double a(final double n, final double y, final double n2, final double n3, final double x, final double y2, final double n4, final double n5, Point2D.Double double1) {
        if (double1 == null) {
            double1 = new Point2D.Double();
        }
        if (x < n || y2 < y || x > n + n2 || y2 > y + n3) {
            double1.x = x;
            double1.y = y2;
            return double1;
        }
        final double n6 = n4 - x;
        final double n7 = n5 - y2;
        if (n6 == 0.0) {
            if (n7 < 0.0) {
                double1.x = x;
                double1.y = y;
                return double1;
            }
            double1.x = x;
            double1.y = y + n3;
            return double1;
        }
        else if (n7 == 0.0) {
            if (n6 < 0.0) {
                double1.x = n;
                double1.y = y2;
                return double1;
            }
            double1.x = n + n2;
            double1.y = y2;
            return double1;
        }
        else {
            final double n8 = n7 / n6;
            if (n6 > 0.0) {
                final double y3 = y2 + n8 * (n + n2 - x);
                if (y3 < y) {
                    double1.x = x + (y - y2) / n8;
                    double1.y = y;
                    return double1;
                }
                if (y3 <= y + n3) {
                    double1.x = n + n2;
                    double1.y = y3;
                    return double1;
                }
                double1.x = x + (y + n3 - y2) / n8;
                double1.y = y + n3;
                return double1;
            }
            else {
                final double y4 = y2 + n8 * (n - x);
                if (y4 < y) {
                    double1.x = x + (y - y2) / n8;
                    double1.y = y;
                    return double1;
                }
                if (y4 <= y + n3) {
                    double1.x = n;
                    double1.y = y4;
                    return double1;
                }
                double1.x = x + (y + n3 - y2) / n8;
                double1.y = y + n3;
                return double1;
            }
        }
    }
    
    private boolean a(final X x, final d d) {
        if (this.p) {
            return false;
        }
        if (this.g != null) {
            final c c = x.c(aN.a);
            return c == null || !c.d(d);
        }
        return true;
    }
    
    private void d(final X x) {
        final boolean j = X.j;
        final e p = x.p();
        while (p.f()) {
            if (p.a().e()) {
                this.b.c(p.a());
                x.d(p.a());
            }
            p.g();
            if (j) {
                break;
            }
        }
    }
    
    private void e(final X x) {
        final boolean j = X.j;
        while (!this.b.isEmpty()) {
            x.e(this.b.d());
            if (j) {
                break;
            }
        }
    }
    
    static {
        a = "y.layout.SelfLoopLayouter.KEEP_SELF_LOOP_LAYOUT_DPKEY";
    }
}
