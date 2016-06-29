package y.f.e.a;

class b implements G
{
    private double a;
    
    b() {
        this(100.0);
    }
    
    b(final double a) {
        this.a = a;
    }
    
    public void a(final ag ag, final l l, final a a) {
        if (ag.e() == 0.0) {
            return;
        }
        if (ag.g() == 1.0) {
            return;
        }
        final double sqrt = Math.sqrt(ag.e());
        if (sqrt == 0.0) {
            return;
        }
        final k f = ag.f();
        if (f.g()) {
            return;
        }
        a.b(f.d(), f.e(), f.f());
        a.b();
        a.d((1.0 - ag.g()) * sqrt * this.a);
        ag.b(a);
    }
}
