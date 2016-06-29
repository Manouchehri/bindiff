package y.f.e.a;

public final class Z implements a
{
    private double a;
    private double b;
    private double c;
    
    public void a() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
    }
    
    public double c() {
        return Math.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
    }
    
    public a a(final k k, final a a) {
        a.a(this.a - k.d());
        a.b(this.b - k.e());
        a.c(this.c - k.f());
        return a;
    }
    
    public void a(final k k) {
        if (k == null) {
            return;
        }
        this.a += k.d();
        this.b += k.e();
        this.c += k.f();
    }
    
    public void a(final double n, final double n2, final double n3) {
        this.a += n;
        this.b += n2;
        this.c += n3;
    }
    
    public void d(final double n) {
        this.a *= n;
        this.b *= n;
        this.c *= n;
    }
    
    public boolean g() {
        return this.a == 0.0 && this.b == 0.0 && this.c == 0.0;
    }
    
    public void b() {
        this.e(1.0);
    }
    
    public void e(final double n) {
        final double c = this.c();
        if (c == 0.0) {
            return;
        }
        final double n2 = n / c;
        this.a *= n2;
        this.b *= n2;
        this.c *= n2;
    }
    
    public double d() {
        return this.a;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public double e() {
        return this.b;
    }
    
    public void b(final double b) {
        this.b = b;
    }
    
    public double f() {
        return this.c;
    }
    
    public void c(final double c) {
        this.c = c;
    }
    
    public void b(final double n, final double n2, final double n3) {
        this.a(n);
        this.b(n2);
        this.c(n3);
    }
    
    public String toString() {
        return "Point3F{x=" + this.a + ", y=" + this.b + ", z=" + this.c + '}';
    }
}
