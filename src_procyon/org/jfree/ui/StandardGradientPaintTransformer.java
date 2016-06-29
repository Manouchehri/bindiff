package org.jfree.ui;

import java.io.*;
import org.jfree.util.*;
import java.awt.*;
import java.awt.geom.*;

public class StandardGradientPaintTransformer implements Serializable, Cloneable, GradientPaintTransformer, PublicCloneable
{
    private static final long serialVersionUID = -8155025776964678320L;
    private GradientPaintTransformType type;
    
    public StandardGradientPaintTransformer() {
        this(GradientPaintTransformType.VERTICAL);
    }
    
    public StandardGradientPaintTransformer(final GradientPaintTransformType type) {
        this.type = type;
    }
    
    public GradientPaint transform(final GradientPaint gradientPaint, final Shape shape) {
        GradientPaint gradientPaint2 = gradientPaint;
        final Rectangle2D bounds2D = shape.getBounds2D();
        if (this.type.equals(GradientPaintTransformType.VERTICAL)) {
            gradientPaint2 = new GradientPaint((float)bounds2D.getCenterX(), (float)bounds2D.getMinY(), gradientPaint.getColor1(), (float)bounds2D.getCenterX(), (float)bounds2D.getMaxY(), gradientPaint.getColor2());
        }
        else if (this.type.equals(GradientPaintTransformType.HORIZONTAL)) {
            gradientPaint2 = new GradientPaint((float)bounds2D.getMinX(), (float)bounds2D.getCenterY(), gradientPaint.getColor1(), (float)bounds2D.getMaxX(), (float)bounds2D.getCenterY(), gradientPaint.getColor2());
        }
        else if (this.type.equals(GradientPaintTransformType.CENTER_HORIZONTAL)) {
            gradientPaint2 = new GradientPaint((float)bounds2D.getCenterX(), (float)bounds2D.getCenterY(), gradientPaint.getColor1(), (float)bounds2D.getMaxX(), (float)bounds2D.getCenterY(), gradientPaint.getColor2(), true);
        }
        else if (this.type.equals(GradientPaintTransformType.CENTER_VERTICAL)) {
            gradientPaint2 = new GradientPaint((float)bounds2D.getCenterX(), (float)bounds2D.getMinY(), gradientPaint.getColor1(), (float)bounds2D.getCenterX(), (float)bounds2D.getCenterY(), gradientPaint.getColor2(), true);
        }
        return gradientPaint2;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardGradientPaintTransformer && this.type == ((StandardGradientPaintTransformer)o).type);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public int hashCode() {
        return (this.type != null) ? this.type.hashCode() : 0;
    }
}
