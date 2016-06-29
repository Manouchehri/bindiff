package y.h;

import java.awt.geom.*;

final class eP implements PathIterator
{
    private eM a;
    private final int b;
    
    eP(final eM a, final int b) {
        this.b = b;
        this.a = a;
    }
    
    public int currentSegment(final float[] array) {
        return this.a.a(array);
    }
    
    public int currentSegment(final double[] array) {
        return this.a.a(array);
    }
    
    public int getWindingRule() {
        return this.b;
    }
    
    public boolean isDone() {
        return this.a == null;
    }
    
    public void next() {
        this.a = this.a.g;
    }
}
