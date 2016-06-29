package y.f.g;

import java.util.*;
import y.c.*;
import y.d.*;

final class r
{
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    private x g;
    private int h;
    private int i;
    private int j;
    private final n k;
    
    r(final n k, final int c, final int d, final int a, final int b) {
        this.k = k;
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = 0;
        this.d = d;
        this.f = 0;
        this.g = new x(a * b);
    }
    
    int a() {
        return this.e;
    }
    
    int b() {
        return this.f;
    }
    
    void a(final int n, final int n2, final int n3, final int n4) {
        final boolean d = y.f.g.d.d;
        int i = n2;
        while (i < n4) {
            this.a(n, n3, i, true);
            ++i;
            if (d) {
                break;
            }
        }
    }
    
    void c() {
        final boolean d = y.f.g.d.d;
        final int[] array = new int[this.b];
        final int[] array2 = new int[this.b];
        final int[] array3 = new int[this.a];
        final int[] array4 = new int[this.a];
        int i = 0;
        while (true) {
            while (i < array.length) {
                array[i] = this.a;
                array2[i] = -1;
                ++i;
                if (d) {
                    while (true) {
                        while (i < array3.length) {
                            array3[i] = this.b;
                            array4[i] = -1;
                            ++i;
                            if (d) {
                                while (true) {
                                    while (i >= 0) {
                                        final int n = i % this.a;
                                        final int n2 = i / this.a;
                                        array[n2] = Math.min(array[n2], n);
                                        array3[n] = Math.min(array3[n], n2);
                                        array2[n2] = Math.max(array2[n2], n);
                                        array4[n] = Math.max(array4[n], n2);
                                        i = this.g.nextSetBit(i + 1);
                                        if (d) {
                                            int j = 0;
                                        Label_0351:
                                            while (j < this.b) {
                                                int n3 = array[j];
                                                while (true) {
                                                    do {
                                                        Label_0238: {
                                                            final int n4 = array2[j];
                                                        }
                                                        int k = 0;
                                                        int n5 = 0;
                                                        Label_0244:
                                                        while (k < n5) {
                                                            final int n6 = array3[n3];
                                                            final int n7 = j;
                                                            if (!d) {
                                                                if (n6 <= n7 && array4[n3] >= j) {
                                                                    int n8 = n3 + 1;
                                                                    while (array3[n8] <= j) {
                                                                        k = array4[n8];
                                                                        n5 = j;
                                                                        if (d) {
                                                                            continue Label_0244;
                                                                        }
                                                                        if (k < n5) {
                                                                            break;
                                                                        }
                                                                        ++n8;
                                                                        if (d) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    this.g.set(i + n3, i + n8);
                                                                }
                                                                ++n3;
                                                                continue Label_0238;
                                                            }
                                                            i = n6 + n7;
                                                            ++j;
                                                            if (d) {
                                                                break Label_0351;
                                                            }
                                                            continue Label_0351;
                                                        }
                                                        break;
                                                    } while (!d);
                                                    final int a = this.a;
                                                    continue;
                                                }
                                            }
                                            return;
                                        }
                                        if (d) {
                                            break;
                                        }
                                    }
                                    i = 0;
                                    continue;
                                }
                            }
                            if (d) {
                                break;
                            }
                        }
                        i = this.g.nextSetBit(0);
                        continue;
                    }
                }
                if (d) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    q a(final r r, final int n, final int n2, final int n3, final int n4, final boolean b, final y y, final D d, final D d2, final boolean b2) {
        final boolean d3 = d.d;
        this.h = Integer.MAX_VALUE;
        this.i = 0;
        this.j = 0;
        this.b(n - (this.c + this.a / 2), n2 - (this.d + this.b / 2));
        final int n5 = this.c + this.a / 2;
        final int n6 = this.d + this.b / 2;
        q a = null;
        int i = 0;
        while (true) {
            while (i < n4) {
                final boolean c = n.c(this.k);
                if (!d3) {
                    if (c) {
                        a = this.a(r, i, y, d, b, b2);
                        if (a != null) {
                            final double sqrt = Math.sqrt((n5 - a.a) * (n5 - a.a) + (n6 - a.b) * (n6 - a.b));
                            int compare = 0;
                            Label_0504: {
                                if (d2 != null && !d2.isEmpty()) {
                                    final int n7 = n5 - a.a;
                                    final int n8 = n6 - a.b;
                                    this.c += n7;
                                    this.d += n8;
                                    this.e += n7;
                                    this.f += n8;
                                    final v v = new v(this.k, n5, n6);
                                    d2.sort(v);
                                    final C m = d2.m();
                                    while (m.f()) {
                                        final q q = (q)m.d();
                                        compare = v.compare(q, a);
                                        if (d3) {
                                            break Label_0504;
                                        }
                                        if (compare < 0 && (t.a(n5, n6, q.a, q.b) < Math.max(n.d(this.k) / n.a(this.k), sqrt) || t.a(a.a, a.b, q.a, q.b) < 15.0 / n.a(this.k)) && this.a(r, q.a - n5, q.b - n6, y, b)) {
                                            return q;
                                        }
                                        m.g();
                                        if (d3) {
                                            break;
                                        }
                                    }
                                    this.c -= n7;
                                    this.d -= n8;
                                    this.e -= n7;
                                    this.f -= n8;
                                }
                            }
                            if (compare != 0) {
                                return a;
                            }
                            return null;
                        }
                    }
                    i += n3;
                    if (d3) {
                        break;
                    }
                    continue;
                }
                else {
                    if (c) {
                        this.c += this.i;
                        this.d += this.j;
                        this.e += this.i;
                        this.f += this.j;
                        return a;
                    }
                    return null;
                }
            }
            continue;
        }
    }
    
    boolean a(final r r, final int n, final int n2, final int n3, final int n4, final y y, final boolean b) {
        final boolean d = y.f.g.d.d;
        this.h = Integer.MAX_VALUE;
        this.i = 0;
        this.j = 0;
        this.b(n - (this.c + this.a / 2), n2 - (this.d + this.b / 2));
        int i = 0;
        while (true) {
            while (i < n4) {
                final boolean c = n.c(this.k);
                if (!d) {
                    if (c && this.a(r, 0, 0, i, y, b)) {
                        return i != 0;
                    }
                    i += n3;
                    if (d) {
                        break;
                    }
                    continue;
                }
                else {
                    if (c) {
                        this.c += this.i;
                        this.d += this.j;
                        this.e += this.i;
                        this.f += this.j;
                        return true;
                    }
                    return false;
                }
            }
            continue;
        }
    }
    
    q a(final r r, final int n, final y y, final D d, final boolean b, final boolean b2) {
        final boolean d2 = d.d;
        final int n2 = this.c + this.a / 2;
        final int n3 = this.d + this.b / 2;
        if (n == 0) {
            final C m = d.m();
            while (m.f()) {
                final u u = (u)m.d();
                if (!b2 || u.b()) {
                    final t t = new t(n2, n3);
                    if (u.a(t) && this.a(r, 0, 0, y, b)) {
                        return new q(t, u.l(), u);
                    }
                }
                m.g();
                if (d2) {
                    break;
                }
            }
            return null;
        }
        final p p6 = new p(new t(n2, n3), n);
        final D d3 = new D();
        final C i = d.m();
        do {
            Label_0186: {
                i.f();
            }
            boolean a = false;
            Label_0193:
            while (a) {
                final u u2 = (u)i.d();
                if (!b2 || u2.b()) {
                    t[] array = null;
                    Label_0276: {
                        if (u2.c().a() == u2.d().a()) {
                            array = p6.b(u2.c().a());
                            if (!d2) {
                                break Label_0276;
                            }
                        }
                        array = p6.a(u2.c().b());
                    }
                    if (array != null) {
                        int j = 0;
                        while (j < array.length) {
                            a = u2.a(array[j]);
                            if (d2) {
                                continue Label_0193;
                            }
                            if (a) {
                                d3.add(new q(array[j], u2.l(), u2));
                            }
                            ++j;
                            if (d2) {
                                break;
                            }
                        }
                    }
                }
                i.g();
                continue Label_0186;
            }
            break;
        } while (!d2);
        d3.sort(new v(this.k));
        final C k = d3.m();
        while (k.f()) {
            final q q = (q)k.d();
            if (this.a(r, q.a - n2, q.b - n3, y, b)) {
                return q;
            }
            k.g();
            if (d2) {
                break;
            }
        }
        return null;
    }
    
    boolean a(final r r, final int n, final int n2, final int n3, final y y, final boolean b) {
        final boolean d = y.f.g.d.d;
        if (n3 == 0) {
            return this.a(r, n, n2, y, b);
        }
        int i = n3;
        int n4 = 0;
        int n6;
        final int n5 = n6 = n3 * n3;
        boolean a = false;
        while (i >= n4) {
            a = this.a(r, n + i, n2 + n4, y, b);
            if (d) {
                return a;
            }
            if (a) {
                return true;
            }
            if (this.a(r, n + i, n2 - n4, y, b)) {
                return true;
            }
            if (this.a(r, n - i, n2 + n4, y, b)) {
                return true;
            }
            if (this.a(r, n - i, n2 - n4, y, b)) {
                return true;
            }
            if (this.a(r, n + n4, n2 + i, y, b)) {
                return true;
            }
            if (this.a(r, n + n4, n2 - i, y, b)) {
                return true;
            }
            if (this.a(r, n - n4, n2 + i, y, b)) {
                return true;
            }
            if (this.a(r, n - n4, n2 - i, y, b)) {
                return true;
            }
            if (n6 < n5) {
                n6 += 1 + 2 * n4;
                ++n4;
                if (!d) {
                    continue;
                }
            }
            n6 += 2 - 2 * i + 2 * n4;
            --i;
            ++n4;
            if (d) {
                break;
            }
        }
        return a;
    }
    
    private final boolean a(final r r, final int i, final int j, final y y, final boolean b) {
        final t t = new t(i + this.c + this.a * 0.5, j + this.d + this.b * 0.5);
        if (y != null && !y.a(t)) {
            return false;
        }
        if (!b) {
            return this.a(r, i, j);
        }
        this.c += i;
        this.d += j;
        final int b2 = this.b(r);
        if (b2 < this.h) {
            this.h = b2;
            this.i = i;
            this.j = j;
        }
        if (b2 == 0) {
            this.e += i;
            this.f += j;
            return true;
        }
        this.c -= i;
        this.d -= j;
        return false;
    }
    
    private final boolean a(final r r, final int n, final int n2) {
        this.c += n;
        this.d += n2;
        if (!this.a(r)) {
            this.e += n;
            this.f += n2;
            return true;
        }
        this.c -= n;
        this.d -= n2;
        return false;
    }
    
    private int b(final r r) {
        final boolean d = y.f.g.d.d;
        final int max = Math.max(this.c, r.c);
        final int min = Math.min(this.c + this.a, r.c + r.a);
        final int max2 = Math.max(this.d, r.d);
        final int min2 = Math.min(this.d + this.b, r.d + r.b);
        int n = 0;
        int n2 = max;
        int n3 = 0;
        do {
            int i = 0;
        Label_0083:
            while (i < min) {
                n3 = max2;
                if (d) {
                    return n3;
                }
                int j = n3;
                while (j < min2) {
                    i = (this.a(n2, j) ? 1 : 0);
                    if (d) {
                        continue Label_0083;
                    }
                    if (i != 0 && r.a(n2, j)) {
                        ++n;
                    }
                    ++j;
                    if (d) {
                        break;
                    }
                }
                ++n2;
            }
            break;
        } while (!d);
        return n3;
    }
    
    public boolean a(final int n, final int n2) {
        return n >= this.c && n < this.c + this.a && n2 >= this.d && n2 < this.d + this.b && this.g.get((n2 - this.d) * this.a + n - this.c);
    }
    
    public void a(final int n, final int n2, final boolean b) {
        if (n < this.c || n >= this.c + this.a || n2 < this.d || n2 >= this.d + this.b) {
            throw new IndexOutOfBoundsException();
        }
        final int n3 = (n2 - this.d) * this.a + n - this.c;
        if (b) {
            this.g.set(n3);
            if (!y.f.g.d.d) {
                return;
            }
        }
        this.g.clear(n3);
    }
    
    public void a(final int n, final int n2, final int n3, final boolean b) {
        if (n < this.c || n2 >= this.c + this.a || n3 < this.d || n3 >= this.d + this.b) {
            throw new IndexOutOfBoundsException();
        }
        final int n4 = (n3 - this.d) * this.a + n - this.c;
        final int n5 = (n3 - this.d) * this.a + n2 - this.c;
        if (b) {
            this.g.set(n4, n5);
            if (!y.f.g.d.d) {
                return;
            }
        }
        this.g.clear(n4, n5);
    }
    
    public void b(final int n, final int n2) {
        this.c += n;
        this.d += n2;
        this.e += n;
        this.f += n2;
    }
    
    public boolean a(final r r) {
        final boolean d = y.f.g.d.d;
        if (r.c >= this.c + this.a || r.d >= this.d + this.b || r.c + r.a <= this.c || r.d + r.b <= this.d) {
            return false;
        }
        final int max = Math.max(this.c, r.c);
        final int min = Math.min(this.c + this.a, r.c + r.a);
        final int max2 = Math.max(this.d, r.d);
        final int max3 = Math.max(this.d + this.b, r.d + r.b);
        if (max < min && max2 < max3) {
            int i = this.a(max, max2, max, max2, min, max3);
            int n = r.a(max, max2, max, max2, min, max3);
            while (i >= 0) {
                final int n2 = n;
                if (d || n2 < 0) {
                    return n2 != 0;
                }
                final int n3 = i % this.a + this.c;
                final int n4 = n % r.a + r.c;
                final int n5 = i / this.a + this.d;
                final int n6 = n / r.a + r.d;
                if (n5 == n6) {
                    if (n3 == n4) {
                        return true;
                    }
                    if (n3 < n4) {
                        i = this.a(n4, n6, max, max2, min, max3);
                        if (!d) {
                            continue;
                        }
                    }
                    n = r.a(n3, n5, max, max2, min, max3);
                    if (!d) {
                        continue;
                    }
                }
                if (n5 < n6) {
                    i = this.a(n4, n6, max, max2, min, max3);
                    if (!d) {
                        continue;
                    }
                }
                n = r.a(n3, n5, max, max2, min, max3);
                if (d) {
                    goto Label_0390;
                }
            }
            goto Label_0390;
        }
        return false;
    }
    
    public final int a(final int n, final int n2, int n3, int n4, int n5, int n6) {
        final boolean d = y.f.g.d.d;
        int n7 = n - this.c + (n2 - this.d) * this.a;
        n3 -= this.c;
        n5 -= this.c;
        n4 -= this.d;
        n6 -= this.d;
        boolean b = n7 >= 0 && n7 % this.a >= n3 && n7 % this.a < n5 && n7 / this.a >= n4 && n7 / this.a < n6;
    Label_0118:
        while (true) {
            Label_0170: {
                if (!b) {
                    if (n7 % this.a < n3) {
                        n7 += n3 - n7 % this.a;
                        if (!d) {
                            break Label_0170;
                        }
                    }
                    n7 += this.a - n7 % this.a;
                }
            }
            final int nextSetBit;
            n7 = (nextSetBit = this.g.nextSetBit(n7));
            int i = 0;
            while (i >= 0) {
                b = (n7 % this.a >= n3 && n7 % this.a < n5 && n7 / this.a >= n4 && n7 / this.a < n6);
                if (!b) {
                    continue Label_0118;
                }
                i = n7;
                if (!d) {
                    return i;
                }
            }
            return -1;
        }
    }
    
    public String toString() {
        final boolean d = y.f.g.d.d;
        final StringBuffer sb = new StringBuffer(this.a * this.b + this.b + 1);
        int n = 0;
        int n2 = 0;
        do {
            int i = 0;
        Label_0034:
            while (i < this.b) {
                int j = 0;
                while (j < this.a) {
                    i = (this.g.get(n) ? 1 : 0);
                    if (d) {
                        continue Label_0034;
                    }
                    Label_0088: {
                        if (i != 0) {
                            sb.append('#');
                            if (!d) {
                                break Label_0088;
                            }
                        }
                        sb.append('.');
                    }
                    ++n;
                    ++j;
                    if (d) {
                        break;
                    }
                }
                sb.append('\n');
                ++n2;
            }
            break;
        } while (!d);
        return "x: " + this.c + " y: " + this.d + "\n" + sb.toString();
    }
}
