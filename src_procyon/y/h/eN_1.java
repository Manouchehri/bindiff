package y.h;

import java.awt.geom.*;

final class eN extends eM
{
    byte a;
    double b;
    double c;
    
    public int a() {
        return this.a;
    }
    
    public int a(final double[] array) {
        array[0] = this.b;
        array[1] = this.c;
        return this.a;
    }
    
    public int a(final float[] array) {
        array[0] = (float)this.b;
        array[1] = (float)this.c;
        return this.a;
    }
    
    int a(final float[] array, final AffineTransform affineTransform) {
        array[0] = (float)this.b;
        array[1] = (float)this.c;
        affineTransform.transform(array, 0, array, 0, 1);
        return this.a;
    }
    
    int a(final double[] array, final AffineTransform affineTransform) {
        array[0] = this.b;
        array[1] = this.c;
        affineTransform.transform(array, 0, array, 0, 1);
        return this.a;
    }
}
