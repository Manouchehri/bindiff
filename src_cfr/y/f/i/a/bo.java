/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.c.D;
import y.f.i.a.L;
import y.f.i.a.M;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.ai;
import y.f.i.a.bN;
import y.f.i.a.w;
import y.f.i.a.y;

class bO {
    D a;
    Set b;
    M c;
    double d;
    private final bN e;

    bO(bN bN2, w w2) {
        this.e = bN2;
        this.a = new D();
        this.b = new HashSet();
        this.a.add(w2);
        this.b.add(w2);
        this.c = w2.a(bN2.b).c();
        bN2.c.add(this.c);
    }

    bO(bN bN2, bO bO2, bO bO3, M m2) {
        this.e = bN2;
        this.a = new D(bO2.a);
        this.b = new HashSet(bO2.b);
        this.a(bO3.a);
        this.c = m2;
        bN2.c.add(this.c);
    }

    public void a(w w2) {
        if (!this.b.add(w2)) return;
        this.a.add(w2);
    }

    public void a(D d2) {
        int n2 = ab.a;
        Iterator iterator = d2.iterator();
        do {
            if (!iterator.hasNext()) return;
            w w2 = (w)iterator.next();
            this.a(w2);
        } while (n2 == 0);
    }

    public void a(bO bO2) {
        this.a.a(bO2.a);
        this.b.addAll(bO2.b);
    }

    public double a() {
        return this.d;
    }

    private void b() {
        int n2 = ab.a;
        double d2 = this.a.size();
        double d3 = ((double)this.e.a.size() / d2 - 1.0) * 5.0;
        double d4 = bN.a(this.e).a().c().k() == null || bN.a(this.e).a().c().k().a(this.c, this.e.d) ? 0.0 : 1.0;
        double d5 = 0.0;
        for (w w2 : this.a) {
            ai ai2 = w2.a(this.e.b);
            M m2 = ai2.c();
            if (m2.d() == 0.0) continue;
            byte by2 = ai2.d();
            if (n2 != 0) return;
            if (by2 == -1) {
                d5 += this.c.b(m2.a()) / m2.d();
                if (n2 == 0) continue;
            }
            if (by2 != 1) continue;
            d5 += this.c.b(m2.b()) / m2.d();
            if (n2 == 0) continue;
        }
        this.d = d3 + d4 + (d5 /= (double)this.a.size());
    }

    public boolean b(D d2) {
        this.a.removeAll(d2);
        if (this.a.size() == 0) {
            return true;
        }
        this.b.removeAll(d2);
        this.b();
        return false;
    }

    static void b(bO bO2) {
        bO2.b();
    }
}

