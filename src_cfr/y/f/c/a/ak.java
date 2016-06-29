/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Collection;
import y.c.d;
import y.f.aE;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.ak;
import y.g.am;

class aK
extends ak {
    Object k;
    Object l;

    aK(d d2, B b2, Object object, Object object2, aE aE2, Collection collection, aE aE3, Collection collection2) {
        super(d2, b2, aE2, collection, aE3, collection2);
        this.k = object;
        this.l = object2;
    }

    @Override
    public Object g() {
        return this.k;
    }

    @Override
    public Object h() {
        return this.l;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void b(boolean var1_1) {
        if (this.i == var1_1) ** GOTO lbl10
        if (!this.i) ** GOTO lbl-1000
        var2_2 = this.k;
        this.k = this.l != null ? ((am)this.l).b : null;
        v0 = this.l = var2_2 != null ? ((am)var2_2).b : null;
        if (N.x) lbl-1000: // 2 sources:
        {
            var2_2 = this.k;
            this.k = this.l != null ? am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", this.l) : null;
            this.l = var2_2 != null ? am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", var2_2) : null;
        }
lbl10: // 4 sources:
        super.b(var1_1);
    }

    @Override
    public A a(boolean bl2, aE aE2) {
        boolean bl3 = N.x;
        if (bl2) {
            if (this.i) {
                this.b = aE2;
                if (!bl3) return this;
            }
            this.a = aE2;
            if (!bl3) return this;
        }
        if (this.i) {
            this.a = aE2;
            if (!bl3) return this;
        }
        this.b = aE2;
        return this;
    }
}

