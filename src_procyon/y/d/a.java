package y.d;

public class a
{
    private double a;
    private double b;
    private double c;
    
    public a(final t t, final z z) {
        this(t, z.a(t, z));
    }
    
    public a(final t t, final t t2) {
        if (a(t.a(), t2.a())) {
            this.a = 1.0;
            this.b = 0.0;
            this.c = -t.a();
            return;
        }
        this.b = -1.0;
        final double a = (t2.b() - t.b()) / (t2.a() - t.a());
        final double c = t.b() - t.a() * a;
        this.a = a;
        this.c = c;
    }
    
    public double a() {
        return this.a;
    }
    
    public double b() {
        return this.b;
    }
    
    public double c() {
        return this.c;
    }
    
    public String toString() {
        return "a: " + this.a + " b: " + this.b + " c: " + this.c;
    }
    
    public static t a(a a, a a2) {
        if (a(a.a()) && a(a2.a())) {
            return null;
        }
        if (a(a.b()) && a(a2.b())) {
            return null;
        }
        if (a(a2.b())) {
            final a a3 = a;
            a = a2;
            a2 = a3;
        }
        final double a4 = a.a();
        final double b = a.b();
        final double n = -a.c();
        if (!a(a4)) {
            final double n2 = (-a2.c() - a2.a() / a4 * n) / (a2.b() - a2.a() / a4 * b);
            return new t((n - n2 * b) / a4, n2);
        }
        final double n3 = n / b;
        return new t((a2.c() + a2.b() * n3) / -a2.a(), n3);
    }
    
    private static boolean a(final double n) {
        return a(n, 0.0);
    }
    
    private static boolean a(final double n, final double n2) {
        return Math.abs(n - n2) < 1.0E-5;
    }
}
