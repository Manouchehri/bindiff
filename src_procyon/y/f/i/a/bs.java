package y.f.i.a;

import y.c.*;
import java.util.*;

class bs
{
    private boolean a;
    private final h b;
    private final boolean c;
    private final L d;
    private i e;
    private A f;
    private q[] g;
    private Z h;
    private double[] i;
    private final bw j;
    
    bs(final h b, final Z h) {
        this.a = true;
        this.b = b;
        this.h = h;
        this.c = b.c();
        this.d = h.c().k();
        this.j = new bw(this);
    }
    
    public bx a() {
        final int a = ab.a;
        final List d = this.b.d();
        bx a2 = this.a(false);
        int n = 1;
    Label_0321:
        while (true) {
            a2.a();
            boolean a3 = false;
        Label_0025:
            while (a3 && n != 0) {
                n = 0;
                final Iterator iterator = a2.d.iterator();
                bu bu = iterator.next();
                while (bu != null) {
                    a3 = bu.a();
                    if (a != 0) {
                        continue Label_0025;
                    }
                    if (a3) {
                        break;
                    }
                    bu = (iterator.hasNext() ? iterator.next() : null);
                    if (a != 0) {
                        break;
                    }
                }
                while (bu != null) {
                    int n2 = 0;
                    int n3 = 0;
                    Label_0169: {
                        if (bu.d < 0) {
                            n2 = bu.a;
                            n3 = bu.b;
                            if (a == 0) {
                                break Label_0169;
                            }
                        }
                        if (bu.c < bu.d) {
                            n2 = bu.c;
                            n3 = bu.d;
                        }
                    }
                    d.add(n3, d.remove(n2));
                    final bx a4 = this.a(false);
                    if (a4.a(a2)) {
                        a2 = a4;
                        n = 1;
                        if (a == 0) {
                            break;
                        }
                    }
                    d.add(n2, d.remove(n3));
                    bu = (iterator.hasNext() ? iterator.next() : null);
                    while (bu != null) {
                        final boolean a5 = bu.a();
                        if (a != 0 || a != 0) {
                            continue Label_0025;
                        }
                        if (a5) {
                            break;
                        }
                        bu = (iterator.hasNext() ? iterator.next() : null);
                        if (a != 0) {
                            break Label_0321;
                        }
                    }
                }
                continue Label_0321;
            }
            break;
        }
        return a2;
    }
    
    private bx a(final boolean b) {
        this.c();
        this.d();
        final bx a = this.a(null, false, false);
        if (a.d.size() != 0) {
            return a;
        }
        final bx a2 = this.a(null, false, true);
        if (a2.b()) {
            if (b) {
                return a;
            }
            return a2;
        }
        else {
            final bx a3 = this.a(null, true, true);
            if (this.d == null || a3.b()) {
                if (b && a3.b()) {
                    return a2;
                }
                return a3;
            }
            else {
                final bx a4 = this.a(this.d, true, true);
                if (b && a4.b()) {
                    return a3;
                }
                return a4;
            }
        }
    }
    
    private bx a(final L l, final boolean b, final boolean b2) {
        final int a = ab.a;
        final bv[] array = new bv[this.b.b()];
        int n = 0;
        boolean b3 = false;
        final D d = new D();
        final double[] array2 = new double[this.b.b()];
        final boolean[] array3 = new boolean[this.b.b()];
        int i = 0;
        boolean a3 = false;
        while (i < this.b.b()) {
            final bv a2 = this.a(i, array2, l, b, b2, this.j);
            array2[i] = a2.i();
            array3[i] = a2.h();
            array[i] = a2;
            n += a2.g();
            a3 = a2.a();
            if (a != 0) {
                return new bx(array, a3 ? (b ? ((l != null) ? 2 : 3) : 1) : 0, n, b3, d);
            }
            if (a3) {
                b3 = true;
            }
            if (this.a(a2, l, b, b2)) {
                d.add(this.a(i, array2, array3, l, b, b2, a2.g()));
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        return new bx(array, a3 ? (b ? ((l != null) ? 2 : 3) : 1) : 0, n, b3, d);
    }
    
    private boolean a(final bv bv, final L l, final boolean b, final boolean b2) {
        return bv.a() || (!bv.f() && (!bv.e() || (l != null && !bv.b())) && (!bv.d() || b) && (!bv.c() || b2));
    }
    
    private bu a(final int n, final double[] array, final boolean[] array2, final L l, final boolean b, final boolean b2, final int n2) {
        final int a = ab.a;
        final M c = this.b.a(n).c();
        int n3 = n;
        int i = 0;
        while (true) {
        Label_0190_Outer:
            while (i < n) {
                final double n4 = dcmpl(array[i], c.b());
                if (a != 0) {
                    double n5 = n4;
                    int j = n3;
                    while (true) {
                        while (j >= 1) {
                            final bv a2 = this.a(j, array, l, b, b2, new by(this, n, j));
                            final int g = a2.g();
                            if (a == 0) {
                                Label_0180: {
                                    if (g > n2) {
                                        n5 = j;
                                        if (a2.h()) {
                                            break;
                                        }
                                        int k = j - 1;
                                        while (k >= 0) {
                                            n5 = k;
                                            final boolean b3 = array2[k];
                                            if (a != 0) {
                                                break;
                                            }
                                            if (b3) {
                                                break;
                                            }
                                            --k;
                                            if (a != 0) {
                                                break Label_0180;
                                            }
                                        }
                                        break;
                                    }
                                }
                                --j;
                                if (a == 0) {
                                    continue Label_0190_Outer;
                                }
                            }
                            int n6 = g;
                            while (true) {
                                while (n6 <= j) {
                                    final int a3 = this.a(array, n6, n, l, b, b2, new by(this, n, n6));
                                    final int a4 = this.a(array, n6, n, l, b, b2, this.j);
                                    if (a != 0) {
                                        if (a3 > a4) {
                                            n6 = -1;
                                        }
                                        final int a5 = this.a(array, (int)n5, n, l, b, b2, this.j);
                                        int n7 = (int)(n5 + 1);
                                        while (true) {
                                            while (n7 <= n) {
                                                final int a6 = this.a(array, (int)n5, n, l, b, b2, new by(this, (int)n5, n7));
                                                final int n8 = a5;
                                                if (a != 0) {
                                                    if (a6 > n8) {
                                                        n7 = -1;
                                                    }
                                                    return new bu(n, n6, (int)n5, n7);
                                                }
                                                if (a6 > n8) {
                                                    break;
                                                }
                                                ++n7;
                                                if (a != 0) {
                                                    break;
                                                }
                                            }
                                            continue;
                                        }
                                    }
                                    if (a3 > a4) {
                                        break;
                                    }
                                    ++n6;
                                    if (a != 0) {
                                        break;
                                    }
                                }
                                continue;
                            }
                        }
                        continue;
                    }
                }
                if (n4 >= 0) {
                    n3 = i;
                    if (a == 0) {
                        break;
                    }
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private int a(final double[] array, final int n, final int n2, final L l, final boolean b, final boolean b2, final bw bw) {
        final int a = ab.a;
        final double[] array2 = new double[array.length];
        int i = 0;
        while (true) {
            while (i < n) {
                array2[i] = array[i];
                ++i;
                if (a != 0) {
                    int j = n;
                    int n3 = 0;
                    while (j <= n2) {
                        final bv a2 = this.a(j, array2, l, b, b2, bw);
                        array2[j] = a2.i();
                        n3 = i + a2.g();
                        if (a != 0) {
                            return n3;
                        }
                        i = n3;
                        ++j;
                        if (a != 0) {
                            break;
                        }
                    }
                    return n3;
                }
                if (a != 0) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    private bv a(final int n, final double[] array, final L l, final boolean b, final boolean b2, final bw bw) {
        final int a = ab.a;
        final int a2 = bw.a(n);
        final ai a3 = this.b.a(a2);
        final boolean a4;
        final boolean b3 = a4 = a(a3);
        final double n2 = b ? this.i[a2] : (b2 ? 1.0E-6 : 0.0);
        final double a5 = a3.c().a();
        final double b4 = a3.c().b();
        final double n3 = (n > 0) ? array[n - 1] : -1.7976931348623157E308;
        if (n3 > b4) {
            if (b3 && n3 < b4 + 1.0E-6) {
                return new bv(b4, (byte)((a4 ? 1 : 0) | 0x2), false);
            }
            return new bv(n3, (byte)((a4 ? 1 : 0) | 0x20), false);
        }
        else {
            final byte b5 = (byte)((a4 ? 1 : 0) | 0x2);
            if (!b2) {
                if (a5 > n3) {
                    return new bv(a5, b5, true);
                }
                return new bv(n3, b5, false);
            }
            else {
                final double max = Math.max(n3, a5);
                double n4 = -1.7976931348623157E308;
                double n5 = -1.7976931348623157E308;
                final List c = bw.c(n);
                double n8 = 0.0;
                Label_0385: {
                    if (!c.isEmpty()) {
                        for (final int intValue : c) {
                            final double n6 = array[bw.b(intValue)];
                            if (n6 > n4) {
                                n4 = n6;
                            }
                            final double n7 = n6 + Math.max(b ? this.i[intValue] : (b2 ? 1.0E-6 : 0.0), n2);
                            if (n7 > n5) {
                                n8 = n7;
                                if (a != 0) {
                                    break Label_0385;
                                }
                                n5 = n8;
                                if (a != 0) {
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    Math.max(n3, n4 + 1.0E-6);
                }
                final double n9 = n8;
                if (n9 > b4) {
                    return new bv(max, b5, false);
                }
                final byte b6 = (byte)(b5 | 0x4);
                if (!b) {
                    if (a5 > n9) {
                        return new bv(a5, b6, true);
                    }
                    return new bv(n9, b6, false);
                }
                else {
                    final double max2 = Math.max(n9, max);
                    final double max3 = Math.max(n3, n5);
                    final boolean b7 = a5 > max3;
                    if (max3 > b4) {
                        return new bv(max2, b6, false);
                    }
                    final byte b8 = (byte)(b6 | 0x8);
                    if (l == null || b3) {
                        if (b7) {
                            return new bv(a5, b8, true);
                        }
                        return new bv(max3, b8, false);
                    }
                    else {
                        final double max4 = Math.max(max3, max2);
                        final double a6 = l.a(max4, new M(max4, Double.MAX_VALUE), this.c);
                        if (a6 > b4) {
                            return new bv(max4, b8, b7);
                        }
                        return new bv(a6, (byte)(b8 | 0x10), b7);
                    }
                }
            }
        }
    }
    
    private void c() {
        final int i = ab.a;
        this.e = new i();
        this.f = this.e.t();
        this.e.a("index", this.f);
        this.g = new q[this.b.b()];
        int j = 0;
        while (true) {
            while (j < this.b.b()) {
                final q d = this.e.d();
                this.g[j] = d;
                final bs bs = this;
                if (i != 0) {
                    final M[] array = new M[bs.b.b()];
                    int n = 0;
                    do {
                        double n2 = 0.0;
                        Label_0119: {
                            n2 = n;
                        }
                        Label_0120:
                        while (n2 < this.b.b()) {
                            final M b = this.b.a(n).b();
                            array[n] = b;
                            final q q = this.g[n];
                            int k = 0;
                            while (k < n) {
                                final double n3 = n2 = dcmpg(b.b(array[k]), 1.0E-6);
                                if (i != 0) {
                                    continue Label_0120;
                                }
                                if (n3 < 0) {
                                    this.e.a(this.g[k], q);
                                }
                                ++k;
                                if (i != 0) {
                                    break;
                                }
                            }
                            ++n;
                            continue Label_0119;
                        }
                        break;
                    } while (i == 0);
                    return;
                }
                this.f.a(d, j);
                ++j;
                if (i != 0) {
                    break;
                }
            }
            final bs bs = this;
            continue;
        }
    }
    
    private static f a(final ah ah) {
        final int a = ab.a;
        final f f = new f();
        f f2 = null;
        for (final ai ai : ah.b()) {
            f2 = f;
            if (a != 0) {
                return f2;
            }
            f2.add(ai.i());
            if (a != 0) {
                break;
            }
        }
        return f2;
    }
    
    public void b() {
        final int a = ab.a;
        final bx a2 = this.a(true);
        final double[] a3 = this.a(a2);
        final double[] b = this.b(a2);
        final double[] array = new double[this.b.b()];
        int i = 0;
        while (true) {
            while (i < this.b.b()) {
                double n = b[i] - a3[i];
                final double n2 = dcmpg(n, 0.0);
                if (a != 0) {
                    final e[] array2 = new e[n2];
                    final d a4 = this.a(array, array2);
                Label_0648:
                    while (true) {
                        double d = a4.d() ? 1 : 0;
                    Label_0481_Outer:
                        while (d == 0) {
                            final e c = a4.c();
                            a4.a(c);
                            final int intValue = (int)c.a();
                            array2[intValue] = null;
                            final double a5 = this.a(intValue, a3, b, array);
                            final ai a6 = this.b.a(intValue);
                            double n3 = this.a(intValue, a5, a3, b, a2);
                            final M c2 = a6.c();
                            if (c2.a() > n3 + 1.0E-6 || c2.b() + 1.0E-6 < n3) {
                                n3 = c2.c();
                            }
                            this.b.a(a6, n3);
                            a3[intValue] = (b[intValue] = n3);
                            array[intValue] = 0.0;
                            final double[] array3 = new double[this.b.b()];
                            int j = 0;
                        Label_0488_Outer:
                            while (true) {
                            Label_0488:
                                while (true) {
                                    while (j < this.b.b()) {
                                        array3[j] = b[j];
                                        ++j;
                                        if (a == 0) {
                                            if (a != 0) {
                                                break;
                                            }
                                            continue Label_0481_Outer;
                                        }
                                        else {
                                            this.b.b();
                                            final double n4;
                                            final double[] array4 = new double[n4];
                                            int k = 0;
                                            while (k < this.b.b()) {
                                                array4[k] = a3[k];
                                                ++k;
                                                if (a != 0) {
                                                    continue Label_0648;
                                                }
                                                if (a != 0) {
                                                    break;
                                                }
                                            }
                                            if (intValue < this.b.b() - 1) {
                                                this.b(array4, intValue + 1, a2);
                                                int l = intValue + 1;
                                                while (l < this.b.b()) {
                                                    final double n5 = d = dcmpl(array4[l], a3[l]);
                                                    if (a != 0) {
                                                        continue Label_0481_Outer;
                                                    }
                                                    if (n5 > 0) {
                                                        a3[l] = array4[l];
                                                        array[l] = b[l] - a3[l];
                                                        if (array2[l] != null) {
                                                            a4.b(array2[l], new Integer(l));
                                                        }
                                                    }
                                                    ++l;
                                                    if (a != 0) {
                                                        break Label_0648;
                                                    }
                                                }
                                                continue Label_0648;
                                            }
                                            continue Label_0648;
                                        }
                                    }
                                    if (intValue > 0) {
                                        this.a(array3, intValue - 1, a2);
                                        int n6 = 0;
                                        while (n6 < intValue) {
                                            final double n4 = dcmpg(array3[n6], b[n6]);
                                            if (a != 0) {
                                                continue Label_0488;
                                            }
                                            if (n4 < 0) {
                                                b[n6] = array3[n6];
                                                array[n6] = b[n6] - a3[n6];
                                                if (array2[n6] != null) {
                                                    a4.b(array2[n6], new Integer(n6));
                                                }
                                            }
                                            ++n6;
                                            if (a != 0) {
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                                continue Label_0488_Outer;
                            }
                        }
                        break;
                    }
                    return;
                }
                Label_0141: {
                    if (n2 < 0) {
                        if (-n < 1.0E-6) {
                            b[i] = a3[i];
                            n = 0.0;
                            if (a == 0) {
                                break Label_0141;
                            }
                        }
                        final M c3 = this.b.a(i).c();
                        a3[i] = c3.a();
                        b[i] = c3.b();
                        n = b[i] - a3[i];
                    }
                }
                array[i] = Math.max(0.0, n);
                ++i;
                if (a != 0) {
                    break;
                }
            }
            this.b.b();
            continue;
        }
    }
    
    private void d() {
        final int a = ab.a;
        this.i = new double[this.b.b()];
        int i = 0;
        while (i < this.b.b()) {
            this.i[i] = this.b.a(i).m();
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    private static boolean a(final ai ai) {
        return ai.f() || ai.n();
    }
    
    private double[] a(final bx bx) {
        final int a = ab.a;
        final double[] array = new double[this.b.b()];
        int i = 0;
        double[] array2 = null;
        while (i < this.b.b()) {
            array2 = array;
            if (a != 0) {
                return array2;
            }
            array2[i] = bx.e[i].i();
            ++i;
            if (a != 0) {
                break;
            }
        }
        return array2;
    }
    
    private double[] b(final bx bx) {
        final double[] array = new double[this.b.b()];
        this.a(array, array.length - 1, bx);
        return array;
    }
    
    private void a(final double[] array, final int n, final bx bx) {
        final int a = ab.a;
        int i = n;
        while (i >= 0) {
            final bv bv = bx.e[i];
            Label_0156: {
                if (bv.b()) {
                    array[i] = this.b.a(i).c().b();
                    if (a == 0) {
                        break Label_0156;
                    }
                }
                double b = Double.MAX_VALUE;
                if (i < this.b.b() - 1) {
                    b = this.b(i, array[i + 1], array, bx);
                }
                double n2 = Math.min(b, this.b.a(i).c().b());
                if (bv.f()) {
                    n2 = this.d.a(n2, new M(-1.7976931348623157E308, n2), this.c);
                }
                array[i] = n2;
            }
            --i;
            if (a != 0) {
                break;
            }
        }
    }
    
    private void b(final double[] array, final int n, final bx bx) {
        final int a = ab.a;
        int i = n;
        while (i < this.b.b()) {
            final bv bv = bx.e[i];
            Label_0154: {
                if (bv.b()) {
                    array[i] = this.b.a(i).c().a();
                    if (a == 0) {
                        break Label_0154;
                    }
                }
                double a2 = -1.7976931348623157E308;
                if (i > 0) {
                    a2 = this.a(i, array[i - 1], array, bx);
                }
                double n2 = Math.max(a2, this.b.a(i).c().a());
                if (bv.f()) {
                    n2 = this.d.a(n2, new M(n2, Double.MAX_VALUE), this.c);
                }
                array[i] = n2;
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    private double a(final int n, double n2, final double[] array, final bx bx) {
        final int a = ab.a;
        if (!bx.e[n].e()) {
            return n2;
        }
        final double n3 = this.i[n];
        double max = 0.0;
        for (final int intValue : this.j.c(n)) {
            max = Math.max(n2, array[intValue] + Math.max(n3, this.i[intValue]));
            if (a != 0) {
                return max;
            }
            n2 = max;
            if (a != 0) {
                break;
            }
        }
        return max;
    }
    
    private double b(final int n, double n2, final double[] array, final bx bx) {
        final int a = ab.a;
        final double n3 = this.i[n];
        double min = 0.0;
        for (final int intValue : this.j.d(n)) {
            if (bx.e[intValue].e()) {
                min = Math.min(n2, array[intValue] - Math.max(n3, this.i[intValue]));
                if (a != 0) {
                    return min;
                }
                n2 = min;
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
        return min;
    }
    
    private d a(final double[] array, final e[] array2) {
        final int a = ab.a;
        final d d = new d(this.b.b(), new bt(this, array));
        int i = 0;
        while (i < this.b.b()) {
            array2[i] = d.a(new Integer(i), this.b.a(i));
            ++i;
            if (a != 0) {
                break;
            }
        }
        return d;
    }
    
    private double a(final int n, final double[] array, final double[] array2, final double[] array3) {
        final int i = ab.a;
        double n2 = array[n];
        int n3 = n;
        int j = n - 1;
        double n4 = 0.0;
        Label_0060: {
            while (j >= 0) {
                n2 = array[j];
                n3 = j;
                n4 = dcmpl(array3[j], 1.0E-6);
                if (i != 0 || n4 <= 0) {
                    break Label_0060;
                }
                --j;
                if (i != 0) {
                    goto Label_0058;
                }
            }
            goto Label_0058;
        }
        final boolean b = n4 == -1;
        double n5 = array2[n];
        int n6 = n;
        int k = n + 1;
        double n7 = 0.0;
        Label_0133: {
            while (k < this.b.b()) {
                n5 = array2[k];
                n6 = k;
                n7 = dcmpl(array3[k], 1.0E-6);
                if (i != 0 || n7 <= 0) {
                    break Label_0133;
                }
                ++k;
                if (i != 0) {
                    goto Label_0131;
                }
            }
            goto Label_0131;
        }
        final boolean b2 = n7 == this.b.b();
        final int[] array4 = new int[this.b.b()];
        int n8 = n3;
        do {
            int l = 0;
            int n9 = 0;
        Label_0169:
            while (l <= n9) {
                final y.c.e m = this.g[n8].k();
                while (m.f()) {
                    final int n10 = l = this.f.a(((y.c.d)m.d()).c());
                    n9 = n3;
                    if (i != 0) {
                        continue Label_0169;
                    }
                    if (l >= n9) {
                        array4[n8] = Math.max(array4[n8], array4[n10] + 1);
                    }
                    m.g();
                    if (i != 0) {
                        break;
                    }
                }
                if (n8 > 0) {
                    array4[n8] = Math.max(array4[n8], array4[n8 - 1]);
                }
                ++n8;
            }
            break;
        } while (i == 0);
        final int n11 = array4[n6];
        final int n12 = array4[n];
        double n13 = n11;
        double n14 = n12;
        if (this.a) {
            n13 = n13 + (b ? 0.5 : 0.0) + (b2 ? 0.5 : 0.0);
            n14 += (b ? 0.5 : 0.0);
        }
        if (n13 == 0.0) {
            final double n15 = n2 + (n5 - n2) / 2.0;
            if (i == 0) {
                return n15;
            }
        }
        return n2 + (n5 - n2) / n13 * n14;
    }
    
    private double a(final int n, final double n2, final double[] array, final double[] array2, final bx bx) {
        final bv bv = bx.e[n];
        M m = new M(array[n], array2[n]);
        if (bv.f()) {
            return this.d.a(n2, m, this.c);
        }
        double n3 = m.c(n2);
        final double a = this.a(n, n3, array, bx);
        final double b = this.b(n, n3, array2, bx);
        if (b >= a) {
            m = new M(a, b);
            n3 = m.c(n3);
        }
        if (this.d != null && !bv.b()) {
            final int a2 = this.d.a(m, this.c, 2);
            if (a2 >= 0) {
                return this.d.a(n3, m, this.c, a2);
            }
        }
        return n3;
    }
    
    public static void a(final h h, final Z z) {
        final int i = ab.a;
        final boolean c = h.c();
        final L k = z.c().k();
        final int b = h.b();
        int n = b - 1;
        while (true) {
            do {
                double n2 = 0.0;
                Label_0030: {
                    n2 = n;
                }
                Label_0032:
                while (n2 >= 0) {
                    final ai a = h.a(n);
                    double d;
                    final byte b2 = (byte)(d = a.d());
                    final byte b3 = 1;
                    if (i == 0) {
                        if (b2 == b3) {
                            double n3 = a.c().b();
                            final double a2 = a(a, z);
                            int j = n + 1;
                            while (j < b) {
                                final ai a3 = h.a(j);
                                final double max = Math.max(a2, a(a3, z));
                                final double n4 = n2 = dcmpl(a.b().b(a3.b()), 0.0);
                                if (i != 0) {
                                    continue Label_0032;
                                }
                                if (n4 == 0) {
                                    n3 = Math.min(n3, h.b(a3) - max);
                                }
                                ++j;
                                if (i != 0) {
                                    break;
                                }
                            }
                            final double b4 = h.b(a);
                            final double min = Math.min(b4, n3);
                            final double max2 = Math.max(b4, n3);
                            final double n5 = (k != null && !a(a)) ? (k.a(new M(min, max2), c) ? k.a(n3, new M(b4, n3), c) : b4) : n3;
                            if (n5 > b4) {
                                h.a(a, n5);
                            }
                        }
                        --n;
                        continue Label_0030;
                    }
                Label_0276_Outer:
                    while (true) {
                        if (d < b3) {
                            final ai a4 = h.a(n);
                        Label_0276:
                            while (true) {
                                Label_0503: {
                                    if (a4.d() != -1) {
                                        break Label_0503;
                                    }
                                    double n6 = a4.c().a();
                                    final double a5 = a(a4, z);
                                    int l = n - 1;
                                    while (l >= 0) {
                                        final ai a6 = h.a(l);
                                        final double max3 = Math.max(a5, a(a6, z));
                                        final double n7 = d = dcmpg(a4.b().b(a6.b()), max3);
                                        if (i != 0) {
                                            break Label_0276;
                                        }
                                        if (n7 < 0) {
                                            n6 = Math.max(n6, h.b(a6) + max3);
                                        }
                                        --l;
                                        if (i != 0) {
                                            break;
                                        }
                                    }
                                    final double b5 = h.b(a4);
                                    final double min2 = Math.min(b5, n6);
                                    final double max4 = Math.max(b5, n6);
                                    final double n8 = (k != null && !a(a4)) ? (k.a(new M(min2, max4), c) ? k.a(n6, new M(b5, n6), c) : b5) : n6;
                                    if (n8 < b5) {
                                        h.a(a4, n8);
                                    }
                                    break Label_0503;
                                    continue Label_0276_Outer;
                                }
                                ++n;
                                if (i == 0) {
                                    d = n;
                                    continue Label_0276;
                                }
                                break;
                            }
                        }
                        break;
                    }
                    return;
                }
                break;
            } while (i == 0);
            n = 0;
            continue;
        }
    }
    
    private static double a(final ai ai, final Z z) {
        final y c = z.c();
        return (ai.i() != null) ? c.a(ai.i()).c() : a(a(ai.k()), z);
    }
    
    private static double a(final f f, final Z z) {
        final int a = ab.a;
        double n = 0.0;
        final y c = z.c();
        final y.c.e a2 = f.a();
        double max = 0.0;
        while (a2.f()) {
            max = Math.max(n, c.a(a2.a()).c());
            if (a != 0) {
                return max;
            }
            n = max;
            a2.g();
            if (a != 0) {
                break;
            }
        }
        return max;
    }
    
    static q[] a(final bs bs) {
        return bs.g;
    }
    
    static A b(final bs bs) {
        return bs.f;
    }
    
    static h c(final bs bs) {
        return bs.b;
    }
}
