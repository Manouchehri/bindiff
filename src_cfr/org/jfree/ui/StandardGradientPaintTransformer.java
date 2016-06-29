/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.util.PublicCloneable;

public class StandardGradientPaintTransformer
implements Serializable,
Cloneable,
GradientPaintTransformer,
PublicCloneable {
    private static final long serialVersionUID = -8155025776964678320L;
    private GradientPaintTransformType type;

    public StandardGradientPaintTransformer() {
        this(GradientPaintTransformType.VERTICAL);
    }

    public StandardGradientPaintTransformer(GradientPaintTransformType gradientPaintTransformType) {
        this.type = gradientPaintTransformType;
    }

    @Override
    public GradientPaint transform(GradientPaint gradientPaint, Shape shape) {
        GradientPaint gradientPaint2 = gradientPaint;
        Rectangle2D rectangle2D = shape.getBounds2D();
        if (this.type.equals(GradientPaintTransformType.VERTICAL)) {
            return new GradientPaint((float)rectangle2D.getCenterX(), (float)rectangle2D.getMinY(), gradientPaint.getColor1(), (float)rectangle2D.getCenterX(), (float)rectangle2D.getMaxY(), gradientPaint.getColor2());
        }
        if (this.type.equals(GradientPaintTransformType.HORIZONTAL)) {
            return new GradientPaint((float)rectangle2D.getMinX(), (float)rectangle2D.getCenterY(), gradientPaint.getColor1(), (float)rectangle2D.getMaxX(), (float)rectangle2D.getCenterY(), gradientPaint.getColor2());
        }
        if (this.type.equals(GradientPaintTransformType.CENTER_HORIZONTAL)) {
            return new GradientPaint((float)rectangle2D.getCenterX(), (float)rectangle2D.getCenterY(), gradientPaint.getColor1(), (float)rectangle2D.getMaxX(), (float)rectangle2D.getCenterY(), gradientPaint.getColor2(), true);
        }
        if (!this.type.equals(GradientPaintTransformType.CENTER_VERTICAL)) return gradientPaint2;
        return new GradientPaint((float)rectangle2D.getCenterX(), (float)rectangle2D.getMinY(), gradientPaint.getColor1(), (float)rectangle2D.getCenterX(), (float)rectangle2D.getCenterY(), gradientPaint.getColor2(), true);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardGradientPaintTransformer)) {
            return false;
        }
        StandardGradientPaintTransformer standardGradientPaintTransformer = (StandardGradientPaintTransformer)object;
        if (this.type == standardGradientPaintTransformer.type) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    public int hashCode() {
        if (this.type == null) return 0;
        int n2 = this.type.hashCode();
        return n2;
    }
}

