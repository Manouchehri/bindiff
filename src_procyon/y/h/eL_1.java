package y.h;

import java.awt.geom.*;

final class eL extends eM
{
    double a;
    double b;
    double c;
    double d;
    double e;
    double f;
    
    public int a() {
        return 2;
    }
    
    public int a(final double[] array) {
        array[0] = this.a;
        array[1] = this.b;
        array[2] = this.c;
        array[3] = this.d;
        array[4] = this.e;
        array[5] = this.f;
        return 3;
    }
    
    public int a(final float[] array) {
        array[0] = (float)this.a;
        array[1] = (float)this.b;
        array[2] = (float)this.c;
        array[3] = (float)this.d;
        array[4] = (float)this.e;
        array[5] = (float)this.f;
        return 3;
    }
    
    int a(final float[] array, final AffineTransform affineTransform) {
        array[0] = (float)this.a;
        array[1] = (float)this.b;
        array[2] = (float)this.c;
        array[3] = (float)this.d;
        array[4] = (float)this.e;
        array[5] = (float)this.f;
        affineTransform.transform(array, 0, array, 0, 3);
        return 3;
    }
    
    int a(final double[] array, final AffineTransform affineTransform) {
        array[0] = this.a;
        array[1] = this.b;
        array[2] = this.c;
        array[3] = this.d;
        array[4] = this.e;
        array[5] = this.f;
        affineTransform.transform(array, 0, array, 0, 3);
        return 3;
    }
}
