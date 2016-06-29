package y.f.e.a;

public class av implements ax
{
    private double a;
    private double b;
    private k c;
    
    public av() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = new Z();
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public void b(final double b) {
        this.b = b;
    }
    
    public k a(final m m, final l l, final a a) {
        final k a2 = m.a();
        final double n = this.c.d() - a2.d();
        final double n2 = this.c.e() - a2.e();
        final double sqrt = Math.sqrt(n * n + n2 * n2);
        final double n3 = this.b - this.a;
        if (this.a <= 0.0 || n3 <= 0.0 || sqrt < n3) {
            return a;
        }
        final double n4 = (sqrt - n3) / this.a;
        final double n5 = n / sqrt * n4;
        final double n6 = n2 / sqrt * n4;
        a.a(n5);
        a.b(n6);
        a.c(0.0);
        return a;
    }
}
