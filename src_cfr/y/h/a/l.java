/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.d.q;
import y.d.r;
import y.h.a.a;
import y.h.fj;
import y.h.gd;
import y.h.gt;

public class L
extends gd
implements a,
gt {
    public L() {
    }

    public L(fj fj2) {
        super(fj2);
    }

    @Override
    public fj createCopy(fj fj2) {
        return new L(fj2);
    }

    @Override
    public r getAutoBoundsInsets() {
        fj fj2 = this.e();
        if (fj2 == null) return new r(0.0, 0.0, 0.0, 0.0);
        a a2 = fj2.getAutoBoundsFeature();
        if (a2 == null) return new r(0.0, 0.0, 0.0, 0.0);
        return a2.getAutoBoundsInsets();
    }

    @Override
    public void setAutoBoundsInsets(r r2) {
        fj fj2 = this.e();
        if (fj2 == null) return;
        a a2 = fj2.getAutoBoundsFeature();
        if (a2 == null) return;
        a2.setAutoBoundsInsets(r2);
    }

    @Override
    public boolean isAutoBoundsEnabled() {
        fj fj2 = this.e();
        if (fj2 == null) return false;
        a a2 = fj2.getAutoBoundsFeature();
        if (a2 == null) return false;
        return a2.isAutoBoundsEnabled();
    }

    @Override
    public void setAutoBoundsEnabled(boolean bl2) {
        fj fj2 = this.e();
        if (fj2 == null) return;
        a a2 = fj2.getAutoBoundsFeature();
        if (a2 == null) return;
        a2.setAutoBoundsEnabled(bl2);
    }

    @Override
    public Rectangle2D getMinimalAutoBounds() {
        fj fj2 = this.e();
        if (fj2 == null) return new Rectangle(0, 0, -1, -1);
        a a2 = fj2.getAutoBoundsFeature();
        if (a2 == null) return new Rectangle(0, 0, -1, -1);
        return a2.getMinimalAutoBounds();
    }

    @Override
    public q getMinimumSize() {
        fj fj2 = this.e();
        if (fj2 == null) return new q(0.0, 0.0);
        gt gt2 = fj2.getSizeConstraintProvider();
        if (gt2 == null) return new q(0.0, 0.0);
        return gt2.getMinimumSize();
    }

    @Override
    public q getMaximumSize() {
        fj fj2 = this.e();
        if (fj2 == null) return new q(Double.MAX_VALUE, Double.MAX_VALUE);
        gt gt2 = fj2.getSizeConstraintProvider();
        if (gt2 == null) return new q(Double.MAX_VALUE, Double.MAX_VALUE);
        return gt2.getMaximumSize();
    }
}

