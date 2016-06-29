package y.h.a;

import y.h.*;
import java.awt.geom.*;
import java.awt.*;
import y.d.*;

public class L extends gd implements a, gt
{
    public L() {
    }
    
    public L(final fj fj) {
        super(fj);
    }
    
    public fj createCopy(final fj fj) {
        return new L(fj);
    }
    
    public r getAutoBoundsInsets() {
        final fj e = this.e();
        if (e != null) {
            final a autoBoundsFeature = e.getAutoBoundsFeature();
            if (autoBoundsFeature != null) {
                return autoBoundsFeature.getAutoBoundsInsets();
            }
        }
        return new r(0.0, 0.0, 0.0, 0.0);
    }
    
    public void setAutoBoundsInsets(final r autoBoundsInsets) {
        final fj e = this.e();
        if (e != null) {
            final a autoBoundsFeature = e.getAutoBoundsFeature();
            if (autoBoundsFeature != null) {
                autoBoundsFeature.setAutoBoundsInsets(autoBoundsInsets);
            }
        }
    }
    
    public boolean isAutoBoundsEnabled() {
        final fj e = this.e();
        if (e != null) {
            final a autoBoundsFeature = e.getAutoBoundsFeature();
            if (autoBoundsFeature != null) {
                return autoBoundsFeature.isAutoBoundsEnabled();
            }
        }
        return false;
    }
    
    public void setAutoBoundsEnabled(final boolean autoBoundsEnabled) {
        final fj e = this.e();
        if (e != null) {
            final a autoBoundsFeature = e.getAutoBoundsFeature();
            if (autoBoundsFeature != null) {
                autoBoundsFeature.setAutoBoundsEnabled(autoBoundsEnabled);
            }
        }
    }
    
    public Rectangle2D getMinimalAutoBounds() {
        final fj e = this.e();
        if (e != null) {
            final a autoBoundsFeature = e.getAutoBoundsFeature();
            if (autoBoundsFeature != null) {
                return autoBoundsFeature.getMinimalAutoBounds();
            }
        }
        return new Rectangle(0, 0, -1, -1);
    }
    
    public q getMinimumSize() {
        final fj e = this.e();
        if (e != null) {
            final gt sizeConstraintProvider = e.getSizeConstraintProvider();
            if (sizeConstraintProvider != null) {
                return sizeConstraintProvider.getMinimumSize();
            }
        }
        return new q(0.0, 0.0);
    }
    
    public q getMaximumSize() {
        final fj e = this.e();
        if (e != null) {
            final gt sizeConstraintProvider = e.getSizeConstraintProvider();
            if (sizeConstraintProvider != null) {
                return sizeConstraintProvider.getMaximumSize();
            }
        }
        return new q(Double.MAX_VALUE, Double.MAX_VALUE);
    }
}
