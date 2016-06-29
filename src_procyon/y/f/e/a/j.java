package y.f.e.a;

class j implements ax
{
    private double a;
    
    j(final double a) {
        this.a = a;
    }
    
    j() {
        this(0.2);
    }
    
    public k a(final m m, final l l, final a a) {
        final k a2 = m.a();
        final double a3 = this.a(l);
        if (Double.isNaN(a3) || Double.isInfinite(a3) || a3 < 1.0E-7) {
            return a;
        }
        a2.a(l.b().e(), a);
        a.b(a.d() * a3 - a.d(), a.e() / a3 - a.e(), 0.0);
        return a;
    }
    
    double a(final l l) {
        return Math.sqrt(this.a / (l.b().a() / l.b().b()));
    }
}
