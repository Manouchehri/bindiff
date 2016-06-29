/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Iterator;
import y.c.q;
import y.f.al;
import y.g.A;
import y.g.z;
import y.h.U;
import y.h.bu;
import y.h.cW;
import y.h.cZ;
import y.h.cd;
import y.h.cg;
import y.h.ch;
import y.h.eR;
import y.h.eU;
import y.h.fM;
import y.h.fj;
import y.h.ft;
import y.h.gY;

public class cY
implements cZ {
    private ch a;

    public cY(ch ch2) {
        this.a = ch2;
    }

    @Override
    public cW a(double d2, double d3, int n2, boolean bl2) {
        cW cW2 = this.a(this.a(), this.b(), d2, d3, n2, bl2);
        if (!bl2) return cW2;
        if ((n2 & 16) == 0) return cW2;
        if (!cW2.s()) return cW2;
        if (cW2.l().isSelected()) return cW2;
        if ((n2 & 1) != 0 && (n2 & 64) != 0) {
            eR eR2 = cW2.l();
            fj fj2 = eR2.g();
            if (fj2 == null) return cW2;
            if (!(eR2.a() instanceof fM)) {
                if (fj2.getNode() == null) return cW2;
                if (!fj2.contains(d2, d3)) return cW2;
                return cY.a(fj2.getNode());
            }
            eU eU2 = fM.a(fj2, eR2.getModelParameter());
            if (eU2 != null && eU2.f() && eU2.a(d2, d3)) {
                return cY.a(eU2);
            }
            if (fj2.getNode() == null) return cW2;
            if (!fj2.contains(d2, d3)) return cW2;
            return cY.a(fj2.getNode());
        }
        if ((n2 & 1) != 0) {
            eR eR3 = cW2.l();
            fj fj3 = eR3.g();
            if (fj3 == null) return cW2;
            if (fj3.getNode() == null) return cW2;
            if (!fj3.contains(d2, d3)) return cW2;
            return cY.a(fj3.getNode());
        }
        if ((n2 & 64) == 0) return cW2;
        eR eR4 = cW2.l();
        fj fj4 = eR4.g();
        if (fj4 == null) return cW2;
        if (!(eR4.a() instanceof fM)) return cW2;
        eU eU3 = fM.a(fj4, eR4.getModelParameter());
        if (eU3 == null) return cW2;
        if (!eU3.f()) return cW2;
        if (!eU3.a(d2, d3)) return cW2;
        return cY.a(eU3);
    }

    protected cW a(ch ch2, bu bu2, double d2, double d3, int n2, boolean bl2) {
        Iterator iterator = cY.a(ch2, bu2, n2);
        return new cW(bu2, iterator, d2, d3, bl2);
    }

    protected ch a() {
        return this.a;
    }

    protected bu b() {
        return this.a().getGraph2D();
    }

    private static Iterator a(ch ch2, bu bu2, int n2) {
        cg cg2;
        block2 : {
            if (ch2.getGraph2DRenderer() instanceof ft) {
                ft ft2 = (ft)ch2.getGraph2DRenderer();
                cg cg3 = cg2 = ch2.getZoom() >= ch2.getPaintDetailThreshold() ? ft2.getPaintOrder() : ft2.getSloppyPaintOrder();
                if (!fj.z) break block2;
            }
            cg2 = new U();
        }
        if (Boolean.TRUE.equals(ch2.getClientProperty("Graph2DView.hitTestInvisibleElements"))) return cg2.b(bu2, n2);
        int n3 = 1;
        return new A(cg2.b(bu2, n2), new gY(bu2, n3, n3, n3, n3));
    }

    private static cW a(q q2) {
        cW cW2 = new cW();
        cW2.a(q2);
        return cW2;
    }

    private static cW a(eU eU2) {
        cW cW2 = new cW();
        cW2.a(eU2);
        return cW2;
    }
}

