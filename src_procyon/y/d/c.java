package y.d;

import y.c.*;

public class c
{
    private double a;
    private D b;
    private double c;
    
    public c(final double n) {
        this(-1.7976931348623157E308, Double.MAX_VALUE, n);
    }
    
    public c(final double n, final double n2, final double n3) {
        if (n > n2) {
            throw new IllegalArgumentException("min (" + n + ") must not be greater than max(" + n2 + ")");
        }
        this.b = new D();
        final d a = d.a(n, n3, 0.0);
        a.a = this.b.a(a);
        final d a2 = d.a(n2, 0.0, 0.0);
        a2.a = this.b.b(a2);
    }
    
    public c(final double n, final double n2, final double n3, final double n4) {
        if (n > n2) {
            throw new IllegalArgumentException("min (" + n + ") must not be greater than max(" + n2 + ")");
        }
        this.b = new D();
        final d a = d.a(n, n3, (n != n2) ? ((n4 - n3) / (n2 - n)) : 0.0);
        a.a = this.b.a(a);
        final d a2 = d.a(n2, 0.0, 0.0);
        a2.a = this.b.b(a2);
    }
    
    private c() {
    }
    
    public c a(final boolean b, final boolean b2) {
        final boolean d = t.d;
        final D b3 = new D();
        Label_0238: {
            if (b2) {
                p p2 = this.b.l().b();
                while (p2 != null) {
                    d d2 = null;
                    Label_0093: {
                        if (b) {
                            d2 = y.d.d.a(-this.d(p2), -this.a(p2), this.c(p2));
                            if (!d) {
                                break Label_0093;
                            }
                        }
                        d2 = y.d.d.a(-this.d(p2), this.a(p2), -this.c(p2));
                    }
                    d2.a = b3.b(d2);
                    p2 = p2.b();
                    if (d) {
                        break;
                    }
                }
                final d a = y.d.d.a(-this.a(), 0.0, 0.0);
                a.a = b3.b(a);
                if (!d) {
                    break Label_0238;
                }
            }
            p p3 = this.b.k();
            while (p3 != null) {
                d d3 = null;
                Label_0215: {
                    if (b) {
                        d3 = y.d.d.a(this.b(p3), -this.a(p3), -this.c(p3));
                        if (!d) {
                            break Label_0215;
                        }
                    }
                    d3 = y.d.d.a(this.b(p3), this.a(p3), this.c(p3));
                }
                d3.a = b3.b(d3);
                p3 = p3.a();
                if (d) {
                    break;
                }
            }
        }
        final c c = new c();
        c.c = 0.0;
        c.a = 0.0;
        c.b = b3;
        return c;
    }
    
    public void a(final double n, final double n2, final double n3) {
        this.a(new c(n, n2, n3), false, true);
    }
    
    public void b(final double n, final double n2, final double n3) {
        this.a(new c(n, n2, n3), true, true);
    }
    
    public void c(final double n, final double n2, final double n3) {
        this.a(n, n2, n3, 0.0);
    }
    
    public void a(double n, double c, double n2, final double n3) {
        final boolean d = t.d;
        if (n > c) {
            throw new IllegalArgumentException("min (" + n + ") must not be greater than max(" + c + ")");
        }
        p p4 = null;
        p p5 = null;
        Label_0270: {
            Label_0261: {
                if (n <= this.a()) {
                    if (c >= this.b()) {
                        this.b.clear();
                        final d a = y.d.d.a(n, n2, n3);
                        a.a = this.b.a(a);
                        final d a2 = y.d.d.a(c, 0.0, 0.0);
                        a2.a = this.b.b(a2);
                        final double n4 = 0.0;
                        this.c = n4;
                        this.a = n4;
                        return;
                    }
                    p4 = null;
                    p5 = this.d(c);
                    c -= this.c;
                    n -= this.c;
                    if (!d) {
                        break Label_0261;
                    }
                }
                n -= this.c;
                p4 = this.d(n);
                if (c >= this.b()) {
                    p5 = this.b.l();
                    c -= this.c;
                    if (!d) {
                        break Label_0261;
                    }
                }
                p5 = p4.a();
                c -= this.c;
                while (((d)p5.c()).c <= c) {
                    p5 = p5.a();
                    if (d) {
                        break Label_0270;
                    }
                    if (d) {
                        break;
                    }
                }
                p5 = p5.b();
            }
            n2 -= this.a;
        }
        if (p4 == p5) {
            final d d2 = (d)p5.c();
            final d a3 = y.d.d.a(c, d2.a(c), d2.d);
            a3.a = this.b.b(a3, d2.a);
            if (d2.c == n) {
                d2.b = n2;
                d2.d = n3;
                if (!d) {
                    return;
                }
            }
            final d a4 = y.d.d.a(n, n2, n3);
            a4.a = this.b.b(a4, d2.a);
            return;
        }
        Label_0490: {
            if (p4 == null) {
                final d a6;
                final p a5 = this.b.a(a6 = y.d.d.a(n, n2, n3));
                a6.a = a5;
                p4 = a5;
                if (!d) {
                    break Label_0490;
                }
            }
            final d d3 = (d)p4.c();
            if (d3.c == n) {
                d3.b = n2;
                d3.d = n3;
                if (!d) {
                    break Label_0490;
                }
            }
            final d a7;
            final p b = this.b.b(a7 = y.d.d.a(n, n2, n3), d3.a);
            a7.a = b;
            p4 = b;
        }
        if (p5 != null) {
            final d d4 = (d)p5.c();
            d4.b = d4.a(c);
            d4.c = c;
        }
        final d d5 = (p4.b() != null) ? ((d)p4.b().c()) : null;
        final d d6 = (d)p4.c();
        if (d5 != null && d5.d == d6.d && d5.a(d6.c) == d6.b) {
            p4 = p4.b();
        }
        final d d7 = (p5 != null && p5.b() != null) ? ((d)p5.b().c()) : null;
        final d d8 = (p5 != null) ? ((d)p5.c()) : null;
        if (p5 != null && p5 != this.b.l() && d7 != null && d7.d == d8.d && d7.a(d8.c) == d8.b) {
            p5 = p5.a();
        }
        p p6 = p4.a();
        while (p6 != p5) {
            this.b.h(p6);
            p6 = p6.a();
            if (d) {
                break;
            }
        }
    }
    
    public void a(final double n) {
        this.a += n;
    }
    
    public void b(final double n) {
        this.c += n;
    }
    
    public double a() {
        return ((d)this.b.f()).c + this.c;
    }
    
    public double b() {
        return ((d)this.b.i()).c + this.c;
    }
    
    public double c() {
        return this.b(this.a(), this.b());
    }
    
    public double d() {
        return this.a(this.a(), this.b());
    }
    
    public double a(final p p2, final double n) {
        return this.a((d)p2.c(), n);
    }
    
    public double a(final d d, double n) {
        n -= this.c;
        if (n - 0.01 > d.a() || n + 0.01 < d.c) {
            throw new IllegalArgumentException(n + " is outside of " + d);
        }
        return d.a(n) + this.a;
    }
    
    public void a(final c c) {
        this.a(c, true, false);
    }
    
    public void b(final c c) {
        this.a(c, false, false);
    }
    
    private static t a(final d d, final d d2) {
        if (d.d == d2.d) {
            return null;
        }
        if (d.d == 0.0) {
            final double b = d.b;
            return new t(d2.c + (b - d2.b) / d2.d, b);
        }
        if (d2.d == 0.0) {
            final double b2 = d2.b;
            return new t(d.c + (b2 - d.b) / d.d, b2);
        }
        final double max = Math.max(d.c, d2.c);
        final double a = d.a(max);
        final double n = d2.a(max) - a;
        final double n2 = d.d - d2.d;
        if (n == 0.0) {
            return new t(max, a);
        }
        if (n * n2 <= 0.0) {
            return null;
        }
        final double n3 = max + n / n2;
        return new t(n3, d.a(n3));
    }
    
    private void a(final c c, final boolean b, final boolean b2) {
        final boolean d = t.d;
        final boolean b3 = b2 && this.b.size() <= c.b.size();
        final double n = b3 ? c.c : this.c;
        final double n2 = b3 ? c.a : this.a;
        final double n3 = b ? -1.7976931348623157E308 : Double.MAX_VALUE;
        final double a = this.a();
        final double a2 = c.a();
        final double b4 = this.b();
        final double b5 = c.b();
        final D b6 = this.b;
        final D b7 = c.b;
        p p3 = b6.k();
        p p4 = b7.k();
        final D d2 = new D();
        if (b4 < a2) {
        Label_0242:
            while (true) {
                if (b3) {
                    while (p3 != null) {
                        final d d4;
                        final d d3 = d4 = (d)p3.c();
                        d4.c += this.c - c.c;
                        final d d5 = d3;
                        d5.b += this.a - c.a;
                        p3 = p3.a();
                        if (d) {
                            break Label_0242;
                        }
                        if (d) {
                            break;
                        }
                    }
                }
                Label_0226: {
                    break Label_0226;
                    while (p4 != null) {
                        final p p5 = p4;
                        p4 = p4.a();
                        if (d) {
                            return;
                        }
                        if (b2) {
                            b7.h(p5);
                            if (!b3) {
                                final d d6 = (d)p5.c();
                                d6.b = c.a(p5) - this.a;
                                d6.c = c.b(p5) - this.c;
                            }
                            b6.a(p5);
                            if (!d) {
                                continue;
                            }
                        }
                        final d a3 = y.d.d.a(c.b(p5) - n, c.a(p5) - n2, c.c(p5));
                        a3.a = b6.b(a3);
                        if (d) {
                            break;
                        }
                    }
                    this.c = n;
                    this.a = n2;
                    return;
                }
                ((d)b6.i()).b = n3 - n2;
                continue Label_0242;
            }
        }
        if (b5 >= a) {
            d d7 = null;
            d d8 = null;
            Label_1365: {
                if (c(a, a2)) {
                    d7 = y.d.d.a(a, this.a(p3), this.c(p3));
                    d8 = y.d.d.a(a, c.a(p4), c.c(p4));
                    if (!d) {
                        break Label_1365;
                    }
                }
                if (a < a2) {
                    Label_1119: {
                        if (b3 || Math.abs(a - a2) < Math.abs(b4 - a2)) {
                            final p p6 = p3;
                            if (b3) {
                                final d d10;
                                final d d9 = d10 = (d)p6.c();
                                d10.c += this.c - c.c;
                                final d d11 = d9;
                                d11.b += this.a - c.a;
                            }
                            p3 = p3.a();
                            b6.h(p6);
                            d2.a(p6);
                            while (p3 != b6.l() && this.b(p3) < a2) {
                                final p p7 = p3;
                                if (b3) {
                                    final d d13;
                                    final d d12 = d13 = (d)p7.c();
                                    d13.c += this.c - c.c;
                                    final d d14 = d12;
                                    d14.b += this.a - c.a;
                                }
                                p3 = p3.a();
                                b6.h(p7);
                                d2.a(p7);
                                if (d) {
                                    break;
                                }
                            }
                            final p l = d2.l();
                            d7 = y.d.d.a(a2, b3 ? c.a(l, a2) : this.a(l, a2), this.c(l));
                            if (!d) {
                                break Label_1119;
                            }
                        }
                        d2.a(b6);
                        p i;
                        p p8 = (i = d2.l()).b();
                        d2.h(i);
                        b6.b(i);
                        while (p8 != d2.k() && this.b(p8) >= a2) {
                            i = p8;
                            p8 = p8.b();
                            d2.h(i);
                            b6.b(i);
                            if (d) {
                                break;
                            }
                        }
                        p3 = i;
                        final p j = d2.l();
                        d7 = y.d.d.a(a2, this.a(j, a2), this.c(j));
                    }
                    d8 = y.d.d.a(c.b(p4), c.a(p4), c.c(p4));
                    if (!d) {
                        break Label_1365;
                    }
                }
                while (p4 != b7.l() && c.b(p4) < a) {
                    final p p9 = p4;
                    p4 = p4.a();
                    if (b2) {
                        b7.h(p9);
                        if (!b3) {
                            final d d15 = (d)p9.c();
                            d15.b = c.a(p9) - this.a;
                            d15.c = c.b(p9) - this.c;
                        }
                        d2.a(p9);
                        if (!d) {
                            continue;
                        }
                    }
                    final d a4 = y.d.d.a(c.b(p9) - n, c.a(p9) - n2, c.c(p9));
                    a4.a = d2.b(a4);
                    if (d) {
                        break;
                    }
                }
                final d d16 = (d)d2.l().c();
                d7 = y.d.d.a(a, this.a(p3, a), this.c(p3));
                d8 = y.d.d.a(a, d16.a(a - n) + n2, this.c(d16));
            }
            double n4 = Math.max(a, a2);
            double n5 = d7.a(n4);
            double n6 = d8.a(n4);
            p p10 = null;
            Label_2177: {
                while (p3 != null) {
                    p10 = p4;
                    if (d || p10 == null) {
                        break Label_2177;
                    }
                    final double n7 = n4;
                    p p11 = null;
                    boolean b8 = false;
                    final double b9 = this.b(p3);
                    if (b9 == n7) {
                        d7.c = n7;
                        d7.b = this.a(p3);
                        d7.d = this.c(p3);
                        p11 = p3;
                        p3 = p3.a();
                        b6.h(p11);
                        b8 = true;
                        Label_1514: {
                            if (p3 == null) {
                                d7.b = n3;
                                n4 = Double.MAX_VALUE;
                                if (!d) {
                                    break Label_1514;
                                }
                            }
                            n4 = this.b(p3);
                        }
                        n5 = d7.a(n7);
                    }
                    else {
                        n4 = b9;
                    }
                    final double b10 = c.b(p4);
                    Label_1705: {
                        if (b10 == n7) {
                            d8.c = n7;
                            d8.b = c.a(p4);
                            d8.d = c.c(p4);
                            Label_1646: {
                                if (p11 == null) {
                                    p11 = p4;
                                    p4 = p4.a();
                                    if (!b2) {
                                        break Label_1646;
                                    }
                                    b7.h(p11);
                                    b8 = true;
                                    if (!d) {
                                        break Label_1646;
                                    }
                                }
                                if (b2) {
                                    final p p12 = p4;
                                    p4 = p4.a();
                                    b7.h(p12);
                                    if (!d) {
                                        break Label_1646;
                                    }
                                }
                                p4 = p4.a();
                            }
                            Label_1682: {
                                if (p4 == null) {
                                    d8.b = n3;
                                    d8.d = 0.0;
                                    if (!d) {
                                        break Label_1682;
                                    }
                                }
                                n4 = Math.min(n4, c.b(p4));
                            }
                            n6 = d8.a(n7);
                            if (!d) {
                                break Label_1705;
                            }
                        }
                        n4 = Math.min(n4, b10);
                    }
                    if (n4 == Double.MAX_VALUE && b4 != Double.MAX_VALUE) {
                        final d d17 = (d)p11.c();
                        if (b8) {
                            d17.c = n7 - n;
                            d17.b = n3 - n2;
                            d17.d = 0.0;
                            d2.a(p11);
                            if (!d) {
                                continue;
                            }
                        }
                        final d a5 = y.d.d.a(d17.c, d17.b, d17.d);
                        a5.a = d2.b(a5);
                        if (!d) {
                            continue;
                        }
                    }
                    final double n8 = n5;
                    final double n9 = n6;
                    n5 = d7.a(n4);
                    n6 = d8.a(n4);
                    final boolean b11 = (b && n8 >= n9) || (!b && n8 <= n9);
                    final boolean b12 = (b && n5 >= n6) || (!b && n5 <= n6);
                    boolean b13 = false;
                    Label_1989: {
                        if (b11 == b12) {
                            b13 = b11;
                            if (!d) {
                                break Label_1989;
                            }
                        }
                        if (c(n8, n9)) {
                            b13 = b12;
                            if (!d) {
                                break Label_1989;
                            }
                        }
                        if (c(n5, n6)) {
                            b13 = b11;
                            if (!d) {
                                break Label_1989;
                            }
                        }
                        final t a6 = a(d7, d8);
                        n4 = a6.a();
                        n5 = a6.b();
                        n6 = a6.b();
                        b13 = b11;
                    }
                    final double d18 = b13 ? d7.d : d8.d;
                    final double n10 = b13 ? n8 : n9;
                    final d d19 = d2.isEmpty() ? null : ((d)d2.i());
                    if (d19 != null && d19.d == d18 && c(d19.a(n7 - n) + n2, n10)) {
                        continue;
                    }
                    if (p11 != null && b8) {
                        final d d20 = (d)p11.c();
                        d20.c = n7 - n;
                        d20.b = n10 - n2;
                        d20.d = d18;
                        d2.a(p11);
                        if (!d) {
                            continue;
                        }
                    }
                    final d a7 = y.d.d.a(n7 - n, n10 - n2, d18);
                    a7.a = d2.b(a7);
                    if (d) {
                        goto Label_2175;
                    }
                }
                goto Label_2175;
            }
            boolean b14 = false;
            Label_2432: {
                Label_2430: {
                    Label_2286: {
                        if (p10 != null) {
                            if (!b3) {
                                d2.a(b6);
                                if (!d) {
                                    break Label_2286;
                                }
                            }
                            while (p3 != null) {
                                final d d22;
                                final d d21 = d22 = (d)p3.c();
                                d22.c += this.c - c.c;
                                final d d23 = d21;
                                d23.b += this.a - c.a;
                                final p p13 = p3;
                                p3 = p3.a();
                                b6.h(p13);
                                d2.a(p13);
                                if (d) {
                                    break Label_2430;
                                }
                                if (d) {
                                    break;
                                }
                            }
                        }
                    }
                    while (p4 != null) {
                        final p p14 = p4;
                        p4 = p4.a();
                        b14 = b2;
                        if (d) {
                            break Label_2432;
                        }
                        if (b2) {
                            b7.h(p14);
                            if (!b3) {
                                final d d25;
                                final d d24 = d25 = (d)p14.c();
                                d25.c += c.c - this.c;
                                final d d26 = d24;
                                d26.b += c.a - this.a;
                            }
                            d2.a(p14);
                            if (!d) {
                                continue;
                            }
                        }
                        final d a8 = y.d.d.a(c.b(p14) - n, c.a(p14) - n2, c.c(p14));
                        a8.a = d2.b(a8);
                        if (d) {
                            break;
                        }
                    }
                }
                b14 = b3;
            }
            if (b14) {
                this.c = c.c;
                this.a = c.a;
            }
            this.b = d2;
            return;
        }
        ((d)b7.i()).b = n3 - n2;
        while (true) {
            while (true) {
                while (p4 != null) {
                    final p p15 = p4;
                    final p a9;
                    p4 = (a9 = p4.a());
                    if (d) {
                        while (true) {
                            if (a9 != null) {
                                final d d28;
                                final d d27 = d28 = (d)p3.c();
                                d28.c += this.c - c.c;
                                final d d29 = d27;
                                d29.b += this.a - c.a;
                                p3 = p3.a();
                                if (d) {
                                    return;
                                }
                                if (!d) {
                                    continue;
                                }
                            }
                            break;
                        }
                        d2.a(b6);
                        this.b = d2;
                        this.c = n;
                        this.a = n2;
                        return;
                    }
                    final double n11 = (a9 == null) ? n3 : c.a(p15);
                    if (b2) {
                        b7.h(p15);
                        if (!b3) {
                            final d d30 = (d)p15.c();
                            d30.b = n11 - this.a;
                            d30.c = c.b(p15) - this.c;
                        }
                        d2.a(p15);
                        if (!d) {
                            continue;
                        }
                    }
                    final d a10 = y.d.d.a(c.b(p15) - n, n11 - n2, c.c(p15));
                    a10.a = d2.b(a10);
                    if (d) {
                        break;
                    }
                }
                if (b3) {
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private static boolean c(final double n, final double n2) {
        return Math.abs(n - n2) < 0.001;
    }
    
    private double a(final p p) {
        return this.a((d)p.c());
    }
    
    private double b(final p p) {
        return this.b((d)p.c());
    }
    
    private double c(final p p) {
        return this.c((d)p.c());
    }
    
    private double d(final p p) {
        if (p.a() == null) {
            throw new IllegalArgumentException("Cell is unbound!");
        }
        return ((d)p.a().c()).c + this.c;
    }
    
    private p d(double n) {
        final boolean d = t.d;
        p p = this.b.k();
        final double c = ((d)p.c()).c;
        final double c2 = ((d)this.b.i()).c;
        n -= this.c;
        if (n < c || n > c2) {
            return null;
        }
        if (n == c2) {
            return this.b.l();
        }
        double n2 = ((d)p.a().c()).c;
        p a = null;
        while (n >= n2) {
            p = p.a();
            a = p.a();
            if (d) {
                return a;
            }
            n2 = ((d)a.c()).c;
            if (d) {
                break;
            }
        }
        return a;
    }
    
    public double a(final d d) {
        return this.a + d.b;
    }
    
    public double b(final d d) {
        return d.c + this.c;
    }
    
    public double c(final d d) {
        return d.d;
    }
    
    public d c(final double n) {
        final p d = this.d(n);
        return (d != null) ? ((d)d.c()) : null;
    }
    
    public double d(final d d) {
        if (d.a.a() == null) {
            throw new IllegalArgumentException("Segment is unbound!");
        }
        return ((d)d.a.a().c()).c + this.c;
    }
    
    public d e() {
        final p k = this.b.k();
        return (k != null) ? ((d)k.c()) : null;
    }
    
    public d f() {
        return (d)this.b.l().b().c();
    }
    
    public d e(final d d) {
        if (d.a.a() != this.b.l()) {
            return (d)d.a.a().c();
        }
        return null;
    }
    
    public double a(final double n, final double n2) {
        final boolean d = t.d;
        final double a = this.a();
        final double b = this.b();
        if (b <= a || n2 <= n) {
            return Double.MAX_VALUE;
        }
        final double max = Math.max(a, n);
        final double min = Math.min(b, n2);
        if (max >= min) {
            return -1.7976931348623157E308;
        }
        final double n3 = max;
        d d2 = null;
        Label_0123: {
            if (a == n) {
                d2 = this.e();
                if (!d) {
                    break Label_0123;
                }
            }
            if (a < n) {
                d2 = this.c(n3);
                if (!d) {
                    break Label_0123;
                }
            }
            d2 = this.e();
        }
        double max2 = d2.a(max - this.c) + this.a;
        double n4 = this.d(d2);
        if (n4 < min) {
            d2 = this.e(d2);
        }
        while (n4 < min && d2 != this.b.i()) {
            max2 = Math.max(Math.max(max2, this.a(d2)), this.a(d2, this.d(d2)));
            n4 = this.d(d2);
            if (n4 >= min) {
                break;
            }
            d2 = this.e(d2);
            if (d) {
                break;
            }
        }
        return Math.max(max2, d2.a(min - this.c) + this.a);
    }
    
    public double b(final double n, final double n2) {
        final boolean d = t.d;
        final double a = this.a();
        final double b = this.b();
        if (b <= a || n2 <= n) {
            return Double.MAX_VALUE;
        }
        final double max = Math.max(a, n);
        final double min = Math.min(b, n2);
        if (max >= min) {
            return Double.MAX_VALUE;
        }
        final double n3 = max;
        d d2 = null;
        Label_0123: {
            if (a == n) {
                d2 = this.e();
                if (!d) {
                    break Label_0123;
                }
            }
            if (a < n) {
                d2 = this.c(n3);
                if (!d) {
                    break Label_0123;
                }
            }
            d2 = this.e();
        }
        double min2 = d2.a(max - this.c) + this.a;
        double n4 = this.d(d2);
        if (n4 < min) {
            d2 = this.e(d2);
        }
        while (n4 < min && d2 != this.b.i()) {
            min2 = Math.min(Math.min(min2, this.a(d2)), this.a(d2, this.d(d2)));
            n4 = this.d(d2);
            if (n4 >= min) {
                break;
            }
            d2 = this.e(d2);
            if (d) {
                break;
            }
        }
        return Math.min(min2, d2.a(min - this.c) + this.a);
    }
    
    public double c(final c c) {
        final boolean d = t.d;
        final double a = this.a();
        final double a2 = c.a();
        final double b = this.b();
        final double b2 = c.b();
        if (b <= a || b2 <= a2) {
            return Double.MAX_VALUE;
        }
        final double max = Math.max(a, a2);
        final double min = Math.min(b, b2);
        if (max >= min) {
            return Double.MAX_VALUE;
        }
        double n = max;
        d d2 = null;
        d d3 = null;
        Label_0144: {
            if (a == a2) {
                d2 = this.e();
                d3 = c.e();
                if (!d) {
                    break Label_0144;
                }
            }
            if (a < a2) {
                d2 = this.c(n);
                d3 = c.e();
                if (!d) {
                    break Label_0144;
                }
            }
            d2 = this.e();
            d3 = c.c(n);
        }
        double n2 = Double.MAX_VALUE;
        while (n < min) {
            n2 = Math.min(n2, c.a(d3, n) - this.a(d2, n));
            if (c.d(d3) < this.d(d2)) {
                n = c.d(d3);
                n2 = Math.min(n2, c.a(d3, n) - this.a(d2, n));
                if (n >= min) {
                    continue;
                }
                d3 = c.e(d3);
                if (!d) {
                    continue;
                }
            }
            n = this.d(d2);
            n2 = Math.min(n2, c.a(d3, n) - this.a(d2, n));
            if (n < min) {
                d2 = this.e(d2);
                if (d) {
                    return n2;
                }
                if (d) {
                    break;
                }
                continue;
            }
        }
        n2 = Math.min(n2, c.a(d3, n) - this.a(d2, n));
        return n2;
    }
    
    public String toString() {
        final boolean d = t.d;
        final StringBuffer sb = new StringBuffer(this.b.size() * 20);
        d e = (d)this.b.f();
        while (e != null) {
            final StringBuffer append = sb.append("Segment [").append(e.c + this.c).append(" - ").append(e.a() + this.c).append("], value=").append(e.b + this.a).append(", slope=").append(e.d);
            if (d) {
                return append.toString();
            }
            e = this.e(e);
            if (d) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
}
