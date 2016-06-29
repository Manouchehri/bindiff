package y.f.i;

import y.d.*;

class ao
{
    public t k;
    public t l;
    private ag[] a;
    protected boolean m;
    private boolean b;
    boolean n;
    float o;
    float p;
    
    public ao(final double n, final double n2, final double n3, final double n4, final boolean m) {
        this.o = Float.MAX_VALUE;
        this.p = -3.4028235E38f;
        this.k = new t(n, n2);
        this.l = new t(n3, n4);
        this.a = new ag[2];
        this.m = m;
    }
    
    public void a(final ag ag, final ag ag2) {
        this.a[0] = ag;
        this.a[1] = ag2;
    }
    
    public void n() {
        this.b = true;
    }
    
    public ag o() {
        return this.a[0];
    }
    
    public double p() {
        if (this.m) {
            final double n = this.l.a - this.k.a;
            if (v.f == 0) {
                return n;
            }
        }
        return this.l.b - this.k.b;
    }
    
    public double q() {
        if (this.m) {
            final double n = this.l.b - this.k.b;
            if (v.f == 0) {
                return n;
            }
        }
        return this.l.a - this.k.a;
    }
    
    public double r() {
        return (this.k.a + this.l.a) / 2.0;
    }
    
    public double s() {
        return (this.k.b + this.l.b) / 2.0;
    }
    
    public double t() {
        if (this.m) {
            final double n = this.k.a;
            if (v.f == 0) {
                return n;
            }
        }
        return this.k.b;
    }
    
    public double u() {
        if (this.m) {
            final double n = this.l.a;
            if (v.f == 0) {
                return n;
            }
        }
        return this.l.b;
    }
    
    public double v() {
        return this.m ? this.k.b : this.k.a;
    }
    
    public double w() {
        return this.m ? this.l.b : this.l.a;
    }
    
    public boolean x() {
        return this.m;
    }
    
    public boolean y() {
        return this.b;
    }
    
    public String toString() {
        return "[" + (this.m ? "vertical" : "horizontal") + ";(" + this.k + ")(" + this.l + ")]";
    }
}
