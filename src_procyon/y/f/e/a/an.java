package y.f.e.a;

public class an implements ax
{
    private double a;
    private double b;
    private double c;
    private k d;
    
    public an() {
        this.a = 0.0;
        this.b = 0.0;
        this.c = 0.0;
        this.d = new Z();
    }
    
    public k a(final m m, final l l, final a a) {
        final k a2 = m.a();
        final double n = this.c / this.b;
        final double n2 = this.d.d() - a2.d();
        final double n3 = (this.d.e() - a2.e()) / n;
        final double sqrt = Math.sqrt(n2 * n2 + n3 * n3);
        final double n4 = this.b - this.a;
        if (this.a <= 0.0 || n4 <= 0.0 || sqrt < n4) {
            return a;
        }
        final double n5 = (sqrt - n4) / this.a;
        final double n6 = n2 / sqrt * n5;
        final double n7 = n3 / sqrt * n5 * n;
        a.a(n6);
        a.b(n7);
        a.c(0.0);
        return a;
    }
}
