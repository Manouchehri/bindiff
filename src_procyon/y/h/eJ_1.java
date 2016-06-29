package y.h;

import java.awt.geom.*;

final class eJ implements PathIterator
{
    private eM a;
    private final AffineTransform b;
    private final int c;
    
    eJ(final eM a, final AffineTransform b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int currentSegment(final float[] array) {
        return this.a.a(array, this.b);
    }
    
    public int currentSegment(final double[] array) {
        return this.a.a(array, this.b);
    }
    
    public int getWindingRule() {
        return this.c;
    }
    
    public boolean isDone() {
        return this.a == null;
    }
    
    public void next() {
        this.a = this.a.g;
    }
}
