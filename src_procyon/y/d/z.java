package y.d;

public class z
{
    private double a;
    private double b;
    
    public z(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public z(final z z) {
        this.a = z.a();
        this.b = z.b();
    }
    
    public z(final t t, final t t2) {
        this.a = t.a() - t2.a();
        this.b = t.b() - t2.b();
    }
    
    public z(final t t) {
        this.a = t.a();
        this.b = t.b();
    }
    
    public z(final double n, final double n2, final double n3, final double n4) {
        this.a = n - n3;
        this.b = n2 - n4;
    }
    
    public double a() {
        return this.a;
    }
    
    public double b() {
        return this.b;
    }
    
    public void c() {
        if (this.a == 0.0 && this.b == 0.0) {
            return;
        }
        final double d = this.d();
        this.a /= d;
        this.b /= d;
    }
    
    public z a(final double n) {
        return new z(Math.cos(n) * this.a - Math.sin(n) * this.b, Math.sin(n) * this.a + Math.cos(n) * this.b);
    }
    
    public void a(final z z) {
        this.a += z.a();
        this.b += z.b();
    }
    
    public static z a(final z z, final z z2) {
        final z z3 = new z(z);
        z3.a(z2);
        return z3;
    }
    
    public static t a(final t t, final z z) {
        return new t(t.a() + z.a(), t.b() + z.b());
    }
    
    public void b(final double n) {
        this.a *= n;
        this.b *= n;
    }
    
    public double d() {
        return Math.sqrt(this.a * this.a + this.b * this.b);
    }
    
    public static boolean b(final z z, final z z2) {
        return z.a() * z2.b() - z.b() * z2.a() > 0.0;
    }
    
    public static z b(final z z) {
        final z z2 = new z(z.a(), z.b());
        z2.c();
        return z2;
    }
    
    public static z c(final z z) {
        final double d = z.d();
        return new z(-z.b() / d, z.a() / d);
    }
    
    public static double c(final z z, final z z2) {
        return z.a() * z2.a() + z.b() * z2.b();
    }
    
    public static double d(final z z, final z z2) {
        final boolean d = t.d;
        final double n = c(z, z2) / (z.d() * z2.d());
        double n2 = 0.0;
        Label_0069: {
            if (n > 1.0) {
                n2 = Math.acos(1.0);
                if (!d) {
                    break Label_0069;
                }
            }
            if (n < -1.0) {
                n2 = Math.acos(-1.0);
                if (!d) {
                    break Label_0069;
                }
            }
            n2 = Math.acos(Math.min(1.0, n));
        }
        if (!b(z, z2)) {
            n2 = 6.283185307179586 - n2;
        }
        return n2;
    }
    
    public String toString() {
        return "X: " + this.a() + " Y: " + this.b();
    }
}
