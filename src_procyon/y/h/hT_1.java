package y.h;

import y.b.*;
import java.awt.geom.*;
import y.g.*;

class hT implements d
{
    private static final double a;
    private final double b;
    private double c;
    private Point2D d;
    private final an e;
    private final ch f;
    private final long g;
    private final cU h;
    private double i;
    private double j;
    private double k;
    private double l;
    private double m;
    private double n;
    private boolean o;
    
    public hT(final ch f, final double b, final an e, final long g, final cU h) {
        this.b = b;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = Math.log(b);
        this.j = this.i / hT.a;
    }
    
    public long preferredDuration() {
        return this.g;
    }
    
    public void initAnimation() {
        this.c = this.f.getZoom();
        this.d = this.f.getCenter();
        this.k = Math.log(this.c);
        this.l = this.k / hT.a;
        this.m = this.a(0.0);
        this.n = this.a(1.0) - this.m;
        this.o = (Math.abs(this.c - this.b) < 1.0E-8);
    }
    
    public void calcFrame(final double n) {
        final double n2 = 1.0 - n;
        this.f.setZoom(Math.pow(2.0, n2 * this.l + n * this.j));
        Label_0168: {
            if (this.o) {
                this.f.setCenter(n2 * this.d.getX() + n * this.e.a(), n2 * this.d.getY() + n * this.e.b());
                if (!fj.z) {
                    break Label_0168;
                }
            }
            final double n3 = (this.a(n) - this.m) / this.n;
            final double n4 = 1.0 - n3;
            this.f.setCenter(n4 * this.d.getX() + n3 * this.e.a(), n4 * this.d.getY() + n3 * this.e.b());
        }
        if (this.h != null) {
            this.h.a();
        }
    }
    
    public void disposeAnimation() {
    }
    
    private double a(final double n) {
        return Math.pow(2.0, (this.l - this.j) * n - this.l) / (this.k - this.i);
    }
    
    static {
        a = Math.log(2.0);
    }
}
