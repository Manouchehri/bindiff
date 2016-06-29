/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Iterator;
import y.c.d;
import y.c.q;
import y.g.A;
import y.g.z;
import y.h.a.v;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.cg;
import y.h.eR;
import y.h.eU;
import y.h.fj;
import y.h.hJ;
import y.h.hK;
import y.h.hN;
import y.h.hQ;

class hP
implements cg {
    private cg a;
    private boolean b;

    public hP(cg cg2, boolean bl2) {
        this.a = cg2;
        this.b = bl2;
    }

    @Override
    public Iterator a(bu bu2, int n2) {
        return this.a(bu2, n2, true);
    }

    @Override
    public Iterator b(bu bu2, int n2) {
        return this.a(bu2, n2, false);
    }

    private Iterator a(bu bu2, int n2, boolean bl2) {
        A a2 = new A(this.a(bu2, bl2), new hJ(this, bu2));
        A a3 = new A(this.a(bu2, bl2), new hK(this, bu2));
        return new hQ(bu2, new hN(a3, a2, bl2), n2, bl2);
    }

    private Iterator a(bu bu2, boolean bl2) {
        if (!bl2) return this.a.b(bu2, 3);
        return this.a.a(bu2, 3);
    }

    private boolean a(Object object, bu bu2) {
        if (object instanceof q) {
            if (this.a(bu2, (q)object)) return true;
        }
        if (!(object instanceof d)) return false;
        if (!this.a(bu2, (d)object)) return false;
        return true;
    }

    private boolean a(bu bu2, q q2) {
        boolean bl2 = bu2.v(q2);
        if (bl2) return true;
        if (this.c(bu2, q2)) return true;
        if (this.b(bu2, q2)) {
            return true;
        }
        if (!this.b) return false;
        v v2 = bu2.C();
        if (v2 == null) return false;
        q q3 = v2.n(q2);
        if (q3 == null) return false;
        if (!this.a(bu2, q3)) return false;
        return true;
    }

    private boolean a(bu bu2, d d2) {
        if (bu2.r(d2)) return true;
        if (this.b(bu2, d2)) return true;
        if (this.a(bu2, d2.c())) return true;
        if (this.a(bu2, d2.d())) return true;
        return false;
    }

    private boolean b(bu bu2, q q2) {
        boolean bl2 = fj.z;
        fj fj2 = bu2.t(q2);
        if (fj2.portCount() <= 0) return false;
        Iterator iterator = fj2.ports();
        do {
            if (!iterator.hasNext()) return false;
        } while (!((eU)iterator.next()).f());
        boolean bl3 = true;
        if (bl2) return bl3;
        return bl3;
    }

    private boolean c(bu bu2, q q2) {
        boolean bl2 = fj.z;
        fj fj2 = bu2.t(q2);
        int n2 = 0;
        do {
            if (n2 >= fj2.labelCount()) return false;
            eR eR2 = fj2.getLabel(n2);
            boolean bl3 = eR2.isSelected();
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            ++n2;
        } while (!bl2);
        return false;
    }

    private boolean b(bu bu2, d d2) {
        boolean bl2 = fj.z;
        aB aB2 = bu2.i(d2);
        int n2 = 0;
        do {
            if (n2 >= aB2.labelCount()) return false;
            aA aA2 = aB2.getLabel(n2);
            boolean bl3 = aA2.isSelected();
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            ++n2;
        } while (!bl2);
        return false;
    }

    static boolean a(hP hP2, Object object, bu bu2) {
        return hP2.a(object, bu2);
    }
}

