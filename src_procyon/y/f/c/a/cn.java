package y.f.c.a;

import y.c.*;
import y.d.*;

abstract class cn implements df
{
    protected double a;
    protected double b;
    protected double c;
    protected double d;
    protected double e;
    protected double f;
    protected double g;
    private double h;
    private double i;
    private f j;
    
    public cn() {
        this.a = 0.0;
        this.b = 10.0;
        this.c = 20.0;
        this.d = 0.0;
        this.e = 10.0;
        this.f = 0.0;
        this.b();
    }
    
    public double a() {
        final int d = this.d();
        if (d < 1) {
            return this.d;
        }
        return this.d + this.f + (d - 1) * this.e + this.g;
    }
    
    public void b() {
        this.h = this.d + this.f;
        this.i = this.a + this.c;
    }
    
    public double c() {
        final double h = this.h;
        this.h += this.e;
        return h;
    }
    
    public void a(final double d) {
        this.d = d;
        this.b();
    }
    
    public void b(final double n) {
        this.g = n;
        this.e = n;
        this.b();
    }
    
    public void a(final d d) {
        this.e().b(d);
    }
    
    public int d() {
        return (this.j != null) ? this.j.size() : 0;
    }
    
    public f e() {
        if (this.j == null) {
            this.j = new f();
        }
        return this.j;
    }
    
    public t a(final double n, final double n2) {
        return new t(this.b(n, n2), this.c(n, n2));
    }
    
    public void b(final d d) {
        this.e().a(d);
    }
}
