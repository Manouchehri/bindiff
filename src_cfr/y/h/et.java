/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.font.FontRenderContext;
import y.d.n;
import y.h.eR;
import y.h.fj;
import y.h.gZ;
import y.h.hc;
import y.h.hj;

final class eT
implements hc {
    eT() {
    }

    @Override
    public void a(gZ gZ2, FontRenderContext fontRenderContext) {
        boolean bl2 = fj.z;
        if (!(gZ2 instanceof eR)) return;
        eR eR2 = (eR)gZ2;
        eR2.sizeDirty = false;
        hj.d.a(gZ2, fontRenderContext, eR2.v);
        double d2 = eR2.contentHeight;
        double d3 = eR2.contentWidth;
        switch (eR2.v) {
            fj fj2;
            case 4: {
                if (!bl2) break;
            }
            case 2: {
                fj2 = eR2.g();
                if (fj2 == null) break;
                d2 = fj2.getHeight();
                if (!bl2) break;
            }
            case 3: {
                fj2 = eR2.g();
                if (fj2 == null) break;
                d3 = fj2.getWidth();
                d2 = fj2.getHeight();
                if (!bl2) break;
            }
            case 1: {
                fj2 = eR2.g();
                if (fj2 == null) break;
                d3 = fj2.getWidth();
            }
        }
        eR2.setContentSize(d3, d2);
    }

    @Override
    public boolean a(gZ gZ2, double d2, double d3) {
        return gZ2.getContentBox().a(d2, d3, true);
    }
}

