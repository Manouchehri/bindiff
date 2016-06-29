package y.f.k;

import y.f.*;

class T
{
    private l a;
    private am b;
    private double c;
    private double d;
    private double e;
    private double f;
    
    T(final l a, final am b) {
        this.a = a;
        this.b = b;
        final n a2 = n.a(b.getWidth(), b.getHeight()).a(a);
        this.c = a2.a(0);
        this.d = a2.a(1);
        final n a3 = n.a(b.getX(), b.getY()).a(a);
        this.e = a3.a(0);
        this.f = a3.a(1);
        if (this.c < 0.0) {
            this.e += this.c;
            this.c = -this.c;
        }
        if (this.d < 0.0) {
            this.f += this.d;
            this.d = -this.d;
        }
    }
    
    public double a() {
        return this.d;
    }
    
    public double b() {
        return this.c;
    }
    
    public double c() {
        return this.e;
    }
    
    public double d() {
        return this.f;
    }
    
    public double e() {
        return this.e + this.c / 2.0;
    }
}
