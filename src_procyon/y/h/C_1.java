package y.h;

import java.awt.geom.*;
import java.util.*;

public class C
{
    private double[] b;
    private int c;
    private double d;
    private double e;
    private short f;
    private short g;
    private short h;
    private Rectangle2D.Double i;
    private final eH j;
    private final double[] k;
    double[] a;
    
    public void a() {
        this.c = 0;
    }
    
    public short b() {
        return this.h;
    }
    
    public short c() {
        return this.g;
    }
    
    public short d() {
        return this.f;
    }
    
    public void a(final double n, final double n2, final double n3, final double n4) {
        final double n5 = 2.0 * this.d;
        final double n6 = n - n5;
        final double n7 = n2 - n5;
        this.i.setFrame(n6, n7, n3 + n5 - n6, n4 + n5 - n7);
    }
    
    public PathIterator a(final PathIterator pathIterator) {
        final boolean z = fj.z;
        final eH j = this.j;
        final double[] k = this.k;
        j.c();
        j.a(pathIterator);
        double n = 0.0;
        double n2 = 0.0;
        eI ei = j.a();
        while (ei != null) {
            Label_0178: {
                switch (ei.a()) {
                    case 4: {
                        if (z) {
                            break Label_0178;
                        }
                        break;
                    }
                    case 3: {
                        ei.a(k);
                        n = k[4];
                        n2 = k[5];
                        if (z) {
                            break Label_0178;
                        }
                        break;
                    }
                    case 1: {
                        ei.a(k);
                        this.a(j, ei, n, n2, k[0], k[1]);
                        n = k[0];
                        n2 = k[1];
                        if (z) {
                            break Label_0178;
                        }
                        break;
                    }
                    case 0: {
                        ei.a(k);
                        n = k[0];
                        n2 = k[1];
                        if (z) {
                            break Label_0178;
                        }
                        break;
                    }
                    case 2: {
                        ei.a(k);
                        n = k[2];
                        n2 = k[3];
                        break;
                    }
                }
            }
            ei = ei.b();
            if (z) {
                break;
            }
        }
        return j.getPathIterator(null);
    }
    
    public void b(final PathIterator pathIterator) {
        final boolean z = fj.z;
        final double[] k = this.k;
        double n = 0.0;
        double n2 = 0.0;
        while (!pathIterator.isDone()) {
            Label_0128: {
                switch (pathIterator.currentSegment(k)) {
                    case 4: {
                        if (z) {
                            break Label_0128;
                        }
                        break;
                    }
                    case 3: {
                        n = k[4];
                        n2 = k[5];
                        if (z) {
                            break Label_0128;
                        }
                        break;
                    }
                    case 1: {
                        this.b(n, n2, k[0], k[1]);
                        n = k[0];
                        n2 = k[1];
                        if (z) {
                            break Label_0128;
                        }
                        break;
                    }
                    case 0: {
                        n = k[0];
                        n2 = k[1];
                        if (z) {
                            break Label_0128;
                        }
                        break;
                    }
                    case 2: {
                        n = k[2];
                        n2 = k[3];
                        break;
                    }
                }
            }
            pathIterator.next();
            if (z) {
                break;
            }
        }
    }
    
    public void b(final double n, final double n2, final double n3, final double n4) {
        if (!this.i.intersectsLine(n, n2, n3, n4)) {
            return;
        }
        this.c(n, n2, n3, n4);
    }
    
    private void a(final eH eh, final eI ei, final double n, final double n2, final double n3, final double n4) {
        final boolean z = fj.z;
        if (!this.i.intersectsLine(n, n2, n3, n4)) {
            return;
        }
        Label_0480: {
            if (this.c > 0) {
                final double n5 = n3 - n;
                final double n6 = n4 - n2;
                if (this.h != 0) {
                    switch (this.h) {
                        case 1: {
                            if (Math.abs(n5) < Math.abs(n6)) {
                                return;
                            }
                            break;
                        }
                        case 2: {
                            if (Math.abs(n5) > Math.abs(n6)) {
                                return;
                            }
                            break;
                        }
                    }
                }
                final double sqrt = Math.sqrt(n5 * n5 + n6 * n6);
                if (sqrt > 0.0) {
                    final double n7 = n5 / sqrt;
                    final double n8 = n6 / sqrt;
                    int n9 = 0;
                    int i = 0;
                    while (true) {
                        while (i < this.c) {
                            final int linesIntersect = Line2D.linesIntersect(n, n2, n3, n4, this.b[i], this.b[i + 1], this.b[i + 2], this.b[i + 3]) ? 1 : 0;
                            if (!z) {
                                if (linesIntersect != 0) {
                                    final double n10 = this.b[i];
                                    final double n11 = this.b[i + 1];
                                    final double n12 = this.b[i + 2] - n10;
                                    final double n13 = this.b[i + 3] - n11;
                                    final double n14 = n13 * n5 - n12 * n6;
                                    final double n15 = (n12 * (n2 - n11) - n13 * (n - n10)) / n14;
                                    if (n15 > 0.0 && n15 < 1.0) {
                                        final double n16 = (n5 * (n2 - n11) - n6 * (n - n10)) / n14;
                                        if (n16 > 0.0 && n16 < 1.0) {
                                            final double n17 = n15 * sqrt;
                                            if (n17 > 0.1 && n17 < sqrt - 0.1) {
                                                if (n9 == this.a.length) {
                                                    final double[] a = new double[this.a.length * 2];
                                                    System.arraycopy(this.a, 0, a, 0, this.a.length);
                                                    this.a = a;
                                                }
                                                this.a[n9++] = n17;
                                            }
                                        }
                                    }
                                }
                                i += 4;
                                if (z) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (linesIntersect > 0) {
                                    Arrays.sort(this.a, 0, n9);
                                    this.a(eh, ei, n, n2, n3, n4, n5, n6, n7, n8, sqrt, this.a, n9);
                                }
                                break Label_0480;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        if (this.h == 0) {
            this.c(n, n2, n3, n4);
        }
    }
    
    private void c(final double n, final double n2, final double n3, final double n4) {
        if (this.h != 0) {
            switch (this.h) {
                case 1: {
                    if (Math.abs(n3 - n) > Math.abs(n4 - n2)) {
                        return;
                    }
                    break;
                }
                case 2: {
                    if (Math.abs(n3 - n) < Math.abs(n4 - n2)) {
                        return;
                    }
                    break;
                }
            }
        }
        if (this.c == this.b.length) {
            final double[] b = new double[this.b.length * 2];
            System.arraycopy(this.b, 0, b, 0, this.b.length);
            this.b = b;
        }
        this.b[this.c++] = n;
        this.b[this.c++] = n2;
        this.b[this.c++] = n3;
        this.b[this.c++] = n4;
    }
    
    private void a(final eH eh, final eI ei, final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final double n7, final double n8, final double n9, final double[] array, final int n10) {
        final boolean z = fj.z;
        final double n11 = this.d * 0.5;
        double max = Math.max(0.0, array[0] - n11);
        double min = Math.min(n9, array[0] + n11);
        int i = 1;
        while (true) {
            while (i < n10) {
                final double n12 = array[i];
                final double max2 = Math.max(0.0, n12 - n11);
                final double min2 = Math.min(n9, n12 + n11);
                final double n13 = dcmpl(max2, min);
                if (z) {
                    if (n13 > 0) {
                        final double n14 = n + max / n9 * n5;
                        final double n15 = n2 + max / n9 * n6;
                        eh.b(n14, n15, ei);
                        this.a(eh, ei, max, n14, n15, min, n + min / n9 * n5, n2 + min / n9 * n6, n7, n8);
                    }
                    return;
                }
                Label_0186: {
                    if (n13 > 0) {
                        final double n16 = n + max / n9 * n5;
                        final double n17 = n2 + max / n9 * n6;
                        eh.b(n16, n17, ei);
                        this.a(eh, ei, max, n16, n17, min, n + min / n9 * n5, n2 + min / n9 * n6, n7, n8);
                        max = max2;
                        min = min2;
                        if (!z) {
                            break Label_0186;
                        }
                    }
                    min = min2;
                }
                ++i;
                if (z) {
                    break;
                }
            }
            final double n18 = dcmpl(min, max);
            continue;
        }
    }
    
    private void a(final eH eh, final eI ei, final double n, final double n2, final double n3, final double n4, final double n5, final double n6, final double n7, final double n8) {
        final boolean z = fj.z;
        final short d = this.d();
        final boolean a = this.a(n7, n8);
        while (true) {
            Label_0886: {
                switch (d) {
                    case 4: {
                        final double n9 = n5 - n2;
                        final double n10 = n6 - n3;
                        if (a) {
                            eh.a(n2 + n10 * 0.5, n3 - n9 * 0.5, n2 + (n10 + n9) * 0.5, n3 + (n10 - n9) * 0.5, ei);
                            eh.a(n5 + n10 * 0.5, n6 - n9 * 0.5, n5, n6, ei);
                            if (!z) {
                                return;
                            }
                        }
                        eh.a(n2 - n10 * 0.5, n3 + n9 * 0.5, n2 + (n9 - n10) * 0.5, n3 + (n9 + n10) * 0.5, ei);
                        eh.a(n5 - n10 * 0.5, n6 + n9 * 0.5, n5, n6, ei);
                        if (z) {
                            break Label_0886;
                        }
                        return;
                    }
                    case 1: {
                        final double n11 = a ? (-this.e) : this.e;
                        final double n12 = (n4 - n) * 0.5;
                        if (this.e < n12) {
                            final double e = this.e;
                            eh.a(n2 - n8 * n11, n3 + n7 * n11, n2 - n8 * n11 + n7 * e, n3 + n7 * n11 + n8 * e, ei);
                            eh.b(n5 - n8 * n11 - n7 * e, n6 + n7 * n11 - n8 * e, ei);
                            eh.a(n5 - n8 * n11, n6 + n7 * n11, n5, n6, ei);
                            if (!z) {
                                return;
                            }
                        }
                        eh.a(n2 - n8 * n11, n3 + n7 * n11, n2 - n8 * n11 + n7 * n12, n3 + n7 * n11 + n8 * n12, ei);
                        eh.a(n5 - n8 * n11, n6 + n7 * n11, n5, n6, ei);
                        if (z) {
                            break Label_0886;
                        }
                        return;
                    }
                    case 127: {
                        this.a(eh, ei, n, n2, n3, n4, n5, n6);
                        if (z) {
                            break;
                        }
                        return;
                    }
                    case 5: {
                        final double n13 = n5 - n2;
                        final double n14 = n6 - n3;
                        if (a) {
                            eh.b(n2 + n14 * 0.5, n3 - n13 * 0.5, ei);
                            eh.b(n5 + n14 * 0.5, n6 - n13 * 0.5, ei);
                            eh.b(n5, n6, ei);
                            if (!z) {
                                return;
                            }
                        }
                        eh.b(n2 - n14 * 0.5, n3 + n13 * 0.5, ei);
                        eh.b(n5 - n14 * 0.5, n6 + n13 * 0.5, ei);
                        eh.b(n5, n6, ei);
                        if (z) {
                            break Label_0886;
                        }
                        return;
                    }
                    case 2: {
                        final double n15 = a ? (-this.e) : this.e;
                        eh.b(n2 - n8 * n15, n3 + n7 * n15, ei);
                        eh.b(n5 - n8 * n15, n6 + n7 * n15, ei);
                        eh.b(n5, n6, ei);
                        if (z) {
                            break Label_0886;
                        }
                        return;
                    }
                    case 3: {
                        final double n16 = a ? (-this.e) : this.e;
                        final double e2 = this.e;
                        eh.b(n2 - n8 * n16 + n7 * e2, n3 + n7 * n16 + n8 * e2, ei);
                        eh.b(n5 - n8 * n16 - n7 * e2, n6 + n7 * n16 - n8 * e2, ei);
                        eh.b(n5, n6, ei);
                        if (z) {
                            break Label_0886;
                        }
                        return;
                    }
                    case 6: {
                        final double n17 = n5 - n2;
                        final double n18 = n6 - n3;
                        if (a) {
                            eh.b(n2 + (n18 + n17) * 0.5, n3 + (n18 - n17) * 0.5, ei);
                            eh.b(n5, n6, ei);
                            if (!z) {
                                return;
                            }
                        }
                        eh.b(n2 + (n17 - n18) * 0.5, n3 + (n17 + n18) * 0.5, ei);
                        eh.b(n5, n6, ei);
                        return;
                    }
                }
            }
            eh.a(n5, n6, ei);
            if (z) {
                continue;
            }
            break;
        }
    }
    
    protected void a(final eH eh, final eI ei, final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
    }
    
    private boolean a(final double n, final double n2) {
        switch (this.c()) {
            case 8: {
                return false;
            }
            case 7: {
                return true;
            }
            default: {
                if (Math.abs(n) > Math.abs(n2)) {
                    return n >= 0.0;
                }
                return n2 >= 0.0;
            }
            case 6: {
                if (Math.abs(n) > Math.abs(n2)) {
                    return n <= 0.0;
                }
                return n2 <= 0.0;
            }
            case 1: {
                return n > 0.0 || (n == 0.0 && n2 > 0.0);
            }
            case 2: {
                return n < 0.0 || (n == 0.0 && n2 > 0.0);
            }
            case 4: {
                return n2 > 0.0 || (n2 == 0.0 && n > 0.0);
            }
            case 3: {
                return n2 < 0.0 || (n2 == 0.0 && n > 0.0);
            }
        }
    }
}
