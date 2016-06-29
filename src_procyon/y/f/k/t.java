package y.f.k;

import java.util.*;
import y.c.*;
import java.awt.geom.*;
import y.f.*;

public class t extends c implements Cloneable, w
{
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private byte h;
    private byte i;
    private byte j;
    private static final Comparator k;
    private static final Comparator l;
    
    public t() {
        this((byte)0, (byte)2, (byte)1, 40.0, 40.0);
    }
    
    public t(final byte b, final byte b2, final byte b3, final double n, final double n2) {
        this(b, b2, b3, n, n2, 0.0, 0.0, 0.0, 0.0);
    }
    
    public t(final byte h, final byte i, final byte j, final double b, final double c, final double d, final double e, final double f, final double g) {
        this.h = 0;
        this.i = 1;
        this.j = 1;
        this.h = h;
        this.i = i;
        this.j = j;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    protected A a(final q q, final byte b) {
        final int g = y.f.k.d.g;
        final am a = this.a.a((Object)q);
        A a2 = null;
        Label_2540: {
            if (q.c() == 0) {
                a2 = this.c(q);
                if (g == 0) {
                    break Label_2540;
                }
            }
            A a3 = null;
            a2 = this.c(q);
            final Rectangle2D a4 = a2.a();
            double n = 0.0;
            double n2 = 0.0;
            Label_2477: {
                if (this.a()) {
                    final y.d.c c = new y.d.c(-1.7976931348623157E308, Double.MAX_VALUE, 0.0);
                    final boolean b2 = this.h == 0;
                    y.d.c a5 = null;
                    double n3 = 0.0;
                    int n4 = 0;
                    final int n5 = (q.c() % 2 == 1) ? ((q.c() - 1) / 2) : (q.c() / 2 - 1);
                    final boolean b3 = q.c() % 2 == 0;
                    Label_0201: {
                        if (b2) {
                            a2.b(0.0, a2.a(2).c(c) - this.b);
                            if (g == 0) {
                                break Label_0201;
                            }
                        }
                        a2.b(0.0, -c.c(a2.a(0)) + this.b);
                    }
                    double n6;
                    double b4 = n6 = this.a.k(q);
                    final double[] array = new double[q.c()];
                    y.c.d d = q.f();
                    while (true) {
                    Label_0995_Outer:
                        while (d != null) {
                            final A b5 = this.b(d.d());
                            final y.d.t p2 = this.a.p(d);
                            final double n7 = b4;
                            if (g != 0) {
                                double n8 = n7;
                                double n9 = 0.0;
                                switch (this.i) {
                                    default: {
                                        n9 = (a3.g() + a3.e()) * 0.5 - a4.getCenterX();
                                        break;
                                    }
                                    case 3: {
                                        n9 = n3 - a4.getCenterX();
                                        break;
                                    }
                                    case 1: {
                                        n9 = a3.e() - a4.getX();
                                        break;
                                    }
                                    case 4: {
                                        n9 = a3.g() - a4.getMaxX();
                                        break;
                                    }
                                    case 5: {
                                        n9 = a3.g() - a4.getMinX() + this.c;
                                        break;
                                    }
                                    case 0: {
                                        n9 = a3.e() - a4.getMaxX() - this.c;
                                        break;
                                    }
                                    case 6: {
                                        n9 = a3.g() - a4.getMinX() + this.c;
                                        if (b2) {
                                            n8 = this.a(this.a.k(q), b4, n6) - this.b * 0.5;
                                            if (g == 0) {
                                                break;
                                            }
                                        }
                                        n8 = this.a(this.a.k(q), b4, n6) + this.b * 0.5;
                                        break;
                                    }
                                    case 7: {
                                        n9 = a3.e() - a4.getMaxX() - this.c;
                                        if (b2) {
                                            n8 = this.a(this.a.k(q), b4, n6) - this.b * 0.5;
                                            if (g == 0) {
                                                break;
                                            }
                                        }
                                        n8 = this.a(this.a.k(q), b4, n6) + this.b * 0.5;
                                        break;
                                    }
                                }
                                a2.b(n9, n8);
                                Label_1253: {
                                    if (this.j == 1) {
                                        int n10 = 0;
                                        double max = 0.0;
                                        y.c.d d2 = a2.k().f();
                                        while (true) {
                                            while (true) {
                                                while (d2 != null) {
                                                    max = Math.max(max, Math.abs(this.a.p(d2).a - array[n10]));
                                                    d2 = d2.g();
                                                    ++n10;
                                                    if (g != 0) {
                                                        final double max2 = 0.0;
                                                        final double max3 = Math.max(this.b, max2 + this.d + this.e);
                                                        if (b2) {
                                                            a2.b(0.0, -max3 + this.b);
                                                            final double n11 = (-max3 + Math.min(max3 - this.e - max2, Math.max((max3 - max2) * 0.5, this.d)) + -Math.min(max3 - this.d - max2, Math.max((max3 - max2) * 0.5, this.e))) * 0.5;
                                                            n2 = n11 - max2 * 0.5;
                                                            n = n11 + max2 * 0.5;
                                                            if (g == 0) {
                                                                break Label_1253;
                                                            }
                                                        }
                                                        a2.b(0.0, max3 - this.b);
                                                        final double n12 = (Math.min(max3 - this.d - max2, Math.max((max3 - max2) * 0.5, this.e)) + (max3 - Math.min(max3 - this.e - max2, Math.max((max3 - max2) * 0.5, this.d)))) * 0.5;
                                                        n2 = n12 + max2 * 0.5;
                                                        n = n12 - max2 * 0.5;
                                                        break Label_1253;
                                                    }
                                                    if (g != 0) {
                                                        break;
                                                    }
                                                }
                                                if (max <= 0.0) {
                                                    continue Label_0995_Outer;
                                                }
                                                final double max2 = Math.max(max * this.f, this.g);
                                                if (g != 0) {
                                                    continue Label_0995_Outer;
                                                }
                                                break;
                                            }
                                            continue;
                                        }
                                    }
                                }
                                a2.a(a3);
                                break Label_2477;
                            }
                            if (n7 > p2.b()) {
                                b4 = p2.b();
                            }
                            if (n6 < p2.b()) {
                                n6 = p2.b();
                            }
                            Label_0342: {
                                if (b2) {
                                    b5.b(0.0, -c.c(b5.a(0)));
                                    if (g == 0) {
                                        break Label_0342;
                                    }
                                }
                                b5.b(0.0, b5.a(2).c(c));
                            }
                            b5.a(b5.b(), b5.c(), b5.b(), 0.0);
                            Label_0415: {
                                if (a5 == null) {
                                    a5 = b5.a(1);
                                    if (g == 0) {
                                        break Label_0415;
                                    }
                                }
                                b5.b(-a5.c(b5.a(3)) + this.c, 0.0);
                                a5.a(b5.a(1));
                            }
                            array[n4] = b5.b();
                            Label_0446: {
                                if (a3 == null) {
                                    a3 = b5;
                                    if (g == 0) {
                                        break Label_0446;
                                    }
                                }
                                a3.a(b5);
                            }
                            Label_0516: {
                                if (b3) {
                                    if (n4 == n5) {
                                        n3 = b5.b();
                                        if (g == 0) {
                                            break Label_0516;
                                        }
                                    }
                                    if (n4 != n5 + 1) {
                                        break Label_0516;
                                    }
                                    n3 = (n3 + b5.b()) * 0.5;
                                    if (g == 0) {
                                        break Label_0516;
                                    }
                                }
                                if (n4 == n5) {
                                    n3 = b5.b();
                                }
                            }
                            this.a(null, b5, d);
                            d = d.g();
                            ++n4;
                            if (g != 0) {
                                break;
                            }
                        }
                        continue;
                    }
                }
                final boolean b6 = this.h == 1;
                final y.d.c c2 = new y.d.c(-1.7976931348623157E308, Double.MAX_VALUE, 0.0);
                y.d.c a6 = null;
                double n13 = 0.0;
                int n14 = 0;
                final int n15 = (q.c() % 2 == 1) ? ((q.c() - 1) / 2) : (q.c() / 2 - 1);
                final boolean b7 = q.c() % 2 == 0;
                Label_1400: {
                    if (b6) {
                        a2.b(-c2.c(a2.a(3)) + this.c, 0.0);
                        if (g == 0) {
                            break Label_1400;
                        }
                    }
                    a2.b(a2.a(1).c(c2) - this.c, 0.0);
                }
                double n16;
                double a7 = n16 = this.a.j(q);
                final double[] array2 = new double[q.c()];
                y.c.d d3 = q.f();
                while (true) {
                Label_2213_Outer:
                    while (d3 != null) {
                        final A b8 = this.b(d3.d());
                        final y.d.t p3 = this.a.p(d3);
                        final double n17 = a7;
                        if (g != 0) {
                            double n18 = n17;
                            double n19 = 0.0;
                            Label_2008: {
                                switch (this.i) {
                                    default: {
                                        n19 = (a3.h() + a3.f()) * 0.5 - a4.getCenterY();
                                        if (g != 0) {
                                            break Label_2008;
                                        }
                                        break;
                                    }
                                    case 3: {
                                        n19 = n13 - a4.getCenterY();
                                        if (g != 0) {
                                            break Label_2008;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        n19 = a3.f() - a4.getY();
                                        if (g != 0) {
                                            break Label_2008;
                                        }
                                        break;
                                    }
                                    case 4: {
                                        n19 = a3.h() - a4.getMaxY();
                                        if (g != 0) {
                                            break Label_2008;
                                        }
                                        break;
                                    }
                                    case 5: {
                                        n19 = a3.h() - a4.getMinY() + this.b;
                                        if (g != 0) {
                                            break Label_2008;
                                        }
                                        break;
                                    }
                                    case 0: {
                                        n19 = a3.f() - a4.getMaxY() - this.b;
                                        if (g != 0) {
                                            break Label_2008;
                                        }
                                        break;
                                    }
                                    case 6: {
                                        n19 = a3.h() - a4.getMinY() + this.b;
                                        if (!b6) {
                                            n18 = this.b(this.a.j(q), a7, n16) - this.c * 0.5;
                                            if (g == 0) {
                                                break;
                                            }
                                        }
                                        n18 = this.b(this.a.j(q), a7, n16) + this.c * 0.5;
                                        if (g != 0) {
                                            break Label_2008;
                                        }
                                        break;
                                    }
                                    case 7: {
                                        n19 = a3.f() - a4.getMaxY() - this.b;
                                        if (!b6) {
                                            n18 = this.b(this.a.j(q), a7, n16) - this.c * 0.5;
                                            if (g == 0) {
                                                break;
                                            }
                                        }
                                        n18 = this.b(this.a.j(q), a7, n16) + this.c * 0.5;
                                        break;
                                    }
                                }
                            }
                            a2.b(n18, n19);
                            Label_2471: {
                                if (this.j == 1) {
                                    int n20 = 0;
                                    double max4 = 0.0;
                                    y.c.d d4 = a2.k().f();
                                    while (true) {
                                        while (true) {
                                            while (d4 != null) {
                                                max4 = Math.max(max4, Math.abs(this.a.p(d4).b - array2[n20]));
                                                d4 = d4.g();
                                                ++n20;
                                                if (g != 0) {
                                                    final double max5 = 0.0;
                                                    final double max6 = Math.max(this.c, max5 + this.d + this.e);
                                                    if (!b6) {
                                                        a2.b(-max6 + this.c, 0.0);
                                                        final double n21 = (-max6 + Math.min(max6 - this.e - max5, Math.max((max6 - max5) * 0.5, this.d)) + -Math.min(max6 - this.d - max5, Math.max((max6 - max5) * 0.5, this.e))) * 0.5;
                                                        n2 = n21 - max5 * 0.5;
                                                        n = n21 + max5 * 0.5;
                                                        if (g == 0) {
                                                            break Label_2471;
                                                        }
                                                    }
                                                    a2.b(max6 - this.c, 0.0);
                                                    final double n22 = (Math.min(max6 - this.d - max5, Math.max((max6 - max5) * 0.5, this.e)) + (max6 - Math.min(max6 - this.e - max5, Math.max((max6 - max5) * 0.5, this.d)))) * 0.5;
                                                    n2 = n22 + max5 * 0.5;
                                                    n = n22 - max5 * 0.5;
                                                    break Label_2471;
                                                }
                                                if (g != 0) {
                                                    break;
                                                }
                                            }
                                            if (max4 <= 0.0) {
                                                continue Label_2213_Outer;
                                            }
                                            final double max5 = Math.max(max4 * this.f, this.g);
                                            if (g != 0) {
                                                continue Label_2213_Outer;
                                            }
                                            break;
                                        }
                                        continue;
                                    }
                                }
                            }
                            a2.a(a3);
                            break Label_2477;
                        }
                        if (n17 > p3.a()) {
                            a7 = p3.a();
                        }
                        if (n16 < p3.a()) {
                            n16 = p3.a();
                        }
                        Label_1541: {
                            if (b6) {
                                b8.b(b8.a(1).c(c2), 0.0);
                                if (g == 0) {
                                    break Label_1541;
                                }
                            }
                            b8.b(-c2.c(b8.a(3)), 0.0);
                        }
                        b8.a(b8.b(), b8.c(), 0.0, b8.c());
                        Label_1618: {
                            if (a6 == null) {
                                a6 = b8.a(2);
                                if (g == 0) {
                                    break Label_1618;
                                }
                            }
                            b8.b(0.0, -a6.c(b8.a(0)) + this.b);
                            a6.a(b8.a(2));
                        }
                        array2[n14] = b8.c();
                        Label_1649: {
                            if (a3 == null) {
                                a3 = b8;
                                if (g == 0) {
                                    break Label_1649;
                                }
                            }
                            a3.a(b8);
                        }
                        Label_1719: {
                            if (b7) {
                                if (n14 == n15) {
                                    n13 = b8.c();
                                    if (g == 0) {
                                        break Label_1719;
                                    }
                                }
                                if (n14 != n15 + 1) {
                                    break Label_1719;
                                }
                                n13 = (n13 + b8.c()) * 0.5;
                                if (g == 0) {
                                    break Label_1719;
                                }
                            }
                            if (n14 == n15) {
                                n13 = b8.c();
                            }
                        }
                        this.a(null, b8, d3);
                        d3 = d3.g();
                        ++n14;
                        if (g != 0) {
                            break;
                        }
                    }
                    continue;
                }
            }
            y.c.d d5 = q.f();
            while (d5 != null) {
                this.a(a, this.b(d5.d()), d5, n, n2);
                a2.a(this.a, d5);
                d5 = d5.g();
                if (g != 0) {
                    return a2;
                }
                if (g != 0) {
                    break;
                }
            }
        }
        if (q.g() != null) {
            this.a(this.a, q, a, a2, q.g(), this.a.b((Object)q.g()), b);
        }
        return a2;
    }
    
    private boolean a() {
        return this.h == 0 || this.h == 2;
    }
    
    private double a(final double n, final double n2, final double n3) {
        if (1 == this.j) {
            return -n;
        }
        switch (this.h) {
            case 2: {
                return -n2;
            }
            case 0: {
                return -n3;
            }
            default: {
                return -n;
            }
        }
    }
    
    private double b(final double n, final double n2, final double n3) {
        if (1 == this.j) {
            return -n;
        }
        switch (this.h) {
            case 1: {
                return -n2;
            }
            case 3: {
                return -n3;
            }
            default: {
                return -n;
            }
        }
    }
    
    protected void a(final X x, final q q, final am am, final A a, final y.c.d d, final y.f.I i, final byte b) {
        final int g = d.g;
        if (b == -2 || b == -1) {
            return;
        }
        aE ae = aE.e(x, d);
        if (ae == null) {
            ae = aE.a((byte)0);
        }
        final double n = am.getX() + am.getWidth();
        final double n2 = am.getY() + am.getHeight();
        final double n3 = this.b * 0.5;
        final double n4 = this.c * 0.5;
        final double n5 = this.b * 0.25;
        final double n6 = this.c * 0.25;
        Label_1345: {
            switch (this.h) {
                case 1: {
                    Label_0438: {
                        switch (b) {
                            case 0:
                            case 3: {
                                Label_0280: {
                                    if (ae.e()) {
                                        a.a(a.g() + n4, a.c());
                                        if (g == 0) {
                                            break Label_0280;
                                        }
                                    }
                                    if (ae.d()) {
                                        a.a(a.b(), n2 + n3);
                                        a.a(a.g() + n4, a.c());
                                        if (g == 0) {
                                            break Label_0280;
                                        }
                                    }
                                    if (ae.f()) {
                                        a.a(am.getX() - n6, a.c());
                                    }
                                }
                                if (b != 3) {
                                    break;
                                }
                                a.a(a.b(), a.f() - n3);
                                a.a(a.e(), a.f() - n3);
                                if (g != 0) {
                                    break Label_0438;
                                }
                                break;
                            }
                            case 1: {
                                if (ae.c()) {
                                    a.a(a.b(), am.getY() - n3);
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (ae.d()) {
                                    a.a(a.b(), n2 + n3);
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (!ae.f()) {
                                    break;
                                }
                                a.a(am.getX() - n6, a.c());
                                a.a(a.b(), am.getY() - n3);
                                if (g != 0) {
                                    break Label_0438;
                                }
                                break;
                            }
                            case 2: {
                                if (ae.e()) {
                                    a.a(a.g() + n4, a.c());
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (ae.c()) {
                                    a.a(a.b(), am.getY() - n3);
                                    a.a(a.g() + n4, a.c());
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (ae.f()) {
                                    a.a(am.getX() - n6, a.c());
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    if (g != 0) {
                        break Label_1345;
                    }
                    break;
                }
                case 3: {
                    Label_0839: {
                        switch (b) {
                            case 0:
                            case 1: {
                                Label_0685: {
                                    if (ae.e()) {
                                        a.a(n + n6, a.c());
                                        if (g == 0) {
                                            break Label_0685;
                                        }
                                    }
                                    if (ae.d()) {
                                        a.a(a.b(), n2 + n3);
                                        a.a(a.e() - n4, a.c());
                                        if (g == 0) {
                                            break Label_0685;
                                        }
                                    }
                                    if (ae.f()) {
                                        a.a(am.getX() - n4, a.c());
                                    }
                                }
                                if (b != 1) {
                                    break;
                                }
                                a.a(a.b(), a.f() - n3);
                                a.a(a.g(), a.f() - n3);
                                if (g != 0) {
                                    break Label_0839;
                                }
                                break;
                            }
                            case 3: {
                                if (ae.c()) {
                                    a.a(a.b(), am.getY() - n3);
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (ae.d()) {
                                    a.a(a.b(), n2 + n3);
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (!ae.e()) {
                                    break;
                                }
                                a.a(n + n6, a.c());
                                a.a(a.b(), am.getY() - n3);
                                if (g != 0) {
                                    break Label_0839;
                                }
                                break;
                            }
                            case 2: {
                                if (ae.e()) {
                                    a.a(n + n6, a.c());
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (ae.c()) {
                                    a.a(a.b(), am.getY() - n3);
                                    a.a(a.e() - n4, a.c());
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (ae.f()) {
                                    a.a(a.e() - n6, a.c());
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    if (g != 0) {
                        break Label_1345;
                    }
                    break;
                }
                case 0: {
                    Label_1197: {
                        switch (b) {
                            case 0: {
                                if (ae.e()) {
                                    a.a(n + n4, a.c());
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (ae.d()) {
                                    a.a(a.b(), n2 + n5);
                                    a.a(am.getX() - n4, a.c());
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (!ae.f()) {
                                    break;
                                }
                                a.a(am.getX() - n4, a.c());
                                if (g != 0) {
                                    break Label_1197;
                                }
                                break;
                            }
                            case 1: {
                                if (ae.c()) {
                                    a.a(a.b(), am.getY() - n3);
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (ae.d()) {
                                    a.a(a.b(), n2 + n5);
                                    if (g == 0) {
                                        break;
                                    }
                                }
                                if (!ae.f()) {
                                    break;
                                }
                                a.a(am.getX() - n4, a.c());
                                a.a(a.b(), a.f() - n3);
                                if (g != 0) {
                                    break Label_1197;
                                }
                                break;
                            }
                            case 2:
                            case 3: {
                                Label_1298: {
                                    if (ae.e()) {
                                        a.a(n + n4, a.c());
                                        a.a(a.b(), a.f() - n3);
                                        if (g == 0) {
                                            break Label_1298;
                                        }
                                    }
                                    if (ae.c()) {
                                        a.a(a.b(), am.getY() - n3);
                                        if (g == 0) {
                                            break Label_1298;
                                        }
                                    }
                                    if (ae.d()) {
                                        a.a(a.b(), n2 + n5);
                                    }
                                }
                                if (b == 2) {
                                    a.a(a.e() - n4, a.c());
                                    a.a(a.e() - n4, a.h());
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    if (g != 0) {
                        break Label_1345;
                    }
                    break;
                }
                case 2: {
                    Label_1600: {
                        switch (b) {
                            case 2: {
                                if (ae.e()) {
                                    a.a(n + n4, a.c());
                                    if (g == 0) {
                                        break Label_1345;
                                    }
                                }
                                if (ae.c()) {
                                    a.a(a.b(), am.getY() - n5);
                                    a.a(am.getX() - n4, a.c());
                                    if (g == 0) {
                                        break Label_1345;
                                    }
                                }
                                if (!ae.f()) {
                                    break Label_1345;
                                }
                                a.a(am.getX() - n4, a.c());
                                if (g != 0) {
                                    break Label_1600;
                                }
                                break Label_1345;
                            }
                            case 1: {
                                if (ae.c()) {
                                    a.a(a.b(), am.getY() - n5);
                                    if (g == 0) {
                                        break Label_1345;
                                    }
                                }
                                if (ae.d()) {
                                    a.a(a.b(), a.h() + n3);
                                    if (g == 0) {
                                        break Label_1345;
                                    }
                                }
                                if (!ae.f()) {
                                    break Label_1345;
                                }
                                a.a(am.getX() - n4, a.c());
                                a.a(a.b(), a.h() + n3);
                                if (g != 0) {
                                    break Label_1600;
                                }
                                break Label_1345;
                            }
                            case 0:
                            case 3: {
                                Label_1701: {
                                    if (ae.e()) {
                                        a.a(n + n4, a.c());
                                        a.a(a.b(), a.h() + n3);
                                        if (g == 0) {
                                            break Label_1701;
                                        }
                                    }
                                    if (ae.c()) {
                                        a.a(a.b(), am.getY() - n5);
                                        if (g == 0) {
                                            break Label_1701;
                                        }
                                    }
                                    if (ae.d()) {
                                        a.a(a.b(), n2 + n3);
                                    }
                                }
                                if (b == 0) {
                                    a.a(a.e() - n4, a.c());
                                    a.a(a.e() - n4, a.f());
                                    break Label_1345;
                                }
                                break Label_1345;
                            }
                        }
                    }
                    break;
                }
            }
        }
        a.d();
    }
    
    protected void a(final am am, final A a, final y.c.d d) {
        this.a.b((Object)d).clearPoints();
    }
    
    protected void a(final am am, final A a, final y.c.d d, final double n, final double n2) {
        if (this.j != 1) {
            this.b(am, a, d);
        }
        this.a(a, d, n, n2);
    }
    
    protected void b(final am am, final A a, final y.c.d d) {
        this.a(a, d, 0.0, 0.0);
    }
    
    private void a(final A a, final y.c.d d, final double n, final double n2) {
        final int g = d.g;
        if (this.j == 3) {
            return;
        }
        final y.f.I b = this.a.b((Object)d);
        b.clearPoints();
        Label_0316: {
            if (this.j == 1) {
                final y.d.t p4 = this.a.p(d);
                if (this.h == 2) {
                    b.addPoint(p4.a, n2);
                    b.addPoint(a.b(), n);
                    if (g == 0) {
                        break Label_0316;
                    }
                }
                if (this.h == 0) {
                    b.addPoint(p4.a, n2);
                    b.addPoint(a.b(), n);
                    if (g == 0) {
                        break Label_0316;
                    }
                }
                if (this.h == 1) {
                    b.addPoint(n2, p4.b);
                    b.addPoint(n, a.c());
                    if (g == 0) {
                        break Label_0316;
                    }
                }
                b.addPoint(n2, p4.b);
                b.addPoint(n, a.c());
                if (g == 0) {
                    break Label_0316;
                }
            }
            if (this.j == 2) {
                final y.d.t p5 = this.a.p(d);
                if (this.h == 2) {
                    b.addPoint(a.b(), p5.b);
                    if (g == 0) {
                        break Label_0316;
                    }
                }
                if (this.h == 0) {
                    b.addPoint(a.b(), p5.b);
                    if (g == 0) {
                        break Label_0316;
                    }
                }
                if (this.h == 1) {
                    b.addPoint(p5.a, a.c());
                    if (g == 0) {
                        break Label_0316;
                    }
                }
                b.addPoint(p5.a, a.c());
            }
        }
        a.a(b);
    }
    
    protected byte a(final q q) {
        if (this.j == 3) {
            return -2;
        }
        return this.h;
    }
    
    static {
        k = new u(true);
        l = new u(false);
    }
}
