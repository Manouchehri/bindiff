package y.h;

import java.awt.geom.*;

final class eK extends eM
{
    double a;
    double b;
    double c;
    double d;
    
    public int a() {
        return 2;
    }
    
    public int a(final double[] array) {
        array[0] = this.a;
        array[1] = this.b;
        array[2] = this.c;
        array[3] = this.d;
        return 2;
    }
    
    public int a(final float[] array) {
        array[0] = (float)this.a;
        array[1] = (float)this.b;
        array[2] = (float)this.c;
        array[3] = (float)this.d;
        return 2;
    }
    
    int a(final float[] array, final AffineTransform affineTransform) {
        array[0] = (float)this.a;
        array[1] = (float)this.b;
        array[2] = (float)this.c;
        array[3] = (float)this.d;
        affineTransform.transform(array, 0, array, 0, 2);
        return 2;
    }
    
    int a(final double[] array, final AffineTransform affineTransform) {
        array[0] = this.a;
        array[1] = this.b;
        array[2] = this.c;
        array[3] = this.d;
        affineTransform.transform(array, 0, array, 0, 2);
        return 2;
    }
}
