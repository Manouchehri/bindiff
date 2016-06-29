package y.h;

import y.b.*;

class cS implements d
{
    double a;
    double b;
    ch c;
    boolean d;
    cT e;
    az f;
    private final cQ g;
    
    cS(final cQ g, final ch c, final boolean d) {
        this.g = g;
        this.e = new cT(this);
        this.c = c;
        this.d = d;
    }
    
    public void calcFrame(double a) {
        if (a > 0.0) {
            a = 1.0 - 1.0 / ((1.0 + a) * (1.0 + a) * (1.0 + a) * (1.0 + a));
        }
        final double n = this.d ? (50.0 + 50.0 * (1.0 - a)) : (50.0 + 50.0 * a);
        this.e.setFrame(this.a - 0.5 * n, this.b - 0.5 * n, n, n);
        this.e.a = a;
    }
    
    public void disposeAnimation() {
        this.c.removeDrawable(this.f);
        cQ.access$202(this.g, null);
    }
    
    public void initAnimation() {
        this.f = new gW(this.c, this.e);
        this.c.addDrawable(this.f);
    }
    
    public long preferredDuration() {
        return 500L;
    }
    
    static cQ a(final cS cs) {
        return cs.g;
    }
}
