package y.f.h.a;

import java.util.*;
import y.f.h.*;

public class e extends b
{
    int[] h;
    
    boolean b() {
        final boolean g = y.f.h.a.b.g;
        final boolean b = super.b();
        this.h = new int[this.c.length];
        int i = 0;
        while (i < this.h.length) {
            this.h[i] = -1;
            ++i;
            if (g) {
                break;
            }
        }
        return b;
    }
    
    int a(final n n) {
        final boolean g = y.f.h.a.b.g;
        if (this.h[n.f()] == -1) {
            int n2 = 0;
            Label_0139: {
                if (n.h() != null) {
                    for (final i i : n.h()) {
                        m m = i.s();
                        r r = m.a(i);
                        n2 += m.a();
                        while (r != i) {
                            final int n3 = n2 + this.a((n)r);
                            m = r.c(m);
                            n2 = n3 + m.a();
                            r = m.a(r);
                            if (g) {
                                break Label_0139;
                            }
                            if (g) {
                                return this.h[n.f()];
                            }
                            if (g) {
                                break Label_0139;
                            }
                        }
                    }
                }
            }
            this.h[n.f()] = n2;
        }
        return this.h[n.f()];
    }
    
    protected void a(final n n, final int n2, final int n3) {
        final boolean g = y.f.h.a.b.g;
        while (n.d(n3)) {
            ((a)n.a(n.c().c(), n2 ^ 0x1, n2)).a(2 + this.a(n));
            if (g) {
                break;
            }
        }
    }
    
    protected boolean a(final n n, final n n2, final m m) {
        final boolean g = y.f.h.a.b.g;
        final int f = n.f();
        boolean b = false;
        int n3 = 0;
        final int[] array = new int[2];
        final boolean[] array2 = new boolean[2];
        n b2 = n2;
        i i = null;
        int n4 = 0;
        this.d[0].b();
        this.d[1].b();
        this.e.b();
        this.e.a(m);
        int n5 = 0;
        boolean b3 = false;
        int n6 = 0;
        int n17 = 0;
    Label_0873_Outer:
        while (!b && n3 < 2) {
            b3 = (b3 || n6 != 0 || b2.c(f));
            array2[0] = !b2.u();
            array2[1] = false;
            array[1] = (array[0] = 0);
            i j = null;
            int a = 0;
            if (!b3 && b2.d(f)) {
                this.a(b2, 1, f);
            }
            int n7 = 0;
        Label_1179:
            while (true) {
                do {
                    int k = 0;
                Label_1119_Outer:
                    while (k < 2) {
                        final int n8 = array2[n7] ? 1 : 0;
                        if (!g) {
                            if (n8 == 0) {
                                n n9 = b2;
                                int n10 = n7;
                                r r = null;
                                m l = null;
                                Label_0307: {
                                    if (n7 == 1 && !b3 && i != null) {
                                        r = b2;
                                        n5 = n7;
                                        l = b2.f(n7 ^ 0x1);
                                        if (!g) {
                                            break Label_0307;
                                        }
                                    }
                                    l = b2.f(n7);
                                    r = l.a(b2);
                                    final int[] array3 = array;
                                    final int n11 = n7;
                                    array3[n11] += l.a();
                                    final int[] array4 = array;
                                    final int n12 = n7;
                                    array4[n12] += this.a(b2);
                                }
                                int n13 = 0;
                                while (n13 == 0 && !array2[n7]) {
                                    if (r instanceof i) {
                                        final i i2 = (i)r;
                                        n13 = 1;
                                        Label_0523: {
                                            if (b3) {
                                                if (n7 != 1 || array2[0]) {
                                                    break Label_0523;
                                                }
                                                if (array[0] >= array[1]) {
                                                    y.f.h.a.b.a(b2, j, 0, a, array[0]);
                                                    array2[0] = true;
                                                    if (!g) {
                                                        break Label_0523;
                                                    }
                                                }
                                                l = j.c(y.f.h.a.b.a(n9, j, n10, a ^ 0x1, array[1]));
                                                array2[1] = true;
                                                if (!g) {
                                                    break Label_0523;
                                                }
                                            }
                                            if (n7 == 1) {
                                                if (array2[0] || array[0] >= array[1]) {
                                                    array2[0] = true;
                                                    if (!g) {
                                                        break Label_0523;
                                                    }
                                                }
                                                array2[1] = true;
                                                l = j.c(y.f.h.a.b.a(n9, j, n10, a ^ 0x1, array[1]));
                                                if (!g) {
                                                    break Label_0523;
                                                }
                                            }
                                            l = y.f.h.a.b.a(n9, i2, n10, i2.a(l, n7 ^ 0x1), array[0]);
                                        }
                                        j = i2;
                                        a = i2.a(l, n7 ^ 0x1);
                                        if (!g) {
                                            continue Label_0873_Outer;
                                        }
                                    }
                                    if (r instanceof n) {
                                        final n n14 = (n)r;
                                        final int[] array5 = array;
                                        final int n15 = n7;
                                        array5[n15] += this.a(n14);
                                        k = (n14.c(f) ? 1 : 0);
                                        if (g) {
                                            continue Label_1119_Outer;
                                        }
                                        if (k != 0) {
                                            ++n3;
                                            array2[n7] = true;
                                            y.f.h.a.b.a(n9, r, n10, n14.a(l, 0x1 ^ n5), array[n7]);
                                            array[n7] = 0;
                                            n6 = 1;
                                            n13 = (array2[0] ? 0 : 1);
                                            if (!g) {
                                                continue Label_0873_Outer;
                                            }
                                        }
                                        if (n14.e(f)) {
                                            n5 = (n14.a(l, n5 ^ 0x1) ^ 0x1);
                                            if (n14.d(f)) {
                                                this.a(n14, n5, f);
                                            }
                                            if (!n14.m().isEmpty()) {
                                                final m o = n14.o();
                                                n10 = n5;
                                                n9 = n14;
                                                array[n7] = 0;
                                                Label_0756: {
                                                    if (n10 == 1) {
                                                        n14.e(o);
                                                        if (!g) {
                                                            break Label_0756;
                                                        }
                                                    }
                                                    n14.d(o);
                                                }
                                                l = o;
                                                this.d[n7].a(o);
                                                if (b3) {
                                                    if (n7 == 1 && !array2[0]) {
                                                        y.f.h.a.b.a(b2, j, 0, a, array[0]);
                                                    }
                                                    if (!array2[n7 ^ 0x1]) {
                                                        ++n3;
                                                    }
                                                    array2[n7 ^ 0x1] = true;
                                                }
                                            }
                                        }
                                        l = r.c(l);
                                        r = l.a(r);
                                        final int[] array6 = array;
                                        final int n16 = n7;
                                        array6[n16] += l.a();
                                        if (g) {
                                            break;
                                        }
                                        continue Label_0873_Outer;
                                    }
                                }
                            }
                            ++n7;
                        }
                        else {
                            if (n8 >= 2) {
                                continue Label_0873_Outer;
                            }
                            n17 = (array2[0] ? 1 : 0);
                            if (g) {
                                break Label_1179;
                            }
                            final int n18 = n17;
                            Label_0984: {
                                if (i != null) {
                                    if (n4 == n18) {
                                        i.d();
                                    }
                                    if (n18 == 0) {
                                        b2.r().b(i.r());
                                        if (!g) {
                                            break Label_0984;
                                        }
                                    }
                                    b2.r().a(i.r());
                                    if (!g) {
                                        break Label_0984;
                                    }
                                }
                                Label_0978: {
                                    if (n18 == 0) {
                                        b2.e(m);
                                        if (!g) {
                                            break Label_0978;
                                        }
                                    }
                                    b2.d(m);
                                }
                                b2.o();
                            }
                            this.e.a(this.d[n18]);
                            if (!b3) {
                                this.e.d(this.d[n18 ^ 0x1]);
                            }
                            Label_1154: {
                                Label_1131: {
                                    if (j.f() == f) {
                                        b = true;
                                        final Iterator d = this.e.d();
                                        while (true) {
                                            while (true) {
                                                while (d.hasNext()) {
                                                    final m m2 = d.next();
                                                    m2.b(j);
                                                    m2.j();
                                                    if (!g) {
                                                        if (g) {
                                                            break;
                                                        }
                                                        continue Label_0873_Outer;
                                                    }
                                                    else {
                                                        j.r().c(this.e);
                                                        this.e.b();
                                                        if (g) {
                                                            break Label_1131;
                                                        }
                                                        break Label_1154;
                                                    }
                                                }
                                                if (a != 0) {
                                                    continue Label_1119_Outer;
                                                }
                                                j.r().b(this.e);
                                                if (g) {
                                                    continue Label_1119_Outer;
                                                }
                                                break;
                                            }
                                            continue;
                                        }
                                    }
                                }
                                j.e();
                                i = j;
                                n4 = a;
                                b2 = j.b();
                                n3 = 0;
                            }
                            this.d[0].b();
                            this.d[1].b();
                            if (g) {
                                break Label_0873_Outer;
                            }
                            continue Label_0873_Outer;
                        }
                    }
                    break;
                } while (!g);
                continue;
            }
            return n17 != 0;
        }
        return n17 != 0;
    }
    
    public boolean a(final D d) {
        this.f = new j();
        if (super.a(d)) {
            this.f = new c(d);
            return super.a(d);
        }
        return false;
    }
}
